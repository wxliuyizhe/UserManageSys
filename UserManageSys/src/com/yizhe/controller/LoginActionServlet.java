// This is a controller, used to finish the verification of User
// Controller itself is not used to do the business logic, but call Classes of Model layer to finish the data processing, i.e. verification

package com.yizhe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yizhe.model.*;


public class LoginActionServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginActionServlet() {
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
		
		// Get the username and password from login.jsp
		String u = request.getParameter("username");
		String p = request.getParameter("passwd");
		// Call classes of Model Layer
		// 1. Instantiate a UserBeanAction object
		
		UserBeanAction uba = new UserBeanAction();
		if(uba.checkUser(u, p)){
			// if correct
			
			// when jump to wel.jsp page, we need to prepare the data to be displayed
			
			ArrayList<UserBean> res = uba.getUsersByPage(1);
			int pageCount = uba.getPageCount();
			// add res and pageCount to request
			request.setAttribute("result", res);
			request.setAttribute("pageCount", pageCount);// downcasting 
			request.setAttribute("pageNow", 1); 
			request.getSession().setAttribute("userName", u);
			
			// sendRedirect is not efficient, thus "request.getRequestDispatcher" is more often applied
			// response.sendRedirect("wel.jsp");
			// The following method is efficient, and objects or info in request can be still used in next page forwarded 
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
		else{
			
			// if wrong user input
			// response.sendRedirect("login.jsp");
			request.getRequestDispatcher("login.jsp").forward(request, response);
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
