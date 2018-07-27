<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="util" uri="http://localhost:8080/weixin/util" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta name="viewport" content="width=device-width,height=device-height,initial-scale=1" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootstrap.css" />
<script src="${pageContext.request.contextPath }/static/js/jquery-1.12.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/static/bootstrap-3.3.5-dist/js/bootstrap.js" type="text/javascript"></script>
<title>查看消防用具信息</title>
<script type="text/javascript">
	function checkDelete() {
		if (confirm("确定删除该分类?")) {
			return true;
		}else{
			return false;
		}
	}
	
</script>
</head>
<body style="background-image: url(${pageContext.request.contextPath }/image/background.jpg);">
<div class="row-fluid" >
		<div class="col-md-12">
			<center><h1><font color="black">查看消防用具信息</font></h1></center>
				<table class="table table-bordered table-striped table-condensed table-hover">
					<thead>
						<tr>
							<td style="color: red;">id</td>
							<td style="color: red;">名称</td>
							<td style="color: red;">型号</td>
							<td style="color: red;">状态</td>
							<td style="color: red;">该型号数量</td>
							<td style="color: red;">备注</td>
							<td style="color: red;">修改时间</td>
							<td style="color: red;">操作</td>
					    </tr>
					</thead>
					
					<tr>
						<td>${productBean.id }</td>
						<td>${productBean.productName }</td>
						<td>${productBean.productType }</td>
						<td>${productBean.status }</td>
						<td>${count }</td>
						<td>${productBean.intro }</td>
						<td>${productBean.createDate }</td>
						<td>
							<c:if test="${productBean !=null }">
								<a href="${pageContext.request.contextPath }/productServlet?method=toUpdate&id=${productBean.id }">修改</a>
								<!-- 通过return的返回值，来干扰a标签的默认操作（即提交表单） -->
								<a href="${pageContext.request.contextPath }/productServlet?method=delete&id=${productBean.id }" onclick="return checkDelete()">删除</a>
							</c:if>
						</td>
					</tr>
				</table>	
				<c:if test="${param.status.equals('1')}">
					<div class="alert alert-success" role="alert">删除成功</div>
				</c:if>
				<c:if test="${param.status.equals('2')}">
					<div class="alert alert-danger" role="alert">删除失败</div>
				</c:if>
				<c:if test="${param.status.equals('3')}">
					<div class="alert alert-success" role="alert">修改成功</div>
				</c:if>
				<c:if test="${param.status.equals('4')}">
					<div class="alert alert-danger" role="alert">修改失败</div>
				</c:if>
				<c:if test="${param.status.equals('5')}">
					<div class="alert alert-danger" role="alert">不存在该消防用具</div>
				</c:if>
		</div>
	</div>
</body>
</html>