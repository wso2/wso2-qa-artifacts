<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                        xmlns:fn="http://www.w3.org/2005/02/xpath-functions"
                        version="2.0" exclude-result-prefixes="test fn"
			xmlns:test="http://test.wso2.org">
            <xsl:output method="xml" omit-xml-declaration="yes" indent="yes"/>
            <xsl:template match="*">
                <xsl:element name="{local-name()}" namespace="http://test.wso2.org">
                    <xsl:copy-of select="attribute::*"/>
                    <xsl:apply-templates/>
                </xsl:element>
            </xsl:template>
        </xsl:stylesheet>
