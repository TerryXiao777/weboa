function user_role_list(puid){
	layer.open({
	  id: 'user_role_list_layer',
	  type: 2,
	  area: ['800px', '450px'], //宽高
	  shadeClose: false, //点击遮罩关闭
      shade: 0.01,
      title:'分配角色',
	  content: 'user.do?method=userRoleList&id='+puid,
	  cancel: function (index, layero) {
		//右上角关闭回调
		var body = layer.getChildFrame('body', index);
		//var orgId = body.find("#orgId").val();
		//var orgName = body.find("#orgName").val();
		//var iframeWin = window[layero.find('iframe')[0]['name']];
		//console.log("orgId-->"+orgId);
		//console.log("orgName-->"+orgName);
		
	  }
	});
}

function acl_operate(principalId){
	layer.open({
	  id: 'acl_operate_layer',
	  type: 2,
	  area: ['800px', '450px'], //宽高
	  shadeClose: false, //点击遮罩关闭
      shade: 0.01,
      title:'用户授权',
	  content: 'acl.do?method=aclOperate&principalType=User&principalId='+principalId,
	  cancel: function (index, layero) {
		//右上角关闭回调
		var body = layer.getChildFrame('body', index);
		//var orgId = body.find("#orgId").val();
		//var orgName = body.find("#orgName").val();
		//var iframeWin = window[layero.find('iframe')[0]['name']];
		//console.log("orgId-->"+orgId);
		//console.log("orgName-->"+orgName);
		
	  }
	});
}