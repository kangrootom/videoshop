<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工信息编辑</title>
<style type="text/css">
	td{
		color:green;
		text-align:center;
	}
	input[type='button']{
		color:blue;font-weight:bolder;font-size:1.1em;
	}
	a{
		text-decoration:none;
		color:#00ffff;
		font-weight:bolder;
	}
</style>>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/datepicker/WdatePicker.js"></script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/edit.action" method="post">
		
			<table align="center" border="2" width="600px">
				<caption style="color:green;font-size:1.5em;">员工信息修改</caption>
				<tr>
					<th>员工姓名</th>
					<th>员工性别</th>
					<th>员工入职时间</th>
				</tr>
				<tr>
					<td><input type="text" value="${emp.name }" name="name"/></td>
					<c:if test="${emp.sex eq '男' }">
						<td>
							<input type="radio" value="男" name="sex" checked="checked">男</input>
							<input type="radio" value="女" name="sex">女</input>
						</td>
						
					</c:if>
					<c:if test="${emp.sex eq '女' }">
						<td>
							<input type="radio" value="女" name="sex" checked="checked">女</input>
							<input type="radio" value="男" name="sex">男</input>
						</td>
					</c:if>
					<c:if test="${emp.sex != '女' and emp.sex != '男' }">
						<td>
							<input type="radio" value="${emp.sex }" name="sex" checked="checked">${emp.sex }</input>
							<input type="radio" value="男" name="sex" >男</input>
							<input type="radio" value="女" name="sex" >女</input>
						</td>
					</c:if>
					<td>
						
						<input name="hiredate" type="text" value="<fmt:formatDate value='${emp.hiredate }' type='date' dateStyle='long'/>" readonly="readonly" onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy年MM月dd日'});"></input>
					</td>
				</tr>
				
						
				
				<tr>
					<td colspan="3">
						<input type="button" value="提交" id="sub"/>
						<input type="button" value="返回" id="back"/>
					</td>
				</tr>
					
			</table>
			<input type="hidden" value="${emp.id}" name="id"/>
		</form>
</body>
<script type="text/javascript">
	$(function(){
		$("#sub").click(function(){
			document.forms[0].submit();
		});
		$("#back").click(function(){
			window.history.back();
		});
			
	}); 

</script>
</html>