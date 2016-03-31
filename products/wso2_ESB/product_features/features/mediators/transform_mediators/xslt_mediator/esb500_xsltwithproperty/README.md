# README

This artifact is written to highlight the usage of properties inside xslt mediator. The content in the csv file is read and transformed using smooks mediator. Thereafter, the xslt mediator transforms the payload using the defined property. Afterwards the transformed payload is used as input to Dbreport mediator. 

> Note: This particular sample is tested with WSO2 ESB 5.0.0 M2 and WSO2 AS 530

### Contents 
  - CSV data file: orderlist.csv
  - Smooks configuration file: smooksconfig_orders.xml
  - XSLT transformation file: transform_order.xslt
  - sequences: xslt_seq_6.xml, xslt_seq_7.xml
  - Proxy service: XsltProxy6.xml
  - SQL script to create table: createTable.sql


### Preconditions
- Upload the .aar file to WSO2 AS
- VFS transport should be enabled for ESB
- In, Out, Fail file locations should be created for VFS transport
- Mysql database exist as "test"
- Table should be created by running the given sql script against the database
- Table in above database exist as below

```sh
 Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| productname | varchar(200) | YES  |     | NULL    |                |
| id          | int(11)      | NO   | PRI | NULL    | auto_increment
```

### Steps
- Upload the given XSLT transformation file to governance registry
- Upload the smooks configuration file to governance registry
- Change the database connection url accordingly in the dbreport mediator that can be found in xslt_seq_7.xml
- Deploy the sequences in ESB
- Deploy the given proxy service in ESB 
- Place the given csv file in the "In" folder defined above
