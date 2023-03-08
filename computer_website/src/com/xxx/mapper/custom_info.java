package com.xxx.mapper;
import com.xxx.mapper.BaseDao;
import com.xxx.mapper.UserDao;

import java.util.*;
import  java.lang.String;
import java.sql.*;

public class custom_info extends BaseDao {
    public final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public final static String URL = "jdbc:mysql://localhost:3306/testcomputer";
    public final static String DBName = "root";
    public final static String DBPass = "609250914";

    //把数据装进字符串里给前端
    public static String get_all_com_image(int page){
        int i=0;
        String need_info="";
        String compu_id;
        int item_num=get_com_num();
        page-=1;
        //这里因为数据量太少了，所以把每一页的切换变成4，应该是12
        for (i=page*4;i<page*4+12&&i<item_num;i++)
        {
            //因为有侧边栏所以最左边的图片要自带一个左空白块
            if (i%4==0)
            {
                need_info+="<div class=\"column side\">";
            }
            else
            {
                need_info+="<div class=\"column middle\">";
            }
            //设置该电脑的图片，超链接和其名称价格
            compu_id=get_com_id(i);
            need_info+=("<div class=\"img\"><a target=\"_blank\" href=\"computer_info.jsp?"+compu_id+"\"><img src="+get_detail_image(compu_id)+"alt=\""+get_detail_name(compu_id)+"\" width=\"300\" height=\"200\"></a><div class=\"desc\">"+get_detail_name(compu_id)+"  $"+get_detail_price(compu_id)+"</div></div></div>");
        }
        return need_info;
    }

    //封装的测试，没用到
    public Map<String, Object> test_return(int x){
        String[] a ={"1","2","3"};
        Map<String, Object> result = new HashMap<>();
        result.put("data", a);
        return result;
    }

