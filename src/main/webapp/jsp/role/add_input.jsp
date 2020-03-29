<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/common.jsp" %>
<%
String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="cache-control" content="no-cache"/>
<meta http-equiv="expires" content="0"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/base.css">

<script type="text/javascript" src="<%=path%>/js/page.js"></script>
<!-- jQuery -->
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>

<script type="text/javascript" src="<%=path%>/layer/layer.js"></script>
<script type="text/javascript" src="<%=path%>/js/common.js"></script>
<script type="text/javascript" src="<%=path%>/js/role/add_input.js"></script>
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
		                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[权限管理]-[角色管理]</td>
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
	        <form action="role.do" method="post" id="roleForm">
	        	<input type="hidden" name="method" value="add">
				<input type="hidden" name="skipUrl" value="role.do?method=roleList">
		        <table width="100%" border="0" cellpadding="0" cellspacing="1">
		          <tr>
		          	<td class="STYLE6" width="10%">角色名称：</td>
		          	<td width="15%">
		          		<input type="text" id="name" name="name" onblur="check();"/>&nbsp;
		          		<span class="STYLE7"></span>
		          	</td>
		          	<td width="75%">
		          		<div class="success" id="msg_succ" style="display: none"></div>
		          		<div class="error" id="msg_error" style="display: none"></div>
		          	</td>
		          </tr>
		          
		          <tr>
		          	<td colspan="3">
		          		<div class="div_img1">
			          		<a href="javascript:void(0);" id="doSubmit">
			          			<img src="images/btn_01.png" border="0" id="btn_ok"/></a>
			          		<img src="images/btn_02.png" style="display:none" border="0" id="btn_cl"/>&nbsp;&nbsp;
			          		<a href="javascript:void(0);" onclick="reset();" ><img src="images/btn_03.png" border="0"/></a>
		          		</div>
		          	</td>
		          	<td></td>
		          	<td>&nbsp;</td>
		          </tr>
		        </table>
	        </form>
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