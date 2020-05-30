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
<title>请选择要添加的公文</title>
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
		                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[公文管理]-[公文维护]</td>
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
	        	<c:forEach items="${workflows }" var="flow">
				<a href="document.do?method=addInput&workflowId=${flow.id }">${flow.name}</a> &nbsp;
				</c:forEach>
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