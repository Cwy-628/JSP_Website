package com.xxx.mapper;
import java.io.IOException;
import java.util.*;
import  java.lang.String;
import java.sql.*;


public class computer extends BaseDao {
    public final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public final static String URL = "jdbc:mysql://localhost:3306/testcomputer";
    public final static String DBName = "root";
    public final static String DBPass = "609250914";

    private static String get_component_info(String sql, String type) {
        String out_html = "";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, type);
            rs = ps.executeQuery();
            while (rs.next()) {
                out_html += "<option>" + rs.getString(1) + "</option>";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            UserDao.closeAll(conn, ps, rs);
        }
        return out_html;
    }


    public static String findhouse_computerid() {
        String out_html = "";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String sql = "select Computer_id from computer ";
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
    public static String findhouse_computerid1() {
        String out_html = "";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String sql = "select Computer_id from blueprint ";
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
    public static String findhouse_computername() {
        String out_html = "";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String sql = "select Computer_name from computer ";

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

        public static String findhouse_componentid() {
            String out_html = "";
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            conn = UserDao.getConn();
            String sql = "select component_id from component ";
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
    public static String findhouse_componentid1() {
        String out_html = "";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String sql = "select component_id from blueprint ";
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
    public static String findhouse_id() {
        String out_html = "";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn =UserDao.getConn();
        String sql = "select storehouse_id from storehouse ";
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
    public static String findcomhouse_id() {
        String out_html = "";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String sql = "select computer_id from computerhouse ";
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
    public static String findcomponenthouse_id() {
        String out_html = "";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String sql = "select component_id from componenthouse ";
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
    public static int setsname(String id, String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String n=name;
        String sql = "update computer set  Computer_name=? where Computer_id=?";
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
    public static void setcomid(String id,String i) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String sql = "update blueprint set  Computer_id=? where component_id=?";
        int x = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, i);
            x = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            UserDao.closeAll(conn, ps, rs);
        }
    }
    public static void setcomponentid(String id,String i) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String sql = "update blueprint set  component_id=? where Computer_id=?";
        int x = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, i);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            UserDao.closeAll(conn, ps, rs);
        }

    }
    public static int setprice(String id, double  p) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String sql = "update computer set  Computer_price=? where Computer_id=?";
        int x = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setDouble(1, p);
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
    public static int setprice2(String id, double  p) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String sql = "update component set  component_price=? where component_id=?";
        int x = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setDouble(1, p);
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
    public static void deleteblueprint1(String id,String cid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int x=0;
        conn = UserDao.getConn();
        String sql = "delete from blueprint where Computer_id=? and component_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, cid);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            UserDao.closeAll(conn, ps, rs);
        }
    }
    public static void deleteblueprint2(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int x=0;
        conn = UserDao.getConn();
        String sql = "delete from blueprint where Computer_id=?";
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

    public static void deleteblueprint3(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int x=0;
        conn = UserDao.getConn();
        String sql = "delete from blueprint where component_id=?";
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





    public static void deletehouse1(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int x=0;
        conn = UserDao.getConn();
        String sql = "delete from computerhouse where Computer_id=?";
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
    public static void deletehouse2(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int x=0;
        conn = UserDao.getConn();
        String sql = "delete from componenthouse where component_id=?";
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
    public static void deletecom2(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int x=0;
        conn = UserDao.getConn();
        String sql = "delete from computer where Computer_id=?";
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
    public static void deletecomponent(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int x=0;
        conn = UserDao.getConn();
        String sql = "delete from component where component_id=?";
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
    public static void insertcom (String id,String name ,double  p) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String sql = "insert into computer( Computer_id,Computer_name,Computer_price) values (?,?,?) ";
        int x = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setDouble(3,p );
            x = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            UserDao.closeAll(conn, ps, rs);
        }
    }
    public static void insertcomponent(String id,String name ,String type,double p) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String sql = "insert into component( component_id,component_name,component_type,component_price) values (?,?,?,?)";
        int x = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3,type );
            ps.setDouble(4, p);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            UserDao.closeAll(conn, ps, rs);
        }
    }
    public static void insertblueprint(String comid,String componentid ,int num) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String sql = "insert into blueprint( Computer_id,component_id,component_number) values (?,?,?)";
        int x = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, comid);
            ps.setString(2, componentid);
            ps.setInt(3,num);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            UserDao.closeAll(conn, ps, rs);
        }
    }
    public static void inserthousecom(String houseid,String comid ,int num) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String sql = "insert into computerhouse( storehouse_id,Computer_id,computer_number) values (?,?,?)";
        int x = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, houseid);
            ps.setString(2, comid);
            ps.setInt(3,num);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            UserDao.closeAll(conn, ps, rs);
        }
    }
    public static void inserthousecomponent(String houseid,String componentid ,int num) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String sql = "insert into componenthouse( storehouse_id,component_id,component_number) values (?,?,?)";
        int x = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, houseid);
            ps.setString(2, componentid);
            ps.setInt(3,num);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            UserDao.closeAll(conn, ps, rs);
        }
    }
    public static void main(String[] args) {

        inserthousecomponent("001","022",2000);
    }
}