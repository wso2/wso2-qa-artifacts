//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.extensions.utils;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.qatest.pi.governance.registry.extensions.utils.GovernanceExceptions;
import org.qatest.pi.governance.registry.extensions.utils.ResponseAPIM;
import org.wso2.carbon.registry.core.Registry;
import org.wso2.carbon.registry.core.Resource;
import org.wso2.carbon.registry.core.exceptions.RegistryException;

public final class APIUtils {
    private static final Log LOG = LogFactory.getLog(APIUtils.class);

    private APIUtils() {
    }

    public static void authenticateAPIM(HttpContext httpContext, String apimEndpoint, String apimUsername, String apimPassword) {
        if(apimEndpoint.charAt(apimEndpoint.length() - 1) != 47) {
            apimEndpoint = apimEndpoint + "/";
        }

        String loginEP = apimEndpoint + "publisher/site/blocks/user/login/ajax/login.jag";
        DefaultHttpClient httpclient = new DefaultHttpClient();

        try {
            HttpPost e = new HttpPost(loginEP);
            MultipartEntity multipartEntity = new MultipartEntity();
            multipartEntity.addPart("action", new StringBody("login"));
            multipartEntity.addPart("username", new StringBody(apimUsername));
            multipartEntity.addPart("password", new StringBody(apimPassword));
            e.setEntity(multipartEntity);
            HttpResponse response = httpclient.execute(e, httpContext);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            if(response.getStatusLine().getStatusCode() != 200) {
                LOG.error(" Authentication with APIM failed: HTTP error code : " + response.getStatusLine().getStatusCode());
                throw new GovernanceExceptions("Authentication failed with API Manager. Please check the credentials");
            }

            Gson gson = new Gson();
            ResponseAPIM responseAPIM = (ResponseAPIM)gson.fromJson(responseString, ResponseAPIM.class);
            if(responseAPIM.getError().equalsIgnoreCase("true")) {
                throw new GovernanceExceptions("Authentication failed with API Manager. Please check the credentials");
            }
        } catch (Exception var16) {
            throw new GovernanceExceptions("Authentication failed with API Manager. Please check the credentials", var16);
        } finally {
            httpclient.getConnectionManager().shutdown();
        }

    }

    public static ResponseAPIM doPostToAPIMPublisherAPI(HttpClient httpclient, HttpPost httppost, MultipartEntity multipartEntity, HttpContext httpContext) {
        try {
            httppost.setEntity(multipartEntity);
            HttpResponse e = httpclient.execute(httppost, httpContext);
            if(e.getStatusLine().getStatusCode() != 200) {
                throw new GovernanceExceptions("Failed : HTTP error code : " + e.getStatusLine().getStatusCode());
            } else {
                HttpEntity entity = e.getEntity();
                String responseString = EntityUtils.toString(entity, "UTF-8");
                Gson gson = new Gson();
                return (ResponseAPIM)gson.fromJson(responseString, ResponseAPIM.class);
            }
        } catch (SocketTimeoutException var8) {
            throw new GovernanceExceptions("Connection timed out, Please check the network availability", var8);
        } catch (UnsupportedEncodingException var9) {
            throw new GovernanceExceptions("Unsupported encode exception.", var9);
        } catch (IOException var10) {
            throw new GovernanceExceptions("IO Exception occurred.", var10);
        } catch (Exception var11) {
            throw new GovernanceExceptions(var11.getMessage(), var11);
        }
    }

    public static MultipartEntity addOwnershipDetails(MultipartEntity multipartEntity, List<String> contactsEntry) throws UnsupportedEncodingException {
        String temp = "";
        String techOwnerEmail = null;
        String techOwnerCorpId = null;
        Iterator i$ = contactsEntry.iterator();

        while(i$.hasNext()) {
            String contact = (String)i$.next();
            temp = contact.substring(0, contact.indexOf(":"));
            if(temp.equalsIgnoreCase("Business Owner")) {
                multipartEntity.addPart("bizOwner", new StringBody(contact.substring(contact.indexOf(":") + 1)));
            }

            if(temp.equalsIgnoreCase("Technical Owner")) {
                multipartEntity.addPart("techOwner", new StringBody(contact.substring(contact.indexOf(":") + 1)));
            }

            if(temp.equalsIgnoreCase("Technical Owner Email")) {
                techOwnerEmail = contact.substring(contact.indexOf(":") + 1);
                multipartEntity.addPart("techOwnerMail", new StringBody(techOwnerEmail));
            }

            if(temp.equalsIgnoreCase("Technical Owner CorpId")) {
                multipartEntity.addPart("techOwnerCorpId", new StringBody(contact.substring(contact.indexOf(":") + 1)));
            }

            if(temp.equalsIgnoreCase("Business Owner Email")) {
                multipartEntity.addPart("bizOwnerMail", new StringBody(contact.substring(contact.indexOf(":") + 1)));
            }

            if(temp.equalsIgnoreCase("Tribe Lead")) {
                multipartEntity.addPart("techOwner", new StringBody(contact.substring(contact.indexOf(":") + 1)));
            }

            if(temp.equalsIgnoreCase("Tribe Lead Email")) {
                techOwnerEmail = contact.substring(contact.indexOf(":") + 1);
                multipartEntity.addPart("techOwnerMail", new StringBody(techOwnerEmail));
            }

            if(temp.equalsIgnoreCase("Tribe Lead CorpId")) {
                techOwnerCorpId = contact.substring(contact.indexOf(":") + 1);
                multipartEntity.addPart("techOwnerCorpId", new StringBody(techOwnerCorpId));
            }
        }

        if(techOwnerEmail == null) {
            techOwnerEmail = techOwnerCorpId + "@fmr.com";
            multipartEntity.addPart("techOwnerMail", new StringBody(techOwnerEmail));
        }

        return multipartEntity;
    }

    public static void updatePromotedProperty(String publishedEnv, Resource resource, Registry registry) {
        try {
            String ex = resource.getProperty("published_env");
            if(ex == null) {
                ex = "";
            } else if(ex.length() > 0) {
                ex = ex + ",";
            }

            if(ex.length() < 1 || ex.indexOf(publishedEnv) == -1) {
                resource.setProperty("published_env", ex + publishedEnv);
                String artifactRelativePath = resource.getPath().substring("/_system/governance".length());
                registry.put(artifactRelativePath, resource);
            }

        } catch (RegistryException var5) {
            throw new GovernanceExceptions(var5.getMessage(), var5);
        }
    }
}
