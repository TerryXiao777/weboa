$(document).ready(function() {
	$('#doSubmit').on('click', function() {
		if(check()==false){
			return;
		}
		else{
			//得到form对象
			var myform=$('#moduleForm');
			myform.submit();
		}
	});
});

function check(){
	var flag = true;
	var name = $("#name").val();
	if(trim(name) == ""){
		var str="模块名称不能为空！";
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
	var sn = $("#sn").val();
	if(trim(sn) == ""){
		var str="模块编号不能为空！";
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
	var orderNo = $("#orderNo").val();
	if(trim(orderNo) == ""){
		var str="排序号不能为空！";
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
	$("#sn").val("");
	$("#orderNo").val("");
	$("#url").val("");
}