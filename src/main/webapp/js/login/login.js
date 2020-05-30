$(document).ready(function() {
	$('#doSubmit').on('click', function() {
		if(check_login()==false){
			return;
		}
		else{
			//得到form对象
			var myform=$('#loginForm');
			myform.submit();
		}
	});

});

function check_login(){
	var flag = true;
	var username = $("#username").val();
	if(trim(username) == ""){
		var str="用户名不能为空！";
		alert(str);
		return false;
	}
	var passwd = $("#passwd").val();
	if(passwd.trim()==""){
		var str="密码不能为空！";
		alert(str);
		return false;
	}
	return flag;
}