//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.executor;

import org.qatest.pi.governance.registry.executor.BaseCreateExecutor;
import org.wso2.carbon.registry.core.jdbc.handlers.RequestContext;

public class ServiceExecutor extends BaseCreateExecutor {
    public ServiceExecutor() {
    }

    public boolean execute(RequestContext context, String currentState, String targetState) {
        this.setResource(context.getResource());
        boolean valid = true;
        return valid;
    }
}
