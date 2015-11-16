//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.extensions.validators;

import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qatest.pi.governance.registry.extensions.validators.BaseCustomValidations;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.core.jdbc.handlers.RequestContext;

public class MapValueAttributeExistenceValidator extends BaseCustomValidations {
    private static final Log LOG = LogFactory.getLog(MapValueAttributeExistenceValidator.class);

    public MapValueAttributeExistenceValidator() {
    }

    public boolean validate(RequestContext context) {
        boolean bool = true;

        try {
            if(!this.preValidate(context)) {
                return false;
            }

            String[] e = this.getGovernanceArtifact().getAttributes(this.getMapName());
            HashMap attMap = new HashMap();
            String[] arr$ = e;
            int len$ = e.length;

            int i$;
            String n;
            for(i$ = 0; i$ < len$; ++i$) {
                n = arr$[i$];
                attMap.put(n.substring(0, n.indexOf(":")), n.substring(n.indexOf(":") + 1));
            }

            if(this.isBoolAtLeast()) {
                bool = false;
                arr$ = this.getAttributes();
                len$ = arr$.length;

                for(i$ = 0; i$ < len$; ++i$) {
                    n = arr$[i$];
                    if(attMap.containsKey(n) && !((String)attMap.get(n)).equalsIgnoreCase("") && !((String)attMap.get(n)).equalsIgnoreCase((String)null)) {
                        return true;
                    }
                }
            } else {
                arr$ = this.getAttributes();
                len$ = arr$.length;

                for(i$ = 0; i$ < len$; ++i$) {
                    n = arr$[i$];
                    if(!attMap.containsKey(n)) {
                        return false;
                    }

                    if(attMap.containsKey(n) && (((String)attMap.get(n)).equalsIgnoreCase("") || ((String)attMap.get(n)).equalsIgnoreCase((String)null))) {
                        return false;
                    }
                }
            }
        } catch (RegistryException var9) {
            LOG.error("Unable to obtain registry instance", var9);
        }

        return bool;
    }
}
