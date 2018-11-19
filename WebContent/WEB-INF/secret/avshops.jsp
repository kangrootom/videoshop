<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>avshop</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/datepicker/WdatePicker.js"></script>
<link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body style="padding:40px">
	<c:if test="${pageResult.totalPage ge 1 }">
	<c:set var="totalPage" value="${pageResult.totalPage}" scope="request"></c:set>
	<% 
		Integer totalPage = (Integer)request.getAttribute("totalPage");
		List<Integer> pageNums = new LinkedList<Integer>();
		for(int i = 1; i<=totalPage;i++){
			pageNums.add(i);
		}
		request.setAttribute("pageNums", pageNums);
	%>
	</c:if>
	<div class="container" style="background: #e6e6e6">
		
		<form action="" method="post">
			<div class="modal fade bs-example-modal-lg" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		        <div class="modal-dialog modal-lg">
		          <div class="modal-content">
		            <div class="modal-header">
		              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		              <h4 class="modal-title" id="exampleModalLabel">美女視頻</h4>
		            </div>
		            <div class="modal-body">
		              <img src="img/1.jpg" id="imgmodal" class="img-responsive" width="100%" height="600" onmouseover="voplay()" onmouseout="vopause()">
		              <video id="videomodal" width="100%" height="600" src="av01.mp4" controls="controls">
		            </div>
		            <div class="modal-footer">
		              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		              <button type="button" class="btn btn-primary">Send message</button>
		          	</div>
		         </div>
		       </div>
		     </div>
		  	<div class="row">
			  	<c:choose>
					
						<c:when test="${not empty pageResult.pageList }">
							
							<c:forEach items="${pageResult.pageList }" var="avshop" varStatus="vs">
						          <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
						            <div class="thumbnail">
						             <!-- <video width="400" height="320" src="file:///E:/av.mp4" controls="controls"> -->
						              <a href="#exampleModal" data-toggle="modal" videoSrc="${pageContext.request.contextPath }/${avshop.avvideosrc }">
						              <img src="${pageContext.request.contextPath }/${avshop.avimgsrc }" class="img-responsive" width="600" height="480" onmouseover="voplay()" onmouseout="vopause()">
						              <%-- <img dynsrc="${pageContext.request.contextPath }/${avshop.avvideosrc }"  class="img-responsive" width="600" height="480" loop="infinite"> --%>
						              </a>
						              <div class="caption">
						                <h3 class="bg-info">${avshop.avtitle }</h3>
						                <p class="text-muted">${avshop.avdesc }</p>
						              </div>
						              <div class="text-right">
						                <a class="btn btn-info btn-xs" href="${pageContext.request.contextPath }/${avshop.avvideosrc }" target="_blank">去看看</a>
						                <button class="btn btn-success btn-xs">点我购买</button>
						              </div>
						            </div>
					              </div>
	            			</c:forEach>
						</c:when>
				
						<c:otherwise>
						
								<div class="bg-info">暂时没有数据&nbsp;&nbsp;<input type="button" class="btn btn-success" value="返回" id="back2"/><div>
						
						</c:otherwise>
			
			
			</c:choose>
          </div>
		</form>
		
		<div align="center">
		
			<%-- <table align="center" border="2"  width="600px">
						
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
				
				
			</table> --%>
				    <c:choose>
				    	<c:when test="${pageResult.pageNo ge 1 }">
				    		<nav>
					  			<ul class="pagination">
					  				<li>
								      <div class="form-group">
							            <label for="sel">每页显示条数</label>
							            <select id="sel" class="form-control" name="pageSize" value="${pageResult.pageSize }">
							       			
							              <option selected="selected">${pageResult.pageSize }</option>
							              <option>3</option>
							              <option>6</option>
							              <option>9</option>
							              <option>12</option>
							              <option>24</option>
							              <option>100</option>
							            </select>
							          </div>
								    </li>
						    		<li>
								      <a href="javascript:doGoTo(${pageResult.pageNo-1 })" aria-label="Previous">
								        <span aria-hidden="true">&laquo;</span>
								      </a>
								    </li>
								    <c:forEach items="${pageNums }" var="pageNum">
								    	<li><a href="javascript:doGoTo(${pageNum })">${pageNum }</a></li>
								    </c:forEach>
						    		<li>
						    			<a href="javascript:doGoTo(${pageResult.pageNo+1 })" aria-label="Next">
								        	<span aria-hidden="true">&raquo;</span>
								      	</a>
								    </li>
								 </ul>
							</nav>
				    	</c:when>
				    	<c:otherwise>
				    		
				    	</c:otherwise>
				    </c:choose>
		</div>
	</div>
</body>
<script type="text/javascript">

	function doSearch(){
		document.forms[0].action="${pageContext.request.contextPath}/avshop/show.action";
		document.forms[0].submit();
	}	
	
	function doGoTo(pageNo){
		var totalPage = ${pageResult.totalPage};
		if(pageNo<1){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo = totalPage;
		}
		document.forms[0].action="${pageContext.request.contextPath}/avshop/show.action?pageNo="+pageNo;
		document.forms[0].submit();
	}
	$(function(){
		
		$("#sel").change(function(){
			var pageSize = $(this).val();
			document.forms[0].action="${pageContext.request.contextPath}/avshop/show.action?pageNo=1&pageSize="+pageSize;
			document.forms[0].submit();
			
		});
		
		$("#back1").click(function(){
			window.location.href="${pageContext.request.contextPath}/index.jsp";
		});
		
		$("#back2").click(function(){
			window.location.href="${pageContext.request.contextPath}/index.jsp";
		});
		$("a[href='#exampleModal']").click(function(){

	          var imgString = $(this).children().attr("src");
	          $("#imgmodal").attr("src",imgString);
	          var videoString = $(this).attr("videoSrc");
	          $("#videomodal").attr("src",videoString);

	      });
		
		
	});

</script>
</html>