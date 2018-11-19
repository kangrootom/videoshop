<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center><h2>this is upload.jsp</h2></center>
	<center>
		
		<h3>采用流的方式上传文件</h3>
		<form name="form1" action="${pageContext.request.contextPath }/fileUpload.action" method="post"  enctype="multipart/form-data">
			<input type="file" name="file">
			<input type="submit" value="upload"/>
		</form>
		</hr>
		<h3>采用multipart提供的file.transfer方法上传文件</h3>
		<form name="form2"  action="${pageContext.request.contextPath }/fileUpload2.action" method="post" enctype="multipart/form-data">
			<input type="file" name="file" />
			<input type="submit" value="提交" />
		</form>
		</hr>
		<h3>使用spring mvc提供的类的方法上传文件</h3>
		<form name="Form3" action="${pageContext.request.contextPath }/springUpload.action" method="post"  enctype="multipart/form-data">
			<input type="file" name="file1">
			<input type="file" name="file2">
			<input type="file" name="file3">
			<input type="file" name="file4">
			<input type="file" name="file5">
			<input type="submit" value="upload"/>
		</form>
	</center>
</body>
</html>