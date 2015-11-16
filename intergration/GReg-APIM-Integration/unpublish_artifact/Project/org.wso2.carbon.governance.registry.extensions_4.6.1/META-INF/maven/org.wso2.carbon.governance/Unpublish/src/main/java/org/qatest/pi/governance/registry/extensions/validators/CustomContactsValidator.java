//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.extensions.validators;

import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.routines.EmailValidator;
import org.qatest.pi.governance.registry.extensions.utils.GovernanceExceptions;
import org.qatest.pi.governance.registry.extensions.validators.BaseCustomValidations;
import org.wso2.carbon.registry.core.jdbc.handlers.RequestContext;

public class CustomContactsValidator extends BaseCustomValidations {
    private static final Log LOG = LogFactory.getLog(CustomContactsValidator.class);

    public CustomContactsValidator() {
    }

    public boolean validate(RequestContext context) {
        try {
            if(!this.preValidate(context)) {
                return false;
            } else {
                String[] e = this.getGovernanceArtifact().getAttributes(this.getMapName());
                String emptyContactMessage = "";
                String[] attMap = this.getAttributes();
                int exceptionMsg = attMap.length;
                byte arr$ = 0;
                if(arr$ < exceptionMsg) {
                    String len$ = attMap[arr$];
                    if(len$.contains("Email")) {
                        emptyContactMessage = "Please add contact information, Both name,email,corpId should be included.";
                    } else {
                        emptyContactMessage = "Please add contact information, Both name and corpId should be included.";
                    }
                }

                if(e == null) {
                    throw new GovernanceExceptions(emptyContactMessage);
                } else {
                    HashMap var13 = new HashMap();
                    String[] var14 = e;
                    int var16 = e.length;

                    String i$;
                    int var18;
                    for(var18 = 0; var18 < var16; ++var18) {
                        i$ = var14[var18];
                        var13.put(i$.substring(0, i$.indexOf(":")), i$.substring(i$.indexOf(":") + 1));
                    }

                    if(this.isBoolAtLeast()) {
                        String var15 = "Name, Email and CorpId should be included.";
                        String[] var17 = this.getAttributes();
                        var18 = var17.length;

                        for(int var19 = 0; var19 < var18; ++var19) {
                            String var20 = var17[var19];
                            String[] contets = var20.split(":");
                            if(!var20.contains("Email")) {
                                var15 = "Name and CorpId should be included.";
                            }

                            if(contets.length == 3 && var13.containsKey(contets[0]) && var13.containsKey(contets[1]) && var13.containsKey(contets[2]) && !((String)var13.get(contets[0])).equalsIgnoreCase("") && this.isEmailValid((String)var13.get(contets[1])) && !((String)var13.get(contets[2])).equalsIgnoreCase("")) {
                                return true;
                            }

                            if(contets.length == 2 && var13.containsKey(contets[0]) && var13.containsKey(contets[1]) && !((String)var13.get(contets[0])).equalsIgnoreCase("") && !((String)var13.get(contets[1])).equalsIgnoreCase("")) {
                                return true;
                            }
                        }

                        throw new GovernanceExceptions(var15);
                    } else {
                        var14 = this.getAttributes();
                        var16 = var14.length;
                        var18 = 0;

                        while(var18 < var16) {
                            i$ = var14[var18];
                            String[] n = i$.split(":");
                            if(var13.containsKey(n[0]) && var13.containsKey(n[1])) {
                                if(!((String)var13.get(n[0])).equalsIgnoreCase("") && this.isEmailValid((String)var13.get(n[1])) && !((String)var13.get(n[2])).equalsIgnoreCase("")) {
                                    ++var18;
                                    continue;
                                }

                                throw new GovernanceExceptions("Both values " + n[0] + "-" + n[1] + "-" + n[2] + " must be valid values.");
                            }

                            throw new GovernanceExceptions("Both values of " + n[0] + "-" + n[1] + "-" + n[2] + " must be provided.");
                        }

                        return true;
                    }
                }
            }
        } catch (RuntimeException var11) {
            LOG.error("Unable to validate contacts");
            throw new GovernanceExceptions(var11.getMessage(), var11);
        } catch (Exception var12) {
            LOG.error("Unable to validate contacts");
            throw new GovernanceExceptions("Unable to validate contacts. Please check contacts are correct", var12);
        }
    }

    private boolean isEmailValid(String email) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        boolean isValid = false;
        return StringUtils.isEmpty(email)?isValid:emailValidator.isValid(email);
    }
}
