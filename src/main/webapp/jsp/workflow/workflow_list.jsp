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
	                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[公文管理]-[流程管理]</td>
	              </tr>
	            </table>
            </td>
            <td width="54%">
            <table border="0" align="right" cellpadding="0" cellspacing="0">
              <tr>
              	<!--  
                <td width="60">
                <table width="87%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1">
	                    <div align="center">
	                      <input type="checkbox" name="allChk" id="allChk"/>
	                    </div>
                    </td>
                    <td class="STYLE1"><div align="center">全选</div></td>
                  </tr>
                </table>
                </td>-->
                <td width="60">
	                <table width="90%" border="0" cellpadding="0" cellspacing="0">
	                  <tr>
	                    <td class="STYLE1"><div align="center"><img src="images/tab/22.gif" width="14" height="14" /></div></td>
	                    <td class="STYLE1"><div align="center"><a href="workflow.do?method=addInput" class="a1">新增</a></div></td>
	                  </tr>
	                </table>
                </td>
                
                
              </tr>
            </table>
            </td>
          </tr>
        </table>
        </td>
        <td width="16"><img src="images/tab/tab_07.gif" width="16" height="30" /></td>
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
        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto();" onmouseout="changeback();" id="resultTable">
           <!-- 列表标题栏 -->
          <tr>
          	<!--  
            <td width="3%" height="22" background="images/bg.gif" bgcolor="#FFFFFF">
	            <div align="center">
	              <input type="checkbox" name="checkbox" value="checkbox" />
	            </div>
            </td>-->
            <td width="25%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">流程名称</span></div></td>
            <td width="18%" height="22" background="images/bg.gif" bgcolor="#FFFFFF" class="STYLE1"><div align="center">基本操作</div></td>
          </tr>
           <!-- 列表数据栏 -->
          <c:if test="${!empty workflows}">
          <c:forEach items="${workflows }" var="workflow">
	      <tr>
		      <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
		      	${workflow.name }
		      	</div>
		      </td>
	          
	          <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE4">
	          	<a href="#" class="a1" onclick="javascript:del('workflow.do?method=del&id=${workflow.id }')" >删除</a>
	          	</span></div>
	          </td>
          </tr>
          </c:forEach>
		  </c:if>
          <!-- 在列表数据为空的时候，要显示的提示信息 -->
	      <c:if test="${empty workflows}">
	      <tr>
	    	<td colspan="9" align="center" bgcolor="#EFF3F7" onmouseover="this.bgColor = '#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
	    	没有找到相应的记录
	    	</td>
	      </tr>
		  </c:if>
		  
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
        <td></td>
     
        <td width="16"><img src="images/tab/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table>
    
    </td>
  </tr>
  
</table>
</body>

</html>