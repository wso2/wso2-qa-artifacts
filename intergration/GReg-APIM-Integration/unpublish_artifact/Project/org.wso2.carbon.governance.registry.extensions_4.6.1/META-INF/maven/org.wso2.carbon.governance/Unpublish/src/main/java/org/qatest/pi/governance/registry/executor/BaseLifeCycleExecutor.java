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

public abstract class BaseLifeCycleExecutor extends BaseExecutor {
    private static final Log LOG = LogFactory.getLog(BaseLifeCycleExecutor.class);
    private final String errorMsg = "Error occurred while deleting the Service/API from API Manager : ";
    private final String excMsg = "Cannot demote Service/API due to active subscriptions in API Manager : ";

    public BaseLifeCycleExecutor() {
    }

    protected boolean deprecateAPIFromAPIM(Resource resource, String serviceName, String apiCreator, String apiEnvironment, String apiEndpoint) throws GovernanceExceptions {
        boolean valid = true;
        BasicHttpContext httpContext = new BasicHttpContext();
        DefaultHttpClient httpclient = new DefaultHttpClient();

        try {
            String e = apiEndpoint + "publisher/site/blocks/life-cycles/ajax/life-cycles.jag";
            HttpPost httppost = new HttpPost(e);
            MultipartEntity multipartEntity = new MultipartEntity();
            multipartEntity.addPart("action", new StringBody("updateStatus"));
            multipartEntity.addPart("name", new StringBody(serviceName));
            multipartEntity.addPart("version", new StringBody(this.getArtifact().getAttribute("overview_version")));
            multipartEntity.addPart("provider", new StringBody(apiCreator));
            multipartEntity.addPart("status", new StringBody("DEPRECATED"));
            multipartEntity.addPart("publishToGateway", new StringBody("true"));
            ResponseAPIM responseAPIM = APIUtils.doPostToAPIMPublisherAPI(httpclient, httppost, multipartEntity, httpContext);
            if(responseAPIM.getError().equalsIgnoreCase("true")) {
                String errorMessage = responseAPIM.getMessage();
                LOG.error(errorMessage);
                if(errorMessage != null && errorMessage.contains("Cannot deprecate the Service/API.")) {
                    LOG.error("Cannot demote Service/API due to active subscriptions in API Manager : " + apiEnvironment);
                    throw new GovernanceExceptions("Cannot demote Service/API due to active subscriptions in API Manager : " + apiEnvironment);
                }

                LOG.error("Error occurred while deleting the Service/API from API Manager : " + apiEnvironment);
                throw new GovernanceExceptions("Error occurred while deleting the Service/API from API Manager : " + apiEnvironment);
            }
        } catch (Exception var17) {
            LOG.error("Exception occurred in deprecate API From APIM, ");
            throw new GovernanceExceptions("Error occurred while deleting the Service/API from API Manager : " + apiEnvironment, var17);
        } finally {
            httpclient.getConnectionManager().shutdown();
        }

        return true;
    }

    protected boolean retireAPIFromAPIM(Resource resource, String serviceName, String apiCreator, String apiEnvironment, String apiEndpoint) throws GovernanceExceptions {
        boolean valid = true;
        BasicHttpContext httpContext = new BasicHttpContext();
        DefaultHttpClient httpclient = new DefaultHttpClient();

        try {
            String e = apiEndpoint + "publisher/site/blocks/life-cycles/ajax/life-cycles.jag";
            HttpPost httppost = new HttpPost(e);
            MultipartEntity multipartEntity = new MultipartEntity();
            multipartEntity.addPart("action", new StringBody("updateStatus"));
            multipartEntity.addPart("name", new StringBody(serviceName));
            multipartEntity.addPart("version", new StringBody(this.getArtifact().getAttribute("overview_version")));
            multipartEntity.addPart("provider", new StringBody(apiCreator));
            multipartEntity.addPart("status", new StringBody("BLOCKED"));
            multipartEntity.addPart("publishToGateway", new StringBody("true"));
            ResponseAPIM responseAPIM = APIUtils.doPostToAPIMPublisherAPI(httpclient, httppost, multipartEntity, httpContext);
            if(responseAPIM.getError().equalsIgnoreCase("true")) {
                String errorMessage = responseAPIM.getMessage();
                LOG.error(errorMessage);
                if(errorMessage != null && errorMessage.contains("Cannot retire the Service/API")) {
                    LOG.error("Cannot demote Service/API due to active subscriptions in API Manager : " + apiEnvironment);
                    throw new GovernanceExceptions("Cannot demote Service/API due to active subscriptions in API Manager : " + apiEnvironment);
                }

                LOG.error("Error occurred while deleting the Service/API from API Manager : " + apiEnvironment);
                throw new GovernanceExceptions("Error occurred while deleting the Service/API from API Manager : " + apiEnvironment);
            }
        } catch (Exception var17) {
            LOG.error("Exception occurred when retire API From APIM, ");
            throw new GovernanceExceptions("Error occurred while deleting the Service/API from API Manager : " + apiEnvironment, var17);
        } finally {
            httpclient.getConnectionManager().shutdown();
        }

        return true;
    }
}
