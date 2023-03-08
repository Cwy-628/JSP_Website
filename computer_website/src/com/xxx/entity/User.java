package com.xxx.entity;

/**
 * User实体类
 */
public class User {
    private String Customer_id;//用户编号
    private String Customer_name;//用户姓名
    private String Customer_pwd;//用户密码
    private String Customer_tele;//用户电话
    private String Customer_address;//用户地址
    private String Customer_type;//用户类别：企业或个人

    public String getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(String customer_id) {
        Customer_id = customer_id;

    }

    public String getCustomer_name() {
        return Customer_name;
    }

    public void setCustomer_name(String customer_name) {
        Customer_name = customer_name;
    }

    public String getCustomer_pwd() {
        return Customer_pwd;
    }

    public void setCustomer_pwd(String customer_pwd) {
        Customer_pwd = customer_pwd;
    }


    public String getCustomer_tele() {
        return Customer_tele;
    }

    public void setCustomer_tele(String customer_tele) {
        Customer_tele = customer_tele;
    }

    public String getCustomer_address() {
        return Customer_address;
    }

    public void setCustomer_address(String customer_address) {
        Customer_address = customer_address;
    }

    public String getCustomer_type() {
        return Customer_type;
    }

    public void setCustomer_type(String customer_type) {
        Customer_type = customer_type;
    }
}
