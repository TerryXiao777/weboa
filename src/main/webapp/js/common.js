//消除空格
String.prototype.trimRight = function() {
	return this.replace(/ +$/,"");
}

String.prototype.trimLeft = function() {
	return this.replace(/^ +/,"");
}

String.prototype.trim = function() {
	return this.replace(/(^ +)|( +$)/,"");
}

function trim(str){
  return ltrim(rtrim(str));
}

function ltrim(str){
  var sRet="";
  regular = /\s*(\S*)/; 
  sRet=str.replace(regular, "$1");
  return sRet;
}

function rtrim(str){
  var sRet="";
  regular = /(\S*)\s*$/; 
  sRet=str.replace(regular, "$1");
  return sRet;
}



/*
 * 删除记录
 */
function del(url){
	layer.confirm('您确定要删除该用户吗?',{btn: ['确定', '取消'],title:"提示"}, function(index){
		layer.close(index);
		$.get(url,function(data,status){
			//console.log("-->"+data);
			//console.log("-->"+status);
			window.location.reload(true);
	    });
		
    });
}