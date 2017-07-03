###### **Product Version** - EI 6.1.0 
###### **Scenario** - Oracle Package with nested User Defined Types  
&nbsp;
#### **Description**
 This scenarios demonstrate an oracle package that uses nested User Defined Types (UDT) and return an oracle ref cursor to get the output.
 
 #### **Pre - Requisite**
 
 ##### **Creating the Oracle Package**
 You should have Oracle 12c instance to create the package. (As this was tested with Oracle 12c)
 
 Follow the below steps to create an oracle package with nested UDTs
 
 1. Create an oracle schema in Oracle 12c
 2. Create a database connection to the above oracle schema
 3. Then run the following script to create UDTs and the Oracle Package
```
create or replace TYPE dType1 IS Object (City VARCHAR2(100 CHAR) ,Country VARCHAR2(2000 CHAR));
/
create or replace TYPE dType2 IS TABLE OF VARCHAR2(1000);
/
create or replace TYPE dType3 IS TABLE OF dType1;
/
create or replace TYPE dType4 is Object(
Region VARCHAR2(50),
CountryDetails dType3,
Currency dType2);
/

create or replace PACKAGE myPackage IS
FUNCTION getData RETURN sys_refcursor;
end myPackage;
/
create or replace PACKAGE Body myPackage as FUNCTION getData
RETURN SYS_REFCURSOR is
    tt  dType4;
    t3  dType3;
    t1  dType1;
    t11 dType1;
    t2  dType2;
    cur sys_refcursor;
  begin
    t1  := dType1('Colombo', 'Sri Lanka');
    t11 := dType1('Delihi', 'India');
    t2  := dType2('Sri Lankan Rupee', 'Indian Rupee');
    t3  := dType3(t1, t11);
    tt  := dType4('Asia continent', t3, t2);
    open cur for
      SELECT tt.Region, tt.CountryDetails, tt.Currency from dual;
    return cur;
  end;
end myPackage;
/
```

##### **Creating the Data Service**
1. Add the ojdbc7.jar to the <EI_HOME>/lib
2. Edit the given **"NestedUDT.dbs"** by adding the Oracle Database configurations (url, username and password) under <config> property. 
3. Then updated "NestedUDT.dbs" to the <EI_HOME>/repository/deployment/server/dataservices directory
2. Start the EI Server

#### **Invoking the DataService**
Use following command to access the data service as a REST resource

```
curl -v http://localhost:8280/services/NestedUDT/data
```
 The response will return the values for 'dType4' as below
```
<MYDetailResponse 
    xmlns="http://ws.wso2.org/dataservice">
    <Details>
        <Region>Asia continent</Region>
        <CountryDetails>{Colombo,Sri Lanka}</CountryDetails>
        <CountryDetails>{Delihi,India}</CountryDetails>
        <Currency>Sri Lankan RupeeIndian Rupee</Currency>
    </Details>
</MYDetailResponse>
```
