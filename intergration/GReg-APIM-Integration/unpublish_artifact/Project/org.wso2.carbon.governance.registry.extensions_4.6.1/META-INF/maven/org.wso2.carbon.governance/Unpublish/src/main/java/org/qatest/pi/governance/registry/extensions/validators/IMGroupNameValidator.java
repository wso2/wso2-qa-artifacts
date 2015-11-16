//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.extensions.validators;

import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qatest.pi.governance.registry.extensions.utils.GovernanceExceptions;
import org.qatest.pi.governance.registry.extensions.validators.BaseCustomValidations;
import org.wso2.carbon.registry.core.jdbc.handlers.RequestContext;

public class IMGroupNameValidator extends BaseCustomValidations {
    private static final Log LOG = LogFactory.getLog(IMGroupNameValidator.class);

    public IMGroupNameValidator() {
    }

    public void init(Map parameterMap) {
    }

    public boolean validate(RequestContext context) {
        try {
            if(!this.preValidate(context)) {
                return false;
            } else if(StringUtils.isEmpty(this.getGovernanceArtifact().getAttribute("assetManagement_imgroupName"))) {
                throw new GovernanceExceptions("Please Provide a valid IM Group name.");
            } else {
                return true;
            }
        } catch (Exception var3) {
            LOG.error("Error while validating the IM Group name");
            throw new GovernanceExceptions(var3.getMessage(), var3);
        }
    }
}
