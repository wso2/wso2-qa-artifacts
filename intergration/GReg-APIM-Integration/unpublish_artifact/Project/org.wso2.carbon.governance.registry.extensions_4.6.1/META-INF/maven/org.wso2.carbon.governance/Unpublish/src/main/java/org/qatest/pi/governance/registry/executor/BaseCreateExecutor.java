//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.executor;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import javax.xml.stream.XMLStreamException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.qatest.pi.governance.registry.executor.BaseExecutor;
import org.qatest.pi.governance.registry.extensions.utils.APIUtils;
import org.qatest.pi.governance.registry.extensions.utils.GovernanceExceptions;
import org.qatest.pi.governance.registry.extensions.utils.PropertyFileHelper;
import org.qatest.pi.governance.registry.extensions.utils.ResponseAPIM;
import org.wso2.carbon.governance.api.exception.GovernanceException;
import org.wso2.carbon.registry.core.Resource;
import org.wso2.carbon.registry.core.Tag;
import org.wso2.carbon.registry.core.exceptions.RegistryException;

public abstract class BaseCreateExecutor extends BaseExecutor {
    private static final Log LOG = LogFactory.getLog(BaseCreateExecutor.class);

    public BaseCreateExecutor() {
    }

    protected boolean retrieveDataAndPublish(String apiName, String user, String artifactRelativePath, Resource apiArtifact) {
        String publishedEnv = null;
        String failedEnv = null;
        String failedEnvMsg = null;
        ArrayList actions = new ArrayList();
        ArrayList actionItems = new ArrayList();
        byte start = 0;
        int count = this.populateActions(actionItems, start);
        this.extractActions(actionItems, actions);
        if(count < 1) {
            throw new GovernanceExceptions("Please Select an Environment for Publish/Unpublish Operation");
        } else {
            List successEnvList = this.isMultiEnvironmentPublishEvent(actions, count);

            try {
                PropertyFileHelper.initialize("repository/conf/gregproperties.xml");
            } catch (IOException var20) {
                LOG.error("IOException Occured in initializing PropertyFileHelper");
                throw new GovernanceExceptions("Error while reading properties file", var20);
            } catch (XMLStreamException var21) {
                LOG.error("xmlStreamException Occured in initializing PropertyFileHelper");
                throw new GovernanceExceptions("Error while reading properties file", var21);
            }

            Iterator i$ = actions.iterator();

            while(i$.hasNext()) {
                String action = (String)i$.next();
                if(!successEnvList.contains(action)) {
                    try {
                        this.getResource().setProperty("api_creator_" + action, user);
                        this.getRegistry().put(artifactRelativePath, apiArtifact);
                        String e = PropertyFileHelper.getValue(action + "_APIM_PUB_ENDPOINT", "https://apipublisher.fmr.com/");
                        String pubuserName;
                        String pubPassword;
                        if(action.contains("PROD")) {
                            pubuserName = PropertyFileHelper.getValue("PROD_APIM_PUB_USERNAME", "admin");
                            pubPassword = PropertyFileHelper.getValue("PROD_APIM_PUB_PWD", "admin");
                        } else {
                            pubuserName = PropertyFileHelper.getValue("NONPROD_APIM_PUB_USERNAME", "admin");
                            pubPassword = PropertyFileHelper.getValue("NONPROD_APIM_PUB_PWD", "admin");
                        }

                        this.publishDataToAPIM(apiName, action, e, pubuserName, pubPassword, user);
                        publishedEnv = action;
                    } catch (GovernanceExceptions var18) {
                        failedEnv = action;
                        failedEnvMsg = var18.getMessage();
                    } catch (RegistryException var19) {
                        failedEnv = action;
                        failedEnvMsg = var19.getMessage();
                    }
                }
            }

            if(publishedEnv != null) {
                APIUtils.updatePromotedProperty(publishedEnv, this.getResource(), this.getRegistry());
            }

            if(failedEnv != null) {
                this.handleException(failedEnvMsg, failedEnv, "publish");
                return false;
            } else {
                return true;
            }
        }
    }

    private List<String> isMultiEnvironmentPublishEvent(List<String> actions, int count) {
        Object successEnvList = new ArrayList();
        String successPublishedEnvs = this.getResource().getProperty("published_env");
        successPublishedEnvs = null;
        if(successPublishedEnvs == null) {
            if(count > 1) {
                throw new GovernanceExceptions("Select only one APIManager environment at a time,to publish as an API.");
            }
        } else {
            String[] successEnvArray = successPublishedEnvs.split(",");
            successEnvList = Arrays.asList(successEnvArray);
            int matches = 0;
            Iterator delta = actions.iterator();

            while(delta.hasNext()) {
                String action = (String)delta.next();

                for(int i = 0; i < successEnvArray.length; ++i) {
                    if(action.endsWith(successEnvArray[i])) {
                        ++matches;
                    }
                }
            }

            if(count <= matches) {
                throw new GovernanceExceptions("The API has been already published to the selected APIManager environments.");
            }

            int var10 = count - matches;
            if(var10 > 1) {
                throw new GovernanceExceptions("Select only one APIManager environment at a time,to publish as an API.");
            }
        }

        return (List)successEnvList;
    }

