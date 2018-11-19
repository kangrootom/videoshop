<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
</head>
<body>
	this is success.jsp;
	<center><h2>${msg }</h2></center>
	</HR>
	<center><button id="b1">GET JSON</button></center>
	<center><h3> <span id="sp1"></span></h3></center>
	
	
</body>
<script type="text/javascript">
	$(function(){
		$("#b1").click(function(){
			var url = "${pageContext.request.contextPath }/getJson.action";
			var sendData = null;
			$.post(url,sendData,function(ajax,textStatus){
				var userInfo = "返回用户信息为：" + "      用户id:"+ajax.emp.id+"      用户姓名:"+ajax.emp.name+"      用户性别"+ajax.emp.sex+ "  msg:"+ajax.status;
				$("#sp1").text(userInfo).css("color","green");
			});
		});	
	});
</script>
</html>