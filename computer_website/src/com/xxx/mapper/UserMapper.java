package com.xxx.mapper;

import com.xxx.entity.Admin;
import com.xxx.entity.User;

/**
 *用户接口类
 */
public interface UserMapper {
    public User queryUserByName(String userName);
    public Admin getAdminInfo(String adminName);
}
//value="${messageModel.object.customer_name}"
//value="${messageModel.object.customer_pwd}"