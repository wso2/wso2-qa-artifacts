//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.extensions.handlers;

import com.ibm.wsdl.xml.WSDLReaderImpl;
import java.util.HashMap;
import java.util.Map;
import javax.wsdl.Definition;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qatest.pi.governance.registry.extensions.utils.WSDLValidations;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.core.jdbc.handlers.Handler;
import org.wso2.carbon.registry.core.jdbc.handlers.RequestContext;
import org.wso2.carbon.registry.extensions.handlers.utils.ExWSDLReaderImpl;

public class WSDLCustomValidationHandler extends Handler {
    private static final Log LOG = LogFactory.getLog(WSDLCustomValidationHandler.class);
    private final Map<String, String[]> map = new HashMap();
    private final WSDLValidations wsdlValidations = new WSDLValidations();
    private boolean validateNP = false;
    private boolean isCamelCaseEnable = false;

    public WSDLCustomValidationHandler() {
    }

    public void setNameSpaceValueString(String nameSpaceValueString) {
        if(!"".equalsIgnoreCase(nameSpaceValueString)) {
            String[] temp = nameSpaceValueString.split(",");
            this.map.put("namespacesvalues", temp);
            this.validateNP = true;
            LOG.info("Namespace validation is " + this.validateNP);
        }

    }

    public void setCamalCaseEnable(String camalCaseEnable) {
        this.isCamelCaseEnable = Boolean.parseBoolean(camalCaseEnable);
        LOG.info("Camel case validation is " + this.isCamelCaseEnable);
    }

    public void put(RequestContext requestContext) throws RegistryException {
        String uri = requestContext.getSourceURL();
        Definition wsdlDefinition = null;
        if(!(uri == null | this.map.isEmpty())) {
            if(this.validateNP || this.isCamelCaseEnable) {
                try {
                    ExWSDLReaderImpl e = new ExWSDLReaderImpl((WSDLReaderImpl)WSDLFactory.newInstance().newWSDLReader());
                    e.setFeature("javax.wsdl.importDocuments", true);
                    e.setFeature("javax.wsdl.verbose", LOG.isDebugEnabled());
                    wsdlDefinition = e.readWSDL(uri);
                } catch (Exception var5) {
                    throw new RegistryException("Wrong wsdl location or invalid wsdl doc.", var5);
                }

                if(wsdlDefinition != null) {
                    if(this.validateNP) {
                        this.wsdlValidations.validate(wsdlDefinition, this.map);
                    }

                    if(this.isCamelCaseEnable) {
                        this.wsdlValidations.validateParameterCamalCase(wsdlDefinition, uri);
                    }

                } else {
                    throw new RegistryException("Cannot read the wsdl document in given link");
                }
            }
        }
    }

    public void importResource(RequestContext requestContext) throws RegistryException {
        if(!this.map.isEmpty()) {
            if(this.validateNP || this.isCamelCaseEnable) {
                String uri = requestContext.getSourceURL();
                Definition wsdlDefinition = null;

                try {
                    WSDLFactory e = WSDLFactory.newInstance();
                    WSDLReader reader = e.newWSDLReader();
                    reader.setFeature("javax.wsdl.importDocuments", true);
                    reader.setFeature("javax.wsdl.verbose", LOG.isDebugEnabled());
                    wsdlDefinition = reader.readWSDL(uri);
                } catch (Exception var6) {
                    throw new RegistryException("Unable to load the wsdl file from url", var6);
                }

                if(wsdlDefinition != null) {
                    if(this.validateNP) {
                        this.wsdlValidations.validate(wsdlDefinition, this.map);
                    }

                    if(this.isCamelCaseEnable) {
                        this.wsdlValidations.validateParameterCamalCase(wsdlDefinition, uri);
                    }

                } else {
                    throw new RegistryException("Cannot read the wsdl document in given link");
                }
            }
        }
    }
}
