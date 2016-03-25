<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
xmlns:fn="http://www.w3.org/2005/02/xpath-functions"
xmlns:xs="http://test.wso2.org"
version="1.0">
      <xsl:output omit-xml-declaration="yes"/>
      <xsl:template match="node()|@*">
         <xsl:copy>
            <xsl:apply-templates select="node()|@*"/>
         </xsl:copy>
      </xsl:template>
      <xsl:template match="xs:age"/>
   </xsl:stylesheet>

