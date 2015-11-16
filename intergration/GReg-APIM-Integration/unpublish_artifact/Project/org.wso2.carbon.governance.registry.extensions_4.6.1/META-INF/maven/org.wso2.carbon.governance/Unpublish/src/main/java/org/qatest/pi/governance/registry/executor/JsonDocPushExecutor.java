//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.executor;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qatest.pi.governance.registry.executor.BaseJsonDocExecutor;
import org.qatest.pi.governance.registry.extensions.utils.APIUtils;
import org.qatest.pi.governance.registry.extensions.utils.CustomJsonUtils;
import org.qatest.pi.governance.registry.extensions.utils.GovernanceExceptions;
import org.qatest.pi.governance.registry.extensions.utils.PropertyFileHelper;
import org.wso2.carbon.context.CarbonContext;
import org.wso2.carbon.registry.app.RemoteRegistry;
import org.wso2.carbon.registry.core.ResourceImpl;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.core.internal.RegistryCoreServiceComponent;
import org.wso2.carbon.registry.core.jdbc.handlers.RequestContext;

public class JsonDocPushExecutor extends BaseJsonDocExecutor {
    private static final Log LOG = LogFactory.getLog(JsonDocPushExecutor.class);
    private String endpoint;
    private String name;

    public JsonDocPushExecutor() {
    }

    public boolean execute(RequestContext context, String currentState, String targetState) {
        this.setResource(context.getResource());
        this.setResourcePath(context.getResourcePath().getPath());
        ArrayList actions = new ArrayList();
        String user = CarbonContext.getThreadLocalCarbonContext().getUsername();

        try {
            this.setRegistry(RegistryCoreServiceComponent.getRegistryService().getGovernanceUserRegistry(user, CarbonContext.getThreadLocalCarbonContext().getTenantId()));
        } catch (RegistryException var14) {
            throw new GovernanceExceptions(var14.getMessage(), var14);
        }

        int selectedCount = this.populateActions(actions);
        if(selectedCount > 1) {
            throw new GovernanceExceptions("Please Select Only One Environment for Publish/Unpublish Operation");
        } else if(selectedCount <= 0) {
            throw new GovernanceExceptions("Please Select an Environment for Publish/Unpublish Operation");
        } else {
            Iterator i$ = actions.iterator();

            while(i$.hasNext()) {
                String action = (String)i$.next();
                String esbEnvironmentURL = PropertyFileHelper.getValue(action + "_ESB_ENVIRONMENT_URL", "https://dpesb.fmr.com");

                try {
                    this.pushEndpointToESB(esbEnvironmentURL, action);
                    this.getResource().setProperty("publisher_" + action, user);
                    this.getResource().setProperty("published_endpoint_" + action, this.endpoint);
                    Date ex = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
                    String dateAndTimeNow = sdf.format(ex);
                    this.getResource().setProperty("published_time_" + action, dateAndTimeNow);
                    APIUtils.updatePromotedProperty(action, this.getResource(), this.getRegistry());
                    LOG.info("User " + CarbonContext.getThreadLocalCarbonContext().getUsername() + " promoted the json doc " + this.name + " to " + action + " ESB environment");
                } catch (RegistryException var13) {
                    throw new GovernanceExceptions(var13.getMessage(), var13);
                }
            }

            return true;
        }
    }

    private void pushEndpointToESB(String esbEnvironmentURL, String action) throws RegistryException {
        URL url;
        try {
            url = new URL(esbEnvironmentURL);
        } catch (MalformedURLException var10) {
            throw new RegistryException("The esb environment url is malformed", var10);
        }

        LOG.info("esbEnvironmentURL:" + esbEnvironmentURL);
        String regUserName;
        String regPwd;
        if(action.contains("PROD")) {
            regUserName = PropertyFileHelper.getValue("PROD_ESB_USERNAME", "admin");
            regPwd = PropertyFileHelper.getValue("PROD_ESB_PASSWORD", "admin");
        } else {
            regUserName = PropertyFileHelper.getValue("NONPROD_ESB_USERNAME", "admin");
            regPwd = PropertyFileHelper.getValue("NONPROD_ESB_PASSWORD", "admin");
        }

        RemoteRegistry remoteRegistry = new RemoteRegistry(url, regUserName, regPwd);
        ResourceImpl newEndpointResource = new ResourceImpl();
        String endpointContent = this.generateJsonResourceContent(this.getResource().getContentStream());
        newEndpointResource.setContent(endpointContent);
        newEndpointResource.setMediaType("application/json");
        this.name = "obfuscation";
        String endpointPath = this.getEndpointResourcePath(this.name);
        LOG.info("endpoint path :" + endpointPath);
        if(endpointPath.startsWith("/_system/governance")) {
            LOG.info("pushing the file to registy :");
            remoteRegistry.put(endpointPath, newEndpointResource);
        } else {
            throw new RegistryException("Resource storage path is invalid : path should start with /_system/governance. Look in the lifecycle configuration");
        }
    }

    private String generateJsonResourceContent(InputStream inputStream) throws RegistryException {
        String resourceContent = null;

        try {
            ByteArrayOutputStream e = CustomJsonUtils.readSourceContent(inputStream);
            resourceContent = e.toString();
            return resourceContent;
        } catch (RegistryException var4) {
            throw new RegistryException("Exception occurred while reading content", var4);
        }
    }
}
