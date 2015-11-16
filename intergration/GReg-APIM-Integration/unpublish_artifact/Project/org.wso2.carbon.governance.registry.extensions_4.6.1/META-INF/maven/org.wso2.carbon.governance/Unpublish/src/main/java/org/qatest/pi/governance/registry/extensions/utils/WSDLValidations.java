//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.extensions.utils;

import java.io.IOException;
import java.io.StringReader;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import javax.wsdl.Definition;
import javax.wsdl.extensions.schema.Schema;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.exolab.castor.xml.schema.ComplexType;
import org.exolab.castor.xml.schema.ElementDecl;
import org.exolab.castor.xml.schema.Group;
import org.exolab.castor.xml.schema.reader.SchemaReader;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.DOMBuilder;
import org.jdom.output.XMLOutputter;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.xml.sax.InputSource;

public class WSDLValidations {
    private static final Log LOG = LogFactory.getLog(WSDLValidations.class);

    public WSDLValidations() {
    }

    public void validate(Definition definition, Map<String, String[]> map) throws RegistryException {
        this.valdateTargetNameSpace(definition.getTargetNamespace(), (String[])map.get("namespacesvalues"));
    }

    private void valdateTargetNameSpace(String targetNameSpace, String[] nameSpaces) throws RegistryException {
        if(nameSpaces.length != 0) {
            String[] arr$ = nameSpaces;
            int len$ = nameSpaces.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String np = arr$[i$];
                if(targetNameSpace.contains(np)) {
                    return;
                }
            }

            throw new RegistryException(targetNameSpace + " is not a valid targetNameSpace");
        }
    }

    public void validateParameterCamalCase(Definition def, String url) throws RegistryException {
        try {
            Schema e = null;
            Object jdomSchemaElement;
            if(def.getTypes() != null && def.getTypes().getExtensibilityElements() != null) {
                for(Iterator domBuilder = def.getTypes().getExtensibilityElements().iterator(); domBuilder.hasNext(); e = (Schema)jdomSchemaElement) {
                    jdomSchemaElement = domBuilder.next();
                }
            }

            DOMBuilder domBuilder1 = new DOMBuilder();
            if(e != null) {
                Element jdomSchemaElement1 = domBuilder1.build(e.getElement());
                Iterator i$ = def.getNamespaces().keySet().iterator();

                while(i$.hasNext()) {
                    Object key = i$.next();
                    if(key != null && !"".equalsIgnoreCase(key.toString())) {
                        jdomSchemaElement1.addNamespaceDeclaration(Namespace.getNamespace(key.toString(), (String)def.getNamespaces().get(key.toString())));
                    }
                }

                this.runThroughSchema(jdomSchemaElement1);
            }

        } catch (Exception var8) {
            LOG.error("Error occured while reading creating the schema", var8);
            throw new RegistryException(var8.getMessage(), var8);
        }
    }

    private void runThroughSchema(Element jdomSchemaElement) throws RegistryException {
        org.exolab.castor.xml.schema.Schema castorSchema = null;
        XMLOutputter outputter = new XMLOutputter();
        String xmlout = outputter.outputString(jdomSchemaElement.getDocument());
        StringReader in2 = new StringReader(xmlout);
        InputSource schemaSource = new InputSource(in2);

        try {
            SchemaReader schemaReader = new SchemaReader(schemaSource);
            castorSchema = schemaReader.read();
            Enumeration e = castorSchema.getComplexTypes();

            while(e.hasMoreElements()) {
                ComplexType a = (ComplexType)e.nextElement();
                Enumeration e1 = a.enumerate();

                while(e1.hasMoreElements()) {
                    Group b = (Group)e1.nextElement();
                    Enumeration e2 = b.enumerate();

                    while(e2.hasMoreElements()) {
                        ElementDecl ed = (ElementDecl)e2.nextElement();
                        if(!this.isStable(ed.getName())) {
                            throw new RegistryException(ed.getName() + "is an uppercase parameter and it is not allowed. " + "Only camel case is allowed.");
                        }
                    }
                }
            }

        } catch (IOException var14) {
            LOG.error("Error occured while reading DOM, IO exception occurred", var14);
            throw new RegistryException("Error occured while reading DOM, IO exception occurred", var14);
        }
    }

    public boolean isStable(String word) {
        char[] charArray = word.toCharArray();
        return !Character.isUpperCase(charArray[0]);
    }
}
