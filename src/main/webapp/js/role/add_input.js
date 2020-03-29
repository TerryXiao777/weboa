$(document).ready(function() {
	$('#doSubmit').on('click', function() {
		if(check()==false){
			return;
		}
		else{
			//得到form对象
			var myform=$('#roleForm');
			myform.submit();
		}
	});
});

function check(){
	var flag = true;
	var name = $("#name").val();
	if(trim(name) == ""){
		var str="角色名称不能为空！";
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
}