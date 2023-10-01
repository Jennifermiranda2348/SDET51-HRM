package com.practicepackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class WithScannerClassTest {

	public static void main(String[] args) throws Throwable {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter Name to add: ");
		String name = s.nextLine();
		
		Connection con = null;
		Random ram = new Random();
		int random = ram.nextInt(100);
		
		try
		{
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject","root","root");
			Statement state = con.createStatement();
			String query = "select Employee_Name from hrm1;";
			ResultSet res = state.executeQuery(query);
			
			boolean flag = false;
			while(res.next())
			{
				String actual = res.getString(1);
				if(actual.equalsIgnoreCase(name))
				{
					flag=true;
					break;
				}
			}
			if(flag==true)
			{
				System.out.println("\n "+name+" is present in the table");
			}
			else
			{
				System.out.println("\n"+name+" does not exist in the table");
				String query1 = "Insert into hrm1 values("+random+",'"+name+"');";
				
				int res1 = state.executeUpdate(query1);			
			}
			}
			catch(Exception e)
			{}
			finally
			{
				con.close();
			}
	}

}
