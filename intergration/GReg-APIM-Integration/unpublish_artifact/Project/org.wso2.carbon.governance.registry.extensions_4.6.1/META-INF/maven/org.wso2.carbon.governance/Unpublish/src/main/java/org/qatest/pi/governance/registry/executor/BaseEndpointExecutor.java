//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.executor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;
import javax.xml.stream.XMLStreamException;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qatest.pi.governance.registry.extensions.utils.GovernanceExceptions;
import org.qatest.pi.governance.registry.extensions.utils.PropertyFileHelper;
import org.wso2.carbon.governance.registry.extensions.interfaces.Execution;
import org.wso2.carbon.registry.core.Registry;
import org.wso2.carbon.registry.core.Resource;
import org.wso2.carbon.registry.core.exceptions.RegistryException;

public abstract class BaseEndpointExecutor implements Execution {
    private static final Log LOG = LogFactory.getLog(BaseEndpointExecutor.class);
    private Registry registry;
    private Resource resource;
    private String resourcePath;

    public BaseEndpointExecutor() {
    }

    public void init(Map parameterMap) {
        try {
            PropertyFileHelper.initialize("repository/conf/gregproperties.xml");
        } catch (IOException var3) {
            LOG.error("IOException Occured in initializing PropertyFileHelper");
            throw new GovernanceExceptions("Error while reading properties file", var3);
        } catch (XMLStreamException var4) {
            LOG.error("xmlStreamException Occured in initializing PropertyFileHelper");
            throw new GovernanceExceptions("Error while reading properties file", var4);
        }
    }

    protected int populateActions(List<String> actions) {
        int localCount = 0;
        Properties props = this.resource.getProperties();
        Iterator i$ = props.entrySet().iterator();

        while(true) {
            Entry entry;
            String propKey;
            do {
                do {
                    if(!i$.hasNext()) {
                        return localCount;
                    }

                    entry = (Entry)i$.next();
                    propKey = (String)entry.getKey();
                } while(!propKey.startsWith("registry.custom_lifecycle.checklist."));
            } while(propKey.endsWith("permission"));

            boolean isChecked = false;
            String checkListItem = "";
            List propValues = (List)entry.getValue();
            Iterator i$1 = propValues.iterator();

            while(true) {
                while(i$1.hasNext()) {
                    String prop = (String)i$1.next();
                    if(prop.startsWith("value") && prop.endsWith("true")) {
                        isChecked = true;
                        ++localCount;
                    } else if(prop.startsWith("name")) {
                        String[] arr = prop.split(":");
                        checkListItem = arr[1];
                    }
                }

                if(isChecked) {
                    actions.add(checkListItem);
                }
                break;
            }
        }
    }

    protected OMElement getDocumentElement() throws RegistryException {
        Object o = this.getResource().getContent();
        if(!(o instanceof byte[])) {
            String content1 = "Project proposals should have a valid content of type byte[].";
            throw new RegistryException(content1);
        } else {
            byte[] content = (byte[])((byte[])this.getResource().getContent());
            ByteArrayInputStream in = new ByteArrayInputStream(content);

            try {
                StAXOMBuilder ae = new StAXOMBuilder(in);
                OMElement docElement = ae.getDocumentElement();
                return docElement;
            } catch (Exception var6) {
                throw new RegistryException("Failed to parse the endpoint rxt content", var6);
            }
        }
    }

    public String getEndpointResourcePath(String name, String version) {
        StringBuilder endpointPath = new StringBuilder(this.getEsbEndpointResourceStoragePath());
        if(this.getEsbEndpointResourceStoragePath().endsWith("/")) {
            endpointPath.append(name + "_v" + version + ".xml");
        } else {
            endpointPath.append("/" + name + "_v" + version + ".xml");
        }

        return endpointPath.toString();
    }

    public void setRegistry(Registry registry) {
        this.registry = registry;
    }

    public Registry getRegistry() {
        return this.registry;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Resource getResource() {
        return this.resource;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getResourcePath() {
        return this.resourcePath;
    }

    public String getEsbEndpointResourceStoragePath() {
        return PropertyFileHelper.getValue("ESB_ENDPOINT_RESOURCE_STORAGE_PATH", "/_system/governance/trunk/endpoints/esb-endpoints");
    }
}
