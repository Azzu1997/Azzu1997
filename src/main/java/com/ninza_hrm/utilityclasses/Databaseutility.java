package com.ninza_hrm.utilityclasses;

import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Databaseutility 
{
	Fileutility f= new Fileutility();
	Connection conn=null;
   ResultSet result=null;
    
    
	public void createDBRegister() throws SQLException, IOException
	{
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		 conn = DriverManager.getConnection(f.ReadTheDataFromThePropertyFile("Dburl"), f.ReadTheDataFromThePropertyFile("dbusername"), f.ReadTheDataFromThePropertyFile("dbpassword"));
		
	}
	
		public ResultSet executeQuery(String query) throws SQLException	
		{
			
			//create statement
		Statement state = conn.createStatement();
		
		//execute
		result=state.executeQuery(query);
		return result;
		}	
		public int updateQuery(String query) throws SQLException	
		{
			
			//create statement
		Statement state = conn.createStatement();
		
		//execute
		 int res = state.executeUpdate(query);
		return res;
		}	
		
		
		public void disconnectionDB() throws SQLException
		{
			
		//close db
		conn.close();
	   }
		
		public boolean  ExecuteQueryVerfyAndGetData(String query,int columnIndex, String expectedData ) throws SQLException
		{
			boolean flag=false;
			
			result=conn.createStatement().executeQuery(query);
			while(result.next())
			{
				if (result.getString(columnIndex).equals(expectedData))
				{
					flag=true;
					break;
				}
			}
			if (flag)
			{
				System.out.println(expectedData +"===>data verified in the database table");
				return true;
			}
			else
			{
				System.out.println(expectedData +"====>data not verified in the database table");
			}
			return false;
			
		}
}
