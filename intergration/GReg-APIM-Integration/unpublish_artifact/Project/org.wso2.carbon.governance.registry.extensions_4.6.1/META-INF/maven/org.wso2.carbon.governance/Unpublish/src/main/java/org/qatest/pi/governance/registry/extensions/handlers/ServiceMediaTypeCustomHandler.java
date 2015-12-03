//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.extensions.handlers;

import com.ibm.wsdl.xml.WSDLReaderImpl;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import javax.wsdl.Definition;
import javax.wsdl.factory.WSDLFactory;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qatest.pi.governance.registry.extensions.utils.WSDLValidations;
import org.wso2.carbon.registry.core.Resource;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.core.jdbc.handlers.Handler;
import org.wso2.carbon.registry.core.jdbc.handlers.RequestContext;
import org.wso2.carbon.registry.core.utils.RegistryUtils;
import org.wso2.carbon.registry.extensions.handlers.utils.ExWSDLReaderImpl;

public class ServiceMediaTypeCustomHandler extends Handler {
    private static final Log LOG = LogFactory.getLog(ServiceMediaTypeCustomHandler.class);
    private final Map<String, String[]> map = new HashMap();
    private final WSDLValidations wsdlValidations = new WSDLValidations();
    private boolean validateNP = false;
    private boolean isCamelCaseEnable = false;

    public ServiceMediaTypeCustomHandler() {
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
        if(this.validateNP || this.isCamelCaseEnable) {
            Resource resource = requestContext.getResource();
            if(resource == null) {
                throw new RegistryException("The resource is not available.");
            } else {
                Object resourceContent = resource.getContent();
                String serviceInfo;
                if(resourceContent instanceof String) {
                    serviceInfo = (String)resourceContent;
                } else {
                    serviceInfo = RegistryUtils.decodeBytes((byte[])((byte[])resourceContent));
                }

                OMElement serviceInfoElement;
                XMLStreamReader wsdlDefinition;
                try {
                    XMLInputFactory definitionURL = XMLInputFactory.newInstance();
                    definitionURL.setProperty("javax.xml.stream.isSupportingExternalEntities", Boolean.valueOf(false));
                    definitionURL.setProperty("javax.xml.stream.supportDTD", Boolean.valueOf(false));
                    wsdlDefinition = definitionURL.createXMLStreamReader(new StringReader(serviceInfo));
                    StAXOMBuilder e = new StAXOMBuilder(wsdlDefinition);
                    serviceInfoElement = e.getDocumentElement();
                } catch (Exception var10) {
                    throw new RegistryException("Cannot read the wsdl document in given link", var10);
                }

                String definitionURL1 = this.getDefinitionURL(serviceInfoElement);
                if(definitionURL1 != null && (definitionURL1.startsWith("http://") || definitionURL1.startsWith("https://")) && definitionURL1.toLowerCase().endsWith("wsdl")) {
                    wsdlDefinition = null;

                    Definition wsdlDefinition1;
                    try {
                        ExWSDLReaderImpl e1 = new ExWSDLReaderImpl((WSDLReaderImpl)WSDLFactory.newInstance().newWSDLReader());
                        e1.setFeature("javax.wsdl.importDocuments", true);
                        e1.setFeature("javax.wsdl.verbose", LOG.isDebugEnabled());
                        wsdlDefinition1 = e1.readWSDL(definitionURL1);
                    } catch (Exception var9) {
                        throw new RegistryException("Unable to load the wsdl file from url", var9);
                    }

                    if(wsdlDefinition1 == null) {
                        throw new RegistryException("Cannot read the wsdl document in given link");
                    }

                    if(this.validateNP) {
                        this.wsdlValidations.validate(wsdlDefinition1, this.map);
                    }

                    if(this.isCamelCaseEnable) {
                        this.wsdlValidations.validateParameterCamalCase(wsdlDefinition1, definitionURL1);
                    }
                }

            }
        }
    }

    private String getDefinitionURL(OMElement element) {
        OMElement overview = element.getFirstChildWithName(new QName("Interface"));
        if(overview != null && overview.getFirstChildWithName(new QName("WSDL-URL")) != null) {
            return overview.getFirstChildWithName(new QName("WSDL-URL")).getText();
        } else {
            overview = element.getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "interface"));
            return overview != null && overview.getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "wsdlURL")) != null?overview.getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "wsdlURL")).getText():"";
        }
    }
}
