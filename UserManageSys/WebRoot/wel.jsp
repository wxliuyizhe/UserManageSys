<%@ page language="java" import="java.util.*,java.sql.*,com.yizhe.model.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'wel.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


	<script type="text/javascript">
	<!-- 
	function confirm(){
		System.out.println("deded");
		return window.confirm("Are you sure to delete?");
	}
	 -->
	</script>
  </head>
  
  <body>
  <%	
  	String u = (String) session.getAttribute("userName");
  	String opFlag = request.getParameter("opFlag");
  	if(u == null){
  		response.sendRedirect("login.jsp?errCode=1");
  		return;
  	}
   %>
  
  <center>
    登录成功！恭喜你 <%=u %><br>
    <a href="login.jsp">返回重新登录</a><br>
    <a href="main.jsp">Back to Main</a>
    <hr>
    <h1>用户信息列表</h1>
    <%
    
 
    	int pageNow = 1;// The default page is 1st page
    	// int pageSize = 3;
    	// int rowCount = 0;// get from database
    	 int pageCount = 0;// calculated based on pageSize and rowCount
    	
    	// get page number user wants to display
    	
    	//String s_pageTo = request.getParameter("pageTo");
    	//if(s_pageTo != null){
    	//	pageNow = Integer.parseInt(s_pageTo);
    	//}
    	
    	pageNow = (Integer)request.getAttribute("pageNow");
    	
    	// Query from DB
    	
    	    	// 1. 加载驱动
    	// Class.forName("com.mysql.jdbc.Driver");
    	
    	// 2. 得到链接
    	// Connection ct = DriverManager.getConnection("jdbc:mysql://localhost/test","neil","274316");
    	// 3. 创建 Statement
    	// Statement sm = ct.createStatement();
    	// 4. 查询
    	//ResultSet rs = sm.executeQuery("select passwd from users where username = '"+u+"'");
    	// ResultSet rs = sm.executeQuery("select count(*) from users ");
    	// if(rs.next()){
    	// 	rowCount = rs.getInt(1);
    	//}
    	
    	//System.out.println("Num of rows: "+rowCount);
    	// if(rowCount%pageSize == 0) pageCount = rowCount/pageSize;
    	//else pageCount = rowCount/pageSize + 1;
    	
    	// 查询出需要显示的记录
    //	rs = sm.executeQuery("select * from users left join (select userId from users limit "+ pageSize*(pageNow - 1) +" ) as u "+
    //	" on users.userId = u.userId where u.userId is null limit "+ pageSize);
    	// Use UserBean method
    	// UserBeanAction uba = new UserBeanAction();
    	// ArrayList<UserBean> res = new ArrayList<UserBean>();
    	// res = uba.getUsersByPage(pageNow);
    	
    	// Instead, retrieve displaying info from request object
    	ArrayList<UserBean> res = (ArrayList<UserBean>) request.getAttribute("result");
    	
    	if(res == null)System.out.println("Hey, EMPTY!!!!!!");
    
    // display	
     %>
     <table border = "1">
     <tr><td>userId</td><td>username</td><td>passwd</td><td>email</td><td>grade</td><td>update</td><td>delete</td></tr>
     <%
     	// while(rs.next()){
     	for(int i = 0; i < res.size();i++){
     		UserBean ub = res.get(i);
     		%>
     		<tr><td><%=ub.getUserId() %></td><td><%= ub.getUsername() %></td><td><%= ub.getPasswd() %></td><td><%=ub.getEmail() %></td><td><%= ub.getGrade() %></td>
     		<td><a href="">Update</a></td>
     		<td><a onclick="confirm()" href="UsersActionServlet?opFlag=delUser&userId=<%=ub.getUserId()%>">Delete</a></td></tr>
     		<%
     	}
     
      %>
     
     </table>
     
     <%
     //String s_pageCount = (String) request.getAttribute("pageCount");
     //System.out.println("YOUMAN"+s_pageCount);
     //pageCount = Integer.parseInt(s_pageCount);
     pageCount = (Integer)request.getAttribute("pageCount");
     // previous page
     if(pageNow != 1)
     out.println("<a href = UsersActionServlet?pageTo=" + (pageNow - 1)+"&opFlag="+opFlag+">Pre</a>");
     //display other pages
     for(int i = 0; i < pageCount;i++){
     	out.println("<a href = UsersActionServlet?pageTo="+(i+1)+"&opFlag="+opFlag+">["+ (i+1) +"]</a>");
     }
     // next page
     if(pageNow!=pageCount)
     out.println("<a href = UsersActionServlet?pageTo="+(pageNow + 1)+"&opFlag="+opFlag+">Next</a>");
      %>
     
    </center>
  </body>
</html>
