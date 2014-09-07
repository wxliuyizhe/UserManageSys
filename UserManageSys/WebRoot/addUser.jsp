<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body><center>
    
    <h1>Input User Info</h1>
    <form action="UsersActionServlet?opFlag=addUser" method="post">
    	<table border="1">
    	<tr><td>User Name:</td><td><input type="text" name="userName" /></td></tr>
    	<tr><td>Password:</td><td><input type="text" name="passwd" /></td></tr>
    	<tr><td>Email:</td><td><input type="text" name="email" /></td></tr>
    	<tr><td>Grade:</td><td><input type="text" name="grade" /></td></tr>
    	<tr><td><input type="submit" value="Submit"></td><td><center><input type="reset" value="Reset"></center></td></tr>
    	</table>
    
    
    </form>	
    </center>
  </body>
</html>
