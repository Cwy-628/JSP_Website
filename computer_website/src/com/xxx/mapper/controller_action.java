package com.xxx.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class controller_action extends BaseDao{
    public final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public final static String URL = "jdbc:mysql://localhost:3306/testcomputer";
    public final static String DBName = "root";
    public final static String DBPass = "609250914";

    private static String get_list_info(String sql, String type){
        String out_html="";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        try
        {
            ps=conn.prepareStatement(sql);
            ps.setString(1,type);
            rs=ps.executeQuery();
            while(rs.next()) {
                out_html+="<option>"+rs.getString(1)+"</option>";
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            UserDao.closeAll(conn, ps, rs);
        }
        return out_html;
    }

    private static String get_info(String sql){
        String out_html="";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        try
        {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                out_html+="<option>"+rs.getString(1)+"</option>";
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            UserDao.closeAll(conn, ps, rs);
        }
        return out_html;
    }

    private static int delete_storage(String sql,String storehouse_id,String component_id){
        int x=0;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        try
        {
            ps=conn.prepareStatement(sql);
            ps.setString(1,storehouse_id);
            ps.setString(2,component_id);
            x=ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            UserDao.closeAll(conn, ps, rs);
        }
        return x;
    }

    private static int update_storehouse(String sql,String storehouse_id,String component_id,int component_number){
        int x=0;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        try
        {
            ps=conn.prepareStatement(sql);
            ps.setString(1, String.valueOf(component_number));
            ps.setString(2,storehouse_id);
            ps.setString(3,component_id);
            x=ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            UserDao.closeAll(conn, ps, rs);
        }
        return x;
    }

    private static String get_id_info(String sql, String id){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        String need_info=null;
        try
        {
            ps=conn.prepareStatement(sql);
            ps.setString(1,id);
            rs=ps.executeQuery();
            while(rs.next()) {
                need_info=rs.getString(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            UserDao.closeAll(conn, ps, rs);
        }
        return need_info;
    }

    public static String get_controller_name(String controller_id){
        return get_id_info("select controller_name from controller where controller_id=?",controller_id);
    }

    //仓库管理
    public static String get_house_computer(String controller_id,String house_id){
        String out_html="";
        String sql="select computer_name,computer_number,computer.computer_id from storehouse,computerhouse,computer where computer.computer_id=computerhouse.computer_id and computerhouse.storehouse_id=storehouse.storehouse_id and controller_id=? and storehouse.storehouse_id=?";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        out_html+="<table class=\"mid\">\n" +
                "        <tr>\n" +
                "            <th>电脑名称</th>\n" +
                "            <th>电脑数量</th>\n" +
                "            <th>编辑</th>\n" +
                "        </tr>";
        try
        {
            ps=conn.prepareStatement(sql);
            ps.setString(1,controller_id);
            ps.setString(2,house_id);
            rs=ps.executeQuery();
            while(rs.next()) {
                out_html+="<tr>";
                out_html += ("<td>" + rs.getString(1) + "</td>");
                out_html += ("<td>" + rs.getString(2) + "</td>");
                out_html += ("<td><a href=\"alter_computer.jsp?" + rs.getString(3) + "\">编辑</a></td>");
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

    public static String get_house_component(String controller_id,String house_id){
        String out_html="";
        String sql="select component_type,component_name,component_number,component.component_id from storehouse,componenthouse,component where component.component_id=componenthouse.component_id and componenthouse.storehouse_id=storehouse.storehouse_id and controller_id=? and storehouse.storehouse_id=?";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        out_html+="<table class=\"side\">\n" +
                "        <tr>\n" +
                "            <th>零件类型</th>\n" +
                "            <th>零件名称</th>\n" +
                "            <th>零件数量</th>\n" +
                "            <th>编辑</th>\n" +
                "        </tr>";
        try
        {
            ps=conn.prepareStatement(sql);
            ps.setString(1,controller_id);
            ps.setString(2,house_id);
            rs=ps.executeQuery();
            while(rs.next()) {
                out_html+="<tr>";
                out_html += ("<td>" + rs.getString(1) + "</td>");
                out_html += ("<td>" + rs.getString(2) + "</td>");
                out_html += ("<td>" + rs.getString(3) + "</td>");
                out_html += ("<td><a href=\"alter_component.jsp?" + rs.getString(4) + "\">编辑</a></td>");
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

    public static String get_controlled_house(String controller_id) {
        return get_list_info("select storehouse_name from storehouse where controller_id=?",controller_id);
    }

    public static String get_computer_name(){
        return get_info("select computer_name from computer");
    }

    public static String get_component_name(){
        return get_info("select component_name from component");
    }

    public static int alter_computer_storage(String house_id,String computer_id,String number){
        return update_storehouse("update computerhouse set computer_number=computer_number+? where storehouse_id=? and computer_id=?",house_id,computer_id, Integer.parseInt(number));
    }

    public static int alter_component_storage(String house_id,String component_id,String number){
        return update_storehouse("update componenthouse set component_number=component_number+? where storehouse_id=? and component_id=?",house_id,component_id, Integer.parseInt(number));
    }

    public static int delete_computer_storeage(String house_id,String computer_id){
        return delete_storage("delete * from computerhouse where storehouse_id=? and computer_id=?",house_id,computer_id);
    }

    public static int delete_component_storeage(String house_id,String component_id){
        return delete_storage("delete * from componenthouse where storehouse_id=? and component_id=?",house_id,component_id);
    }


    //查看所有未接取的订单
    public static String get_enabled_orders(int select_mod)
    {
        String out_html="";
        String sql = "";
        switch(select_mod)
        {
            case(0):
                sql="select computer.computer_name,orders.computer_number,component.component_name,orders.component_number,customer.Customer_name,customer.Customer_address,orders_id from orders,component,computer,customer where orders.computer_id=computer.computer_id and orders.component_id=component.component_id and orders.customer_id=customer.customer_id and order_sent=0 and order_controller is null";
                out_html+="<table>\n" +
                        "        <tr>\n" +
                        "            <th>订单类型</th>\n" +
                        "            <th>电脑(零件)名称</th>\n" +
                        "            <th>电脑(零件)数量</th>\n" +
                        "            <th>客户名</th>\n" +
                        "            <th>地址</th>\n" +
                        "            <th>操作</th>\n" +
                        "        </tr>";
                break;
            case(1):
                sql="select computer.computer_name,orders.computer_number,customer.customer_name,customer.Customer_address,orders_id from orders,component,computer,customer where orders.computer_id=computer.computer_id and orders.component_id=component.component_id and orders.customer_id=customer.customer_id and order_sent=0 and order_controller is null and computer_number!=0";
                out_html+="<table>\n" +
                        "        <tr>\n" +
                        "            <th>电脑名称</th>\n" +
                        "            <th>电脑数量</th>\n" +
                        "            <th>客户名</th>\n" +
                        "            <th>地址</th>\n" +
                        "            <th>操作</th>\n" +
                        "        </tr>";
                break;
            case(2):
                sql="select component.component_name,orders.component_number,customer.customer_name,customer.Customer_address,orders_id from orders,component,computer,customer where orders.computer_id=computer.computer_id and orders.component_id=component.component_id and orders.customer_id=customer.customer_id and order_sent=0 and order_controller is null and component_number!=0";
                out_html+="<table>\n" +
                        "        <tr>\n" +
                        "            <th>零件名称</th>\n" +
                        "            <th>零件数量</th>\n" +
                        "            <th>客户名</th>\n" +
                        "            <th>地址</th>\n" +
                        "            <th>操作</th>\n" +
                        "        </tr>";
                break;
        }
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
                switch(select_mod) {
                    case(0):
                        if(Integer.parseInt(rs.getString(4))==0){
                            out_html += ("<td>电脑</td>");
                            out_html += ("<td>" + rs.getString(1) + "</td>");
                            out_html += ("<td>" + rs.getString(2) + "</td>");
                        }
                        else{
                            out_html += ("<td>零件</td>");
                            out_html += ("<td>" + rs.getString(3) + "</td>");
                            out_html += ("<td>" + rs.getString(4) + "</td>");
                        }
                        out_html += ("<td>" + rs.getString(5) + "</td>");
                        out_html += ("<td>" + rs.getString(6) + "</td>");
                        out_html += ("<td><a href=\"take_order.jsp?" + rs.getString(7) + "\">接取</a></td>");
                        break;
                    case(1):
                    case(2):
                        out_html += ("<td>" + rs.getString(1) + "</td>");
                        out_html += ("<td>" + rs.getString(2) + "</td>");
                        out_html += ("<td>" + rs.getString(3) + "</td>");
                        out_html += ("<td>" + rs.getString(4) + "</td>");
                        out_html += ("<td><a href=\"take_order.jsp?" + rs.getString(5) + "\">接取</a></td>");
                        break;
                }
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

    //查看所有已经接取未完成的订单
    public static String get_unfinished_orders(String controller_id)
    {
        String out_html="<table>\n" +
                "        <tr>\n" +
                "            <th>电脑名称</th>\n" +
                "            <th>电脑数量</th>\n" +
                "            <th>零件名称</th>\n" +
                "            <th>零件数量</th>\n" +
                "            <th>客户名</th>\n" +
                "            <th>地址</th>\n" +
                "            <th>操作1</th>\n" +
                "            <th>操作2</th>\n" +
                "        </tr>";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        String sql="select computer.computer_name,orders.computer_number,component.component_name,orders.component_number,customer.customer_name,customer.Customer_address,orders_id from orders,component,computer,customer where orders.computer_id=computer.computer_id and orders.component_id=component.component_id and orders.customer_id=customer.customer_id and order_sent=0 and order_controller=?";
        String get_data;
        try
        {
            ps=conn.prepareStatement(sql);
            ps.setString(1,controller_id);
            rs=ps.executeQuery();
            while(rs.next()) {
                out_html+="<tr>";
                get_data= rs.getString(1);
                if (!Objects.equals(get_data, "empty")){
                    out_html+=("<td>"+get_data+"</td>");
                    out_html+=("<td>"+rs.getString(2)+"</td>");
                }
                else{
                    out_html+=("<td>无</td>");
                    out_html+=("<td>无</td>");
                }
                get_data= rs.getString(3);
                if (!Objects.equals(get_data, "empty")){
                    out_html+=("<td>"+get_data+"</td>");
                    out_html+=("<td>"+rs.getString(4)+"</td>");
                }
                else{
                    out_html+=("<td>无</td>");
                    out_html+=("<td>无</td>");
                }
                out_html+=("<td>"+rs.getString(5)+"</td>");
                out_html+=("<td>"+rs.getString(6)+"</td>");
                out_html+=("<td><a href=\"abandon_order.jsp?"+rs.getString(7)+"\">放弃</a></td>");
                out_html+=("<td><a href=\"finish_order.jsp?"+rs.getString(7)+"\">发货</a></td>");
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

    //查看所有已完成的订单
    public static String get_finished_orders(String controller_id)
    {
        String out_html="<table>\n" +
                "        <tr>\n" +
                "            <th>确认收货</th>\n" +
                "            <th>电脑名称</th>\n" +
                "            <th>电脑数量</th>\n" +
                "            <th>零件名称</th>\n" +
                "            <th>零件数量</th>\n" +
                "            <th>客户名</th>\n" +
                "            <th>地址</th>\n" +
                "            <th>操作</th>\n" +
                "        </tr>";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        String sql="select computer.computer_name,orders.computer_number,component.component_name,orders.component_number,customer.customer_name,customer.Customer_address,orders_id,customer_confirm from orders,component,computer,customer where orders.computer_id=computer.computer_id and orders.component_id=component.component_id and orders.customer_id=customer.customer_id and order_sent=1 and order_controller=?";
        String get_data;
        try
        {
            ps=conn.prepareStatement(sql);
            ps.setString(1,controller_id);
            rs=ps.executeQuery();
            while(rs.next()) {
                out_html+="<tr>";
                if (Objects.equals(rs.getString(8), "0")){
                    out_html+=("<td>未确认</td>");
                }
                else{
                    out_html+=("<td>已确认</td>");
                }
                get_data= rs.getString(1);
                if (!Objects.equals(get_data, "empty")){
                    out_html+=("<td>"+get_data+"</td>");
                    out_html+=("<td>"+rs.getString(2)+"</td>");
                }
                else{
                    out_html+=("<td>无</td>");
                    out_html+=("<td>无</td>");
                }
                get_data= rs.getString(3);
                if (!Objects.equals(get_data, "empty")){
                    out_html+=("<td>"+get_data+"</td>");
                    out_html+=("<td>"+rs.getString(4)+"</td>");
                }
                else{
                    out_html+=("<td>无</td>");
                    out_html+=("<td>无</td>");
                }
                out_html+=("<td>"+rs.getString(5)+"</td>");
                out_html+=("<td>"+rs.getString(6)+"</td>");
                out_html+=("<td><a href=\"#"+rs.getString(7)+"\">售后</a></td>");
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

    //完成订单
    public static int finish_order(String order_id)
    {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        int x=0;
        String sql="update orders set order_sent=1 where orders_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, order_id);
            x=ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            UserDao.closeAll(conn, ps, rs);
        }
        return x;
    }

    //放弃订单
    public static int abandon_order(String controller_id,String order_id)
    {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        int x=0;
        String sql="update orders set order_controller=null where order_controller=? and orders_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, controller_id);
            ps.setString(2, order_id);
            x=ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            UserDao.closeAll(conn, ps, rs);
        }
        return x;
    }

    //接取订单
    public static int take_order(String controller_id,String order_id)
    {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        int x=0;
        String sql="update orders set order_controller=? where orders_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, controller_id);
            ps.setString(2, order_id);
            x=ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            UserDao.closeAll(conn, ps, rs);
        }
        return x;
    }



    public static void main(String[] args) {
        System.out.println(get_house_component("A02","001"));
    }
}
