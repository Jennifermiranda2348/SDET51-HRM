package com.practicepackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest {

	public static void main(String[] args) throws Throwable {
		
		Connection con = null;
		
		try
		{
		//Step 1: Register the driver
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject","root","root");
		
		//Step 2: Create statement
		Statement state = con.createStatement();
		
		String query = "select * from hrm";
		
		//Step 4: Execute the query
		ResultSet result = state.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5));
		}
	}
	catch(Exception e)
	{
		
	}
	finally
	{
		con.close();
	}
	

	}

}
