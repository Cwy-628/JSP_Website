package com.xxx.mapper;
import com.xxx.entity.User;

import java.util.*;
import  java.lang.String;
import java.sql.*;

public class computer_workshop extends BaseDao{

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

    private static String get_name_info(String sql, String id){
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

    public static String get_house_id(String storehouse_id){
        return get_name_info("select storehouse_id from storehouse where storehouse_name=?",storehouse_id);
    }

    public static String get_computer_id(String orders_id){
        return get_name_info("select computer_id from orders where orders_id=?",orders_id);
    }

    public static int get_order_computer_number(String orders_id){
        return Integer.parseInt(get_name_info("select computer_number from orders where orders_id=?",orders_id));
    }

    public static String get_house_component(String controller_id,String house_id){
        String out_html="";
        String sql="select component_type,component_name,component_number from storehouse,componenthouse,component where component.component_id=componenthouse.component_id and componenthouse.storehouse_id=storehouse.storehouse_id and controller_id=? and storehouse.storehouse_id=?";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        out_html+="<table class=\"all\">\n" +
                "        <tr>\n" +
                "            <th>零件类型</th>\n" +
                "            <th>零件名称</th>\n" +
                "            <th>零件数量</th>\n" +
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

    private static String fill_options(String sql,String controller_id){
        String out_html="";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        try
        {
            ps=conn.prepareStatement(sql);
            ps.setString(1,controller_id);
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

    public static String get_all_workhouse(String controller_id){
        return fill_options("select storehouse_name from storehouse where controller_id=? and storehouse_id like 'work_%'",controller_id);
    }

    public static String get_all_computer_id(){
        String sql="select computer_id from computer where computer_id<>'fff' and computer_id not like 'custom_made%'";
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

    public static String get_all_custom_made_order(String controller_id){
        return fill_options("select orders_id from orders where order_controller=? and order_sent=0 and component_id='fff'",controller_id);
    }

    public static String[][] get_component_need(String computer_id){
        String sql="select component.component_id,component_number,component_type,component_name from blueprint,component where blueprint.component_id=component.component_id and computer_id=?";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        String[][] need_info = new String[5][4];
        int i=0;
        try
        {
            ps=conn.prepareStatement(sql);
            ps.setString(1,computer_id);
            rs=ps.executeQuery();
            while(rs.next()) {
                need_info[i][0]=rs.getString(1);
                need_info[i][1]=rs.getString(2);
                need_info[i][2]=rs.getString(3);
                need_info[i][3]=rs.getString(4);
                i++;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            UserDao.closeAll(conn, ps, rs);
        }
        return need_info;
    }

    public static String[][] list_component_num(String computer_id,int computer_num,String storehouse_id){
        String[][] out_info = new String[5][2];
        int i,j,k,max=0;
        if (storehouse_id==null||storehouse_id.equals("")||computer_id==null||computer_id.equals("")||computer_num<=0){
            for (i=0;i<5;i++) {
                out_info[i][0] = "<td>无</td>";
                out_info[i][1] = "<td>0/0</td>";
            }
            return out_info;
        }
        String sql="select blueprint.component_id,blueprint.component_number,componenthouse.component_number from blueprint,componenthouse where componenthouse.component_id=blueprint.component_id and blueprint.computer_id=? and componenthouse.storehouse_id=?";
        String[][] com_need =get_component_need(computer_id);
        String[][] com_store = new String[5][2];
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=UserDao.getConn();
        try
        {
            ps=conn.prepareStatement(sql);
            ps.setString(1,computer_id);
            ps.setString(2,storehouse_id);
            rs=ps.executeQuery();
            while(rs.next()) {
                com_store[max][0]=rs.getString(1);
                com_store[max][1]=rs.getString(3);
                max++;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            UserDao.closeAll(conn, ps, rs);
        }
        String[] type_apart={"main_board","cpu","gpu","memory","screen"};
        for (i=0;i<5;i++)//顺序遍历type_apart按顺序排序
        {
            for (j=0;j<5;j++)//将need中筛选出和type_apart[i]对应的
            {
                if (Objects.equals(type_apart[i],com_need[j][2]))
                {
                    out_info[i][0]="<td>"+com_need[j][3]+"</td>";
                    for (k=0;k<max;k++){//从store中筛选和need对应的
                        if (Objects.equals(com_store[k][0],com_need[j][0])){
                            if (Integer.parseInt(com_store[k][1])<Integer.parseInt(com_need[j][1])*computer_num){//判断存量是否足够
                                out_info[i][1]="<td class=\"red\">"+Integer.parseInt(com_need[j][1])*computer_num+"/"+com_store[k][1]+"</td>";
                            }
                            else {
                                out_info[i][1]="<td class=\"green\">"+Integer.parseInt(com_need[j][1])*computer_num+"/"+com_store[k][1]+"</td>";
                            }
                            break;
                        }
                    }
                    if (k==max){
                        out_info[i][1]="<td class=\"red\">"+Integer.parseInt(com_need[j][1])*computer_num+"/0</td>";
                    }
                    break;
                }
            }
        }
        return out_info;
    }

    public static int judge_build_possibility(String[][] table){
        int i;
        for (i=0;i<5;i++){
            if (table[i][1].indexOf('g')==-1)
                return 0;
        }
        return 1;
    }

    public static int build_computer(String computer_id,int computer_num,String storehouse_id){
        String[][] com_need =get_component_need(computer_id);
        int i;
        int x=0;
        for (i=0;i<5;i++) {
            x+=update_storehouse("update componenthouse set component_number=component_number-? where storehouse_id=? and component_id=?",storehouse_id,com_need[i][0],Integer.parseInt(com_need[i][1]) * computer_num);
        }
        if (update_storehouse("update computerhouse set computer_number=computer_number+? where storehouse_id=? and computer_id=?",storehouse_id,computer_id,computer_num)==0){
            x+=update_storehouse("insert into computerhouse(computer_number,storehouse_id,computer_id)values(?,?,?)",storehouse_id,computer_id,computer_num);
        }
        return x;
    }

    public static void main(String[] args) {

    }
}
