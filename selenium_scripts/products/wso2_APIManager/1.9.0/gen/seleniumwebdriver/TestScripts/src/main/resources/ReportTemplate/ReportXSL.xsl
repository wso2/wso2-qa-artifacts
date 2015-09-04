<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"
            indent="no"
            encoding="iso-8859-1"
            media-type="text/html"
            doctype-public="-//W3C//DTD HTML 4.0//EN"/>
	<xsl:variable name="cellsPerRow" select="3"/>
	<xsl:variable name="maxItems" select="1000"/>

	<xsl:param name="testcaserid"/>
	<xsl:param name="loadAll" /> 


    <!-- Report Root Content -->
	<xsl:template match="/report/*">
		<div id="header-top">
			<h1 id="logo">
			  <a href="#" title="VTAF">
				<em>VTAF Report</em>
				Virtusa Test Automation Framework
			  </a>
			</h1>
			<div id="small-nav"></div>
		</div>
		<div id="page">
			<div id="container">
			<div id="Content">
				<xsl:choose>
					<!-- Testsuit Template -->
					<xsl:when test="./activity[@type='test suite' or @type='test case' or @type='repeat container']">
						<h1> 
							<xsl:choose>
							<xsl:when test="./activity[@type='test suite']"><xsl:value-of select ="./activity/@testsuitename"/></xsl:when>
							<xsl:when test="./activity[@type='repeat container']"><xsl:value-of select ="./activity/@headertext"/></xsl:when>
							<xsl:otherwise>Report for selected test case</xsl:otherwise> 
							</xsl:choose>
						</h1>
						<p> 
							<xsl:choose><xsl:when test="./activity[@type='test suite']"><xsl:value-of select ="./activity/detail"/></xsl:when>
							<xsl:otherwise> <xsl:value-of select ="./detail"/> </xsl:otherwise></xsl:choose>
							<xsl:value-of select ="./activity/@runlabel"/>
						</p>
						
						<br />
							
						<!-- EXECUTION INFORMATION -->
						<xsl:call-template name="executionInformation"/>

						<xsl:variable name="itemCount" >
						  <xsl:value-of select ="count(.//item)"/>
						</xsl:variable>
						
						<div>
							<!-- BUTTONS -->
							<div> 
							  <xsl:choose>
								<xsl:when test="$itemCount &lt; $maxItems">
													<input type="button" onclick="expandTestcases()" class="exButton" value="Expand Testcases"  />
													<input type="button" onclick="expandDetails()" class="exButton" value="Expand Details"  />
													<input type="button" onclick="collapseAll()" class="exButton" value="Collapse All" />
								</xsl:when>
								<xsl:otherwise>
								   <input type="button" onclick="expandTestcases()" class="exButton" value="Expand Testcases"  disabled="disabled"/>
								   <input type="button" onclick="expandDetails()" class="exButton" value="Expand Details"  disabled="disabled"/>
								   <input type="button" onclick="collapseAll()" class="exButton" value="Collapse All" disabled="disabled"/>
								   <em style="color: #888; font-size: 10px;">Disabled due to performance reasons.</em>
								</xsl:otherwise>
							  </xsl:choose>
							</div>
							<!-- PIECHART -->														
							<div id="testCasesPie" style="height:180px;width:280px; position:relative;  margin: -180px 0 0 550px; right: 0;">
								<xsl:attribute name="totalsuccesscount">
									<xsl:value-of select="@totalsuccesscount" />
								</xsl:attribute>
								<xsl:attribute name="totalfailedcount">
									<xsl:value-of select="@totalfailedcount" />
								</xsl:attribute>
								<xsl:attribute name="totalblockedcount">
									<xsl:value-of select="@totalblockedcount" />
								</xsl:attribute>
							</div>
												
						</div> 
						
						<!--Test Case Filter Checkboxes -->
                        <div style="margin-top: 20px;">
                                <xsl:call-template name="globalCategorySelector">
                                </xsl:call-template>
                        </div>
                        
						<xsl:if test=".//item[@level='Warn']">
							<div class="warnmessage" style="margin-top: 25px; margin-bottom: -12px;">
							  <span class="ui-module-icon warn" style="background-position: -196px 3px; margin-right: 8px;"></span> Warnings occurred. For additional information see the report of the individual modules, please.
							</div>
						</xsl:if>
              
						<ul id="treeList" class="ui-treeList">
							<xsl:if test="./activity[@type='test suite']/params/param">	
								<div class="dataparams" style="margin-top: 25px; margin-bottom: -12px;">
									<b>Global Parameters: </b>
									<xsl:apply-templates select="./activity[@type='test suite']/params"/>
								</div>
							</xsl:if>
							
							<xsl:choose>
								<xsl:when test="./activity[@type='test suite']">
									<xsl:apply-templates select="./activity/activity">
										<xsl:with-param name="itemCount" select="$itemCount" />
									</xsl:apply-templates>
								</xsl:when>
								<xsl:otherwise>
									<xsl:apply-templates select="./activity">
										<xsl:with-param name="itemCount" select="$itemCount" />
									</xsl:apply-templates>
								</xsl:otherwise>
							</xsl:choose>
						</ul>
					</xsl:when>
					
					<!-- Standalone Recording Template-->
					<xsl:otherwise>
						<h1> <xsl:value-of select ="@module"/></h1>
						<h2 class="module {@result}"> <span class="ui-status-icon"></span> <xsl:value-of select="@result"/> </h2>

						<xsl:call-template name="executionInformation"/>

						<div style="margin-top: 20px;"><xsl:call-template name="levelFilterSelector"/></div>

						<div style="margin:15px 0 40px 0; position:relative;">
							<TABLE border="0" cellSpacing="0" class="reporttable">
							<thead>
								<tr>
									<th width="10%" >
									  <b>Time</b>
									</th>
									<th width="8%" >
									  <b>Level</b>
									</th>
									<th width="12%" >
									  <b>Category</b>
									</th>
									<th>
									  <b>Message</b>
									</th>
								</tr>
								</thead>
								<tbody>
								<xsl:apply-templates select="./item">
									<xsl:with-param name="type">standalone</xsl:with-param>
								</xsl:apply-templates>							
								</tbody>
							</TABLE>
						</div>
					</xsl:otherwise>
				</xsl:choose>				
            </div>
            <div style="clear:both"></div>
            <div id="Footer"></div>
          </div>
        </div>		
    </xsl:template>
    
    <!-- Testcase and Container Template -->
	<xsl:template match="activity[(@type='test case' or @type='repeat container') and (@result='Success' or (@result='Failed' or @result='Active') or @result='Ignored')]">
		<xsl:param name="itemCount"/>
		<li class="{@result} ui-treeList-item" id="testcase{@rid}" onMouseOver="DisplayHoverMenu(this);"  onMouseOut="HideHoverMenu(this)"> 
			<xsl:variable name="success">
				<xsl:value-of select="@totalsuccesscount" />
			</xsl:variable>
					 
			 <xsl:variable name="failed">
				<xsl:value-of select="@totalfailedcount" />
			 </xsl:variable>
					 
			 <xsl:variable name="ignored">
				<xsl:value-of select="@totalblockedcount" />
			 </xsl:variable>
					 
			 <xsl:variable name="max">
			  <xsl:choose>
				<xsl:when test="@iterationcount &gt; 0">
					<xsl:value-of select="@iterationcount" />
				</xsl:when>
				<xsl:when test="@repeatCount &gt; 0">
					<xsl:value-of select="@repeatCount" />
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$success + $failed + $ignored" />
				</xsl:otherwise>
			  </xsl:choose>
			 </xsl:variable>
					 
			<xsl:variable name="parentid"> <xsl:value-of select="@rid" /></xsl:variable>
			<xsl:for-each select="./activity[(@type='test case' or @type='repeat container') and (@result='Success' or (@result='Failed' or @result='Active'))]">
				<xsl:variable name="maxparent">
					<xsl:choose>
						<xsl:when test="(@result='Success' or (@result='Failed' or @result='Active')) and (@iterationcount &gt; 0 or @repeatCount &gt; 0)">
							<xsl:choose>
								<xsl:when test="not(@repeatCount)">
									<xsl:value-of select="@iterationcount" />
								</xsl:when>
								<xsl:otherwise>
									<xsl:value-of select="@repeatCount" />
								</xsl:otherwise>
							</xsl:choose>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$max" />
						</xsl:otherwise>
					</xsl:choose>
				</xsl:variable>
			</xsl:for-each>


			<h2 class="{@result}" onclick="OnLoadContentDynamic('{@rid}','testcase',this);" >
			
				<xsl:if test="not(@type = 'repeat container')">
				<div class="controls-container testcase" >
					<a href="#" class="jump-to">
					<metainfo id='{@testcaseid}' type='{@type}'> </metainfo>
					<span class="ui-icon"></span>Jump to Testcase</a>
				</div>
				</xsl:if>
				
				<span class="ui-status-icon"></span> <span class="ui-testcase-icon"></span>
				<xsl:choose>
					<xsl:when test="./@testcasename">  <xsl:value-of select="./@testcasename"/>  </xsl:when>
					<xsl:otherwise>  <xsl:value-of select="./@modulerepeatcontainername"/>  </xsl:otherwise>
				</xsl:choose>
				<xsl:if test=".//item[@level='Warn']"><span class="ui-module-icon warn"></span> </xsl:if>
									
				<xsl:variable name="detailstext">
					<xsl:value-of select="substring-after(./detail,substring-before(./detail, substring(normalize-space(./detail),1,1)))"/>
				</xsl:variable>
				<a title="{$detailstext}" class="description"> <xsl:value-of select="substring($detailstext,0,50)"/>
					<xsl:if test="string-length($detailstext) &gt; 50">...</xsl:if>
				</a>
									
				<xsl:if test="(@result='Success' or (@result='Failed' or @result='Active')) and $max &gt; 0">
					<xsl:variable name="maxWidth" select="150"/>
					<xsl:variable name="widthSuccess">
						<xsl:value-of select="round(($success div $max) * $maxWidth)"/>
					</xsl:variable>
					<xsl:variable name="widthFailed">
						<xsl:value-of select="round(($failed div $max) * $maxWidth)"/>
					</xsl:variable>
					<xsl:if test="$widthSuccess &lt; $maxWidth and $widthFailed &lt; $maxWidth">
						<div id="chart{@rid}" style="position: absolute; display:block; font-size:0; width:{$maxWidth}px; margin-top: 5px; right:60px;  height: 10px; background-color:#bbbbbb; border:1px #f5f5f5 solid; overflow: hidden; top: 6px; ">
							<div style="position: absolute; width:{$widthSuccess}px; height: 8px; background-color:#6ec66e; " ></div>
							<div style="position: absolute; margin-left:{$widthSuccess}px;  width:{$widthFailed}px; height: 8px; background-color:#e66e6e; " ></div>
						</div>
					</xsl:if>
				</xsl:if>
				<span class="duration"><xsl:value-of select="./@duration"/></span>
			</h2>
			
			<ul>                                   
				<xsl:if test="./params/param"> 
					<div class="dataparams"><xsl:apply-templates select="./params"/></div>
				</xsl:if>
         
				<xsl:if test="./errormessage">
					<div class="errormessage">
						<b class="message"><xsl:value-of select="./errormessage"/></b>
					</div>
				</xsl:if>    
				
				<xsl:if test="$loadAll = 1">				
					<xsl:apply-templates select="./activity">
						<xsl:with-param name="itemCount" select="$itemCount" />
					</xsl:apply-templates>
				</xsl:if>
			</ul>
		</li> 	
	</xsl:template>


	<xsl:template match="datarow|params">
		<table>
			<xsl:for-each select="(field|param)[position() mod $cellsPerRow = 1]">
				<tr>
					<xsl:apply-templates select=".|(following-sibling::field|following-sibling::param)[position() &lt; $cellsPerRow]"/>
				</tr>
			</xsl:for-each>
		</table>
	</xsl:template>
  
	<xsl:template match="param|field">
		<td>
			<xsl:value-of select="./@name"/>: 
			<b><xsl:value-of select="."/></b>
		</td>
	</xsl:template>


	<xsl:template match="activity[@type='test case iteration' or @type='test module iteration']">
		<xsl:param name="itemCount"/>

		<li class="{@result} iteration" id="iteration{@rid}">  
			<h2 class="{@result}" onclick="OnLoadContentDynamic('{@rid}','iteration',this);">
				<span class="ui-status-icon"></span>
				<xsl:choose>
					<xsl:when test="@type='test case iteration'">Iteration: </xsl:when>
					<xsl:otherwise>Repeat: </xsl:otherwise>
				</xsl:choose>
				<xsl:value-of select="./@iteration"/>
				<xsl:if test=".//item[@level='Warn']">
					<span class="ui-module-icon warn"></span>
				</xsl:if>
				<span class="duration">
					<xsl:value-of select="./@duration"/>
				</span>
			</h2>
			<ul>
				<xsl:if test="./datarow/field">
					<div class="datarow">
						<xsl:apply-templates select="./datarow"/>
					</div>
				</xsl:if>
				
				<xsl:if test="$loadAll = 1">				
					<xsl:apply-templates select="./activity">
						<xsl:with-param name="itemCount" select="$itemCount" />
					</xsl:apply-templates>
				</xsl:if>
			</ul>
		</li>
	</xsl:template>

	<xsl:template match="activity[@type='test case setup' or @type='test case teardown']">
		<xsl:param name="itemCount"/>
		<li class="{@result} setup-teardown" id="testcase{@rid}"> 
			<h2 class="{@result}" onclick="OnLoadContentDynamic('{@rid}','testcase',this);">
				<span class="ui-status-icon"></span> <xsl:if test="@type='test case setup'">SETUP</xsl:if> <xsl:if test="@type='test case teardown'">TEARDOWN</xsl:if> <xsl:value-of select="./@iteration"/>
				<xsl:if test=".//item[@level='Warn']"><span class="ui-module-icon warn"></span></xsl:if>
				<span class="duration"><xsl:value-of select="./@duration"/></span>
			</h2>
			
			<ul>
				<xsl:if test="$loadAll = 1">
					<xsl:apply-templates select="./activity">
						<xsl:with-param name="itemCount" select="$itemCount" />
					</xsl:apply-templates>
				</xsl:if>
			</ul>
		</li>
	</xsl:template>
    
	<xsl:template match="activity[@type='test module']" >
		<xsl:param name="itemCount"/>
		<li>
			<h3 class="module-title {@result}" id="testmodule{@rid}" onclick="OnLoadContentDynamic('{@rid}','testmodule',this);">
				<a href="#"><span class="ui-icon ui-icon-circle-triangle-e"></span> 
				<span class="ui-status-icon"></span> 
				<span class="ui-module-icon {@moduletype}"></span> 
				<xsl:value-of select="./@modulename"/>
				<xsl:if test=".//item[@level='Warn']"><span class="ui-module-icon warn"></span></xsl:if>
				<i><xsl:value-of select="./detail"/> </i> 
				<span class="duration"><xsl:value-of select="./@duration"/></span></a>
			</h3>
			<div class="module-container"> 
				<div class="module-header"> <xsl:call-template name="levelFilterSelector"/> </div>
				<div class="module-report">
					<TABLE border="0" cellSpacing="0" class="reporttable">
						<thead>
							<th width="10%" >
							  <b>Time</b>
							</th>
							<th width="8%" >
							  <b>Level</b>
							</th>
							<th width="12%" >
							  <b>Category</b>
							</th>
							<th>
							  <b>Message</b>
							</th>
						</thead>
					
						<tbody>						
							<xsl:if test="$loadAll = 1">
								<xsl:apply-templates select="./item">
								  <xsl:with-param name="type">testsuite</xsl:with-param>
								</xsl:apply-templates>
							</xsl:if>
						</tbody>
          
						<!-- additional metadata per module activity (added by mgi) -->
						<xsl:copy-of select="./varbindings/varbinding"/>
					</TABLE>
				</div>
			</div>
		</li>	
	</xsl:template>
  
	<!--
	MODULE GROUP TEMPLATE

	[Expand/Collapse][StatusIcon][ModulgroupIcon][ModuleGroupName] ... [Duration]
	-->
	<xsl:template match="activity[@type='module group']">
        <xsl:param name="itemCount"/>
        <li class="modulgroup {@result} ui-treeList-item">
            <h2 class="modulgroup {@result}">
                <span class="ui-status-icon"></span>
                <span class="ui-icon modulegroup"></span>
                <xsl:value-of select="./@modulegroupname"/>
				<xsl:if test=".//item[@level='Warn']"><span class="ui-module-icon warn"></span></xsl:if>
                <span class="duration">
                    <xsl:value-of select="./@duration"/>
                </span>
            </h2>

            <ul>
                <!-- ModuleGroup Warn Messages -->
                <xsl:choose>
                    <xsl:when test="./item" >
                        <div class="warnmessage" style="margin-top:8px; ">
                            <xsl:for-each select="./item">
                                <xsl:copy-of select="./message"/>
                            </xsl:for-each>
                        </div>
                    </xsl:when>
                </xsl:choose>
                      
                <!-- Sub Items of ModuleGroup -->
                <xsl:choose>
                    <xsl:when test="@result='Failed' or @result='Active' or @result='Ignored' or @result='Success'">
                        <xsl:apply-templates select="./activity">
                            <xsl:with-param name="itemCount" select="$itemCount" />
                        </xsl:apply-templates>
                    </xsl:when>
                </xsl:choose>
            </ul>
        </li>
    </xsl:template> 
  
	<!--
	FOLDER TEMPLATE

	[Expand/Collapse][StatusIcon][FolderIcon][FolderName] ... [Duration]
	-->   
	<xsl:template match="activity[@type='folder']">
        <xsl:param name="itemCount"/>
        <li class="folder {@result} ui-treeList-item">
            <h2 class="folder {@result}">
                <span class="ui-status-icon"></span>
                <span class="ui-icon folder"></span>
                <xsl:value-of select="./@foldername"/>
				<xsl:if test=".//item[@level='Warn']"><span class="ui-module-icon warn"></span></xsl:if>
                <span class="duration">
                    <xsl:value-of select="./@duration"/>
                </span>
            </h2>
            <ul>
                <xsl:choose>
                    <xsl:when test="@result='Failed' or @result='Active' or @result='Ignored' or @result='Success'">
                        <xsl:apply-templates select="./activity">
                            <xsl:with-param name="itemCount" select="$itemCount" />
                        </xsl:apply-templates>
                    </xsl:when>
                </xsl:choose>
            </ul>
        </li>
    </xsl:template> 
  
  
	<!--
	ITEM TEMPLATE

	[Time]  [Level] [Category] [Message] (Hover -> Menu(Jump to Item, Edit in Spy ...))

	-->
	<xsl:template match="item">
		<xsl:param name="type"/>	
		<tr class="{translate(@level,' ','_')}" style="{@style}" onMouseOver="DisplayHoverMenu(this)"  onMouseOut="HideHoverMenu(this)">
			<td class="timeCell">
				<xsl:value-of select="./@time"/>
			</td>
			<td class="levelCell">
				<xsl:value-of select="./@level"/>
			</td>
			<td class="categoryCell">
				<xsl:value-of select="./@category"/>
			</td>
			<td class="messageCell {$type}">
				<xsl:if test='metainfo'>
					<xsl:variable name="controls-class">
					  <xsl:choose>
						<xsl:when test="./metainfo/@path and (@level='Error' or @level='Warn')">
							<xsl:text>controls-container three-columns</xsl:text>
						</xsl:when>
						<xsl:when test="./metainfo/@path or @level='Error' or @level='Warn'">
							<xsl:text>controls-container two-columns</xsl:text>
						</xsl:when>
						<xsl:otherwise>
							<xsl:text>controls-container</xsl:text>
						</xsl:otherwise>
					  </xsl:choose>
					 </xsl:variable>
					
					<!-- Jump-To Popup -->
					<xsl:if test="not(@category = 'Popup Watcher')"> <!-- No jump-to possible for Popup Watcher -->
						<xsl:if test="./metainfo/@id or ./metainfo/@path or ((./metainfo/@codefile and ./metainfo/@codeline) or  ./metainfo/@itemindex) or (@level='Error' or @level='Warn')">
							<div class="{$controls-class}">		
								<xsl:if test="(./metainfo/@codefile and ./metainfo/@codeline) or  ./metainfo/@itemindex or ./metainfo/@id">
									<a href="#" class="jump-to"><xsl:copy-of select="./metainfo"/> <span class="ui-icon"></span>Jump to item</a> 
								</xsl:if>						
								<xsl:if test="./metainfo/@path"><a href="#" class="spy"><xsl:copy-of select="./metainfo"/>  <span class="ui-icon"></span><span class="spytext">Edit in Spy</span></a></xsl:if>
								<xsl:if test="@level='Error' or @level='Warn'"><a href="#" class="help"> <span class="ui-icon"></span>View Help</a></xsl:if>					
							</div>
						</xsl:if>
					</xsl:if>
				</xsl:if>

				<xsl:copy-of select="./message"/>

				<xsl:if test='./metainfo/@stacktrace'>
				<div class="stacktrace" >
				  <span onclick="$(this).next().toggle();">Show/Hide Stacktrace</span>
				  <p>
					<xsl:value-of select="./metainfo/@stacktrace"/>
				  </p>
				</div>
				</xsl:if>

				<xsl:if test='@errimg'>
					<br />
					<a href="{@errimg}" class="thickbox" rel="modulename"><img src="{@errthumb}" alt="Screenshot"/></a>
				</xsl:if>				
			</td>
		</tr>
	</xsl:template>

	<xsl:template name="levelFilterSelector">
		<div class="filter">
			<span>Filter: </span>
			<xsl:if test=".//item[@level='Debug']">
				<xsl:call-template name="levelFilterCheckbox">
					<xsl:with-param name="level" select=".//item[@level='Debug']" />
				</xsl:call-template>
			</xsl:if>
			<xsl:if test=".//item[@level='Info']">
				<xsl:call-template name="levelFilterCheckbox">
					<xsl:with-param name="level" select=".//item[@level='Info']" />
				</xsl:call-template>
			</xsl:if>
			<xsl:if test=".//item[@level='Warn']">
				<xsl:call-template name="levelFilterCheckbox">
					<xsl:with-param name="level" select=".//item[@level='Warn']" />
				</xsl:call-template>
			</xsl:if>
			<xsl:if test=".//item[@level='Error']">
				<xsl:call-template name="levelFilterCheckbox">
					<xsl:with-param name="level" select=".//item[@level='Error']" />
				</xsl:call-template>
			</xsl:if>
			<xsl:if test=".//item[@level='Success']">
				<xsl:call-template name="levelFilterCheckbox">
					<xsl:with-param name="level" select=".//item[@level='Success']" />
				</xsl:call-template>
			</xsl:if>
			<xsl:if test=".//item[@level='Failure']">
				<xsl:call-template name="levelFilterCheckbox">
					<xsl:with-param name="level" select=".//item[@level='Failure']" />
				</xsl:call-template>
			</xsl:if>   
			<xsl:for-each select=".//item[not(@level=preceding-sibling::item/@level) and not(@level='Debug' or @level='Info' or @level='Warn' or @level='Error' or @level='Success' or @level='Failure')]">
				<xsl:call-template name="levelFilterCheckbox">
					<xsl:with-param name="level" select="." />
				</xsl:call-template>
			</xsl:for-each> 
		</div>
	</xsl:template>

 <xsl:template name="levelFilterCheckbox">
  <xsl:param name="level"/>
  <xsl:variable name="currentId">
    <xsl:value-of select="generate-id($level)"/>
  </xsl:variable>
   <xsl:variable name="levelName">
     <xsl:value-of select="$level/@level"/>
   </xsl:variable>

    <xsl:choose>
    <xsl:when test="$level/../../activity[@type='test module']">
      <input type="checkbox" id="checkBox{$currentId}" name="checkBox{$currentId}" onClick="ShowHideItem($(this).parent().parent().next().find('tr.{translate($levelName,' ','_')}'), !this.checked);" checked="1" />
    </xsl:when>
    <xsl:otherwise>
      <input type="checkbox" id="checkBox{$currentId}" name="checkBox{$currentId}" onClick="ShowHideItem($('tr.{translate($levelName,' ','_')}'), !this.checked);" checked="1" />
    </xsl:otherwise>
  </xsl:choose>

  <label for="checkBox{$currentId}">
    <xsl:value-of select="$levelName"/>
  </label>
 </xsl:template>


 <xsl:template name ="globalCategorySelector">
     <div class="filter">
         <span>Filter:</span>
         <input type="checkbox" id="checkBoxTestCaseSuccess" name="checkBoxTestCaseSuccess" onClick="OnFilter(this,['li.Success'])" checked="1"/> <label for="checkBoxTestCaseSuccess">Success</label>
         <input type="checkbox" id="checkBoxTestCaseFailed" name="checkBoxTestCaseFailed" onClick="OnFilter(this,['li.Failed','li.Active'])" checked="1" /> <label for="checkBoxTestCaseFailed">Failed</label>
         <input type="checkbox" id="checkBoxTestCaseIgnored" name="checkBoxTestCaseIgnored" onClick="OnFilter(this,['li.Ignored'])" checked="1" /> <label for="checkBoxTestCaseIgnored">Blocked</label>
     </div>
 </xsl:template>


 <xsl:template name="executionInformation">
	<div class="execution-information">
    <table>
      <tr>
        <td>
          <i class="field">
            Execution time <b>
              <xsl:value-of select="@timestamp"/>
            </b>
          </i>
        </td>
        <td>
          <i class="field">
            Computer name <b>
              <xsl:value-of select="@host"/>
            </b>
          </i>
        </td>
      </tr>
      <tr>
        <td>
          <i class="field">
            Operating system <b>
              <xsl:value-of select="@osversion"/>
            </b>
          </i>
        </td>
        <td>
          <i class="field">
            Screen dimensions <b>
              <xsl:value-of select="@screenresolution"/>
            </b>
          </i>
        </td>
      </tr>
       <tr>
      <td>
        <i class="field">
          Language <b>
            <xsl:value-of select="@language"/>
          </b>
        </i>
      </td>
      <td>
        <xsl:choose>
          <xsl:when test="./activity[@type='test suite']">
            <i class="field">
              Duration <b>
                <xsl:value-of select="./activity[@type='test suite']/./@duration"/>
              </b>
            </i>
          </xsl:when>
        </xsl:choose>
      </td>
      </tr>
      <xsl:if test="@timeoutfactor != '1'">
        <tr>
          <td>
            <i class="field">
              Timeout factor <b>
                <xsl:value-of select="@timeoutfactor"/>
              </b>
            </i>
          </td>
        </tr>
      </xsl:if>
	   <tr>
	    <xsl:if test="@totalerrorcount">
       
          <td>
            <i class="field">
              Total errors<b>
                <xsl:value-of select="@totalerrorcount"/>
              </b>
            </i>
          </td>
        
      </xsl:if>
	   <xsl:if test="@totalwarningcount">
       
          <td>
            <i class="field">
              Total warnings<b>
                <xsl:value-of select="@totalwarningcount"/>
              </b>
            </i>
          </td>
       
      </xsl:if>
		 </tr>
    </table>
	</div>
</xsl:template> 

<xsl:template match="/" mode="TestCaseDetail">
  <xsl:apply-templates select="//activity[@rid = $testcaserid]/activity" >
    <xsl:with-param name="itemCount" select="$maxItems" />
  </xsl:apply-templates>
</xsl:template>


<xsl:template match="/" mode="TestModuleDetail">
  <xsl:apply-templates select="//activity[@rid = $testcaserid]/item" >
    <xsl:with-param name="itemCount" select="$maxItems" />
  </xsl:apply-templates>
</xsl:template>

  
  
</xsl:stylesheet>


