<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta name="viewport" content="width=device-width,height=device-height,initial-scale=1" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/md5.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery-1.12.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/js/bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.validate.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootstrap.css" />
<title>添加管理员信息</title>
</head>

<body style="background-image: url(${pageContext.request.contextPath }/image/admin1.jpg)">
<div class="row-fluid" >
		<div class="col-md-4"></div>
		<div class="col-md-4">
		<center><h1><font color="red">添加管理员信息</font></h1></center>
			<form role="form" class="form-horizontal" 
				action="${pageContext.request.contextPath }/OAuthServlet?method=update"
				method="post" id="checkForm">
				<div class="form-group">
					<label class="col-md-3 control-label" for="username" style="color:yellow;">用户名</label>
					<div class="col-md-9">
						<input class="form-control" name="username" type="text" id="username"
							placeholder="Username" value="" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label" for="inputPassword" style="color:yellow;">密码</label>
					<div class="col-md-9">
						<input type="password" name="password1" class="form-control"
							id="inputPassword1" placeholder="Password">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label" for="inputPassword" style="color:yellow;">确认密码</label>
					<div class="col-md-9">
						<input type="password" name="password2" class="form-control"
							id="inputPassword2" placeholder="确认密码">
					</div>
				</div>
				<div class="form-group">
				</div>
				<div class="form-group">
					<div class="col-md-offset-3 col-md-3">
						<button type="submit" class="btn btn-primary btn-block">
							确定</button>
					</div>
					<div class="col-md-offset-3 col-md-3">
					    <a href="${pageContext.request.contextPath}/admin/login.jsp" 
					    class="btn btn-primary btn-block">退出</a>
					</div>
				</div>
				<c:if test="${param.status.equals('1')}">
					<div class="alert alert-danger" role="alert">修改失败</div>
				</c:if>
				<c:if test="${param.status.equals('2')}">
					<div class="alert alert-success" role="alert">修改成功，请返回登录页面</div>
				</c:if>
				<c:if test="${param.status.equals('3')}">
					<div class="alert alert-danger" role="alert">用户名重复</div>
				</c:if>
			</form>
		</div>
		<div class="col-md-4"></div>
	</div>
	
	<script type="text/javascript">
	$().ready(function() {
		
		// 自定义验证规则
		$.validator.addMethod("usernp", function(value, element) {   
			var usernameReg = /^[a-zA-Z0-9_][a-zA-Z0-9_]{3,9}$/;
			return this.optional(element) || (usernameReg.test(value));
		}, "请正确填写您的用户名/密码");
		
		//规则（把XXX改为相应的表单id）
		  $("#checkForm").validate({
			  errorElement : 'span',  
		      errorClass : 'help-block',  
		      focusInvalid : false,   
			  rules: {
					username:{
						required : true,
						usernp:true
					},
					password:{
						required : true,
						usernp:true
					},
					password2:{
						required : true,
						equalTo:"#inputPassword1"
					}		
			    },
			    messages: {
					username:{
						required : "用户名为空",
						usernp:"用户名格式不正确，4-10位数字/字母/下划线"
					},
					password:{
						required : "密码为空",
						usernp:"密码格式不正确，4-10位数字/字母/下划线"
					},
					password:{
						required : "确认密码为空",
						equalTO:"两次密码输入不一致"
					}
			    },  
		        highlight : function(element) {  
		            $(element).closest('.form-group').addClass('has-error');  
		        },  
		        success : function(label) {  
		            label.closest('.form-group').removeClass('has-error');  
		            label.remove();  
		        },  
		        errorPlacement : function(error, element) {  
		            element.parent('div').append(error);  
		        },
		        submitHandler : function(form) {
					//md5加密后传到后台
					var pass = hex_md5($("#inputPassword1").val());
		        	//alert(pass);
		        	$("#inputPassword1").val(pass);
					form.submit();
				}
			});
		});
	</script>
</body>
</html>