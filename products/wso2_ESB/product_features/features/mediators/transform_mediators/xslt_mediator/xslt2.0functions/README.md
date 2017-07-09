###### **Product Version** - Enterprise Servie Bus 5.0.0, Enterprise Integrator 6.1.0
###### **Related testcases** - EI6-5097 to EI6-5103
&nbsp;
# XSLT 2.0 Functions

These artifacts demonstrate the xslt 2.0 functionality supported in ESB/EI.

#### **Deploy the samples**
1. Extract ESB or EI pack
2. Go to <Product_HOME>/repository/deployment/server/synapse-configs/default location and copy the given **local_entries**  and **proxy services** for the relevant directory.
3. Start the Server

#### **Invoke the services**
 **Incoming Payload** - Use the following incoming payload to test below scenarios.
 ```
<?xml version="1.0" encoding="UTF-8"?>
<catalog>
  <cd>
    <title>Empire Burlesque</title>
    <artist>Bob Dylan</artist>
    <country>USA</country>
    <company>Columbia</company>
    <price>10.90</price>
    <year>1985</year>
  </cd>
  <cd>
    <title>Red</title>
    <artist>The Communards</artist>
    <country>UK</country>
    <company>London</company>
    <price>7.80</price>
    <year>1987</year>
  </cd>
    <cd>
    <title>Unchain my heart</title>
    <artist>Joe Cocker</artist>
    <country>USA</country>
    <company>EMI</company>
    <price>8.20</price>
    <year>1987</year>
  </cd>
</catalog>
```
#### Sample Services
##### 1.0 Current()
**Service URL** - http://localhost:8280/services/xslt_current 
**Response** - Response should contains the current node set.
```
<html xmlns="http://ws.apache.org/ns/synapse">
   <body>     Current node: Bob Dylan
      <br/>     Current node: The Communards
      <br/>     Current node: Joe Cocker
      <br/>
   </body>
</html>
```

##### 2.0 element_available()
**Service URL** - http://localhost:8280/services/xslt_element_available 
**Response** - This function verify whether the element specified is supported by the XSLT processor or not
```
<html xmlns="http://ws.apache.org/ns/synapse">
   <body>
      <p>xsl:comment is supported.</p>
      <p>xsl:delete is not supported.</p>
   </body>
</html>
```

##### 3.0 format_number()
**Service URL** - http://localhost:8280/services/xslt_format_number 
**Response** -  Verify that the function can converts a number into a string
```
<html xmlns="http://ws.apache.org/ns/synapse">
   <body>500100.00
      <br/>500100.0
      <br/>500,100.00
      <br/>23%
      <br/>500100
   </body>
</html>
```

##### 4.0 function_available()
**Service URL** - http://localhost:8280/services/xslt_function_available 
**Response** -  Verify whether the function specified is supported by the XSLT processor
```
<html xmlns="http://ws.apache.org/ns/synapse">
   <body>
      <p>sum() is supported.</p>
      <p>current() is supported.</p>
   </body>
</html>
```

##### 5.0 generate_id()
**Service URL** - http://localhost:8280/services/xslt_generate_id 
**Response** -  Verify whether the function returns a string value that uniquely identifies a specified node
```
<html xmlns="http://ws.apache.org/ns/synapse">
   <body>
      <h3>Artists:</h3>
      <ul>
         <li>
            <a href="#d1e5">Bob Dylan</a>
         </li>
         <li>
            <a href="#d1e18">The Communards</a>
         </li>
         <li>
            <a href="#d1e31">Joe Cocker</a>
         </li>
      </ul>
   </body>
</html>
```

##### 6.0 key()
**Service URL** - http://localhost:8280/services/xslt_key
**Response** -  Verify whether the function returns a node-set using the index specified by an <xsl:key> element
```
<html xmlns="http://ws.apache.org/ns/synapse">
   <body>
      <p>   Title: Empire Burlesque
         <br/>   Artist: Bob Dylan
         <br/>   Price: 10.90
      </p>
   </body>
</html>
```

##### 7.0 system_property()
**Service URL** - http://localhost:8280/services/xslt_system_property
**Response** -  Verify whether the function returns the value of the system properties
```
<html xmlns="http://ws.apache.org/ns/synapse">
   <body>
      <p> Version: 2.0
         <br/> Vendor: Saxonica
         <br/> Vendor URL: http://www.saxonica.com/
      </p>
   </body>
</html>
```

