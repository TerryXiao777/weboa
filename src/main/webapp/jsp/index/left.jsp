<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px;
	color: #FFFFFF;
}
.STYLE3 {
	font-size: 12px;
	color: #033d61;
}
a:link { text-decoration: none;}
a:visited { text-decoration: none;}
a:hover { text-decoration: none;}
a:active { text-decoration: none;}
-->
</style>
<style type="text/css">
.menu_title SPAN {font-weight: bold; left: 3px; color: #ffffff; position: relative; top: 2px }
.menu_title2 SPAN {font-weight: bold; left: 3px; color: #FFCC00; position: relative; top: 2px}
</style>
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
<script type="text/javascript">
	var he=document.documentElement.clientHeight-105;
	//alert(document.documentElement.clientHeight);
	//document.write("<div id=tt style=height:"+he+";overflow:hidden>")
	document.write("<div id=tt style=height:100%;overflow:hidden>")
</script>

<table width="165" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="28" background="images/main_40.gif">
	    <table width="100%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td width="19%">&nbsp;</td>
	        <td width="81%" height="20"><span class="STYLE1">管理菜单</span></td>
	      </tr>
	    </table>
    </td>
  </tr>
  
  <tr>
    <td valign="top">
    <table width="151" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="images/main_47.gif" id="imgmenu1" class="menu_title" onMouseOver="this.className='menu_title2';" 
            	onClick="showsubmenu(1)" onMouseOut="this.className='menu_title';" style="cursor:hand">
	            <table width="100%" border="0" cellspacing="0" cellpadding="0">
	              <tr>
	                <td width="18%">&nbsp;</td>
	                <td width="82%" class="STYLE1">组织机构</td>
	              </tr>
	            </table>
            </td>
          </tr>
          <tr>
            <td background="images/main_51.gif" id="submenu1" style="DISPLAY: none">
			 <div class="sec_menu" >  
			 <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td>
                <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                    <td width="84%" height="23">
	                    <table width="95%" border="0" cellspacing="0" cellpadding="0">
	                        <tr>
	                          <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
	                          	<a href="#" onclick="getIframe('org.do?method=orgList');">
	                          	<span class="STYLE3">机构管理</span></a>
	                          </td>
	                        </tr>
	                    </table>
                    </td>
                  </tr>
                  
                  <tr>
                    <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                    <td height="23">
	                    <table width="95%" border="0" cellspacing="0" cellpadding="0">
	                        <tr>
	                          <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
	                          	<a href="#" onclick="getIframe('person.do?method=personList');">
	                          	<span class="STYLE3">人员管理</span></a>
	                          </td>
	                        </tr>
	                    </table>
                    </td>
                  </tr>
                 
                </table>
                </td>
              </tr>
              <tr>
                <td height="5"><img src="images/main_52.gif" width="151" height="5" /></td>
              </tr>
            </table>
            </div>
            </td>
          </tr>
        </table>
        </td>
      </tr>
      
      <tr>
        <td>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="images/main_47.gif" id="imgmenu2" class="menu_title" onmouseover="this.className='menu_title2';" 
            onclick="showsubmenu(2)" onmouseout="this.className='menu_title';" style="cursor:hand">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="18%">&nbsp;</td>
                  <td width="82%" class="STYLE1">权限管理</td>
                </tr>
            </table>
            </td>
          </tr>
          <tr>
            <td background="images/main_51.gif" id="submenu2" style="DISPLAY: none">
            <div class="sec_menu" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td width="84%" height="23">
	                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
	                              <tr>
	                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
	                                	<a href="#" onclick="getIframe('module.do?method=moduleList');">
	                                	<span class="STYLE3">模块管理</span></a>
	                                </td>
	                              </tr>
	                          </table>
                          </td>
                        </tr>
                        
                        <tr>
                          <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td height="23">
	                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
	                              <tr>
	                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
	                                	<span class="STYLE3">角色管理</span>
	                                </td>
	                              </tr>
	                          </table>
                          </td>
                        </tr>
                        
                        <tr>
                          <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td height="23">
	                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
	                              <tr>
	                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
	                                	<span class="STYLE3">用户管理</span>
	                                </td>
	                              </tr>
	                          </table>
                          </td>
                        </tr>
                        
                        
                        
                    </table>
                    </td>
                  </tr>
                  <tr>
                    <td height="5"><img src="images/main_52.gif" width="151" height="5" /></td>
                  </tr>
                </table>
            </div>
            </td>
          </tr>
        </table>
        </td>
      </tr>
      
      <tr>
        <td>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="images/main_47.gif" id="imgmenu3" class="menu_title" onmouseover="this.className='menu_title2';" 
            onclick="showsubmenu(3)" onmouseout="this.className='menu_title';" style="cursor:hand">
	            <table width="100%" border="0" cellspacing="0" cellpadding="0">
	                <tr>
	                  <td width="18%">&nbsp;</td>
	                  <td width="82%" class="STYLE1">系统安全</td>
	                </tr>
	            </table>
            </td>
          </tr>
          <tr>
            <td background="images/main_51.gif" id="submenu3" style="display:none">
            <div class="sec_menu" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td>
                    	<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td width="84%" height="23">
                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; " 
                                	onmouseout="this.style.borderStyle='none'">
                                	<a href="#" onclick="getIframe('ami.do?method=amiListPage');">
                                		<span class="STYLE3">附件类型</span>
                                	</a>
                                	</td>
                              </tr>
                          </table>
                          </td>
                        </tr>
                        
                        <tr>
                          <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td height="23">
                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
                                	<span class="STYLE3">信息安全管理</span>
                                </td>
                              </tr>
                          </table>
                          </td>
                        </tr>
                        
                        <tr>
                          <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td height="23">
                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
                                <span class="STYLE3">安全审计</span>
                                </td>
                              </tr>
                          </table>
                          </td>
                        </tr>
                        
                        <tr>
                          <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td height="23">
                          <table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'">
                                <span class="STYLE3">网站安全</span>
                                </td>
                              </tr>
                          </table>
                          </td>
                        </tr>
                        
                    </table>
                    </td>
                  </tr>
                  <tr>
                    <td height="5"><img src="images/main_52.gif" width="151" height="5" /></td>
                  </tr>
                </table>
            </div>
            </td>
          </tr>
        </table>
        </td>
      </tr>
      
    </table>
    </td>
  </tr>
  
  <tr>
    <td height="18" background="images/main_58.gif">
	    <table width="100%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td height="18" valign="bottom">
	        	<div align="center" class="STYLE3">版本：V1.0</div>
	        </td>
	      </tr>
	    </table>
    </td>
  </tr>
</table>

<script type="text/javascript">
function showsubmenu(sid)
{
	whichEl = eval("submenu" + sid);
	imgmenu = eval("imgmenu" + sid);
	if (whichEl.style.display == "none")
	{
		eval("submenu" + sid + ".style.display=\"\";");
		imgmenu.background="images/main_47.gif";
	}
	else
	{
		eval("submenu" + sid + ".style.display=\"none\";");
		imgmenu.background="images/main_48.gif";
	}
}
</script>

<script type="text/javascript">
function getIframe(url)
{
     //var htmlUrl = window.parent.frames["I2"].location;
     //var htmlUrl = $(window.parent.document).find("#I2").attr("src");
     $("#I2",parent.document.body).attr("src",url);
}
</script>