<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    Login page. <br>
    <form action="login" method="get">
    	<input type="hidden" name="method" value="checkIn"/>
    	username : <input type="text" name="loginId" value="${user.loginId }"/><br>
    	password : <input type="text" name="passwd" value="${user.passwd }"/><br>
    	<input type="submit" value="login"/>&nbsp;&nbsp;
		<input type="reset" value="reset"/>    	
    </form>
  </body>
</html>
