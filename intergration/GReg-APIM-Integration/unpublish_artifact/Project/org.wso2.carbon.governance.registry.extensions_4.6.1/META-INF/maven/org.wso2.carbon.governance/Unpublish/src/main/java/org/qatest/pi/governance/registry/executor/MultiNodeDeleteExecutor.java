//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.executor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;
import javax.xml.stream.XMLStreamException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qatest.pi.governance.registry.executor.BaseDeleteExecutor;
import org.qatest.pi.governance.registry.extensions.utils.GovernanceExceptions;
import org.qatest.pi.governance.registry.extensions.utils.PropertyFileHelper;
import org.wso2.carbon.context.CarbonContext;
import org.wso2.carbon.governance.api.generic.GenericArtifactManager;
import org.wso2.carbon.registry.core.Resource;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.core.internal.RegistryCoreServiceComponent;
import org.wso2.carbon.registry.core.jdbc.handlers.RequestContext;

public class MultiNodeDeleteExecutor extends BaseDeleteExecutor {
    private static final Log LOG = LogFactory.getLog(MultiNodeDeleteExecutor.class);

    public MultiNodeDeleteExecutor() {
    }

    public boolean execute(RequestContext context, String currentState, String targetState) {
        String unPublishedEnv = null;
        String failedEnv = null;
        String failedEnvMsg = "";
        this.setGregUserName(CarbonContext.getThreadLocalCarbonContext().getUsername());

        String apiName;
        String apiVersion;
        Resource apiArtifact;
        String artifactRelativePath;
        try {
            this.setRegistry(RegistryCoreServiceComponent.getRegistryService().getGovernanceUserRegistry(this.getGregUserName(), CarbonContext.getThreadLocalCarbonContext().getTenantId()));
            this.setResource(context.getResource());
            String actions = this.getResource().getPath();
            artifactRelativePath = actions.substring("/_system/governance".length());
            apiArtifact = this.getRegistry().get(artifactRelativePath);
            GenericArtifactManager actionItems;
            if(artifactRelativePath.startsWith("/trunk/services")) {
                actionItems = new GenericArtifactManager(this.getRegistry(), "service");
            } else if(artifactRelativePath.startsWith("/trunk/dpapis")) {
                actionItems = new GenericArtifactManager(this.getRegistry(), "dpapi");
            } else {
                actionItems = new GenericArtifactManager(this.getRegistry(), "fmrapi");
            }

            String start = apiArtifact.getUUID();
            this.setArtifact(actionItems.getGenericArtifact(start));
            apiName = this.getArtifact().getAttribute("overview_name");
            apiVersion = this.getArtifact().getAttribute("overview_version");
        } catch (Exception var24) {
            throw new GovernanceExceptions(var24.getMessage(), var24);
        }

        try {
            PropertyFileHelper.initialize("repository/conf/gregproperties.xml");
        } catch (IOException var22) {
            LOG.error("IOException Occured in initializing PropertyFileHelper");
            throw new GovernanceExceptions("Error while reading properties file", var22);
        } catch (XMLStreamException var23) {
            LOG.error("XMLStreamException Occured in initializing PropertyFileHelper");
            throw new GovernanceExceptions("Error while reading properties file", var23);
        }

        ArrayList actions1 = new ArrayList();
        ArrayList actionItems1 = new ArrayList();
        byte start1 = 0;
        int count = this.populateActions(actionItems1, start1);
        this.extractActions(actionItems1, actions1);
        if(count < 1) {
            throw new GovernanceExceptions("Please Select an Environment for Publish/Unpublish Operation");
        } else {
            this.isMultiEnvironmentUnpublishEvent(actions1, count);
            Iterator i$ = actions1.iterator();

            while(i$.hasNext()) {
                String action = (String)i$.next();

                try {
                    String apiCreator = apiArtifact.getProperty("api_creator_" + action);
                    String e = PropertyFileHelper.getValue(action + "_APIM_PUB_ENDPOINT", "https://apistore.fmr.com");
                    String pubuserName;
                    String pubPassword;
                    if(action.contains("PROD")) {
                        pubuserName = PropertyFileHelper.getValue("PROD_APIM_PUB_USERNAME", "admin");
                        pubPassword = PropertyFileHelper.getValue("PROD_APIM_PUB_PWD", "admin");
                    } else {
                        pubuserName = PropertyFileHelper.getValue("NONPROD_APIM_PUB_USERNAME", "admin");
                        pubPassword = PropertyFileHelper.getValue("NONPROD_APIM_PUB_PWD", "admin");
                    }

                    if(e.charAt(e.length() - 1) != 47) {
                        e = e + "/";
                    }

                    this.deleteAPIFromAPIM(this.getResource(), apiName, apiVersion, apiCreator, action, e, pubuserName, pubPassword);
                    unPublishedEnv = action;
                    this.updateLifecycleEvent(action, false);
                } catch (GovernanceExceptions var21) {
                    failedEnv = action;
                    failedEnvMsg = var21.getMessage();
                }
            }

            if(unPublishedEnv != null) {
                this.updatePromotedEnvProperty(unPublishedEnv, artifactRelativePath);
            }

            if(failedEnv != null) {
                this.handleException(failedEnvMsg, failedEnv, "unpublish");
                return false;
            } else {
                return true;
            }
        }
    }

