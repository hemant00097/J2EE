package org.jspiders.jdbcApp;
import java.sql.*;
import java.util.Scanner;
public class LoginValidation 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select FullName from jspider.user where Name=? and Password=? ";
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the Name ???");
		String Name=sc.next();
		System.out.println("Enter the Password ???");
		String Password=sc.next();
		sc.close();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306? user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			//SET THE VALUE FOR PLACEHOLDER BEFORE EXECUTION
			pstmt.setString(1, Name);
			pstmt.setString(2,Password);
			//EXECUTE SQL QUERY
			rs=pstmt.executeQuery();
			//CHECK FOR RECORDS IN CURSOR OR BUFFER MEMORY
			if(rs.next())
			{
				String username=rs.getString(1);
				System.out.println("Welcome "+username);
			}
			else
			{
				System.out.println("Invalid Name/Password");
			}
		  } 
		catch(ClassNotFoundException|SQLException e)
		   {
			  e.printStackTrace();
		   }
		finally
		{
			if(rs!=null)
			{
				try
				{
					rs.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try
				{
					con.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
