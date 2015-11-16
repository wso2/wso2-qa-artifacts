//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.extensions.handlers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.core.jdbc.handlers.Handler;
import org.wso2.carbon.registry.core.jdbc.handlers.RequestContext;

public class CustomDeleteHandler extends Handler {
    private static final Log LOG = LogFactory.getLog(CustomDeleteHandler.class);

    public CustomDeleteHandler() {
    }

    public void delete(RequestContext requestContext) throws RegistryException {
        String published_env = requestContext.getResource().getProperty("published_env");
        if(published_env != null && !published_env.isEmpty()) {
            LOG.error("Cannot delete the resource.This resource has been already published to:" + published_env);
            throw new RegistryException("Cannot delete the resource.This resource has been already published to:" + published_env);
        }
    }
}