    protected boolean publishDataToAPIM(String serviceName, String apiEnvironment, String pubEndpoint, String pubUser, String pubPassword, String userName) throws GovernanceExceptions {
        boolean valid = true;
        BasicHttpContext httpContext = new BasicHttpContext();
        this.authenticateWithAPIM(httpContext, apiEnvironment, pubEndpoint, pubUser, pubPassword);
        DefaultHttpClient httpclient = new DefaultHttpClient();

        try {
            if(pubEndpoint.charAt(pubEndpoint.length() - 1) != 47) {
                pubEndpoint = pubEndpoint + "/";
            }

            String e = pubEndpoint + "publisher/site/blocks/item-add/ajax/add.jag";
            HttpPost httppost = new HttpPost(e);
            MultipartEntity multipartEntity = new MultipartEntity();
            String[] endPoints = null;
            if(this.getArtifact().getAttributes("endpoints_entry") != null) {
                endPoints = this.getArtifact().getAttributes("endpoints_entry");
            } else if(this.getArtifact().getAttributes("implementationEndpoints_entry") != null) {
                endPoints = this.getArtifact().getAttributes("implementationEndpoints_entry");
            }

            if(endPoints != null && endPoints.length >= 1) {
                List endPointsList = Arrays.asList(endPoints);
                String artifactAbsolutePath = this.getResource().getPath();
                String artifactRelativePath = artifactAbsolutePath.substring("/_system/governance".length());
                if(artifactRelativePath.startsWith("/trunk/services")) {
                    this.addSvcCreateParameters(multipartEntity, serviceName, apiEnvironment, userName, endPointsList);
                } else {
                    this.addAPICreateParameters(multipartEntity, serviceName, apiEnvironment, userName, endPointsList);
                }

                ResponseAPIM responseAPIM = APIUtils.doPostToAPIMPublisherAPI(httpclient, httppost, multipartEntity, httpContext);
                if(!responseAPIM.getError().equalsIgnoreCase("true")) {
                    this.publishdocLinksToApim(pubEndpoint, serviceName, userName, endPointsList, apiEnvironment, httpclient, httpContext);
                    return true;
                } else {
                    String errorMessage = responseAPIM.getMessage();
                    if(errorMessage != null && errorMessage.contains("A duplicate API already exists for ")) {
                        LOG.error("A duplicate API already exists for " + serviceName + " in API Manager : " + apiEnvironment);
                        throw new GovernanceExceptions("A duplicate API already exists for " + serviceName + " in API Manager : " + apiEnvironment);
                    } else {
                        LOG.error("Exception occurred while publishing API to APIManager :" + errorMessage);
                        throw new GovernanceExceptions(errorMessage);
                    }
                }
            } else {
                LOG.error("API publishing failed.Service Endpoint is missing for the environment :" + apiEnvironment);
                throw new GovernanceExceptions("API publishing failed.Service Endpoint is missing for the environment :" + apiEnvironment);
            }
        } catch (Exception var22) {
            LOG.error("Exception occurred while publishing API to APIManager :");
            throw new GovernanceExceptions(var22.getMessage(), var22);
        } finally {
            httpclient.getConnectionManager().shutdown();
        }
    }

