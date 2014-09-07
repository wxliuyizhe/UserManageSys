// This controller is used to deal with display by page, user addition,delete, etc. actions

package com.yizhe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yizhe.model.UserBean;
import com.yizhe.model.UserBeanAction;

public class UsersActionServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UsersActionServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//		out.println("  <BODY>");
//		out.print("    This is ");
//		out.print(this.getClass());
//		out.println(", using the GET method");
//		out.println("  </BODY>");
//		out.println("</HTML>");
//		out.flush();
//		out.close();
		
		// Get the page we want to get to
		
		String userName = (String)request.getSession().getAttribute("userName");
		String opFlag = request.getParameter("opFlag");
		
		if(opFlag.equals("dispByPage")){
			try{
				String s_pageTo = request.getParameter("pageTo");
				int pageTo = Integer.parseInt(s_pageTo);
				// call UserBeanAction object
					UserBeanAction uba = new UserBeanAction();
					
					ArrayList<UserBean> res = uba.getUsersByPage(pageTo);
					int pageCount = uba.getPageCount();
					// add res and pageCount to request
					request.setAttribute("result", res);
					request.setAttribute("pageCount", pageCount);// downcasting 
					request.setAttribute("pageNow", pageTo); 			
					request.getSession().setAttribute("userName", userName);
					request.getRequestDispatcher("wel.jsp?opFlag=dispByPage").forward(request, response);
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		if(opFlag.equals("delUser")){
//			System.out.println("Hey,delete user.");
			
			String userId = request.getParameter("userId");
			UserBeanAction uba = new UserBeanAction();
			if(uba.delUserById(userId)){
				// delete successfully
				request.getRequestDispatcher("suc.jsp").forward(request, response);
			}else{// failed
				request.getRequestDispatcher("fail.jsp").forward(request, response);				
			}
		}
		
		
		if(opFlag.equals("addUser")){
//			System.out.println("Hey,delete user.");
			
			String newUserName = request.getParameter("userName");
			String newPasswd = request.getParameter("passwd");
			String newEmail = request.getParameter("email");
			String newGrade = request.getParameter("grade");
			
			UserBeanAction uba = new UserBeanAction();
			if(uba.addUser(newUserName, newPasswd, newEmail, newGrade)){
				// delete successfully
				request.getRequestDispatcher("suc.jsp").forward(request, response);
			}else{// failed
				request.getRequestDispatcher("fail.jsp").forward(request, response);				
			}
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//		out.println("  <BODY>");
//		out.print("    This is ");
//		out.print(this.getClass());
//		out.println(", using the POST method");
//		out.println("  </BODY>");
//		out.println("</HTML>");
//		out.flush();
//		out.close();
		
		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
