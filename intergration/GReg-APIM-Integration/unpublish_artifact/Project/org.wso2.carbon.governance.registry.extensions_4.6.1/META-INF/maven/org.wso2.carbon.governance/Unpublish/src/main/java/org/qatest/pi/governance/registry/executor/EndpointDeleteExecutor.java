//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.executor;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.namespace.QName;
import org.apache.axiom.om.OMElement;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qatest.pi.governance.registry.executor.BaseEndpointExecutor;
import org.qatest.pi.governance.registry.extensions.utils.GovernanceExceptions;
import org.qatest.pi.governance.registry.extensions.utils.PropertyFileHelper;
import org.wso2.carbon.context.CarbonContext;
import org.wso2.carbon.registry.app.RemoteRegistry;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.core.jdbc.handlers.RequestContext;

public class EndpointDeleteExecutor extends BaseEndpointExecutor {
    private static final Log LOG = LogFactory.getLog(EndpointDeleteExecutor.class);
    private String name;

    public EndpointDeleteExecutor() {
    }

    public boolean execute(RequestContext context, String currentState, String targetState) {
        this.setResource(context.getResource());
        this.setResourcePath(context.getResourcePath().getPath());
        this.setRegistry(context.getRegistry());
        ArrayList actions = new ArrayList();
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
                    this.deleteEndpointFromESB(esbEnvironmentURL, action);
                    LOG.info("User " + CarbonContext.getThreadLocalCarbonContext().getUsername() + " demoted the endpoint " + this.name + " from " + action + " ESB environment");
                } catch (RegistryException var10) {
                    throw new GovernanceExceptions(var10.getMessage(), var10);
                }
            }

            return true;
        }
    }

    private void deleteEndpointFromESB(String esbEnvironmentURL, String action) throws RegistryException {
        URL url;
        try {
            url = new URL(esbEnvironmentURL);
        } catch (MalformedURLException var8) {
            throw new RegistryException("The esb environment url is malformed", var8);
        }

        RemoteRegistry remoteRegistry = new RemoteRegistry(url, PropertyFileHelper.getValue(action + "_ESB_USERNAME", "admin"), PropertyFileHelper.getValue(action + "_ESB_PASSWORD", "admin"));
        OMElement docElement = this.getDocumentElement();
        this.name = docElement.getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "overview")).getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "name")).getText();
        String version = docElement.getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "overview")).getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "version")).getText();
        String resourcePathToDelete = this.getEndpointResourcePath(this.name, version);
        if(remoteRegistry.resourceExists(resourcePathToDelete)) {
            remoteRegistry.delete(resourcePathToDelete);
        } else {
            throw new RegistryException("The endpoint resource doesn\'t exist in " + action + " ESB environment");
        }
    }
}