    private void publishdocLinksToApim(String pubEndpoint, String serviceName, String userName, List<String> endPointsList, String apiEnvironment, HttpClient httpclient, HttpContext httpContext) throws GovernanceException, UnsupportedEncodingException {
        String addDocsEndpoint = pubEndpoint + "publisher/site/blocks/documentation/ajax/docs.jag";
        HttpPost httpDocsPost = new HttpPost(addDocsEndpoint);
        MultipartEntity multipartDocsEntity = null;
        HashMap attMap = new HashMap();
        String[] docsLinks = this.getArtifact().getAttributes("docLinks_entry");
        List docLinksList = Arrays.asList(docsLinks);
        Iterator i$;
        if(CollectionUtils.isNotEmpty(docLinksList)) {
            i$ = docLinksList.iterator();

            while(i$.hasNext()) {
                String key = (String)i$.next();
                if(StringUtils.isNotEmpty(key)) {
                    attMap.put(key.substring(0, key.indexOf(":")), key.substring(key.indexOf(":") + 1));
                }
            }
        }

        if(MapUtils.isNotEmpty(attMap)) {
            multipartDocsEntity = new MultipartEntity();
            i$ = attMap.entrySet().iterator();

            while(i$.hasNext()) {
                Entry key1 = (Entry)i$.next();
                String docType = (String)key1.getKey();
                String docLinkUrl = (String)key1.getValue();
                multipartDocsEntity.addPart("action", new StringBody("addDocumentation"));
                multipartDocsEntity.addPart("mode", new StringBody("add"));
                multipartDocsEntity.addPart("docName", new StringBody(docType));
                multipartDocsEntity.addPart("docUrl", new StringBody(docLinkUrl));
                multipartDocsEntity.addPart("docType", new StringBody("how to"));
                multipartDocsEntity.addPart("summary", new StringBody("summary"));
                multipartDocsEntity.addPart("sourceType", new StringBody("URL"));
                multipartDocsEntity.addPart("name", new StringBody(serviceName));
                multipartDocsEntity.addPart("version", new StringBody(this.getArtifact().getAttribute("overview_version")));
                multipartDocsEntity.addPart("apiName", new StringBody(serviceName));
                multipartDocsEntity.addPart("name", new StringBody(serviceName));
                multipartDocsEntity.addPart("provider", new StringBody(userName));
                ResponseAPIM responseAPIM = APIUtils.doPostToAPIMPublisherAPI(httpclient, httpDocsPost, multipartDocsEntity, httpContext);
                if(responseAPIM.getError().equalsIgnoreCase("true")) {
                    String errorMessage = responseAPIM.getMessage();
                    LOG.error("Exception occurred while publishing API to APIManager :" + errorMessage);
                    throw new GovernanceExceptions(errorMessage);
                }
            }
        }

    }

    protected void addCommonParameters(MultipartEntity multipartEntity, String apiName, String apiEnvironment, String userName, List<String> endPointsList) throws UnsupportedEncodingException, GovernanceException, RegistryException {
        multipartEntity.addPart("action", new StringBody("addAPI"));
        multipartEntity.addPart("name", new StringBody(apiName));
        multipartEntity.addPart("version", new StringBody(this.getArtifact().getAttribute("overview_version")));
        multipartEntity.addPart("visibility", new StringBody("public"));
        StringBuilder tagsContent = new StringBuilder();
        if(StringUtils.isNotEmpty(this.getArtifact().getAttribute("overview_businessUnit"))) {
            tagsContent.append(this.getArtifact().getAttribute("overview_businessUnit"));
        }

        if(StringUtils.isNotEmpty(this.getArtifact().getAttribute("overview_serviceCategory"))) {
            tagsContent.append(",");
            tagsContent.append(this.getArtifact().getAttribute("overview_serviceCategory"));
        }

        String artifactAbsolutePath = this.getResource().getPath();
        String artifactRelativePath = artifactAbsolutePath.substring("/_system/governance".length());
        Tag[] tags = this.getRegistry().getTags(artifactRelativePath);
        Object tagsList = new ArrayList();
        if(tags != null) {
            tagsList = Arrays.asList(tags);
        }

        if(CollectionUtils.isNotEmpty((Collection)tagsList)) {
            Tag[] endpointConfigJson = tags;
            int ownershipDetails = tags.length;

            for(int ownershipDetailsList = 0; ownershipDetailsList < ownershipDetails; ++ownershipDetailsList) {
                Tag tag = endpointConfigJson[ownershipDetailsList];
                if(tag != null && StringUtils.isNotEmpty(tag.getTagName())) {
                    tagsContent.append(",");
                    tagsContent.append(tag.getTagName());
                }
            }
        }

        multipartEntity.addPart("tags", new StringBody(tagsContent.toString()));
        multipartEntity.addPart("endpointType", new StringBody("nonsecured"));
        multipartEntity.addPart("provider", new StringBody(userName));
        multipartEntity.addPart("endpoint", new StringBody(this.getEnvironmentUrl(endPointsList, apiEnvironment)));
        String var15 = "{\"production_endpoints\":{\"url\":\"" + this.getEnvironmentUrl(endPointsList, apiEnvironment) + "\",\"config\":null},\"endpoint_type\":\"http\"}";
        multipartEntity.addPart("endpoint_config", new StringBody(var15));
        String[] var16 = this.getArtifact().getAttributes("contacts_entry");
        List var17 = Arrays.asList(var16);
        APIUtils.addOwnershipDetails(multipartEntity, var17);
        multipartEntity.addPart("subscriptions", new StringBody("current_tenant"));
    }

