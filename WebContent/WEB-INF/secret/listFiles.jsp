<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件下载</title>
<style type="text/css">
	td{
		text-align: center;
		color:green;
	}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
</head>
<body>
	
	<center><h2>this is download list</h2></center>
	
	<center>
	
		<table border="2" align="center">
			<caption>文件下载列表</caption>
			<tr>
				<th>文件编号</th>
				<th>文件名称</th>
				<th>下载</th>
				<th>打开</th>
			</tr>
			<c:choose>
				
				<c:when test="${not empty fileList }">
					<c:forEach items="${fileList }" var="file" varStatus="vs">
					
						<tr>
							<td>${vs.count }</td>
							<td name="parse">${file.name }</td>
							<td>
								<c:url var="url" value="downLoad.action">
									<c:param name="fileName" value="${file.name }"></c:param>
									<c:param name="filePath" value="${file.parent}"></c:param>
								</c:url>
								<a href="${url }">下载</a>
							</td>
							<td><a href="javascript:goTo('${file.name}')">打开</a></td>
						</tr>
					</c:forEach>
				</c:when>
				
				<c:otherwise>
					<tr><td colspan="3">服务器暂时没有文件</td><tr>
				</c:otherwise>
			
			</c:choose>
		</table>
		
	</center>
</body>
<script type="text/javascript">
	
	function goTo(fileName){
		var url = "${pageContext.request.contextPath}/upload/"+encodeURI(encodeURI(fileName));
		
		window.location.href= url;
		
	}
	$(function(){
		var $tds = $("td[name='parse']");
		$.each($tds,function(index,td){
			var txt = $(td).text();
			txt = txt.substring(32, txt.length); 
			$(td).text(txt);
		});
	});
	
</script>
</html>