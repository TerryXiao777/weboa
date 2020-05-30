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
<style type="text/css">

body {
	margin:0;
	padding:0;
	background-color: #016aa9;
}
.STYLE1 {
	color: #000000;
	font-size: 12px;
}
.input01{
	width:105px;
	height:17px;
	background-color:#292929;
	border:solid 1px #7dbad7;
	font-size:12px;
	color:#ffffff;
}

</style>
<!-- jQuery -->
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/layer/layer.js"></script>

<script type="text/javascript" src="<%=path%>/js/common.js"></script>
<script type="text/javascript" src="<%=path%>/js/login/login.js"></script>

<title>登录</title>

</head>

<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td>
	    <table width="962" border="0" align="center" cellpadding="0" cellspacing="0">
	      <tr>
	        <td height="235" background="images/login_03.gif">&nbsp;</td>
	      </tr>
	      <tr>
	        <td>
	          <table width="100%" border="0" cellspacing="0" cellpadding="0">
		        <tr>
		          <td width="394" height="53" background="images/login_05.gif"></td>
		          <td width="206" background="images/login_06.gif">
		          	<form action="login.do" method="post" id="loginForm">
		          	<input type="hidden" name="method" value="login">
			         <table width="100%" border="0" cellspacing="0" cellpadding="0">
		              <tr>
		                <td width="20%" height="25">
		                	<div align="right">
		                		<span class="STYLE1">用户名</span>
		                	</div>
		                </td>
		                <td width="57%" height="25">
			                <div align="center">
			                  <input type="text" name="username" class="input01" id="username"/>
			                </div>
		                </td>
		                <td width="23%" height="25"></td>
		              </tr>
		              <tr>
		                <td height="25">
		                	<div align="right"><span class="STYLE1">密&nbsp;&nbsp;&nbsp;码</span></div>
		                </td>
		                <td height="25">
		                	<div align="center">
		                  		<input type="password" name="password" class="input01" id="passwd"/>
		                	</div>
		                </td>
		                <td height="25">
		                	<div align="left">
		                		<a href="javascript:void(0);" id="doSubmit">
		                			<img src="images/dl.gif" width="49" height="18" border="0"/>
		                		</a>
		                	</div>
		                </td>
		              </tr>
			        </table>
			        </form>
	            </td>
	            <td width="362" background="images/login_07.gif"></td>
	          	</tr>
        	</table>
        </td>
      </tr>
      <tr>
        <td height="213" background="images/login_08.gif"></td>
      </tr>
    </table>
    </td>
  </tr>
</table>
</body>
</html>