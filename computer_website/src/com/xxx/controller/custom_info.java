package com.xxx.controller;

import com.xxx.mapper.BaseDao;
import com.xxx.mapper.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class custom_info extends BaseDao {
    public final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public final static String URL = "jdbc:mysql://localhost:3306/mcomputer";
    public final static String DBName = "root";
    public final static String DBPass = "Ccl.2602";

    //把数据装进字符串里给前端
    public static String get_all_com_image(int page){
        int i=0;
        String need_info="";
        //这里因为数据量太少了，所以把每一页的切换变成4，应该是12
        for (i=page*4;i<page*4+12;i++)
        {
            if (i%4==0)
            {
                need_info+="<div class=\"column side\">";
            }
            else
            {
                need_info+="<div class=\"column middle\">";
            }
            need_info+=("<div class=\"img\"><a target=\"_blank\" href=\"/upload/compu1.jpg\"><img src="+get_com_image(i)+"alt=\""+get_com_name(i)+"\" width=\"300\" height=\"200\"></a><div class=\"desc\">"+get_com_name(i)+"</div></div></div>");
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

    //获取电脑名字
    public static String get_com_name(int num){
        int i=0;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn= UserDao.getConn();
        String sql="select computer_name from computer";
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

    //获取电脑图片地址
    //因为我没加边界判断，所以超界的会返回最后一台电脑的数据
    public static String get_com_image(int num){
        int i=0;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        String sql="select computer_image_path from computer";
        String need_path=null;
        try
        {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()&&i<=num) {
                need_path=rs.getString(1);
                i++;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            UserDao.closeAll(conn, ps, rs);
        }
        return need_path;
    }
    public static void main(String[] args) {
        int i;
        for (i = 0; i < 5; i++) {
            System.out.println (get_all_com_image(0));
        }
    }

}
