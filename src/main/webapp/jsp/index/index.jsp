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

  <frameset rows="98,*,8" frameborder="no" border="0" framespacing="0">
  <frame src="top.do" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />
  <frame src="main.do" name="mainFrame" id="mainFrame" />
  <frame src="down.do" name="bottomFrame" scrolling="no" noresize="noresize" id="bottomFrame" />
</frameset>
<noframes>
<body>
</body>
</noframes>
</head>
</html>