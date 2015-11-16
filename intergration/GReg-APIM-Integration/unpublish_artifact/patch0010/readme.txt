Reproducing the issue
-----------------------
1 - Download Greg 5.1.0 pack ( <GREG-HOME> )
2 - Set the port offset to 2000
3 - Copy gregproperties.xml to <GREG-HOME>/repository/conf/
4 - Copy the jar files from lib/ to <GREG-HOME>/repository/components/lib/

5 - Add the following entry to <GREG-HOME>/repository/conf/datasources/master-datasources.xml

	<datasource>
		    <name>WSO2REG_DB</name>
		    <description>The datasource used for API Manager database</description>
		    <jndiConfig>
		        <name>jdbc/WSO2REG_DB</name>
		    </jndiConfig>
		     <definition type="RDBMS">
		        <configuration>
		             <url>jdbc:mysql://127.0.0.1:3306/regfiveREG</url>
		             <username>root</username>
		             <password>root</password>
		             <driverClassName>com.mysql.jdbc.Driver</driverClassName>
		             <maxActive>150</maxActive>
		             <maxWait>60000</maxWait>
		             <testOnBorrow>false</testOnBorrow>
		             <validationQuery>SELECT 1</validationQuery>
		             <validationInterval>30000</validationInterval>
		        </configuration>
		    </definition>
	</datasource>


	  <datasource>
		    <name>WSO2UM_DB</name>
		    <description>The datasource used for API Manager database</description>
		    <jndiConfig>
		        <name>jdbc/WSO2UM_DB</name>
		    </jndiConfig>
		     <definition type="RDBMS">
		        <configuration>
		             <url>jdbc:mysql://127.0.0.1:3306/regfiveUM</url>
		             <username>root</username>
		             <password>root</password>
		             <driverClassName>com.mysql.jdbc.Driver</driverClassName>
		             <maxActive>150</maxActive>
		             <maxWait>60000</maxWait>
		             <testOnBorrow>false</testOnBorrow>
		             <validationQuery>SELECT 1</validationQuery>
		             <validationInterval>30000</validationInterval>
		        </configuration>
		    </definition>
	</datasource>

	Note: Update the username and password with your mysql username and password

7 - Create two mysql databases ( regfiveREG and regfiveUM )

8 - Add the following settings to <GREG-HOME>/repository/conf/registry.xml

	<dbConfig name="sharedregistry">
	<dataSource>jdbc/WSO2REG_DB</dataSource>
	</dbConfig>

	<remoteInstance url="https://localhost:9443/registry">
		<id>mountInstance</id>
	<dbConfig>sharedregistry</dbConfig>
	<readOnly>false</readOnly>
		<enableCache>true</enableCache>
		<cacheId>root@jdbc:mysql:@127.0.0.1:3306:regfiveREG</cacheId>
	<registryRoot>/</registryRoot>
	</remoteInstance>

	<mount path="/_system/config" overwrite="true">
	<instanceId>mountInstance</instanceId>
	<targetPath>/_system/asNodes</targetPath>
	</mount>

	<mount path="/_system/governance" overwrite="true">
	<instanceId>mountInstance</instanceId>
	<targetPath>/_system/governance</targetPath>
	</mount>


9 - Update the setting from A to B in <GREG-HOME>/repository/conf/user-mgt.xml where A and B are as follows.

	A -----------------


		    	<Property name="dataSource">jdbc/WSO2CarbonDB</Property>
		</Configuration>

	B ----------------

			<Property name="dataSource">jdbc/WSO2UM_DB</Property>
		        <Property name="GetRoleListOfInternalUserSQL">SELECT UM_ROLE_NAME FROM UM_HYBRID_USER_ROLE, UM_HYBRID_ROLE WHERE UPPER(UM_USER_NAME)=UPPER ( ? ) AND UM_HYBRID_USER_ROLE.UM_ROLE_ID=UM_HYBRID_ROLE.UM_ID AND UM_HYBRID_USER_ROLE.UM_TENANT_ID=? AND UM_HYBRID_ROLE.UM_TENANT_ID=? AND UM_HYBRID_USER_ROLE.UM_DOMAIN_ID=(SELECT UM_DOMAIN_ID FROM UM_DOMAIN WHERE UM_TENANT_ID=? AND UM_DOMAIN_NAME=?)</Property>
		</Configuration>

10 - Start greg 5.1.0 with -Dsetup option
-------------------
11 - Download wso2am-1.9.0
12 - Start APIM 1.9.0 with the default configurations.
------------------

14 - Now login to https://<your-ip>:11443/carbon/
15 - Navigate to "Extensions(tab) > Configure > Lifecycles" and add a new lifecycle with the give file ( SOMAapiLifeCycle.xml ) and name it as SOMAapiLifeCycle
16 - Navigate to "Extensions(tab) > Configure > Artifact Types" and add new artifact with the given file ( fmrapi.xml ) and name it fmrapi
17 - Restart GREG server.
18 - Now login to https://<your-ip>:11443/publisher/ (username = admin, password = admin)
19 - Navigate to the newly created artifact listing page SOMA Services ( screen1.png )
20 - Create new SOMA service with the configuration given with ( screen2.png )
21 - Go to it's lifecycle page ( screen3.png )
22 - Take the lifecycle stage up to the state given on screen3.png


After checking items from the "Check List" click on the "publish" button.
Now navigate to API Managers ( Publisher ) API Listing page ( https://<your-ip>:9443/publisher/). There you will be able to see an api added. ( It's better to use two different browsers for GREG and APIM )

Now go back to the GREG lifecycle view ( screen3.png ). After checking items from the "Check List" click on the "Unpublish" button.

User should be able to successfully unpublish the artifact from API-M once it's been updated via lifecycle in G-Reg.

