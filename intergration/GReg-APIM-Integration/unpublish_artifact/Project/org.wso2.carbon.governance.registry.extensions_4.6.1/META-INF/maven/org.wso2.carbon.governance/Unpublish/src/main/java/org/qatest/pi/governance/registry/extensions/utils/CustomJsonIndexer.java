//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.extensions.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.solr.common.SolrException;
import org.wso2.carbon.governance.api.util.GovernanceArtifactConfiguration;
import org.wso2.carbon.governance.api.util.GovernanceUtils;
import org.wso2.carbon.registry.core.Registry;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.core.utils.RegistryUtils;
import org.wso2.carbon.registry.indexing.IndexingManager;
import org.wso2.carbon.registry.indexing.AsyncIndexer.File2Index;
import org.wso2.carbon.registry.indexing.indexer.Indexer;
import org.wso2.carbon.registry.indexing.solr.IndexDocument;

public class CustomJsonIndexer implements Indexer {
    public static final Log log = LogFactory.getLog(CustomJsonIndexer.class);

    public CustomJsonIndexer() {
    }

    public IndexDocument getIndexedDocument(File2Index fileData) throws SolrException, RegistryException {
        if(log.isDebugEnabled()) {
            log.debug("Registry RXT Indexer is running");
        }

        IndexDocument indexedDocument = this.getPreProcessedDocument(fileData);
        Registry registry = GovernanceUtils.getGovernanceSystemRegistry(IndexingManager.getInstance().getRegistry(fileData.tenantId));
        GovernanceArtifactConfiguration configuration = GovernanceUtils.findGovernanceArtifactConfigurationByMediaType(fileData.mediaType, registry);
        if(configuration == null) {
            return indexedDocument;
        } else {
            Map fields = indexedDocument.getFields();
            this.setAttributesToLowerCase(fields);
            fields.put("overview_name", Arrays.asList(new String[]{RegistryUtils.getResourceName(fileData.path).toLowerCase()}));
            indexedDocument.setFields(fields);
            return indexedDocument;
        }
    }

    private IndexDocument getPreProcessedDocument(File2Index fileData) throws RegistryException {
        String jsonAsStr = RegistryUtils.decodeBytes(fileData.data);
        StringBuffer contentOnly = new StringBuffer();
        IndexDocument indexDocument = new IndexDocument(fileData.path, jsonAsStr, contentOnly.toString());
        HashMap attributes = new HashMap();
        if(fileData.mediaType != null) {
            attributes.put("mediaType", Arrays.asList(new String[]{fileData.mediaType}));
        }

        if(fileData.lcState != null) {
            attributes.put("lcState", Arrays.asList(new String[]{fileData.lcState}));
        }

        if(fileData.lcName != null) {
            attributes.put("lcName", Arrays.asList(new String[]{fileData.lcName}));
        }

        indexDocument.setFields(attributes);
        return indexDocument;
    }

    private void setAttributesToLowerCase(Map<String, List<String>> attributes) {
        Iterator i$ = attributes.entrySet().iterator();

        while(true) {
            List list;
            do {
                if(!i$.hasNext()) {
                    return;
                }

                Entry entry = (Entry)i$.next();
                list = (List)entry.getValue();
            } while(list == null);

            for(int i = 0; i < list.size(); ++i) {
                list.set(i, list.get(i) != null?((String)list.get(i)).toLowerCase():(String)list.get(i));
            }
        }
    }
}
