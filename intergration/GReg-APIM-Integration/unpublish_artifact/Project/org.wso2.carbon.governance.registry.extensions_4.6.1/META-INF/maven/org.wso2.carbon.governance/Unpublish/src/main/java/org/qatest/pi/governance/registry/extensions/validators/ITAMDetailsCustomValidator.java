//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.extensions.validators;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.apache.juddi.v3.client.mapping.MockSSLSocketFactory;
import org.qatest.pi.governance.registry.extensions.utils.GovernanceExceptions;
import org.qatest.pi.governance.registry.extensions.validators.BaseCustomValidations;
import org.json.JSONException;
import org.json.JSONObject;
import org.wso2.carbon.registry.core.jdbc.handlers.RequestContext;

public class ITAMDetailsCustomValidator extends BaseCustomValidations {
    private static final Log LOG = LogFactory.getLog(ITAMDetailsCustomValidator.class);
    private String apiKey = "";
    private String url = "";

    public ITAMDetailsCustomValidator() {
    }

    public void init(Map map) {
        this.apiKey = (String)map.get("API_KEY");
        this.url = (String)map.get("url");
    }

    public boolean validate(RequestContext context) {
        try {
            if(!this.preValidate(context)) {
                return false;
            } else if(StringUtils.isEmpty(this.getGovernanceArtifact().getAttribute("assetManagement_appID"))) {
                throw new GovernanceExceptions("Please Provide Asset Management ApplicationID.");
            } else if(!StringUtils.isAlphanumeric(this.getGovernanceArtifact().getAttribute("assetManagement_appID"))) {
                throw new GovernanceExceptions("Please Provide aplha numericals only for ApplicationID.");
            } else {
                String e = "";
                String prdName = "";
                if(StringUtils.isNotEmpty(this.getGovernanceArtifact().getAttribute("assetManagement_productLine"))) {
                    e = this.getGovernanceArtifact().getAttribute("assetManagement_productLine").trim();
                }

                if(StringUtils.isNotEmpty(this.getGovernanceArtifact().getAttribute("assetManagement_product"))) {
                    prdName = this.getGovernanceArtifact().getAttribute("assetManagement_product").trim();
                }

                String appID = this.getGovernanceArtifact().getAttribute("assetManagement_appID").trim();
                JSONObject jb = this.callITAMAPI(appID);
                if(!jb.get("status").equals("Approved")) {
                    throw new GovernanceExceptions(appID + " is not in Approved status, Please check the appID again.");
                } else if(!jb.get("productLineName").toString().trim().equalsIgnoreCase(e)) {
                    throw new GovernanceExceptions("Product line is not correct. Correct product line associated with the app id should be " + jb.get("productLineName").toString());
                } else if(!jb.get("productName").toString().trim().equalsIgnoreCase(prdName)) {
                    throw new GovernanceExceptions("Product name is not correct. Correct product name associated with app id should be " + jb.get("productName").toString());
                } else {
                    return true;
                }
            }
        } catch (Exception var6) {
            LOG.error("Error while validating the ITAM integration is correct.");
            throw new GovernanceExceptions(var6.getMessage(), var6);
        }
    }

    private JSONObject callITAMAPI(String appID) {
        DefaultHttpClient httpclient = null;

        JSONObject var9;
        try {
            SchemeRegistry e = new SchemeRegistry();
            e.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
            e.register(new Scheme("https", 443, new MockSSLSocketFactory()));
            SingleClientConnManager cm = new SingleClientConnManager(e);
            httpclient = new DefaultHttpClient(cm);
            HttpGet httpget = new HttpGet(this.url + "/" + appID);
            httpget.addHeader(new BasicHeader("API_KEY", this.apiKey));
            httpget.addHeader(new BasicHeader("Accept", "application/json"));
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            var9 = new JSONObject(responseString);
        } catch (NoSuchAlgorithmException var18) {
            LOG.error("Method not found", var18);
            throw new GovernanceExceptions(var18.getMessage(), var18);
        } catch (KeyManagementException var19) {
            LOG.error("Key management exception", var19);
            throw new GovernanceExceptions(var19.getMessage(), var19);
        } catch (KeyStoreException var20) {
            LOG.error("Keystore exception", var20);
            throw new GovernanceExceptions(var20.getMessage(), var20);
        } catch (UnrecoverableKeyException var21) {
            LOG.error("Unrecoverable key is found", var21);
            throw new GovernanceExceptions(var21.getMessage(), var21);
        } catch (JSONException var22) {
            LOG.error("Correct json object is not found. AppID may be wrong", var22);
            throw new GovernanceExceptions("Seems like AppID is wrong, Please check the AppID", var22);
        } catch (Exception var23) {
            LOG.error("Unexpected error occurred in ITAM connection", var23);
            throw new GovernanceExceptions("Unexpected error occurred", var23);
        } finally {
            if(httpclient != null) {
                httpclient.getConnectionManager().shutdown();
            }

        }

        return var9;
    }
}