    private void isMultiEnvironmentUnpublishEvent(List<String> actions, int count) {
        String successPublishedEnvs = this.getResource().getProperty("published_env");
        if(successPublishedEnvs == null) {
            if(count > 0) {
                throw new GovernanceExceptions("The API has not been published to the selected APIManager environments yet.");
            }
        } else {
            String[] successEnvsArray = successPublishedEnvs.split(",");
            int matches = 0;
            Iterator i$ = actions.iterator();

            while(i$.hasNext()) {
                String action = (String)i$.next();

                for(int i = 0; i < successEnvsArray.length; ++i) {
                    if(action.endsWith(successEnvsArray[i])) {
                        ++matches;
                    }
                }
            }

            if(matches == 0) {
                throw new GovernanceExceptions("The API has not been published to the selected APIManager environments yet.");
            }

            if(matches == 1) {
                if(matches < count) {
                    throw new GovernanceExceptions("Select only one APIManager environment at a time,to un-publish.");
                }
            } else if(matches > 1) {
                throw new GovernanceExceptions("Select only one APIManager environment at a time,to un-publish.");
            }
        }

    }

    private void updatePromotedEnvProperty(String unPublishedEnv, String artifactRelativePath) {
        try {
            String ex = this.getResource().getProperty("published_env");
            if(ex != null && ex.length() > 0) {
                String[] published_env;
                if(ex.contains(",")) {
                    published_env = ex.split(",");
                } else {
                    published_env = new String[]{ex};
                }

                LinkedList pubEnvList = new LinkedList(Arrays.asList(published_env));
                if(pubEnvList.contains(unPublishedEnv)) {
                    pubEnvList.remove(unPublishedEnv);
                }

                StringBuffer finalPublishEnv = new StringBuffer("");
                int pubEnvLen = pubEnvList.size();

                for(int index = 0; index < pubEnvLen; ++index) {
                    finalPublishEnv.append((String)pubEnvList.get(index)).append(",");
                }

                if(pubEnvLen > 0) {
                    finalPublishEnv = new StringBuffer(finalPublishEnv.substring(0, finalPublishEnv.length() - 1));
                }

                this.getResource().setProperty("published_env", finalPublishEnv.toString());
                this.getResource().removeProperty("api_creator_" + unPublishedEnv);
                this.getRegistry().put(artifactRelativePath, this.getResource());
            }

        } catch (RegistryException var9) {
            throw new GovernanceExceptions(var9.getMessage(), var9);
        }
    }

    private void updateLifecycleEvent(String apiEnvironment, boolean status) {
        Set entries = this.getResource().getProperties().entrySet();
        Iterator ex = entries.iterator();

        while(true) {
            Entry entry;
            String propKey;
            do {
                do {
                    if(!ex.hasNext()) {
                        try {
                            String var13 = this.getResource().getPath().substring("/_system/governance".length());
                            this.getRegistry().put(var13, this.getResource());
                            return;
                        } catch (RegistryException var12) {
                            throw new GovernanceExceptions(var12.getMessage(), var12);
                        }
                    }

                    entry = (Entry)ex.next();
                    propKey = (String)entry.getKey();
                } while(!propKey.startsWith("registry.custom_lifecycle.checklist."));
            } while(propKey.endsWith("permission"));

            boolean isSameEnv = false;
            int index = 0;
            List propValues = (List)entry.getValue();

            for(int i = 0; i < propValues.size(); ++i) {
                String prop = (String)propValues.get(i);
                if(prop.startsWith("value")) {
                    index = i;
                } else if(prop.startsWith("name") && prop.endsWith(apiEnvironment)) {
                    isSameEnv = true;
                }
            }

            if(isSameEnv) {
                propValues.set(index, "value:" + status);
                this.getResource().setProperty(propKey, propValues);
            }
        }
    }
}
