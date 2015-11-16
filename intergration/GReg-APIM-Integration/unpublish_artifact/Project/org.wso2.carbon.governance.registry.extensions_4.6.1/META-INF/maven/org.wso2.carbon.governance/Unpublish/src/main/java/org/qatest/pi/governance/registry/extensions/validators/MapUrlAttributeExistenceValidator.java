//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.extensions.validators;

import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.routines.UrlValidator;
import org.qatest.pi.governance.registry.extensions.validators.BaseCustomValidations;
import org.wso2.carbon.governance.api.exception.GovernanceException;
import org.wso2.carbon.registry.core.jdbc.handlers.RequestContext;

public class MapUrlAttributeExistenceValidator extends BaseCustomValidations {
    private static final Log LOG = LogFactory.getLog(MapUrlAttributeExistenceValidator.class);

    public MapUrlAttributeExistenceValidator() {
    }

    public boolean validate(RequestContext context) {
        boolean bool = true;

        try {
            if(!this.preValidate(context)) {
                return false;
            } else {
                String[] e = this.getGovernanceArtifact().getAttributes(this.getMapName());
                UrlValidator defaultValidator = new UrlValidator(8L);
                HashMap attMap = new HashMap();
                String[] arr$;
                int len$;
                int i$;
                String n;
                if(e != null) {
                    arr$ = e;
                    len$ = e.length;

                    for(i$ = 0; i$ < len$; ++i$) {
                        n = arr$[i$];
                        if(!defaultValidator.isValid(n.substring(n.indexOf(":") + 1))) {
                            return false;
                        }

                        attMap.put(n.substring(0, n.indexOf(":")), n.substring(n.indexOf(":") + 1));
                    }
                }

                if(!this.isBoolAtLeast()) {
                    arr$ = this.getAttributes();
                    len$ = arr$.length;

                    for(i$ = 0; i$ < len$; ++i$) {
                        n = arr$[i$];
                        if(!attMap.containsKey(n)) {
                            return false;
                        }

                        if(attMap.containsKey(n) && !defaultValidator.isValid((String)attMap.get(n))) {
                            return false;
                        }
                    }
                } else {
                    bool = false;
                    arr$ = this.getAttributes();
                    len$ = arr$.length;

                    for(i$ = 0; i$ < len$; ++i$) {
                        n = arr$[i$];
                        if(attMap.containsKey(n) && defaultValidator.isValid((String)attMap.get(n))) {
                            return true;
                        }
                    }
                }

                return bool;
            }
        } catch (GovernanceException var10) {
            LOG.error(var10.getMessage(), var10);
            return false;
        }
    }
}
