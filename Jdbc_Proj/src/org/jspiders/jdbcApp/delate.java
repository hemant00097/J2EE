package org.jspiders.jdbcApp;
import java.sql.*;
public class delate {
	public static void main(String [] args) 
	{
		Connection con=null;
		Statement stmt=null;
		String qry="delete from jspider.student where id=4 ";
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Class Loaded & Registered");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		System.out.println("Connection Established with DataBase Server");
		stmt=con.createStatement();
		System.out.println("Plateform Created");
		stmt.executeUpdate(qry);
		System.out.println("Data Delete !!!!");
	}catch(ClassNotFoundException | SQLException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(stmt!=null)
		{
			try
			{
				stmt.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("Close all Costly Resources");
	  }	
	}
}

