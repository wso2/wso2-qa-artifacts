//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.executor;

import org.qatest.pi.governance.registry.executor.BaseDeleteExecutor;
import org.wso2.carbon.context.CarbonContext;
import org.wso2.carbon.registry.core.jdbc.handlers.RequestContext;

public class ServiceDeleteExecutor extends BaseDeleteExecutor {
    public ServiceDeleteExecutor() {
    }

    public boolean execute(RequestContext context, String currentState, String targetState) {
        this.setGregUserName(CarbonContext.getThreadLocalCarbonContext().getUsername());
        boolean valid = true;
        return valid;
    }
}
