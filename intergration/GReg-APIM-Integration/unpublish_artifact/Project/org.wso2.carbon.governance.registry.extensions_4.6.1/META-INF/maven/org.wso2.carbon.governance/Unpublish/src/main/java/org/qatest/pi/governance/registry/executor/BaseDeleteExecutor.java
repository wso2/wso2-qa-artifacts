//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.executor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.qatest.pi.governance.registry.executor.BaseExecutor;
import org.qatest.pi.governance.registry.extensions.utils.APIUtils;
import org.qatest.pi.governance.registry.extensions.utils.GovernanceExceptions;
import org.qatest.pi.governance.registry.extensions.utils.ResponseAPIM;
import org.wso2.carbon.registry.core.Resource;

public abstract class BaseDeleteExecutor extends BaseExecutor {
    private static final Log LOG = LogFactory.getLog(BaseDeleteExecutor.class);

    public BaseDeleteExecutor() {
    }

    protected boolean deleteAPIFromAPIM(Resource resource, String serviceName, String apiCreator, String apiEnvironment, String apiEndpoint, String pubUser, String pubPwd) throws GovernanceExceptions {
        boolean valid = true;
        BasicHttpContext httpContext = new BasicHttpContext();
        this.authenticateWithAPIM(httpContext, apiEnvironment, apiEndpoint, pubUser, pubPwd);
        DefaultHttpClient httpclient = new DefaultHttpClient();

        try {
            String e = apiEndpoint + "publisher/site/blocks/item-add/ajax/remove.jag";
            HttpPost httppost = new HttpPost(e);
            MultipartEntity multipartEntity = new MultipartEntity();
            multipartEntity.addPart("action", new StringBody("removeAPI"));
            multipartEntity.addPart("name", new StringBody(serviceName));
            multipartEntity.addPart("provider", new StringBody(apiCreator));
            multipartEntity.addPart("version", new StringBody(resource.getProperty("overview_version")));
            ResponseAPIM responseAPIM = APIUtils.doPostToAPIMPublisherAPI(httpclient, httppost, multipartEntity, httpContext);
            if(responseAPIM.getError().equalsIgnoreCase("true")) {
                String errorMessage = responseAPIM.getMessage();
                LOG.error(errorMessage);
                if(errorMessage != null && errorMessage.contains("Active Subscriptions Exist")) {
                    LOG.error("API un-publishing failed.Active Subscriptions Exist :" + apiEnvironment);
                    throw new GovernanceExceptions("API un-publishing failed.Active Subscriptions Exist :" + apiEnvironment);
                }

                LOG.error("Exception occurred while un-publishing API from APIManager :" + apiEnvironment);
                throw new GovernanceExceptions("Exception occurred while un-publishing API from APIManager :" + apiEnvironment);
            }
        } catch (Exception var19) {
            LOG.error("Exception occurred while un-publishing API from APIManager :");
            throw new GovernanceExceptions(var19.getMessage(), var19);
        } finally {
            httpclient.getConnectionManager().shutdown();
        }

        return true;
    }

    protected boolean deleteAPIFromAPIM(Resource resource, String serviceName, String serviceVersion, String apiCreator, String apiEnvironment, String apiEndpoint, String pubUser, String pubPwd) throws GovernanceExceptions {
        boolean valid = true;
        BasicHttpContext httpContext = new BasicHttpContext();
        this.authenticateWithAPIM(httpContext, apiEnvironment, apiEndpoint, pubUser, pubPwd);
        DefaultHttpClient httpclient = new DefaultHttpClient();

        try {
            String e = apiEndpoint + "publisher/site/blocks/item-add/ajax/remove.jag";
            HttpPost httppost = new HttpPost(e);
            MultipartEntity multipartEntity = new MultipartEntity();
            multipartEntity.addPart("action", new StringBody("removeAPI"));
            multipartEntity.addPart("name", new StringBody(serviceName));
            multipartEntity.addPart("provider", new StringBody(apiCreator));
            multipartEntity.addPart("version", new StringBody(serviceVersion));
            ResponseAPIM responseAPIM = APIUtils.doPostToAPIMPublisherAPI(httpclient, httppost, multipartEntity, httpContext);
            if(responseAPIM.getError().equalsIgnoreCase("true")) {
                String errorMessage = responseAPIM.getMessage();
                LOG.error(errorMessage);
                if(errorMessage != null && errorMessage.contains("Active Subscriptions Exist")) {
                    LOG.error("API un-publishing failed.Active Subscriptions Exist :" + apiEnvironment);
                    throw new GovernanceExceptions("API un-publishing failed.Active Subscriptions Exist :" + apiEnvironment);
                }

                LOG.error("Exception occurred while un-publishing API from APIManager :" + apiEnvironment);
                throw new GovernanceExceptions("Exception occurred while un-publishing API from APIManager :" + apiEnvironment);
            }
        } catch (Exception var20) {
            LOG.error("Exception occurred while un-publishing API from APIManager :");
            throw new GovernanceExceptions(var20.getMessage(), var20);
        } finally {
            httpclient.getConnectionManager().shutdown();
        }

        return true;
    }
}
