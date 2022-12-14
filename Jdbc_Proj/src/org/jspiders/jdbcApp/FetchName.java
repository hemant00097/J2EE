package org.jspiders.jdbcApp;
import java.sql.*;
import java.util.Scanner;
public class FetchName
{
	public static void main(String[] args) 
	{
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry ="Select * from jspider.Student where name=? ";
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the Name ");
		String name=sc.next();
		sc.close();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt =con.prepareStatement(qry);
			//SET THE VALUE FOR PLACEHOLDER BEFORE EXECUTION 
			pstmt.setString(1, name);
            //EXCUTE SQL QUERY 
			rs=pstmt.executeQuery();
			//CHECK FOR RECORD IN CURSOR OR BUFFFER MEMORY 
			if(rs.next())
			{
			 int id =rs.getInt(1);
			 double perc =rs.getDouble(3);
			 System.out.println("Id = "+ id +" perc= "+ perc);	
			}
			else 
			{
				System.out.println("No Data Found For ID = "+name);
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
	

