// sometimes , this class is called BO, business object, main target is to encapsulate all ACTIONS to table "users"
// C.R.U.D operations 
package com.yizhe.model;

import java.sql.*;
import java.util.*;

public class UserBeanAction {
	
	private Statement sm = null;// If use prepareStatement, faster
	private ResultSet rs = null;
	private Connection ct = null;
	private int pageSize = 3;
	private int pageCount = 0;
	private int rowCount = 0;
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public void close() {
		try{	
			if(rs != null){
				rs.close();
				rs = null;
			}
			if(sm != null){
				sm.close();
				sm = null;
			}
			if(ct != null){
				ct.close();
				ct = null;
			}
			
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// verify whether user exists
	public boolean checkUser(String u, String p){
		boolean res = false;
		
		try{
			// get connection
			ct = new ConnDB().getConn();
			
			sm = ct.createStatement();
			rs = sm.executeQuery("select passwd from users where username = '"+u+"'");
			
			if(rs.next()){
				if(rs.getString(1).equals(p)){
					res = true;
				}
			}
//			else{// password wrong
//				res = false;
//			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		finally{
			// close all resources, very IMPORTANT, in the reverse order of opening, since ct is opened first, then sm, then rs
			// copy above code into a method;
			this.close();
		}
		
		return res;
	}
	
	// return number of all pages
	
	public int getPageCount(){

		try{
			ct = new ConnDB().getConn();
			sm = ct.createStatement();
			rs = sm.executeQuery("select count(*) from users ");
	    	 if(rs.next()){
	    	 	rowCount = rs.getInt(1);
	    	}
	     	if(rowCount%pageSize == 0) pageCount = rowCount/pageSize;
	     	else pageCount = rowCount/pageSize + 1; 
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			this.close();
		}
		
		return pageCount;
	}
	
	public ArrayList<UserBean> getUsersByPage(int pageNow){

		ArrayList<UserBean> res = new ArrayList<UserBean>();
		try{
			ct = new ConnDB().getConn();
			sm = ct.createStatement();
			rs = sm.executeQuery("select * from users left join (select userId from users limit "+ pageSize*(pageNow - 1) +" ) as u "+
		    	" on users.userId = u.userId where u.userId is null limit "+ pageSize);
			while(rs.next()){
				UserBean ub = new UserBean();
				ub.setUserId(rs.getInt(1));
				ub.setUsername(rs.getString(2));
				ub.setPasswd(rs.getString(3));
				ub.setEmail(rs.getString(4));
				ub.setGrade(rs.getInt(5));
				res.add(ub);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			this.close();
		}
		
		return res;
	}
	
	// delete user by userId
	public boolean delUserById(String userId){
		boolean res = false;
		
		try{
			ct = new ConnDB().getConn();
			sm = ct.createStatement();
			int exRes = sm.executeUpdate("delete from users where userId='"+userId+"'");
			if(exRes==1){
				// delete successfully
				res = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			
		}
		return res;
	}
	
	public boolean addUser(String userName, String passwd, String email, String grade){
		boolean res = false;
		
		try{
			ct = new ConnDB().getConn();
			sm = ct.createStatement();
			int exRes = sm.executeUpdate("insert into users valuse() userId=");
			if(exRes==1){
				// delete successfully
				res = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			
		}
		
		return res;
	}
}
