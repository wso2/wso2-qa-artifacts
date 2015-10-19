Testing mime-types
==================

Important to understand
mime.types	: maps the file extension to the mime.type
mime.mapping 	: maps the mime type to a Human Readable/Understandable format

*** NOTE ***
you might need to get a fresh pack and delete the database (GREG_HOME/repository/database)

*** DO NOT START WITHOUT CONFIGURING THE FOLLOWING ***

Eg:
We have "sample.properties" file (or create it)

Configure as below;

mime.types
----------
text/properties				properties
text/config				conf
text/wso2				wso2
text/ruby				rb
xml/drool				drl
xml/xquery                              xq
xml/evan                                eva

mime.mapping
------------
text/properties				Properties
text/config				Configurations
text/wso2				WSO2
text/ruby				Ruby
xml/drool				Drools
xml/xquery                              XQuery
xml/evan                                EVA


1. Start the server with "-Dsetup" option (to create fresh database)
	./wso2carbon -Dsetup

2. Upload files with the configured file extension
	sample.properties
	sample.conf
	sample.wso2
	sample.rb
	sample.drl
	sample.xq
	sample.eva

when uploading the resource it should show the following(Media type should load automatically);

=====================================
File Name 	: sample.properties
Media Type 	: Properties
=====================================
File Name 	: sample.conf
Media Type 	: Configurations
=====================================
File Name 	: sample.wso2
Media Type 	: WSO2
=====================================