    protected String getEnvironmentUrl(List<String> endpointsEntry, String apiEnvironment) {
        Iterator i$ = endpointsEntry.iterator();

        String att;
        do {
            if(!i$.hasNext()) {
                LOG.error("API publishing failed.Service Endpoint is missing for the environment :" + apiEnvironment);
                throw new GovernanceExceptions("API publishing failed.Service Endpoint is missing for the environment :" + apiEnvironment);
            }

            att = (String)i$.next();
        } while(!att.substring(0, att.indexOf(":")).equalsIgnoreCase(apiEnvironment));

        return att.substring(att.indexOf(":") + 1);
    }

    protected void addPublishParameters(MultipartEntity multipartEntity, String serviceName, String provider) throws UnsupportedEncodingException, GovernanceException {
        multipartEntity.addPart("action", new StringBody("updateStatus"));
        multipartEntity.addPart("name", new StringBody(serviceName));
        multipartEntity.addPart("version", new StringBody(this.getArtifact().getAttribute("overview_version")));
        multipartEntity.addPart("provider", new StringBody(provider));
        multipartEntity.addPart("status", new StringBody("PUBLISHED"));
        multipartEntity.addPart("publishToGateway", new StringBody("true"));
        multipartEntity.addPart("requireResubscription", new StringBody("true"));
    }

    protected void addURITempletes(MultipartEntity multipartEntity) throws UnsupportedEncodingException, GovernanceException {
        if(!this.getResource().getProperties().containsKey("uritemplate_urlPattern0") && !this.getResource().getProperties().containsKey("uritemplate_urlPattern1")) {
            multipartEntity.addPart("uriTemplate-0", new StringBody("/*"));
            multipartEntity.addPart("resourceMethod-0", new StringBody("POST,GET,PUT,DELETE,OPTIONS"));
            multipartEntity.addPart("resourceMethodAuthType-0", new StringBody("Any,Any,Any,Any,None"));
            multipartEntity.addPart("resourceMethodThrottlingTier-0", new StringBody(this.getApiThrottlingTier()));
        } else {
            int x = 0;

            for(int i = 0; i < 5; ++i) {
                if(this.getResource().getProperties().containsKey("uritemplate_urlPattern" + Integer.toString(i))) {
                    multipartEntity.addPart("uriTemplate-" + Integer.toString(i), new StringBody(this.getArtifact().getAttribute("uritemplate_urlPattern" + Integer.toString(i))));
                    multipartEntity.addPart("resourceMethod-" + Integer.toString(i), new StringBody(this.getArtifact().getAttribute("uritemplate_httpVerb" + Integer.toString(i))));
                    multipartEntity.addPart("resourceMethodAuthType-" + Integer.toString(i), new StringBody(this.getArtifact().getAttribute("uritemplate_authType" + Integer.toString(i))));
                    multipartEntity.addPart("resourceMethodThrottlingTier-" + Integer.toString(i), new StringBody(this.getApiThrottlingTier()));
                    ++x;
                }
            }

            multipartEntity.addPart("resourceCount", new StringBody(Integer.toString(x)));
        }

    }

    protected void addAPICreateParameters(MultipartEntity multipartEntity, String apiName, String apiEnvironment, String userName, List<String> apiEndpoints) throws UnsupportedEncodingException, GovernanceException, RegistryException {
        this.addCommonParameters(multipartEntity, apiName, apiEnvironment, userName, apiEndpoints);
        if(StringUtils.isNotEmpty(this.getArtifact().getAttribute("overview_uriContext"))) {
            multipartEntity.addPart("context", new StringBody(this.getArtifact().getAttribute("overview_uriContext")));
        } else if(StringUtils.isNotEmpty(this.getArtifact().getAttribute("overview_apiManagerGatewayRootURI"))) {
            multipartEntity.addPart("context", new StringBody(this.getArtifact().getAttribute("overview_apiManagerGatewayRootURI")));
        }

        multipartEntity.addPart("description", new StringBody(this.getArtifact().getAttribute("overview_capabilityDescription")));
        String thumbPath = null;
        if(StringUtils.isNotEmpty(this.getArtifact().getAttribute("overview_businessUnit"))) {
            thumbPath = this.getAPIThumbPath(this.getArtifact().getAttribute("overview_businessUnit"));
        } else {
            thumbPath = this.getAPIThumbPath("");
        }

        FileBody thumbnailImage = this.getThumbnailImage(thumbPath);
        if(thumbnailImage != null) {
            ;
        }

        this.addURITempletes(multipartEntity);
    }

