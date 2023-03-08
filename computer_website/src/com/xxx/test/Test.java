package com.xxx.test;

import com.xxx.entity.Admin;
import com.xxx.mapper.UserMapper;
import com.xxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

public class Test {
    public static void main(String[] args) {
        // 获取sqlSession对象
        SqlSession session = GetSqlSession.createSqlSession();
        // 得到对应Mapper
        UserMapper userMapper = session.getMapper(UserMapper.class);
        // 调用方法，返回用户对象
        Admin admin = userMapper.getAdminInfo("admin");
        System.out.println(admin);
    }
}
