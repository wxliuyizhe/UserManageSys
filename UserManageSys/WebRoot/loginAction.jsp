<%@ page language="java" import="java.util.*,java.sql.*,com.yizhe.model.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'loginAction.jsp' starting page</title>
    
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
    <%
    	// 接收用户名和密码，完成对用户的验证
    	String u = request.getParameter("username");
    	String p = request.getParameter("passwd");
    	
    	UserBeanAction uba = new UserBeanAction();
    	
    	if(uba.checkUser(u, p)){
    		response.sendRedirect("wel.jsp?userName="+u);
    	}
    	else{
    		response.sendRedirect("login.jsp");
    	}
    	
    	// 验证，先不去数据库
    	
    	// 到数据库中验证
    	// 1. 加载驱动
    	// Class.forName("com.mysql.jdbc.Driver");
    	
    	// 2. 得到链接
    	// Connection ct = DriverManager.getConnection("jdbc:mysql://localhost/test","neil","274316");
    	// 3. 创建 Statement
    	// Statement sm = ct.createStatement();
    	// 4. 查询
   
    	// ResultSet rs = sm.executeQuery("select passwd from users where username = '"+u+"'");
    	
    	// 根据结果判断
    	// if (rs.next()){// 若能进去，说明用户名存在
    	 
    	 	//System.out.println(rs.getString(1));
    	//	if(rs.getString(1).equals(p)){// 合法
    	//			response.sendRedirect("wel.jsp?userName="+u);
    	//	}
    	//	else{// 密码错误
    	//	 	response.sendRedirect("login.jsp?errorNO=2");// errorNO = 1 表示是密码错误； 2 表示用户名出错
    	//	}
    	//}
    	// else{
    	// 用户名错误
    	//	response.sendRedirect("login.jsp?errorNO=1");// errorNO = 1 表示是密码错误； 2 表示用户名出错
    	//}
    	//}
    	//if(u.equals("neil") && p.equals("274316")){
    		//合法
    		//1. cookie 2. session 3. response.sendRedirect
    //		response.sendRedirect("wel.jsp?userName="+u);
    		
    //	}else{
    		//非法
   // 		response.sendRedirect("login.jsp");
    //	}
     %>
  </body>
</html>
