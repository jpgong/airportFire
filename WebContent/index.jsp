<%@page import="com.weixin.OAuth.SNSUerInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" http-equiv="Content-Type" content="width=device-width,user-scalable=0">
	<title>OAuth2.0网页授权</title>
	<style type="text/css">
		*{margin: 0;padding: 0}
		table {border: 1px dashed #B9B9DD;font-size: 12pt;}
		td {border: 1px dashed #B9B9DD;word-break:break-all; word-wrap:break-word; }
	</style>
</head>
<body>
	<%
		//获取由OAuthservlet传入的参数
		SNSUerInfo user = (SNSUerInfo)request.getAttribute("snsUerInfo");
	    if(user != null){
	%>
	<table width="100%" cellspacing="0" cellpadding="0">
		<tr><td width="20%">属性</td><td width="80%">值</td></tr>
		<tr><td>OpenId</td><td><%=user.getOpenid()%></td></tr>
		<tr><td>昵称</td><td><%=user.getNickname()%></td></tr>
		<tr><td>性别</td><td><%=user.getSex()%></td></tr>
		<tr><td>国家</td><td><%=user.getCountry()%></td></tr>
		<tr><td>省份</td><td><%=user.getProvince()%></td></tr>
		<tr><td>城市</td><td><%=user.getCity()%></td></tr>
		<tr><td>头像</td><td><%=user.getHeadimgurl()%></td></tr>
		<tr><td>特权</td><td><%=user.getPrivilege()%></td></tr>
	</table>
	<%
	    }
	    else
	    	out.print("未获取到用户信息");
	%>

</body>
</html>