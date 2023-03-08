package com.xxx.mapper;

import java.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao {
	
	/*public final static String DRIVER="org.apache.derby.jdbc.ClientDriver";
    public final static String URL="jdbc:derby://localhost:1527/myeclipse";
    public final static String DBName="APP";
    public final static String DBPass="APP";*/
    
	//���ӻ�����mysql
	public final static String DRIVER="com.mysql.cj.jdbc.Driver";
	public final static String URL="jdbc:mysql://localhost:3306/testcomputer";
	public final static String DBName="root";
	public final static String DBPass="609250914";
    
    public static Connection getConn() 
	{
		Connection conn=null;
		try {
			Class.forName(DRIVER);
			try {
				conn=(Connection) DriverManager.getConnection(URL,DBName,DBPass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void closeAll(Connection conn,PreparedStatement ps,ResultSet rs)
	{
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		if(ps!=null)
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseDao bd=new BaseDao();
		Connection cn=bd.getConn();
		if(cn!=null)
		{System.out.println("success");}

	}
	
}
