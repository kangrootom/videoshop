<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工信息新增</title>
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
</style>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/datepicker/WdatePicker.js"></script>
</head>
<body>
	
	<form action="${pageContext.request.contextPath }/add.action" method="post">
		
			<table align="center" border="2" width="600px">
				<caption style="color:green;font-size:1.5em;">员工信息修改</caption>
				<tr>
					<th>员工编号</th>
					<th>员工姓名</th>
					<th>员工性别</th>
					<th>入职日期</th>
				</tr>
				<tr>
					<td><input type="text" name="id"/><spn></span></td>
					<td><input type="text" name="name"></td>
					<td>
						<input type="radio" name="sex" value="男" checked="checked">男</input>
						<input type="radio" name="sex" value="女" >女</input>
					</td>
					<td><input name="hiredate" type="text" value="" readonly="readonly" onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy年MM月dd日'});"/></td>
				</tr>
						
				
				<tr>
					<td colspan="4">
						<input type="button" value="提交" id="sub"/>
						<input type="button" value="返回" id="back"/>
					</td>
				</tr>
					
			</table>
		
	</form>
	
</body>
<script type="text/javascript">
	$(function(){
		
		$("input[name='id']").blur(function(){
			if($(this).val().trim()==""){
				$(this).next().text("员工编号不能为空且唯一").css({"color":"green","font-size":"10px","font-weigth":"bold"});
			}
		});
		$("input[name='id']").focus(function(){
			$(this).next().empty();
		});
		$("#sub").click(function(){
			if($("input[name='id']").val().trim() !=""){
				document.forms[0].submit();
			}
		});
		$("#back").click(function(){
			window.history.back();
		});
			
	}); 

</script>
</html>