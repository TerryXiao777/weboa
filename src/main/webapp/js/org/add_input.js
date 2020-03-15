$(document).ready(function() {
	$('#doSubmit').on('click', function() {
		if(check()==false){
			return;
		}
		else{
			//得到form对象
			var myform=$('#orgForm');
			myform.submit();
		}
	});

});


function check(){
	var name = $("#name").val();
	if(trim(name) == ""){
		var str="机构名称不能为空！";
		$("#msg_error").html(str);
		$("#msg_error").show();
		$("#msg_succ").hide();
		return false;
	}
	else{
		$("#msg_error").hide();
		$("#msg_succ").show();
		return true;
	}
}

function reset(){
	$("#name").val("");
	$("#description").val("");
}