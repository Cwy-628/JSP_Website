package com.xxx.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class customer_account extends BaseDao {
    public final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public final static String URL = "jdbc:mysql://localhost:3306/testcomputer";
    public final static String DBName = "root";
    public final static String DBPass = "609250914";


    public static String findaccount_customerid() {
        String out_html = "";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String sql = "select Customer_id from customer ";

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

    public static String findaccount_customername() {
        String out_html = "";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String sql = "select Customer_name from customer ";

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

    public static int setcname(String id, String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String n=name;
        String sql = "update customer set  Customer_name=? where Customer_id=?";
        int x = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, id);
            x = ps.executeUpdate();
            return x;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            UserDao.closeAll(conn, ps, rs);
        }
        return x;
    }

    public static int setpwd(String id, String  p) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String sql = "update customer set  Customer_pwd=? where Customer_id=?";
        int x = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(2, id);
            ps.setString(1, p);

            x = ps.executeUpdate();
            return x;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            UserDao.closeAll(conn, ps, rs);
        }
        return x;
    }

}