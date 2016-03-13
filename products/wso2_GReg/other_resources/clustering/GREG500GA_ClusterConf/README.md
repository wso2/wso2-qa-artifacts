Contains the Cluster configs of GREG 5.0.0 release set up 
1. Manager node1
2. Manager node2
3. Nginx conf

.
├── manager1
│   └── conf
│       ├── attachment-management.xml
│       ├── attach-mgt-conf.properties
│       ├── axis2
│       │   ├── axis2_client.xml
│       │   ├── axis2.xml
│       │   └── tenant-axis2.xml
│       ├── carbon.xml
│       ├── claim-config.xml
│       ├── datasources
│       │   ├── bps-datasources.xml
│       │   ├── master-datasources.xml
│       │   └── social-datasources.xml
│       ├── email
│       │   └── email-admin-config.xml
│       ├── etc
│       │   ├── bundle-config
│       │   ├── carboncontext-osgi-services.properties
│       │   ├── config-validation.xml
│       │   ├── jmx.xml
│       │   ├── launch.ini
│       │   ├── logging-bridge.properties
│       │   ├── logging-config.xml
│       │   ├── mime.mappings
│       │   ├── mime.types
│       │   ├── osgi-debug.options
│       │   └── permission-mappings.xml
│       ├── event-broker.xml
│       ├── governance.xml
│       ├── ht
│       │   └── humantask.xml
│       ├── humantask.xml
│       ├── identity
│       │   ├── application-authentication.xml
│       │   ├── identity-mgt.properties
│       │   ├── identity-providers
│       │   │   └── default.xml
│       │   ├── service-providers
│       │   │   ├── default.xml
│       │   │   └── sp_dashboard.xml
│       │   └── sso-idp-config.xml
│       ├── identity.xml
│       ├── log4j.properties
│       ├── msg-mgt.properties
│       ├── multitenancy
│       │   ├── cloud-services-desc.xml
│       │   ├── multitenancy-packages.xml
│       │   ├── stratos.xml
│       │   └── usage-throttling-agent-config.xml
│       ├── notifications-email-verification.xml
│       ├── output-event-adapters.xml
│       ├── registry.xml
│       ├── security
│       │   ├── authenticators.xml
│       │   ├── cipher-text.properties
│       │   └── cipher-tool.properties
│       ├── social.xml
│       ├── solr
│       │   ├── registry-indexing
│       │   │   ├── conf
│       │   │   │   ├── currency.xml
│       │   │   │   ├── elevate.xml
│       │   │   │   ├── lang
│       │   │   │   │   └── stopwords_en.txt
│       │   │   │   ├── protwords.txt
│       │   │   │   ├── schema.xml
│       │   │   │   ├── scripts.conf
│       │   │   │   ├── solrconfig.xml
│       │   │   │   ├── spellings.txt
│       │   │   │   ├── stopwords.txt
│       │   │   │   └── synonyms.txt
│       │   │   └── core.properties
│       │   └── solr.xml
│       ├── tenant-mgt.xml
│       ├── tomcat
│       │   ├── carbon
│       │   │   ├── META-INF
│       │   │   │   └── context.xml
│       │   │   └── WEB-INF
│       │   │       └── web.xml
│       │   ├── catalina-server.xml
│       │   ├── context.xml
│       │   ├── tomcat-users.xml
│       │   ├── webapp-classloading-environments.xml
│       │   ├── webapp-classloading.xml
│       │   └── web.xml
│       └── user-mgt.xml
├── manager2
│   └── conf
│       ├── attachment-management.xml
│       ├── attach-mgt-conf.properties
│       ├── axis2
│       │   ├── axis2_client.xml
│       │   ├── axis2.xml
│       │   └── tenant-axis2.xml
│       ├── carbon.xml
│       ├── claim-config.xml
│       ├── datasources
│       │   ├── bps-datasources.xml
│       │   ├── master-datasources.xml
│       │   └── social-datasources.xml
│       ├── email
│       │   └── email-admin-config.xml
│       ├── etc
│       │   ├── bundle-config
│       │   ├── carboncontext-osgi-services.properties
│       │   ├── config-validation.xml
│       │   ├── jmx.xml
│       │   ├── launch.ini
│       │   ├── logging-bridge.properties
│       │   ├── logging-config.xml
│       │   ├── mime.mappings
│       │   ├── mime.types
│       │   ├── osgi-debug.options
│       │   └── permission-mappings.xml
│       ├── event-broker.xml
│       ├── governance.xml
│       ├── ht
│       │   └── humantask.xml
│       ├── humantask.xml
│       ├── identity
│       │   ├── application-authentication.xml
│       │   ├── identity-mgt.properties
│       │   ├── identity-providers
│       │   │   └── default.xml
│       │   ├── service-providers
│       │   │   ├── default.xml
│       │   │   └── sp_dashboard.xml
│       │   └── sso-idp-config.xml
│       ├── identity.xml
│       ├── log4j.properties
│       ├── msg-mgt.properties
│       ├── multitenancy
│       │   ├── cloud-services-desc.xml
│       │   ├── multitenancy-packages.xml
│       │   ├── stratos.xml
│       │   └── usage-throttling-agent-config.xml
│       ├── notifications-email-verification.xml
│       ├── output-event-adapters.xml
│       ├── registry.xml
│       ├── security
│       │   ├── authenticators.xml
│       │   ├── cipher-text.properties
│       │   └── cipher-tool.properties
│       ├── social.xml
│       ├── solr
│       │   ├── registry-indexing
│       │   │   ├── conf
│       │   │   │   ├── currency.xml
│       │   │   │   ├── elevate.xml
│       │   │   │   ├── lang
│       │   │   │   │   └── stopwords_en.txt
│       │   │   │   ├── protwords.txt
│       │   │   │   ├── schema.xml
│       │   │   │   ├── scripts.conf
│       │   │   │   ├── solrconfig.xml
│       │   │   │   ├── spellings.txt
│       │   │   │   ├── stopwords.txt
│       │   │   │   └── synonyms.txt
│       │   │   └── core.properties
│       │   └── solr.xml
│       ├── tenant-mgt.xml
│       ├── tomcat
│       │   ├── carbon
│       │   │   ├── META-INF
│       │   │   │   └── context.xml
│       │   │   └── WEB-INF
│       │   │       └── web.xml
│       │   ├── catalina-server.xml
│       │   ├── context.xml
│       │   ├── tomcat-users.xml
│       │   ├── webapp-classloading-environments.xml
│       │   ├── webapp-classloading.xml
│       │   └── web.xml
│       └── user-mgt.xml
├── nginx
│   └── GREG.conf
└── README.md
