<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>

    <link rel="stylesheet" href="css/restyle.css">
</head>
<body>
<div class="page-container" style="text-align: center">
    <h1>注册</h1>
    <form action="register" method="post" id="reForm">
        用户名：&nbsp;&nbsp;<input type="text" name="uname" id="uname" align="left" value="${messageModel.object.customer_name}" ><br/>
        密&nbsp;&nbsp;&nbsp;码：&nbsp;&nbsp;<input type="password" name="upwd" align="left" id="upwd" value="${messageModel.object.customer_pwd}"><br/>
        用户类型：<input list="Customer_type" align="left" name="Customer_type">
    <datalist id="Customer_type">
        <option value="个人">
        <option value="企业">
    </datalist><br/>
    手机号：&nbsp;&nbsp;<input type="text" name="Customer_tele"><br/>
    地&nbsp;&nbsp;&nbsp;&nbsp;址：<input type="text" name="Customer_address"><br/>


    <span id = "msg" style="font-size: 12px;color: red">${messageModel.msg}</span><br/>
    <input type="submit" id="reButton" value="提交" >
    <input type="reset" onclick="">
    </form>
</div>
</body>


<%--<!-- 前端校验 -->--%>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
    /*
        JS校验注册表单验证
     1. 给注册按钮绑定点击事件(通过id绑定）
     2. 获取用户姓名和密码的值（
     3. 判断姓名是否为空
            如果姓名为空，提示用户（span标签赋值），并且return
     4. 判断密码是否为空
            如果密码为空，提示用户（span标签赋值），并且return
     5. 如果都不为空，则手动提交表单
     */
    $("#reButton").click(function (){
        //获取用户名和密码
        const uname = $("#uname").val();
        const upwd = $("#upwd").val();
        if(isEmpty(uname)){
            //如果姓名为空，用return html()对span标签赋值
            $("#msg").html("用户姓名不可为空");
            return;
        }
        if(isEmpty(upwd)){
            //密码，用return html()对span标签赋值
            $("#msg").html("用户密码不可为空");
            return;
        }
        //如果都不为空，则手动提交表单
        $("#reForm").submit();
    });

    //判断字符串是否为空
    function isEmpty(str){
        if(str == null || str.trim() == ""){
            return true;
        }
        return false;
    }
</script>
</html>
