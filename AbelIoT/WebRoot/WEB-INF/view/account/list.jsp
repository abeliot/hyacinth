<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'account.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="resources/css/pager.css">
	<script type="text/javascript" src="resources/js/pager.js"></script>

  </head>
  
  <body>
   	您现在所在的位置： <br>
   	
   	<form id="queryForm" action="account?method=show" method="post">
   		<input type="hidden" name="pageSize" value="3"/>
   		<input type="hidden" name="pageIndex" value="1" />
   		<input type="submit" value="查询">
   	</form>

    
    <table border="1">
    	<tr>
    		<th>id</th><th>login_name</th><th>password</th><th>display_name</th><th>register_date</th><th>update_date</th><th>account_status</th>
    	</tr>
    	
    	<c:forEach items="${pageList.records}" var="account" >
    	<tr>
    		<td>${account.id}</td>
    		<td>${account.login_name }</td>
    		<td>${account.login_passwd }</td>
    		<td>${account.display_name }</td>
    		<td>${account.register_date }</td>
    		<td>${account.update_date }</td>
    		<td>${account.account_status }</td>
    	</tr>
    	</c:forEach>
    	
    </table>
    <tags:pager pagerRange="3" pageList="${pageList}" formId="queryForm"></tags:pager>  
  </body>
</html>
