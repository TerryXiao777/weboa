<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="cache-control" content="no-cache"/>
<meta http-equiv="expires" content="0"/>
<title>更新记录成功</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/base.css">
<script type="text/javascript">
var path = "<%=path%>";

function goUrl(){
	location.href= path + "/${skipUrl}";
}
function clock(){
	i = i -1;
	if(document.getElementById("info")){
		document.getElementById("info").innerHTML = "本窗口将在"+i+"秒后自动跳转";
	}
	if(i > 0)
		setTimeout("clock();",1000);
	else
		goUrl();
}

var i = 4;
clock();

</script>
</head>

  <body>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" background="images/tab/tab_05.gif">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="images/tab/tab_03.gif" width="12" height="30" /></td>
        <td>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="46%" valign="middle">
	            <table width="100%" border="0" cellspacing="0" cellpadding="0">
	              <tr>
	                <td width="5%"><div align="center"><img src="images/tab/tb.gif" width="16" height="16" /></div></td>
	                <td width="95%" class="STYLE1"></td>
	              </tr>
	            </table>
            </td>
          </tr>
        </table>
        </td>
        <td width="16">
        <img src="images/tab/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table>
    </td>
  </tr>
  
  <tr>
    <td>
	    <table width="100%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td width="8" background="images/tab/tab_12.gif">&nbsp;</td>
	        <td>
		        <table width="100%" border="0" cellpadding="0" cellspacing="1">
		          <tr>
		          	<td colspan="3">
		          		<div class="p_succ_div">
		          			<img src="images/big_success.png" border="0" class="img_succ">&nbsp;
		          			更新记录成功！<p>
		          			<div id="info">本窗口将在3秒后自动关闭</div>
		          		</div>
		          	</td>
		          </tr>
		          <tr>
		          	<td colspan="3">
		          		<div class="div_img1">
		          			<a href="javascript:void(0);" onclick="goUrl();"><img src="images/btn_05.png" border="0"/></a>
		          		</div>
		          	</td>
		          	<td></td>
		          	<td>&nbsp;</td>
		          </tr>
		        </table>
	        </td>
	        <td width="8" background="images/tab/tab_15.gif">&nbsp;</td>
	      </tr>
	    </table>
    </td>
  </tr>
  
  <tr>
    <td height="35" background="images/tab/tab_19.gif">
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="images/tab/tab_18.gif" width="12" height="35" /></td>
        <td>
	        <table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td>&nbsp;</td>
	            <td>&nbsp;</td>
	          </tr>
	        </table>
        </td>
        <td width="16"><img src="images/tab/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table>
    
    </td>
  </tr>
</table>
  </body>
</html>