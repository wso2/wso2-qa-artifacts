//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.dropdown;

import java.util.Map;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.context.CarbonContext;
import org.wso2.carbon.context.RegistryType;
import org.wso2.carbon.governance.api.util.GovernanceUtils;
import org.wso2.carbon.governance.generic.ui.utils.DropDownDataPopulator;
import org.wso2.carbon.registry.core.Registry;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.core.session.UserRegistry;

public class BusinessUnitPopulator implements DropDownDataPopulator {
    private static final Log LOG = LogFactory.getLog(BusinessUnitPopulator.class);

    public BusinessUnitPopulator() {
    }

    public String[] getList(HttpServletRequest httpServletRequest, ServletConfig servletConfig) {
        if(httpServletRequest != null) {
            Map paramMap = httpServletRequest.getParameterMap();
            if(paramMap != null && paramMap.containsKey("path")) {
                String path = httpServletRequest.getParameter("path");
                if(path != null) {
                    path = path.replace("/_system/governance", "");

                    try {
                        UserRegistry e = (UserRegistry)CarbonContext.getThreadLocalCarbonContext().getRegistry(RegistryType.USER_GOVERNANCE);
                        GovernanceUtils.loadGovernanceArtifacts(e);
                        if(e.get(path).getProperty("overview_businessUnit") != null) {
                            return new String[]{e.get(path).getProperty("overview_businessUnit")};
                        }
                    } catch (RegistryException var6) {
                        LOG.error("Unable to load current resource and it\'s business unit.", var6);
                    }
                }
            }
        }

        return this.getBusinessUnitList();
    }

    public String[] getList(String uuid, String path, Registry registry) {
        return null;
    }

    private String[] getBusinessUnitList() {
        return new String[]{"PI", "WI", "FI", "SIPD", "FBCT", "FIMT"};
    }
}
