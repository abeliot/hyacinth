<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String WebInfPath = request.getServletContext().getRealPath("/WEB-INF");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'infoList.jsp' starting page</title>
    
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
	
	<script type="text/javascript">
		function del(id){
						
			location = "info?method=del&id="+id;
		}
	</script>

  </head>
  
  <body>
    This is info list page. <br>
    <form id="queryForm" action="info?method=list" method="post">
   		<input type="hidden" name="pageSize" value="3"/>
   		<input type="hidden" name="pageIndex" value="1" />
   		<input type="submit" value="查询">
   	</form>
   	
    <table border="1">
    	<tr>
    		<th>id</th><th>name</th><th>age</th><th></th>
    	</tr>
    	
    	<c:forEach items="${pageList.records}" var="info" >
    	<tr>
    		<td>${info.id}</td>
    		<td>${info.name }</td>
    		<td>${info.age }</td>
    		<td><a href="javascript:del(${info.id })">删除</a></td>
    	</tr>
    	</c:forEach>
    	
    </table>
    <tags:pager pagerRange="3" pageList="${pageList}" formId="queryForm"></tags:pager>  
  </body>
</html>
