$(document).ready(function() {
	$('#doSubmit').on('click', function() {
		if(check()==false){
			return;
		}
		else{
			//得到form对象
			var myform=$('#personForm');
			myform.submit();
		}
	});
});

function select_org(){
	layer.open({
	  id: 'sel_org_layer',
	  type: 2,
	  area: ['800px', '350px'], //宽高
	  shadeClose: false, //点击遮罩关闭
      shade: 0.01,
      title:'选择机构',
	  content: 'org.do?method=orgList&select=true',
	  cancel: function (index, layero) {
		//右上角关闭回调
		var body = layer.getChildFrame('body', index);
		var orgId = body.find("#orgId").val();
		var orgName = body.find("#orgName").val();
		//var iframeWin = window[layero.find('iframe')[0]['name']];
		//console.log("orgId-->"+orgId);
		//console.log("orgName-->"+orgName);
		
		$("#orgIdId").val(orgId);
		$("#orgNameId").val(orgName);
	  }
	});
}

function check(){
	var flag = true;
	var name = $("#name").val();
	if(trim(name) == ""){
		var str="姓名不能为空！";
		$("#msg_error").html(str);
		$("#msg_error").show();
		$("#msg_succ").hide();
		return false;
	}
	else{
		$("#msg_error").hide();
		$("#msg_succ").show();
		flag = true;
	}
	var age = $("#age").val();
	if(trim(age) == ""){
		var str="年龄不能为空！";
		$("#msg_error").html(str);
		$("#msg_error").show();
		$("#msg_succ").hide();
		return false;
	}
	else{
		$("#msg_error").hide();
		$("#msg_succ").show();
		flag = true;
	}
	var orgNameId = $("#orgNameId").val();
	if(trim(orgNameId) == ""){
		var str="机构不能为空！";
		$("#msg_error").html(str);
		$("#msg_error").show();
		$("#msg_succ").hide();
		return false;
	}
	else{
		$("#msg_error").hide();
		$("#msg_succ").show();
		flag = true;
	}
	var duty = $("#duty").val();
	if(trim(duty) == ""){
		var str="职务不能为空！";
		$("#msg_error").html(str);
		$("#msg_error").show();
		$("#msg_succ").hide();
		return false;
	}
	else{
		$("#msg_error").hide();
		$("#msg_succ").show();
		flag = true;
	}
	return flag;
}

function reset(){
	$("#name").val("");
	$("#age").val("");
	$("#duty").val("");
	$("#phone").val("");
	$("#address").val("");
}