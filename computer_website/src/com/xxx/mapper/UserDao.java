package com.xxx.mapper;

import com.xxx.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserDao extends BaseDao {

	//��д��ѯ��������ѯ���е�����Ϣ���ռ۸��������� �������ز�ѯ���
	public List displayUser()
	{
		List list=new ArrayList();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		conn= UserDao.getConn();
		String sql="select * from customer where Customer_name = #{Customer_name}";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				User user=new User();
				user.setCustomer_name(rs.getString("book_author"));
				user.setCustomer_pwd(rs.getString("book_name"));
//				user.setBook_price(rs.getDouble("book_price"));
//				user.setBook_publish(rs.getString("book_publish"));
//				user.setBook_type(rs.getString("book_type"));
				list.add(user);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			UserDao.closeAll(conn, ps, rs);
		}
		return list;
		
	}
   // 用户注册信息插入数据库
	public int insertUser(String Customer_id,String Customer_name,String Customer_pwd,String Customer_type,String Customer_tele,String Customer_address)
	{

		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		conn= UserDao.getConn();
		String sql="insert into customer(Customer_id,Customer_name,Customer_pwd,Customer_type,Customer_tele,Customer_address) values(?,?,?,?,?,?)";
		int x=0;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, Customer_id);
			ps.setString(2,Customer_name);
			ps.setString(3, Customer_pwd);
			ps.setString(4, Customer_type);
			ps.setString(5, Customer_tele);
			ps.setString(6, Customer_address);
			x=ps.executeUpdate();
			return x;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			UserDao.closeAll(conn, ps, rs);
		}
		return x;
	}

	public static int check_pwd(String input_id,String input_key){
		Connection conn =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		conn=UserDao.getConn();
		String sql="select Customer_pwd from customer where customer_id =?";
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1,input_id);
			rs=ps.executeQuery();
			String check_key=null;
			while(rs.next()){
				check_key= rs.getString(1);
			}
			if(check_key == null){
				return -1;
			}
			if(check_key.equals(input_key)){
				return -1;
			}else{
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			UserDao.closeAll(conn,ps,rs);
		}
		return 0;
	}


	//测试数据库是否连接成功
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			UserDao bd=new UserDao();
		//----------------����һ���鱾��Ϣ---------------------------

		Scanner in=new Scanner(System.in);
		System.out.println("请输入用户名和密码：");
		String Customer_id = in.next();
		String Customer_name=in.next();
		String Customer_pwd=in.next();
		String Customer_type=in.next();
		String Customer_tele=in.next();
		String Customer_address=in.next();

		int x=bd.insertUser(Customer_id,Customer_name,Customer_pwd,Customer_type,Customer_tele,Customer_address);
		if(x==0)
			System.out.println("插入失败");
		else
			System.out.println("插入成功 ");


		}


	public int updateUser(String nupwd) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		conn= UserDao.getConn();
		String sql="update customer set Customer_pwd=? where Customer_name=?";
		int x=0;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, nupwd);
			x=ps.executeUpdate();
			return x;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			UserDao.closeAll(conn, ps, rs);
		}
		return x;
	}
}
