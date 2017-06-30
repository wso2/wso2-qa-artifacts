~~~~~~~~~~README~~~~~~


Description
-------------------------

WSO2 data mapper is a data mapping solution that convert and transform one format(xml, csv, json) of data to a different format. It provides a WSO2 Developer Studio based tool to create the graphical mapping configuration and generate the files needed to execute the mapping configuration by the WSO2 Data mapper engine. 
Repository includes JSON, XML and CSV fiels which can be used as Input and Output Schemas of DataMapper mediator configurations.


Usage
-------------------------

DataMapper mediator mainly required three different reources to work as expected. When we add a DataMapper mediator following artifacts should be exist as registry resources in ESB. We can easily design/develop these with WSO2 
Developer Studio itself. 
1. Mapping Config
2. Input Schema
3. Output Schema
other than that this needs following two configuration values as well.
4. Input Type: eg: XML, CSV, JSON
5. Out Type: eg: XML, CSV, JSON


Summary of Sub Directories
--------------------------
JSON:
Includes different JSON formats which we can use as Input or Output schemas for DataMapper configurations.
XML:
Includes different XML formats which we can use as Input or Output schemas for DataMapper configurations.
CAPPS:
Includes different Composite Applications which created packing with necessary artifacts(input schema, output schema and mapping config files) to test the DataMapper mediator.
