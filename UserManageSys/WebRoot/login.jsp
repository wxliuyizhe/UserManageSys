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
  <center>
  <%
  	String errCode = request.getParameter("errCode");
  	if(errCode!=null)
	  	if(errCode.equals("1")) out.println("Ilegal Login. Try again.<br>");
   %>
  
    用户登录 <br>
    <hr>
    <form action = "LoginActionServlet" method="post">
    用户名：<input type="text" name="username"><br>
  密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name = "passwd"><br>
  <input type="submit" value="登录">
  <input type="reset" value="重置"> 
    
    </form>
    <hr>
    </center>
  </body>
</html>
