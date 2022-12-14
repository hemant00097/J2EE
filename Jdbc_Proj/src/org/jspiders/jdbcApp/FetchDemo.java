package org.jspiders.jdbcApp;
import java.sql.*;
import java.util.Scanner;
public class FetchDemo 
{
	public static void main(String[] args) 
	{
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry ="Select * from jspider.Student where id=? ";
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the id ");
		int id=sc.nextInt();
		sc.close();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt =con.prepareStatement(qry);
			//SET THE VALUE FOR PLACEHOLDER BEFORE EXECUTION 
			pstmt .setInt(1,id);
            //EXCUTE SQL QUERY 
			rs=pstmt.executeQuery();
			//CHECK FOR RECORD IN CURSOR OR BUFFFER MEMORY 
			if(rs.next())
			{
			 String name =rs.getString(2);
			 double perc =rs.getDouble(3);
			 System.out.println("Name = "+ name +" perc= "+ perc);	
			}
			else 
			{
				System.out.println("No Data Found For ID = "+id);
			}
		}
			catch(ClassNotFoundException | SQLException e)
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
	
