//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.extensions.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.governance.registry.extensions.internal.GovernanceRegistryExtensionsComponent;
import org.wso2.securevault.SecretResolver;
import org.wso2.securevault.SecretResolverFactory;

public final class PropertyFileHelper {
    private static Properties appProperties;
    private static boolean initialized;
    private static final Log LOG = LogFactory.getLog(PropertyFileHelper.class);

    private PropertyFileHelper() {
    }

    public static void initialize(String propertiesFile) throws IOException, XMLStreamException {
        if(!initialized) {
            Class var1 = PropertyFileHelper.class;
            synchronized(PropertyFileHelper.class) {
                appProperties = new Properties();
                loadPropertyFileEntries(propertiesFile);
                initialized = true;
            }
        }

    }

    private static void loadPropertyFileEntries(String fileName) throws IOException, XMLStreamException {
        Object inputStream = null;
        SecretResolver secretResolver = SecretResolverFactory.create((OMElement)null, false);
        secretResolver.init(GovernanceRegistryExtensionsComponent.getSecretCallbackHandlerService().getSecretCallbackHandler());

        try {
            File xmlStreamException = new File(fileName);
            FileInputStream fileInputStream = new FileInputStream(xmlStreamException);
            StAXOMBuilder builder = new StAXOMBuilder(fileInputStream);
            OMElement configElement = builder.getDocumentElement();
            Iterator entryIterator = configElement.getChildElements();

            String propertyName;
            String propertyValue;
            for(QName keyAttr = new QName("key"); entryIterator.hasNext(); appProperties.put(propertyName, propertyValue)) {
                OMElement entryEle = (OMElement)entryIterator.next();
                propertyName = entryEle.getAttributeValue(keyAttr);
                QName secreteAlias = new QName("http://org.wso2.securevault/configuration", "secretAlias");
                String secreteAliasVal = entryEle.getAttributeValue(secreteAlias);
                if(secreteAliasVal == null) {
                    propertyValue = entryEle.getText();
                } else {
                    propertyValue = secretResolver.resolve(secreteAliasVal);
                }
            }

            fileInputStream.close();
        } catch (IOException var22) {
            LOG.error("IOException Occured in reading property file");
            throw var22;
        } catch (XMLStreamException var23) {
            LOG.error("XMLStreamException Occured in reading property file");
            throw var23;
        } finally {
            if(inputStream != null) {
                try {
                    ((InputStream)inputStream).close();
                } catch (IOException var21) {
                    ;
                }
            }

        }

    }

    public static String getValue(String name, String defaultValue) {
        return initialized?appProperties.getProperty(name, defaultValue):defaultValue;
    }
}
