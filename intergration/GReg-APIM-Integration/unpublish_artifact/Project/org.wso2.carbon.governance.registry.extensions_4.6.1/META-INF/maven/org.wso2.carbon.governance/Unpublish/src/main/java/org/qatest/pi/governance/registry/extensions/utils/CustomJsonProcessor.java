//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.extensions.utils;

import com.google.gson.JsonParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import org.apache.axiom.om.OMElement;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qatest.pi.governance.registry.extensions.utils.CustomJsonUtils;
import org.wso2.carbon.registry.core.Registry;
import org.wso2.carbon.registry.core.Resource;
import org.wso2.carbon.registry.core.ResourceImpl;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.core.jdbc.handlers.RequestContext;
import org.wso2.carbon.registry.core.utils.RegistryUtils;
import org.wso2.carbon.registry.extensions.utils.CommonUtil;

public class CustomJsonProcessor {
    private static final Log LOG = LogFactory.getLog(CustomJsonProcessor.class);
    OMElement restServiceElement = null;
    OMElement endpointElement = null;
    private RequestContext requestContext;
    private Registry registry;
    private JsonParser parser = new JsonParser();
    private String documentVersion;

    public CustomJsonProcessor(RequestContext requestContext) {
        this.requestContext = requestContext;
        this.registry = requestContext.getRegistry();
    }

    public void processJsonUpload(InputStream inputStream, String commonLocation, String sourceUrl) throws RegistryException {
        this.createCollection(commonLocation);
        ByteArrayOutputStream swaggerContentStream = readSourceContent(inputStream);
        this.documentVersion = this.requestContext.getResource().getProperty("version");
        if(this.documentVersion == null) {
            this.documentVersion = "1.0.0";
        }

        String swaggerResourcePath = this.getSwaggerDocumentPath(commonLocation);
        this.addSwaggerDocumentToRegistry(swaggerContentStream, swaggerResourcePath, this.documentVersion);
        CustomJsonUtils.closeOutputStream(swaggerContentStream);
    }

    private void addSwaggerDocumentToRegistry(ByteArrayOutputStream contentStream, String path, String documentVersion) throws RegistryException {
        Object resource;
        if(this.registry.resourceExists(path)) {
            resource = this.registry.get(path);
            Object resourceId = ((Resource)resource).getContent();
            String resourceContent;
            if(resourceId instanceof String) {
                resourceContent = (String)resourceId;
                ((Resource)resource).setContent(RegistryUtils.encodeString(resourceContent));
            } else {
                if(!(resourceId instanceof byte[])) {
                    throw new RegistryException("Resource content is not valid.");
                }

                resourceContent = RegistryUtils.decodeBytes((byte[])((byte[])resourceId));
            }

            if(resourceContent.equals(contentStream.toString())) {
                LOG.info("Old content is same as the new content. Skipping the put action.");
                return;
            }
        } else {
            resource = new ResourceImpl();
        }

        String resourceId1 = ((Resource)resource).getUUID() == null?UUID.randomUUID().toString():((Resource)resource).getUUID();
        ((Resource)resource).setUUID(resourceId1);
        ((Resource)resource).setMediaType("application/vnd.wso2+json");
        ((Resource)resource).setContent(contentStream.toByteArray());
        ((Resource)resource).addProperty("version", documentVersion);
        this.registry.put(path, (Resource)resource);
        this.registry.associateAspect(path, "Obfuscation_LifeCycle_1.3");
        this.requestContext.setProcessingComplete(true);
    }

    private void createCollection(String commonLocation) throws RegistryException {
        Registry systemRegistry = CommonUtil.getUnchrootedSystemRegistry(this.requestContext);
        if(!systemRegistry.resourceExists(commonLocation)) {
            systemRegistry.put(commonLocation, systemRegistry.newCollection());
        }

    }

    private String getSwaggerDocumentPath(String rootLocation) throws RegistryException {
        String swaggerDocPath = this.requestContext.getResourcePath().getPath();
        String swaggerDocName = swaggerDocPath.substring(swaggerDocPath.lastIndexOf("/") + 1);
        String swaggerResourcesPath = rootLocation + "/" + this.documentVersion;
        return swaggerResourcesPath + "/" + swaggerDocName;
    }

    public static ByteArrayOutputStream readSourceContent(InputStream inputStream) throws RegistryException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            int nextChar;
            while((nextChar = inputStream.read()) != -1) {
                outputStream.write(nextChar);
            }

            outputStream.flush();
            return outputStream;
        } catch (IOException var4) {
            throw new RegistryException("Exception occurred while reading content", var4);
        }
    }
}
