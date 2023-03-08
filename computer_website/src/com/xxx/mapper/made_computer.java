package com.xxx.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class made_computer extends BaseDao {
    public final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public final static String URL = "jdbc:mysql://localhost:3306/testcomputer";
    public final static String DBName = "root";
    public final static String DBPass = "609250914";

    private static String get_component_info(String sql, String type){
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

    private static String get_name_info(String sql, String id){
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
        if (need_info==null){
            return "0";
        }
        return need_info;
    }

    private static String get_sql_info(String sql){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        String need_info=null;
        try
        {
            ps=conn.prepareStatement(sql);
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

    public static int get_component_price(String component_name){
        if (component_name==null){
            return 0;
        }
        return Integer.parseInt(get_name_info("select component_price from component where component_name=?",component_name));
    }

    public static String get_mainbord_component(){
        return get_component_info("select component_name from component where component_type=?","main_board");
    }

    public static String get_screen_component(){
        return get_component_info("select component_name from component where component_type=?","screen");
    }

    public static String get_cpu_component(){
        return get_component_info("select component_name from component where component_type=?","cpu");
    }

    public static String get_memory_component(){
        return get_component_info("select component_name from component where component_type=?","memory");
    }

    public static String get_gpu_component(){
        return get_component_info("select component_name from component where component_type=?","gpu");
    }

    public static String create_custom_made_computer(String computer_name,String computer_price){
        int having_created= Integer.parseInt(get_sql_info("select count(computer_id) from computer where computer_image_path='empty'"));
        String computer_id="custom_made";
        if (having_created<10){
            computer_id+="00"+having_created;
        }
        else if (having_created<100) {
            computer_id+="0"+having_created;
        }
        else{
            computer_id+=String.valueOf(having_created);
        }
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        String sql="insert into computer(computer_id,computer_name,computer_price,computer_image_path)values(?,?,?,'empty')";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,computer_id);
            ps.setString(2,computer_name);
            ps.setString(3,computer_price);
            ps.executeUpdate();
            return computer_id;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            UserDao.closeAll(conn, ps, rs);
        }
        return "";
    }

    public static String get_auto_mainboard(){
        return get_sql_info("select component_name from component where component_type='main_board'");
    }

    public static String get_auto_gpu(){
        return get_sql_info("select component_name from component where component_type='gpu'");
    }

    public static String get_auto_memory(){
        return get_sql_info("select component_name from component where component_type='memory'");
    }

    public static String get_auto_screen(){
        return get_sql_info("select component_name from component where component_type='screen'");
    }

    private static String get_component_id(String component_name){
        return get_name_info("select component_id from component where component_name=?",component_name);
    }

    public static void create_custom_made_blueprint(String computer_id,String component_name){
        String component_id=get_component_id(component_name);
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        String sql="insert into blueprint(computer_id,component_id,component_number)values(?,?,1)";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,computer_id);
            ps.setString(2,component_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            UserDao.closeAll(conn, ps, rs);
        }
    }

}
