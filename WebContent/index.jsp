<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center><h2><bold>this is index.jsp</bold></h2></center>
	
	<center><a href="${pageContext.request.contextPath}/getJson.action">getJson</a></center>
	<center><a href="${pageContext.request.contextPath}/say.action">go to say</a></center>
	<center><a href="${pageContext.request.contextPath}/show.action">go to show emp</a></center>
	<center><a href="${pageContext.request.contextPath}/avshop/show.action">go to show videoshop</a></center>
	<center><a href="${pageContext.request.contextPath}/toUpLoad.jsp">go to upload</a></center>
	<center><a href="${pageContext.request.contextPath}/listFiles.action">go to download</a></center>
</body>
</html>