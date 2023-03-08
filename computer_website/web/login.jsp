
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <title>用户登录</title>
    <!-- CSS -->
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style.css">

</head>
<body>
    <!--<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script> -->

    <div style="text-align: center">
        <div class="page-container">
            <h1>智能电脑零部件管理系统</h1>

            <!--el表达式在你获取对象时，自动把你的属性名转换成字符串，并把首字母大写，进行拼接（"get"+属性名），然后通过反射的方式获取到get方法，返回属性值。实际上就是调用了一遍JavaBean里面的某属性的get函数。 -->
            <form action="login" method="post" id="loginForm">
                <div class="word1" style="margin: 10px 0 -10px 0">用户名：</div><input type="text" name="uname" id="uname"  ><br/>
                <div class="word1" style="margin: 10px 0 -10px 0">密码：</div><input type="password" name="upwd" id="upwd" ><br/>
                <span id = "msg" style="font-size: 12px;color: red">${messageModel.msg}</span><br/>

                <table class = "radio_size" width="100%" style="text-align: center" border="none">
                    <tr>
                        <th>登录类型:</th>
                            <td><input type="radio" name="type" id = "type" value="a" style="zoom:50%;">用户</td>
                            <td><input type="radio" name="type" value="b" style="zoom:50%;">管理员</td>
                    </tr>
                </table>

                <button type="button" id="loginButton">登录</button>
                <a href="register.jsp">
                <button type="button" id="reButton">注册</button>
                </a>
            </form>

        </div>
    </div>
</body>



<!-- 引入jQuery的js文件 -->

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js" ></script>

<script type="text/javascript">
    /*
        JS校验登录表单验证
     1. 给登录按钮绑定点击事件(通过id绑定）
     2. 获取用户姓名和密码的值（
     3. 判断姓名是否为空
            如果姓名为空，提示用户（span标签赋值），并且return
     4. 判断密码是否为空
            如果密码为空，提示用户（span标签赋值），并且return
     5. 如果都不为空，则手动提交表单
     */
    $("#loginButton").click(function (){
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
        $("#loginForm").submit();
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
