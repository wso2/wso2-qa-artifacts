
What is a RXT
===========================
One of the well -defined extension point included in WSO2 Governance registry.
This extension point can be used to customize any of the Metadata Which you want to display inside Governance registry.
For an example:
If you want to display your students' information inside wso2 Governance registry,
You can create your own RXT file to display the student info which you need to govern.

How to write a RXT
==========================
It's like some other programming language.
It has it's own variables and when we define our rxt according to those variables, rxt will be completed.

I will divide the rxt in to 3 parts

*Artifact Type section
*UI section
*Content section


If we consider the Head of the RXT, It is the "artifact Type" element and it contains several key words

Ex:
<artifactType hasNamespace="false" iconSet="9" pluralLabel="Universities" shortName="universities"
singularLabel="University" type="application/vnd.wso2-university+xml">
<storagePath>/universities/@{name}/@{students_number}</storagePath>
<nameAttribute>uni_universityname</nameAttribute>



artifact Type Element
==============================
* type
Denotes the media type of the artifact.You can define your own media types according to the following format.
EX:
application/vnd."ANYName"+xml
application/vnd."universities"+xml

* hasNamespace
This denotes whether your artifact contains a namespace or not.

IF
hasNamespace=true, you should have the following property in your rxt file.
        <namespaceAttribute></namespaceAttribute>

 
*shortName
Name of the artifact.
your custom rxt will be displayed by this name and lower-case letters are used for this
ex:
shortName="universities"

*pluralLabel
plural version of the artifact and it can contains mix of upper and lower case letters.
ex:
pluralLabel="Universities"


*singularLabel
singular version of the artifact and it contains the mix of upper and lower case letters
ex:
singularLabel="University"

*storagePath
This is the path where your metadata information stored.
When we enter the details from the UI, information will be stored in the registry path which you defined as the StoragePath
Ex:
<storagePath>/universities/@{name}/@{students_number}</storagePath>

When storing the information, @{name} attribute will be the name attribute of the artifact.
If you define in namespace in the storage path, it will replace the namespace inside the namespace attribute of the artifact.

In addtion to the name attriibute and namespace attribute in the storage path, we can customize it adding several other attrivutes as well
But the format always should be

${lowercasetablename}_{lowercasefeildname}



UI Element
================================
Middle part of the rxt is UI section.
Any of the columns you have defined in this section will be displayed when you listing the custom metadata in management console.
Ex: we have 10 columns in the rxt, but We don't need to show all of them while listing the metadata.Therefore we define specific columns in this section.

In <UI> section it contains the <list> tag and, Under the <list> ,you can define the columns which you need to display in metadata list.
Ex:
<ui>
    <list>
    <column name="University">
        <data href="@{storagePath}" type="path" value="uni_universityname"/>
    </column>

    <column name="Name">
                <data href="@{storagePath}" type="path" value="students_name"/>                
       </column>

    <column name="Name">
                <data href="@{storagePath}" type="path" value="students_number"/>                
       </column>

    <column name="Name">
                 <data href="@{storagePath}" type="path" value="courses_name"/>                
       </column>              
    </list>
</ui>

Column needs to have a name and it contains the data attribute.
In side this data attribute, it contains

*Type
Type of the data displayed

Type can be either path or Text
Ex01:
<data href="@{storagePath}" type="path" value="uni_universityname"/>
Ex02:
<data type="text" value="detail_name"/>

*value
The value displayed on the UI either as plain text or as a clickable link, depending on the type.

You can give the $tablenamn_$columnName as the value

*href
If the type is path, then this value represent the path as the hyper link.

Cotent
=========================================

This is the last part of the Rxt and it will describe What are the information you need to store.

Each section contains Tables and Inside those tables we can define our required fields.

ex:
<table name="uni">
    <field type="text" required="true">
    <name>Universityname</name>
    </field>
    <field type="text" required="true">
    <name>StatedYear</name>
    </field>
    <field type="text" required="true">
    <name>Chancerllar</name>
    </field>
</table>

Multiple tables can be difinied inside the content section and we can customize the feilds in side the table by adding data time/calaender,combo box, checkboxs etc...


How to deploy a RXT
============================


Go  to extension->ArtifactType section

        1) Click on the add button and paste your rxt file.
        2) Click on the save button.
        3) You can access Your customize rxt via Meta data section in the management console




