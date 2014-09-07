<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
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
    <h1>Main Page</h1>
    <hr>
    <center>
	    <h2>Operations</h2>
	    <a href="UsersActionServlet?pageTo=1&opFlag=dispByPage">Manage User</a><br>
	    <a href="addUser.jsp">Add User</a><br>
	    <a href="">Search User</a><br>
	    <a href="">Delete User</a><br>
    </center>
    <hr>
  </body>
</html>