    protected void addSvcCreateParameters(MultipartEntity multipartEntity, String serviceName, String apiEnvironment, String userName, List<String> svcEndpoints) throws UnsupportedEncodingException, GovernanceException, RegistryException {
        this.addCommonParameters(multipartEntity, serviceName, apiEnvironment, userName, svcEndpoints);
        multipartEntity.addPart("context", new StringBody(serviceName));
        multipartEntity.addPart("uriTemplate-0", new StringBody("/*"));
        multipartEntity.addPart("resourceMethod-0", new StringBody("POST,GET,PUT,DELETE,OPTIONS"));
        multipartEntity.addPart("resourceMethodAuthType-0", new StringBody("Any,Any,Any,Any,None"));
        multipartEntity.addPart("resourceMethodThrottlingTier-0", new StringBody(this.getApiThrottlingTier()));
        multipartEntity.addPart("description", new StringBody(this.getArtifact().getAttribute("overview_description")));
        String thumbPath = this.getServiceThumbPath(this.getArtifact().getAttribute("overview_businessUnit"));
        FileBody thumbnailImage = this.getThumbnailImage(thumbPath);
        if(thumbnailImage != null) {
            multipartEntity.addPart("apiThumb", thumbnailImage);
        }

    }

    protected FileBody getThumbnailImage(String thumbPath) {
        File image = new File(thumbPath);
        return new FileBody(image);
    }

    private String getAPIThumbPath(String businessUnit) {
        byte var4 = -1;
        switch(businessUnit.hashCode()) {
            case 2243:
                if(businessUnit.equals("FI")) {
                    var4 = 2;
                }
                break;
            case 2553:
                if(businessUnit.equals("PI")) {
                    var4 = 0;
                }
                break;
            case 2770:
                if(businessUnit.equals("WI")) {
                    var4 = 1;
                }
                break;
            case 2150957:
                if(businessUnit.equals("FBCT")) {
                    var4 = 4;
                }
                break;
            case 2157994:
                if(businessUnit.equals("FIMT")) {
                    var4 = 5;
                }
                break;
            case 2545354:
                if(businessUnit.equals("SIPD")) {
                    var4 = 3;
                }
        }

        String registryPath;
        switch(var4) {
            case 0:
                registryPath = "repository/resources/api-images/fmrapi/PI_REST.png";
                break;
            case 1:
                registryPath = "repository/resources/api-images/fmrapi/WI_REST.png";
                break;
            case 2:
                registryPath = "repository/resources/api-images/fmrapi/FI_REST.png";
                break;
            case 3:
                registryPath = "repository/resources/api-images/fmrapi/SIPD_REST.png";
                break;
            case 4:
                registryPath = "repository/resources/api-images/fmrapi/FBCT_REST.png";
                break;
            case 5:
                registryPath = "repository/resources/api-images/fmrapi/FIMT_REST.png";
                break;
            default:
                registryPath = "repository/resources/api-images/fmrapi/rest.png";
        }

        return registryPath;
    }

    private String getServiceThumbPath(String businessUnit) {
        byte var4 = -1;
        switch(businessUnit.hashCode()) {
            case 2243:
                if(businessUnit.equals("FI")) {
                    var4 = 2;
                }
                break;
            case 2553:
                if(businessUnit.equals("PI")) {
                    var4 = 0;
                }
                break;
            case 2770:
                if(businessUnit.equals("WI")) {
                    var4 = 1;
                }
                break;
            case 2150957:
                if(businessUnit.equals("FBCT")) {
                    var4 = 4;
                }
                break;
            case 2157994:
                if(businessUnit.equals("FIMT")) {
                    var4 = 5;
                }
                break;
            case 2545354:
                if(businessUnit.equals("SIPD")) {
                    var4 = 3;
                }
        }

        String registryPath;
        switch(var4) {
            case 0:
                registryPath = "repository/resources/api-images/fmrsvc/PI_SOAP.png";
                break;
            case 1:
                registryPath = "repository/resources/api-images/fmrsvc/WI_SOAP.png";
                break;
            case 2:
                registryPath = "repository/resources/api-images/fmrsvc/FI_SOAP.png";
                break;
            case 3:
                registryPath = "repository/resources/api-images/fmrsvc/SIPD_SOAP.png";
                break;
            case 4:
                registryPath = "repository/resources/api-images/fmrsvc/FBCT_SOAP.png";
                break;
            case 5:
                registryPath = "repository/resources/api-images/fmrsvc/FIMT_SOAP.png";
                break;
            default:
                registryPath = "repository/resources/api-images/fmrsvc/soap.png";
        }

        return registryPath;
    }
}
