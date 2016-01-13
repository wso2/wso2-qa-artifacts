//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.extensions.handlers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import org.apache.axiom.om.OMElement;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qatest.pi.governance.registry.extensions.utils.CustomJsonProcessor;
import org.qatest.pi.governance.registry.extensions.utils.CustomJsonUtils;
import org.wso2.carbon.registry.core.Resource;
import org.wso2.carbon.registry.core.config.RegistryContext;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.core.jdbc.handlers.Handler;
import org.wso2.carbon.registry.core.jdbc.handlers.RequestContext;
import org.wso2.carbon.registry.core.utils.RegistryUtils;
import org.wso2.carbon.registry.extensions.utils.CommonUtil;

public class CustomJsonHandler extends Handler {
    private static final Log LOG = LogFactory.getLog(CustomJsonHandler.class);
    private String swaggerLocation;

    public CustomJsonHandler() {
    }

    public void setSwaggerLocationConfiguration(OMElement locationConfiguration) {
        Iterator confElements = locationConfiguration.getChildElements();

        while(confElements.hasNext()) {
            OMElement confElement = (OMElement)confElements.next();
            if("location".equals(confElement.getLocalName())) {
                this.swaggerLocation = confElement.getText();
                if(!this.swaggerLocation.startsWith("/")) {
                    this.swaggerLocation = "/" + this.swaggerLocation;
                }

                if(!this.swaggerLocation.endsWith("/")) {
                    this.swaggerLocation = this.swaggerLocation + "/";
                }
            }
        }

    }

    public void put(RequestContext requestContext) throws RegistryException {
        if(CommonUtil.isUpdateLockAvailable()) {
            CommonUtil.acquireUpdateLock();
            Object inputStream = null;

            try {
                Resource e = requestContext.getResource();
                if(e == null) {
                    throw new RegistryException("Resource does not exist.");
                }

                Object resourceContentObj = e.getContent();
                if(!(resourceContentObj instanceof byte[])) {
                    throw new RegistryException("Resource content is not valid.");
                }

                requestContext.setSourceURL(requestContext.getResource().getProperty("sourceURL"));
                String sourceURL = requestContext.getSourceURL();
                CustomJsonProcessor processor;
                if(StringUtils.isBlank(sourceURL)) {
                    inputStream = new ByteArrayInputStream((byte[])((byte[])resourceContentObj));
                    processor = new CustomJsonProcessor(requestContext);
                    processor.processJsonUpload((InputStream)inputStream, this.getChrootedLocation(requestContext.getRegistryContext()), (String)null);
                } else {
                    inputStream = (new URL(sourceURL)).openStream();
                    processor = new CustomJsonProcessor(requestContext);
                    processor.processJsonUpload((InputStream)inputStream, this.getChrootedLocation(requestContext.getRegistryContext()), sourceURL);
                }
            } catch (IOException var10) {
                throw new RegistryException("The URL " + requestContext.getSourceURL() + " is incorrect.", var10);
            } finally {
                CustomJsonUtils.closeInputStream((InputStream)inputStream);
                CommonUtil.releaseUpdateLock();
            }

        }
    }

    public void importResource(RequestContext requestContext) throws RegistryException {
        if(CommonUtil.isUpdateLockAvailable()) {
            CommonUtil.acquireUpdateLock();
            String sourceURL = null;
            InputStream inputStream = null;

            try {
                sourceURL = requestContext.getSourceURL();
                if(sourceURL == null || sourceURL.isEmpty()) {
                    throw new RegistryException("Source url is empty. Cannot read content.");
                }

                if(sourceURL.toLowerCase().startsWith("file:")) {
                    throw new RegistryException("The source URL must not be point to a file in the server\'s local file system. ");
                }

                inputStream = (new URL(sourceURL)).openStream();
                CustomJsonProcessor e = new CustomJsonProcessor(requestContext);
                e.processJsonUpload(inputStream, this.getChrootedLocation(requestContext.getRegistryContext()), sourceURL);
            } catch (IOException var8) {
                throw new RegistryException("The URL " + sourceURL + " is incorrect.", var8);
            } finally {
                CustomJsonUtils.closeInputStream(inputStream);
                CommonUtil.releaseUpdateLock();
            }

        }
    }

    private String getChrootedLocation(RegistryContext registryContext) {
        return RegistryUtils.getAbsolutePath(registryContext, "/_system/governance" + this.swaggerLocation);
    }
}
