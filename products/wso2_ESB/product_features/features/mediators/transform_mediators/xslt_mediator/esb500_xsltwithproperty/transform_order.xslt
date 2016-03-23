<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fn="http://www.w3.org/2005/02/xpath-functions"  version="2.0"> 
        <xsl:output method="xml" omit-xml-declaration="yes" indent="yes"/> 
        <xsl:param name="order_name"/> 
        <xsl:template match="/"> 
            <Order> 
                <xsl:for-each select="//Orders/order[contains(ordername, $order_name)]"> 
                    <ordername> 
                        <xsl:value-of select="ordername"/> 
                    </ordername> 
                </xsl:for-each> 
            </Order> 
        </xsl:template> 
</xsl:stylesheet>
