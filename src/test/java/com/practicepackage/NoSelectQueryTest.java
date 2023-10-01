package com.practicepackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NoSelectQueryTest {

	public static void main(String[] args) throws Throwable{
		Connection con = null;
		int res=0;
		
		try 
		{
			Driver driver = new Driver();
			
			//Step 1: Register database
			DriverManager.registerDriver(driver);
			
			//Step 2: Connection to the database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject","root","root");
			
			//Step 3: Create statement
			Statement state = con.createStatement();
			String q = "insert into hrm values(6.,'Miranda','Trainer','Teaching','Bengaluru),(7.,'Shridhar','Director','Accenture','ring road');";
			
			//Step 4: Execute query
			res = state.executeUpdate(q);
		}
		catch(Exception e)
		{}
		finally
		{
			if(res==2)
			{
				System.out.println("Data is created");
			}
			else
			{
				System.out.println("Data is not created");
			}
			con.close();
			
		}
	}

}
