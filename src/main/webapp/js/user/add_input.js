$(document).ready(function() {
	$('#doSubmit').on('click', function() {
		if(check()==false){
			return;
		}
		else{
			//得到form对象
			var myform=$('#userForm');
			myform.submit();
		}
	});
});

function check(){
	var flag = true;
	var username = $("#username").val();
	if(trim(username) == ""){
		var str="用户账号不能为空！";
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
	
	var password = $("#password").val();
	if(trim(password) == ""){
		var str="登录密码不能为空！";
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
	
	var expireTime = $("#expireTime").val();
	if(trim(expireTime) == ""){
		var str="失效时间不能为空！";
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
	$("#username").val("");
	$("#password").val("");
	$("#expireTime").val("");
}