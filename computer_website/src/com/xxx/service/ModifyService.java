package com.xxx.service;

import com.xxx.entity.User;
import com.xxx.entity.valueObject.MessageModel;
import com.xxx.util.StringUtil;

/**
 *
 */
public class ModifyService {
    public  MessageModel userModify(String oupwd, String nupwd) {
        MessageModel messageModel = new MessageModel();
        //回显
        User u = new User();
        u.setCustomer_pwd(nupwd);
        messageModel.setObject(u);
        //参数非空判断
        if (StringUtil.isEmpty(oupwd) || StringUtil.isEmpty(nupwd)) {
            //将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMsg("密码不能为空");
            //回显
            return messageModel;
        }


        return messageModel;
    }
}
