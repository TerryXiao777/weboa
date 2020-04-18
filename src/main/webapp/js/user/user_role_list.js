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
	var orderNo = $("#orderNo").val();
	if(trim(orderNo) == ""){
		var str="优先级不能为空！";
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
	
	var roleId = $("input[type='radio']:checked").val();
	if(roleId==undefined || roleId==null || roleId==""){
		alert("请选择一个角色名称");
		return false;
	}
	
	return flag;
}