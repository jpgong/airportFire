<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta name="viewport" content="width=device-width,height=device-height,initial-scale=1" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/md5.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery-1.12.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/js/bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.validate.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootstrap.css" />

<script type="text/javascript">
var code ; //在全局 定义验证码   
function createCode()   
{    
  code = "";   
  var codeLength = 4;//验证码的长度   
  var checkCode = document.getElementById("checkCode");   
  var selectChar = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');//所有候选组成验证码的字符，当然也可以用中文的   
      
  for(var i=0;i<codeLength;i++)   
  {   
      
  var charIndex = Math.floor(Math.random()*36);   
  code +=selectChar[charIndex];   
     
  }   
//  alert(code);   
  if(checkCode)   
  {   
    checkCode.className="code";   
    checkCode.value = code;   
  }   
     
}
</script>
</head>
<!-- onload是页面加载完毕，调用指定方法 -->
<body  onload="createCode()" style="background-image: url(${pageContext.request.contextPath }/image/admin1.jpg)">
<div class="row-fluid">
		<div class="col-md-4"></div>
		<div class="col-md-4">
		<center><h1><font color="red">用户登录</font></h1></center>
			<form role="form" class="form-horizontal" 
				action="${pageContext.request.contextPath }/OAuthServlet?method=login"
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
						<input type="password" name="password" class="form-control"
							id="inputPassword" placeholder="Password">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label" for="checkCode" style="color:yellow;">验证码</label>
					<div class="col-md-4">
						<input type="text" name="codeCheck" class="form-control"
							id="codeCheck" placeholder="Code">
					</div>
					<div class="col-md-4">
						<input type="text" onclick="createCode()" readOnly="true" id="checkCode" class="unchanged" style="width: 80px"  />
					</div>
					<div class="col-md-1"></div>
					
				</div>
				<div class="form-group">
				</div>
				<div class="form-group">
					<div class="col-md-offset-3 col-md-3">
						<button type="submit" class="btn btn-primary btn-block">
							登录</button>
					</div>
				</div>
				<c:if test="${param.status.equals('1')}">
					<div class="alert alert-danger" role="alert">用户名或密码错误</div>
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
			    	codeCheck:{
						required : true,
						equalTo : "#checkCode"
					},
					username:{
						required : true,
						usernp:true
					},
					password:{
						required : true,
						usernp:true
					}			
			    },
			    messages: {
			    	codeCheck:{
						required : "验证码为空",
						equalTo :"验证码输入错误"
					},
					username:{
						required : "用户名为空",
						usernp:"用户名格式不正确，4-10位数字/字母/下划线"
					},
					password:{
						required : "密码为空",
						usernp:"密码格式不正确，4-10位数字/字母/下划线"
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
					var pass = hex_md5($("#inputPassword").val());
		        	//alert(pass);
		        	$("#inputPassword").val(pass);
					form.submit();
				}
			});
		});
	</script>
</body>
</html>