    //根据sql的语句和目标id获取信息
    private static String get_id_info(String sql, String id){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn= UserDao.getConn();
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

    //获取用户名称
    public static String get_customer_name(String customer_id){
        return get_id_info("select customer_name from customer where customer_id=?",customer_id);
    }

    //获取电脑数量
    public static int get_com_num(){
        int i=0;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        String sql="select count(computer_id) from computer where computer_image_path<>'empty'";
        int need_num=0;
        try
        {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                need_num= Integer.parseInt(rs.getString(1));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            UserDao.closeAll(conn, ps, rs);
        }
        return need_num;
    }

    //根据次序（默认的次序，后面考虑做排序以后改）来导出电脑的id
    public static String get_com_id(int num){
        int i=0;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        String sql="select computer_id from computer where computer_image_path<>'empty'";
        String need_name=null;
        try
        {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()&&i<=num) {
                need_name=rs.getString(1);
                i++;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            UserDao.closeAll(conn, ps, rs);
        }
        return need_name;
    }

    //根据电脑id获取电脑图片地址
    public static String get_detail_image(String comid){
        return get_id_info("select computer_image_path from computer where computer_id=?",comid);
    }

    //根据电脑id获取电脑名称
    public static String get_detail_name(String comid){
        return get_id_info("select computer_name from computer where computer_id=?",comid);
    }

    //根据电脑id获取电脑价格
    public static String get_detail_price(String comid){
        return get_id_info("select computer_price from computer where computer_id=?",comid);
    }

    //根据电脑id获取其使用的零件有几种
    public static int get_component_num(String comid){
        return Integer.parseInt(get_id_info("select count(component_id) from blueprint where computer_id=?",comid));
    }

    //根据电脑id获取其具体零件信息
    public static String get_com_detail_component(String compu_id){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        String sql_result="select component_name,component_type from component where component_id in (select component_id from blueprint where computer_id=?)";
        int component_num=get_component_num(compu_id);
        String[] need_componame = new String[component_num];
        String[] need_compotype = new String[component_num];
        int i=0;
        try
        {
            ps=conn.prepareStatement(sql_result);
            ps.setString(1,compu_id);
            rs=ps.executeQuery();
            while(rs.next()) {
                need_componame[i] = rs.getString(1);
                need_compotype[i] = rs.getString(2);
                i++;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            UserDao.closeAll(conn, ps, rs);
        }

        String return_data="";
        return_data+="<table><tr>";
        for (i=0;i<component_num;i++)
        {
            return_data+="<th>"+need_compotype[i]+"</th>";
        }
        return_data+="</tr><tr>";
        for (i=0;i<component_num;i++)
        {
            return_data+="<th>"+need_componame[i]+"</th>";
        }
        return_data+="</tr></table>";
        return return_data;
    }

    //统计订单数量（用于给订单id命名）
    public static int get_orders_num() {
        int orders_num=0;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        String sql_cont="select count(orders_id) from orders";
        try
        {
            ps=conn.prepareStatement(sql_cont);
            rs=ps.executeQuery();
            while(rs.next()) {
                orders_num= Integer.parseInt(rs.getString(1));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            UserDao.closeAll(conn, ps, rs);
        }
        return orders_num;
    }

    //创建电脑订单
    public static int create_order(String customer_id,String computer_id,String computer_number){
        int recent_order=get_orders_num()+1;
        String order_id="";
        if (recent_order<10){
            order_id="00"+recent_order;
        }
        else if (recent_order<100){
            order_id="0"+recent_order;
        }
        else{
            order_id= String.valueOf(recent_order);
        }
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        String sql="insert into orders(orders_id,computer_id,computer_number,customer_id)values(?,?,?,?)";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,order_id);
            ps.setString(2,computer_id);
            ps.setString(3,computer_number);
            ps.setString(4,customer_id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            UserDao.closeAll(conn, ps, rs);
        }
        return 0;
    }

    //获取用户的订单
    public static String get_customer_orders(String customer_id){
        String out_html="<table>\n" +
                "        <tr>\n" +
                "            <th>订单类型</th>\n" +
                "            <th>电脑(零件)名称</th>\n" +
                "            <th>电脑(零件)数量</th>\n" +
                "            <th>状态</th>\n" +
                "            <th>详情</th>\n" +
                "            <th>操作</th>\n" +
                "        </tr>";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        String sql="select computer_name,computer_number,component_name,component_number,order_controller,order_sent,customer_confirm,orders.computer_id,orders.component_id,orders.orders_id from orders,component,computer where orders.computer_id=computer.computer_id and orders.component_id=component.component_id and orders.customer_id=?";
        String get_data;
        try
        {
            ps=conn.prepareStatement(sql);
            ps.setString(1,customer_id);
            rs=ps.executeQuery();
            while(rs.next()) {
                out_html+="<tr>";
                get_data= rs.getString(1);
                if (!Objects.equals(get_data, "empty")){
                    out_html+=("<td>电脑</td>");
                    out_html+=("<td>"+get_data+"</td>");
                    out_html+=("<td>"+rs.getString(2)+"</td>");
                }
                else{
                    out_html+=("<td>零件</td>");
                    out_html+=("<td>"+rs.getString(3)+"</td>");
                    out_html+=("<td>"+rs.getString(4)+"</td>");
                }
                if (Objects.equals(rs.getString(5), null)){
                    out_html+=("<td>待接取</td>");
                    out_html+=("<td><a href=\"customer_order_delete.jsp?"+rs.getString(10)+"\">取消订单</a></td>");
                }
                else if(Objects.equals(rs.getString(6), "0")){
                    out_html+=("<td>已接取</td>");
                    out_html+=("<td><a href=\"customer_order_delete.jsp?"+rs.getString(10)+"\">取消订单</a></td>");
                }
                else if(Objects.equals(rs.getString(7), "0")){
                    out_html+=("<td>已发货</td>");
                    out_html+=("<td><a href=\"customer_confirm.jsp?"+rs.getString(10)+"\">确认收货</a></td>");
                }
                else{
                    out_html+=("<td>已收货</td>");
                    out_html+=("<td><a href=\"customer_order_delete.jsp?"+rs.getString(10)+"\">取消订单</a></td>");
                }
                if (!Objects.equals(get_data, "empty")){
                    out_html+=("<td><a href=\"computer_info.jsp?"+rs.getString(8)+"\">订单详情</a></td>");
                }
                else{
                    out_html+=("<td><a href=\"#\">订单详情</a></td>");
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

    public static void set_not_wanted_order(String order_id){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        int x=0;
        String sql="update orders set computer_number=0 and component_number=0 and customer_confirm=1 where orders_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, order_id);
            x=ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            UserDao.closeAll(conn, ps, rs);
        }
    }

    public static String get_component_brief(String component_name){
        return get_id_info("select component_brief from component where component_name=?",component_name);
    }

    public static int customer_accept(String order_id){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        int x=0;
        String sql="update orders set customer_confirm=1 where orders_id=?";
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

    public static void main(String[] args) {
        System.out.println (get_customer_orders("123"));
    }

}
