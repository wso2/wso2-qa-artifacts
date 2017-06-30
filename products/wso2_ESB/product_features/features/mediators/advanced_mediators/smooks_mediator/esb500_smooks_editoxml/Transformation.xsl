<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
  xmlns:fn="http://www.w3.org/2005/02/xpath-functions" xmlns:sam="http://sample.wso2.org" xmlns:xsd="http://sample.wso2.org/xsd"
  exclude-result-prefixes="sam fn">
  <xsl:output method="xml" omit-xml-declaration="yes" indent="yes"/>
  <xsl:template match="/">
    <sam:placeOrder>
      <xsl:apply-templates select="//Orders" /> 
    </sam:placeOrder>
 </xsl:template>
  <xsl:template match="order-item">
    <sam:order>
         <xsd:price><xsl:value-of select="unit-price"/></xsd:price>
         <xsd:quantity><xsl:value-of select="quantity"/></xsd:quantity>
         <xsd:productid><xsl:value-of select="product-id"/></xsd:productid>
	 <xsd:reference><xsl:value-of select="reference"/></xsd:reference>
    </sam:order>
   </xsl:template>
 </xsl:stylesheet>


