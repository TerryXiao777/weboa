$(document).ready(function() {
	$('#doSubmit').on('click', function() {
		if(check()==false){
			return;
		}
		else{
			//得到form对象
			var myform=$('#documentForm');
			myform.submit();
		}
	});
});

function check(){
	var flag = true;
	var title = $("#title").val();
	if(trim(title) == ""){
		var str="公文名称不能为空！";
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
	
	var description = $("#description").val();
	if(trim(description) == ""){
		var str="公文描述不能为空！";
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
	
	var contentFile = $("#contentFile").val();
	if(contentFile.match(/^(.*)(\.)(.{1,8})$/)[3] != 'doc')   
	{
		var str="必需是doc文档！";
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