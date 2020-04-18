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


<script type="text/javascript" src="<%=path%>/js/common.js"></script>

<script type="text/javascript" src="<%=path%>/dwr/engine.js"></script>
<script type="text/javascript" src="<%=path%>/dwr/util.js"></script>
<script type="text/javascript" src="<%=path%>/dwr/interface/aclManager.js"></script>

<script type="text/javascript">
//授权
function addOrUpdatePermission(field){
	dwr.engine.setAsync(false);
	field.moduleId = field.getAttribute("moduleId");
	field.permission = field.getAttribute("permission");
	//console.log(field.moduleId);
	//console.log(field.permission);
	//如果被选择上，则同时选择其"不继承"和"启用"checkbox
	if(field.checked){
		$(field.moduleId+"_USE").checked = true;
		<c:if test="${aclForm.principalType eq 'User' }">
			$(field.moduleId+"_EXT").checked = true;
			addOrUpdateExtends(field);
		</c:if>
	}

	aclManager.addOrUpdatePermission("${aclForm.principalType}",${aclForm.principalId},
			field.moduleId,field.permission,field.checked);
}

//设置用户的继承特性
function addOrUpdateExtends(field){
	//field.moduleId = $(field).attr("moduleId");
	
	aclManager.addOrUpdateUserExtends(${aclForm.principalId},field.moduleId,!field.checked);
}

//点击启用checkbox
function usePermission(field){
	//如果checkbox被选中，意味着需要更新ACL的状态
	//更新C/R/U/D以及Extends状态
	
	//设置为同步方式，以便DWR依次发出下列请求
	dwr.engine.setAsync(false);
	//var moduleId = $(field).attr("moduleId");
	if(field.checked){
		addOrUpdatePermission($(field.moduleId+"_C"));
		addOrUpdatePermission($(field.moduleId+"_R"));
		addOrUpdatePermission($(field.moduleId+"_U"));
		addOrUpdatePermission($(field.moduleId+"_D"));
		<c:if test="${aclForm.principalType eq 'User' }">
		addOrUpdateExtends(field.moduleId+"_EXT");
		</c:if>
	}
	else{
		aclManager.deletePermission("${aclForm.principalType}",${aclForm.principalId},field.moduleId);
		
		$(field.moduleId+"_C").checked = false;
		$(field.moduleId+"_R").checked = false;
		$(field.moduleId+"_U").checked = false;
		$(field.moduleId+"_D").checked = false;
		<c:if test="${aclForm.principalType eq 'User' }">
		$(field.moduleId+"_EXT").checked = false;
		</c:if>
	}
}

function initTable(){
	aclManager.searchAclRecord("${aclForm.principalType}",${aclForm.principalId},
		function(datas){
			for(var i=0; i < datas.length; i++){
				var moduleId = datas[i][0];
				var cState = datas[i][1];
				var rState = datas[i][2];
				var uState = datas[i][3];
				var dState = datas[i][4];
				var extState = datas[i][5];
				
				$(moduleId+"_C").checked = cState == 0 ? false : true;
				$(moduleId+"_R").checked = rState == 0 ? false : true;
				$(moduleId+"_U").checked = uState == 0 ? false : true;
				$(moduleId+"_D").checked = dState == 0 ? false : true;
				<c:if test="${aclForm.principalType eq 'User' }">
				$(moduleId+"_EXT").checked = extState == 0 ? true : false;
				</c:if>
				$(moduleId+"_USE").checked = true;
			}
		}
	);
}
</script>
</head>

<body onload="initTable()">

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
		                <c:choose>
		                	<c:when test="${aclForm.principalType eq 'Role' }">
		                		<td width="55%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[权限管理]-[角色管理]</td>
		                		<c:set var="title" value="请给角色【${role.name }】授权"/>
		                	</c:when>
		                	<c:otherwise>
		                		<td width="55%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[权限管理]-[用户管理]</td>
		                		<c:set var="title" value="请给用户【${user.person.name }】授权"/>
		                	</c:otherwise>
		                </c:choose>
		                
		                <td width="40%"><span class="STYLE3">${title }</span></td>
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
	        			<td class="STYLE6">顶级模块</td>
	        			<td class="STYLE6">二级模块</td>
	        			<td class="STYLE6">权限</td>
	        			<c:if test="${aclForm.principalType eq 'User' }">
						<td class="STYLE6" >不继承</td>
						</c:if>
						<td class="STYLE6" >启用</td>
	        		</tr>
	        		
	        		<!-- 输出模块树 -->
	        		<c:forEach items="${modules }" var="module">
	        			<tr>
	        				<td>${module.name }</td>
							<td></td>
							<td>
							<input type="checkbox" id="${module.id }_C" onclick="addOrUpdatePermission(this)" moduleId="${module.id }" permission="0">C
							<input type="checkbox" id="${module.id }_R" onclick="addOrUpdatePermission(this)" moduleId="${module.id }" permission="1">R
							<input type="checkbox" id="${module.id }_U" onclick="addOrUpdatePermission(this)" moduleId="${module.id }" permission="2">U
							<input type="checkbox" id="${module.id }_D" onclick="addOrUpdatePermission(this)" moduleId="${module.id }" permission="3">D
							</td>
							<c:if test="${aclForm.principalType eq 'User' }">
								<td><input type="checkbox" id="${module.id }_EXT"  onclick="addOrUpdateExtends(this)" moduleId="${module.id }"></td>
							</c:if>
							<td><input type="checkbox" id="${module.id }_USE" onclick="usePermission(this)" moduleId="${module.id }"></td>
	        			</tr>
	        			
	        			<c:forEach items="${module.children }" var="child">
	        				<tr>
								<td></td>
								<td>${child.name }</td>
								<td>
								<input type="checkbox" id="${child.id }_C" onclick="addOrUpdatePermission(this)" moduleId="${child.id }" permission="0">C
								<input type="checkbox" id="${child.id }_R" onclick="addOrUpdatePermission(this)" moduleId="${child.id }" permission="1">R
								<input type="checkbox" id="${child.id }_U" onclick="addOrUpdatePermission(this)" moduleId="${child.id }" permission="2">U
								<input type="checkbox" id="${child.id }_D" onclick="addOrUpdatePermission(this)" moduleId="${child.id }" permission="3">D
								</td>
								<c:if test="${aclForm.principalType eq 'User' }">
									<td><input type="checkbox" id="${child.id }_EXT" onclick="addOrUpdateExtends(this)" moduleId="${child.id }"></td>
								</c:if>
								<td><input type="checkbox" id="${child.id }_USE" onclick="usePermission(this)" moduleId="${child.id }"></td>
							</tr>
	        			</c:forEach>
	        		</c:forEach>
	        		
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