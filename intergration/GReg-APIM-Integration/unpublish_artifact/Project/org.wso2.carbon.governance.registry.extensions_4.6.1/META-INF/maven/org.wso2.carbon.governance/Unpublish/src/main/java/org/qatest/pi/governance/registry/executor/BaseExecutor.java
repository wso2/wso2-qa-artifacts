//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.executor;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;
import javax.xml.stream.XMLStreamException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.protocol.HttpContext;
import org.qatest.pi.governance.registry.extensions.utils.APIUtils;
import org.qatest.pi.governance.registry.extensions.utils.GovernanceExceptions;
import org.qatest.pi.governance.registry.extensions.utils.PropertyFileHelper;
import org.wso2.carbon.governance.api.generic.dataobjects.GenericArtifact;
import org.wso2.carbon.governance.registry.extensions.interfaces.Execution;
import org.wso2.carbon.registry.core.Registry;
import org.wso2.carbon.registry.core.Resource;

public abstract class BaseExecutor implements Execution {
    private static final Log LOG = LogFactory.getLog(BaseExecutor.class);
    private String apiThrottlingTier = "Unlimited,Unlimited,Unlimited,Unlimited,Unlimited";
    private String gregUserName = null;
    private Registry registry;
    private Resource resource;
    private GenericArtifact artifact;

    public BaseExecutor() {
    }

    protected String getGregUserName() {
        return this.gregUserName;
    }

    protected void setGregUserName(String gregUserName) {
        this.gregUserName = gregUserName;
    }

    protected String getApiThrottlingTier() {
        return this.apiThrottlingTier;
    }

    protected void setApiThrottlingTier(String apiThrottlingTier) {
        this.apiThrottlingTier = apiThrottlingTier;
    }

    protected Registry getRegistry() {
        return this.registry;
    }

    protected void setRegistry(Registry registry) {
        this.registry = registry;
    }

    protected Resource getResource() {
        return this.resource;
    }

    protected void setResource(Resource resource) {
        this.resource = resource;
    }

    protected GenericArtifact getArtifact() {
        return this.artifact;
    }

    protected void setArtifact(GenericArtifact artifact) {
        this.artifact = artifact;
    }

    public void init(Map parameterMap) {
        if(parameterMap.containsKey("throttlingTier")) {
            this.apiThrottlingTier = parameterMap.get("throttlingTier").toString();
        }

        try {
            PropertyFileHelper.initialize("repository/conf/gregproperties.xml");
        } catch (IOException var3) {
            LOG.error("IOException Occured in initializing PropertyFileHelper");
            throw new GovernanceExceptions("Error while reading properties file", var3);
        } catch (XMLStreamException var4) {
            LOG.error("xmlStreamException Occured in initializing PropertyFileHelper");
            throw new GovernanceExceptions("Error while reading properties file", var4);
        }
    }

    protected void authenticateWithAPIM(HttpContext httpContext, String apimEnv, String apiEndpoint, String pubUser, String pubPassword) {
        if(apiEndpoint != null && pubUser != null && pubPassword != null) {
            BasicCookieStore cookieStore = new BasicCookieStore();
            httpContext.setAttribute("http.cookie-store", cookieStore);

            try {
                APIUtils.authenticateAPIM(httpContext, apiEndpoint, pubUser, pubPassword);
            } catch (Exception var9) {
                String errorCauseMessage = var9.getCause().getMessage();
                if(errorCauseMessage != null && errorCauseMessage.contains("Connection to")) {
                    LOG.error("Error occurred while authenticating to API Manager :" + apimEnv + " - " + errorCauseMessage, var9);
                    throw new GovernanceExceptions(errorCauseMessage, var9);
                } else {
                    LOG.error("Error occurred while authenticating to API Manager :" + apimEnv, var9);
                    throw new GovernanceExceptions("Error occurred while authenticating to API Manager :" + apimEnv, var9);
                }
            }
        } else {
            LOG.error("API publishing/unpublishing failed.APIManager server URL or credentials are missing.");
            throw new GovernanceExceptions("API publishing/unpublishing failed.APIManager server URL or credentials are missing.");
        }
    }

    protected int populateActions(List<String> actions, int count) {
        int localCount = count;
        Properties props = this.getResource().getProperties();
        Iterator i$ = props.entrySet().iterator();

        while(true) {
            Entry entry;
            String propKey;
            do {
                do {
                    if(!i$.hasNext()) {
                        return localCount;
                    }

                    entry = (Entry)i$.next();
                    propKey = (String)entry.getKey();
                } while(!propKey.startsWith("registry.custom_lifecycle.checklist."));
            } while(propKey.endsWith("permission"));

            boolean isChecked = false;
            String checkListItem = "";
            List propValues = (List)entry.getValue();
            Iterator i$1 = propValues.iterator();

            while(true) {
                while(i$1.hasNext()) {
                    String prop = (String)i$1.next();
                    if(prop.startsWith("value") && prop.endsWith("true")) {
                        isChecked = true;
                        ++localCount;
                    } else if(prop.startsWith("name")) {
                        String[] arr = prop.split(":");
                        checkListItem = arr[1];
                    }
                }

                if(isChecked) {
                    actions.add(checkListItem);
                }
                break;
            }
        }
    }

    protected void handleException(String errorMsg, String env, String event) {
        if(!errorMsg.equals("API publishing/unpublishing failed.APIManager server URL or credentials are missing.") && !errorMsg.contains("Error occurred while authenticating to API Manager :") && !errorMsg.equals("Authentication failed with API Manager. Please check the credentials") && !errorMsg.equals("Connection timed out, Please check the network availability")) {
            if(errorMsg.contains("A duplicate API already exists for ")) {
                throw new GovernanceExceptions("API publishing failed.A duplicate API already exists in :" + env);
            } else if(errorMsg.contains("API publishing failed.Service Endpoint is missing for the environment :")) {
                throw new GovernanceExceptions("API publishing failed.Service Endpoint is missing for the environment :" + env);
            } else if(errorMsg.contains("API un-publishing failed.Active Subscriptions Exist :")) {
                throw new GovernanceExceptions("API un-publishing failed.Active Subscriptions Exist :" + env);
            } else {
                LOG.error(errorMsg);
                if(event.equals("publish")) {
                    throw new GovernanceExceptions("Exception occurred while publishing API to APIManager :" + env);
                } else {
                    throw new GovernanceExceptions("Exception occurred while un-publishing API from APIManager :" + env);
                }
            }
        } else if(event.equals("publish")) {
            throw new GovernanceExceptions("API publishing failed.Cannot connect to APIManager in environment : " + env);
        } else {
            throw new GovernanceExceptions("API un-publishing failed.Cannot connect to APIManager in environment : " + env);
        }
    }

    protected void extractActions(List<String> actionItems, List<String> actions) {
        Iterator iterator = actionItems.iterator();

        while(iterator.hasNext()) {
            String actionString = (String)iterator.next();
            if(actionString.contains("DIT")) {
                actions.add("DIT");
            } else if(actionString.contains("FAC")) {
                actions.add("FAC");
            } else if(actionString.contains("PAC")) {
                actions.add("PAC");
            } else if(actionString.contains("PIN")) {
                actions.add("PIN");
            } else {
                actions.add(actionString);
            }
        }

    }
}
