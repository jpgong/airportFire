<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta name="viewport" content="width=device-width,height=device-height,initial-scale=1" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath }/static/bootstrap-3.3.5-dist/js/bootstrap.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath }/static/js/jquery.validate.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/bootstrap-3.3.5-dist/css/bootstrap.css" />
<title>修改消防用具信息</title>
</head>

<body style="background-image: url(${pageContext.request.contextPath }/image/background.jpg);">
	<div class="row-fluid">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<center><h1>修改消防用具信息</h1></center>
			<form role="form" class="form-horizontal"
				action="${pageContext.request.contextPath}/productServlet?method=updateProduct"
				method="post" id="checkForm">
				<div class="form-group">
					<label class="col-md-3 control-label" for="name">名称</label>
					<div class="col-md-9">
						<input class="form-control" name="name" type="text" id="name"
							placeholder="name" value="${productBean.productName }" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label" for="type">型号</label>
					<div class="col-md-9">
						<input class="form-control" name="type" type="text" id="type"
							placeholder="name" value="${productBean.productType }" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-3 control-label" for="status">状态</label>
					<div class="col-md-9">
						<input type="text" name="status" class="form-control" id="status"
							placeholder="分类序号" value="${productBean.status }">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label" for="intro">备注</label>
					<div class="col-md-9">
						<input type="text" name="intro" class="form-control" id="intro"
							placeholder="分类描述" value="${productBean.intro }">
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-offset-3 col-md-9">
						<button type="submit" class="btn btn-primary btn-block">
							修改</button>
					</div>
					<input type="hidden" name="id" value="${productBean.id }" />
				</div>
				<c:if test="${param.status.equals('1')}">
					<div class="alert alert-danger" role="alert">添加失败</div>
				</c:if>
				<c:if test="${param.status.equals('2')}">
					<div class="alert alert-success" role="alert">添加成功</div>
				</c:if>
				<c:if test="${param.status.equals('3')}">
					<div class="alert alert-success" role="alert">修改成功</div>
				</c:if>
				<c:if test="${param.status.equals('4')}">
					<div class="alert alert-danger" role="alert">修改失败</div>
				</c:if>
			</form>
		</div>
		<div class="col-md-4"></div>
	</div>

	<script type="text/javascript">
		$()
				.ready(
						function() {

							// 自定义验证规则
							$.validator
									.addMethod(
											"usernp",
											function(value, element) {
												var usernameReg = /^[a-zA-Z0-9_][a-zA-Z0-9_]{3,9}$/;
												return this.optional(element)
														|| (usernameReg
																.test(value));
											}, "请正确填写您的用户名/密码");

							//规则（把XXX改为相应的表单id）
							$("#checkForm")
									.validate(
											{
												errorElement : 'span',
												errorClass : 'help-block',
												focusInvalid : false,
												rules : {
													name : {
														required : true,
													},
													type : {
														required : true,
													},
													status : {
														required : true,
													},
													
												},
												messages : {
													name : {
														required : "消防用具名称不能为空",
													},
													type : {
														required : "器件类型不能为空",
													},
													status : {
														required : "器件状态不能为空",
													}
												},
												highlight : function(element) {
													$(element)
															.closest(
																	'.form-group')
															.addClass(
																	'has-error');
												},
												success : function(label) {
													label
															.closest(
																	'.form-group')
															.removeClass(
																	'has-error');
													label.remove();
												},
												errorPlacement : function(
														error, element) {
													element.parent('div')
															.append(error);
												},
												submitHandler : function(form) {
	<%--
		        	var types = document.getElementById("productType").getElementsByTagName("option");
		        	if (types==1) {
						//一级分类为空
						form.submit();
					}--%>
		form.submit();
												}
											});
						});
	</script>

</body>
</html>