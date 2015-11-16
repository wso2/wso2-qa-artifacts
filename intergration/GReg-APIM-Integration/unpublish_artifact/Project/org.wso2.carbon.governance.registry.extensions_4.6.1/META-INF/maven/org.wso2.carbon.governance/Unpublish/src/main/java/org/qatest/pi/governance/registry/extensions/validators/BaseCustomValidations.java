//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.extensions.validators;

import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.governance.api.common.dataobjects.GovernanceArtifact;
import org.wso2.carbon.governance.api.exception.GovernanceException;
import org.wso2.carbon.governance.api.util.GovernanceUtils;
import org.wso2.carbon.governance.registry.extensions.interfaces.CustomValidations;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.core.jdbc.handlers.RequestContext;
import org.wso2.carbon.registry.core.session.UserRegistry;

public abstract class BaseCustomValidations implements CustomValidations {
    private static final Log LOG = LogFactory.getLog(BaseCustomValidations.class);
    private String mapName = "";
    private boolean boolAtLeast = true;
    private String[] attributes = new String[0];
    private GovernanceArtifact governanceArtifact;

    public BaseCustomValidations() {
    }

    protected GovernanceArtifact getGovernanceArtifact() {
        return this.governanceArtifact;
    }

    protected void setGovernanceArtifact(GovernanceArtifact governanceArtifact) {
        this.governanceArtifact = governanceArtifact;
    }

    protected String getMapName() {
        return this.mapName;
    }

    protected void setMapName(String mapName) {
        this.mapName = mapName;
    }

    protected boolean isBoolAtLeast() {
        return this.boolAtLeast;
    }

    protected void setBoolAtLeast(boolean boolAtLeast) {
        this.boolAtLeast = boolAtLeast;
    }

    protected String[] getAttributes() {
        return (String[])this.attributes.clone();
    }

    protected void setAttributes(String[] attributes) {
        this.attributes = (String[])attributes.clone();
    }

    public void init(Map parameterMap) {
        if(parameterMap != null) {
            this.mapName = (String)parameterMap.get("mapName");
            String attrs = (String)parameterMap.get("attributes");
            String atleastOne = (String)parameterMap.get("atLeastOne");
            this.attributes = attrs.split(",");
            this.boolAtLeast = Boolean.parseBoolean(atleastOne);
        }

    }

    protected boolean preValidate(RequestContext context) {
        try {
            String e = context.getResourcePath().getPath();
            int index = e.indexOf("/_system/governance");
            if(index < 0) {
                LOG.warn("Unable to use Validator For Resource Path: " + e);
                return false;
            } else {
                index += "/_system/governance".length();
                if(e.length() <= index) {
                    LOG.warn("Unable to use Validator For Resource Path: " + e);
                    return false;
                } else {
                    e = e.substring(index);
                    UserRegistry registry = (UserRegistry)context.getSystemRegistry();
                    if(registry.resourceExists(e)) {
                        registry = (UserRegistry)context.getSystemRegistry();
                    } else {
                        registry = ((UserRegistry)context.getSystemRegistry()).getChrootedRegistry("/_system/governance");
                    }

                    this.setGovernanceArtifact(GovernanceUtils.retrieveGovernanceArtifactByPath(registry, e));
                    return true;
                }
            }
        } catch (GovernanceException var5) {
            LOG.error(var5.getMessage(), var5);
            return false;
        } catch (RegistryException var6) {
            LOG.error(var6.getMessage(), var6);
            return false;
        }
    }
}
