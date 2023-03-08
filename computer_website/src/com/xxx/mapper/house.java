package com.xxx.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class house extends BaseDao {
    public final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public final static String URL = "jdbc:mysql://localhost:3306/testcomputer";
    public final static String DBName = "root";
    public final static String DBPass = "609250914";

    public static String findname(String controller_id) {
        String name = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String sql = "select controller_name from controller where  controller_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, controller_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            UserDao.closeAll(conn, ps, rs);
        }
        return name;
    }

    public static String findhouse_computer() {
        String out_html = "<table>\n" +
                "        <tr>\n" +
                "            <th>电脑id</th>\n" +
                "            <th>电脑名称</th>\n" +
                "            <th>电脑价格</th>\n" +
                "            <th>操作</th>\n"+
                "        </tr>";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String sql = "select Computer_id,computer_name,Computer_price from computer ";
        /*
                "where orders.computer_id=computer.computer_id and " +
                "orders.component_id=component.component_id and " +
                "orders.customer_id=customer.customer_id and order_finished=1 and order_controller=?";*/
        String get_data;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                out_html += "<tr>";
                get_data = rs.getString(1);
                out_html += ("<td>" + get_data + "</td>");
                out_html += ("<td>" + rs.getString(2) + "</td>");
                get_data = rs.getString(3);
                out_html += ("<td>" + get_data + "</td>");
                out_html += ("<td>" + "<a onclick=\" window.open('bianji_computer.jsp', 'newwindow', 'height=400, width=400, top=500, left=500, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no');\n" +
                        "\" href=\"javascript:void(0);\">编辑</a>"+ "</td>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            UserDao.closeAll(conn, ps, rs);
        }
        out_html += "</table>";
        return out_html;
    }

    public static String findhousecomponent() {
        String out_html = "<table>\n" +
                "        <tr>\n" +
                "            <th>零件id</th>\n" +
                "            <th>零件名称</th>\n" +
                "            <th>零件价格</th>\n" +
                "            <th>零件类型</th>\n" +
                "        </tr>";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String sql = "select  component_id, component_name, component_price, component_type from component ";
        /*
                "where orders.computer_id=computer.computer_id and " +
                "orders.component_id=component.component_id and " +
                "orders.customer_id=customer.customer_id and order_finished=1 and order_controller=?";*/
        String get_data;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                out_html += "<tr>";
                get_data = rs.getString(1);
                out_html += ("<td>" + get_data + "</td>");
                out_html += ("<td>" + rs.getString(2) + "</td>");
                get_data = rs.getString(3);
                out_html += ("<td>" + get_data + "</td>");
                out_html += ("<td>" + rs.getString(4) + "</td>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            UserDao.closeAll(conn, ps, rs);
        }
        out_html += "</table>";
        return out_html;
    }
    public static String findblueprint() {
        String out_html = "<table>\n" +
                "        <tr>\n" +
                "            <th>电脑id</th>\n" +
                "            <th>电脑名称</th>\n" +
                "            <th>零件id</th>\n" +
                "            <th>零件名称</th>\n" +
                "            <th>零件数量</th>\n" +
                "        </tr>";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = UserDao.getConn();
        String sql = "select  blueprint.computer_id, computer_name,blueprint.component_id, component_name, blueprint.component_number  from computer,component,blueprint where blueprint.computer_id=computer.computer_id and blueprint.component_id=component.component_id";
        /*
                "where orders.computer_id=computer.computer_id and " +
                "orders.component_id=component.component_id and " +
                "orders.customer_id=customer.customer_id and order_finished=1 and order_controller=?";*/
        String get_data;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                out_html += "<tr>";
                get_data = rs.getString(1);
                out_html += ("<td>" + get_data + "</td>");
                out_html += ("<td>" + rs.getString(2) + "</td>");
                get_data = rs.getString(3);
                out_html += ("<td>" + get_data + "</td>");
                out_html += ("<td>" + rs.getString(4) + "</td>");
                out_html += ("<td>" + rs.getString(5) + "</td>");
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
        System.out.println(findblueprint());
    }
}
