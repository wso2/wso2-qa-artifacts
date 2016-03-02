//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.executor;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.qatest.pi.governance.registry.executor.BaseCreateExecutor;
import org.qatest.pi.governance.registry.extensions.utils.GovernanceExceptions;
import org.wso2.carbon.context.CarbonContext;
import org.wso2.carbon.governance.api.generic.GenericArtifactManager;
import org.wso2.carbon.registry.core.Resource;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.core.internal.RegistryCoreServiceComponent;
import org.wso2.carbon.registry.core.jdbc.handlers.RequestContext;

public class MultiNodeExecutor extends BaseCreateExecutor {
    public MultiNodeExecutor() {
    }

    public boolean execute(RequestContext context, String currentState, String targetState) {
        this.setResource(context.getResource());
        String user = CarbonContext.getThreadLocalCarbonContext().getUsername();

        try {
            this.setRegistry(RegistryCoreServiceComponent.getRegistryService().getGovernanceUserRegistry(user, CarbonContext.getThreadLocalCarbonContext().getTenantId()));
            String e = this.getResource().getPath();
            String artifactRelativePath = e.substring("/_system/governance".length());
            Resource apiArtifact = this.getRegistry().get(artifactRelativePath);
            GenericArtifactManager artifactManager;
            if(artifactRelativePath.startsWith("/trunk/services")) {
                artifactManager = new GenericArtifactManager(this.getRegistry(), "service");
            } else if(artifactRelativePath.startsWith("/trunk/dpapis")) {
                artifactManager = new GenericArtifactManager(this.getRegistry(), "dpapi");
            } else {
                artifactManager = new GenericArtifactManager(this.getRegistry(), "fmrapi");
            }

            String artifactId = apiArtifact.getUUID();
            this.setArtifact(artifactManager.getGenericArtifact(artifactId));
            String apiName = this.getArtifact().getAttribute("overview_name");
            String[] ownershipDetails = this.getArtifact().getAttributes("contacts_entry");
            List ownershipDetailsList = Arrays.asList(ownershipDetails);
            String temp = "";
            String techOwnerCorpId = "";
            String tribeLeadCorpId = "";
            if(CollectionUtils.isNotEmpty(ownershipDetailsList)) {
                Iterator i$ = ownershipDetailsList.iterator();

                while(i$.hasNext()) {
                    String contact = (String)i$.next();
                    temp = contact.substring(0, contact.indexOf(":"));
                    if(temp.equalsIgnoreCase("Technical Owner CorpId")) {
                        techOwnerCorpId = contact.substring(contact.indexOf(":") + 1);
                        if(StringUtils.isNotEmpty(techOwnerCorpId)) {
                            user = techOwnerCorpId;
                            break;
                        }
                    }

                    if(temp.equalsIgnoreCase("Tribe Lead CorpId")) {
                        tribeLeadCorpId = contact.substring(contact.indexOf(":") + 1);
                        if(StringUtils.isNotEmpty(tribeLeadCorpId)) {
                            user = tribeLeadCorpId;
                            break;
                        }
                    }
                }
            }

            if(StringUtils.isEmpty(user)) {
                throw new RegistryException("Tehnical onwer CorpId missing");
            } else {
                return this.retrieveDataAndPublish(apiName, user, artifactRelativePath, apiArtifact);
            }
        } catch (RegistryException var18) {
            throw new GovernanceExceptions(var18.getMessage(), var18);
        } catch (GovernanceExceptions var19) {
            throw new GovernanceExceptions(var19.getMessage(), var19);
        }
    }
}
