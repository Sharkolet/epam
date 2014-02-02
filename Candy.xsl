<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    
    <xsl:template match="/">
        <html>
            <body>
                <xsl:for-each select="Candies/Candy">
                    <h2>Candy <xsl:value-of select="@name"/> </h2>
                    <table border="1">
                        <tr bgcolor="#9acd32">
                            <th colspan="2">Info</th>
                        </tr>
                        <tr>
                            <td>Energy</td> 
                            <td><xsl:value-of select="Energy"/> </td>
                        </tr>
                        <tr>
                            <td>Type</td> 
                            <td><xsl:value-of select="Type"/></td>
                        </tr>
                        <tr>
                            <td>Production</td> 
                            <td><xsl:value-of select="Production"/> </td>
                        </tr>
                        <tr bgcolor="#9acd32">
                            <th colspan="2">Ingredients</th>
                        </tr>
                        
                        <xsl:for-each select="Ingredients/Ingredient">
                            <tr>
                                <td><xsl:value-of select="Name"/></td>
                                <td><xsl:value-of select="Count"/></td>
                            </tr>
                        </xsl:for-each>
                        <tr bgcolor="#9acd32">
                            <th colspan="2">Values</th>
                        </tr>
                        <tr>
                            <td>Fats</td> 
                            <td><xsl:value-of select="Value/Fats"/></td>
                        </tr>
                        <tr>
                            <td>Proteins</td> 
                            <td><xsl:value-of select="Value/Proteins"/></td>
                        </tr>
                        <tr>
                            <td>Carbohydrates</td> 
                            <td><xsl:value-of select="Value/Carbohydrates"/></td>
                        </tr>
                        
                    </table>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>