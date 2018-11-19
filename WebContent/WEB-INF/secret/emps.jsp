<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工信息管理</title>
<style type="text/css">
	td{
		color:green;
		text-align:center;
	}
	input[type='button']{
		color:blue;font-weight:bolder;font-size:1.1em;
	}
	input[name='like_name']{
		color:blue;font-weight:bolder;font-size:1.1em;border:1px solid #00ffff;
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
	
	<center>
	
		<form action="" method="post">
		
			<table align="center" border="2" width="600px">
				<caption style="color:green;font-size:1.5em;">员工管理系统</caption>
				<tr>
					<td colspan="6">
						<input type="text" value="${like_name }" name="like_name"/> &nbsp;&nbsp;<button onclick="doSearch()">搜索</button>
					</td>
				</tr>
				<tr>
					<th><input type="checkbox" id="checkAll"></th>
					<th>员工序号</th>
					<th>员工编号</th>
					<th>员工姓名</th>
					<th>员工性别</th>
					<th>入职日期</th>
					<th>操作</th>
				</tr>
				<c:choose>
				
					<c:when test="${not empty pageResult.pageList }">
						
						<c:forEach items="${pageResult.pageList }" var="emp" varStatus="vs">
							
							<tr>
								<td><input type="checkbox" name="checkOne"/></td>
								<td>${vs.count }</td>
								<td>${emp.id }</td>
								<td>${emp.name }</td>
								<td>${emp.sex }</td>
								<td>
									
									<fmt:formatDate value="${emp.hiredate }" type="date" dateStyle="long" />
									
								</td>
								<td><input type="button" value="编辑" name="edit" /></td>
							</tr>
						
						
						</c:forEach>
					</c:when>
					
					<c:otherwise>
					
							<tr><td colspan="6">暂时没有数据&nbsp;&nbsp;<input type="button" value="返回" id="back2"/></td></tr>
					
					</c:otherwise>
				
				
				</c:choose>
							
			
			
			</table>
		
		</form>
		
		<div>
		
			<table align="center" border="2"  width="600px">
						
						<tr>	
							<td colspan="6">
								当前第${pageResult.pageNo }/${pageResult.totalPage }页&nbsp;&nbsp;
								<a href="javascript:doGoTo(1)">首页</a>&nbsp;&nbsp;
								<a href="javascript:doGoTo(${pageResult.pageNo-1 })">上一页</a>&nbsp;&nbsp;
								<a href="javascript:doGoTo(${pageResult.pageNo+1 })">下一页</a>&nbsp;&nbsp;
								<a href="javascript:doGoTo(${pageResult.totalPage })">尾页</a>&nbsp;&nbsp;
								跳转:<input type="text" onkeypress="javascript:if(event.keyCode==13){doGoTo($(this).val())}"/>
							</td>	
						</tr>
						<tr>
							<td colspan="6">
								<input type="button" value="新增" name="add"/>
								<input type="button" value="删除" id="del"/>
								<input type="button" value="返回" id="back1"/>
							</td>
						</tr>
				
				
			</table>
			
		</div>
	</center>
</body>
<script type="text/javascript">

	function doSearch(){
		document.forms[0].action="${pageContext.request.contextPath}/show.action";
		document.forms[0].submit();
	}	
	
	function doGoTo(pageNo){
		var totalPage = ${pageResult.totalPage};
		if(pageNo<1){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo = totalPage;
		}
		document.forms[0].action="${pageContext.request.contextPath}/show.action?pageNo="+pageNo;
		document.forms[0].submit();
	}
	$(function(){
		$("input[name='edit']").click(function(){
			var eid = $(this).parents("tr").children(":eq(2)").text();
			window.location.href="${pageContext.request.contextPath}/getinfo.action?eid="+eid;
		});
		
		$("input[name='add']").click(function(){
			window.location.href="${pageContext.request.contextPath}/fillinfo.action";
		});
		
		
		$("#del").click(function(){
			var ids = new Array();
			var $checks= $(":checkbox[name='checkOne']:checked");
				if($checks.size()>0){
					$.each($checks,function(index,check){
						var id = $(check).parents("tr").children(":eq(2)").text();
						ids[index]=id;
					});
					window.location.href="${pageContext.request.contextPath}/del.action?ids="+ids;
				}else{
					alert("请勾选要删除的选项");
				}
		});
		
		$("#back1").click(function(){
			window.location.href="${pageContext.request.contextPath}/index.jsp";
		});
		
		$("#back2").click(function(){
			window.location.href="${pageContext.request.contextPath}/index.jsp";
		});
		
		$("#checkAll").click(function(){
			$(":checkbox[name='checkOne']:checked").attr("disabled","disabled");
			$(":checkbox[name='checkOne']:enabled").attr("checked","checked");
			$(":checkbox[name='checkOne']:disabled").removeAttr("disabled").removeAttr("checked");
		});
		
		
	});

</script>
</html>