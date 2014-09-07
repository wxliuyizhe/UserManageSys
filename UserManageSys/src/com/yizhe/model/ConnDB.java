// get connection to DB

package com.yizhe.model;

import java.sql.*;
import java.util.*;

public class ConnDB {
	
	private Connection ct = null;
	public Connection getConn(){
		
		try{
	    	Class.forName("com.mysql.jdbc.Driver");
	    	
	    	// 2. get connection
	    	ct = DriverManager.getConnection("jdbc:mysql://localhost/test","neil","274316");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return ct;
	}
	
}
