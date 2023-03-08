package com.xxx.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class account_cancel extends BaseDao{
    public final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public final static String URL = "jdbc:mysql://localhost:3306/testcomputer";
    public final static String DBName = "root";
    public final static String DBPass = "609250914";



    public static String get_enabled_orders()
    {
        String out_html="";
        String sql = "";
        sql="select * from customer";
        out_html+="<table>\n" +
                "        <tr>\n" +
                "            <th>编号</th>\n" +
                "            <th>用户名</th>\n" +
                "            <th>用户类别</th>\n" +
                "            <th>电话</th>\n" +
                "            <th>地址</th>\n" +
                "            <th>密码</th>\n" +
                "            <th>操作</th>\n" +
                "        </tr>";

        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        try
        {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                out_html+="<tr>";
                out_html += ("<td>" + rs.getString(1) + "</td>");
                out_html += ("<td>" + rs.getString(2) + "</td>");
                out_html += ("<td>" + rs.getString(3) + "</td>");
                out_html += ("<td>" + rs.getString(4) + "</td>");
                out_html += ("<td>" + rs.getString(5) + "</td>");
                out_html += ("<td>" + rs.getString(6) + "</td>");
                out_html += ("<td>" + "<a href='deleteuser.jsp'>删除</a> "+ "</td>");

                out_html+="</tr>";
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            UserDao.closeAll(conn, ps, rs);
        }
        out_html+="</table>";
        return out_html;
    }

    public static void delete_user(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int x=0;
        conn = UserDao.getConn();
        String sql = "delete from customer where customer_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            UserDao.closeAll(conn, ps, rs);
        }
    }

    public static String finduser_info() {
        String out_html = "";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String sql = "select Customer_id from customer ";
        /*
                "where orders.computer_id=computer.computer_id and " +
                "orders.component_id=component.component_id and " +
                "orders.customer_id=customer.customer_id and order_finished=1 and order_controller=?";*/
        String get_data;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                out_html += "<option>" + rs.getString(1) + "</option>";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            UserDao.closeAll(conn, ps, rs);
        }
        out_html += "</table>";
        return out_html;
    }
    public static void main(String[] args) {
        System.out.println(get_enabled_orders());
    }
}
