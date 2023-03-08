<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: krispao
  Date: 2022/4/24
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息修改</title>
    <style>
        ul.a1{
            list-style-type: none;
            margin: 0;
            padding: 0;
            width: 20%;
            background-color: #f1f1f1;
            position: fixed;
            height: 100%;
            overflow: auto;
        }

        ul.pagination {
            display: inline-block;
            padding: 0;
            margin: 0;
        }

        ul.pagination li {display: inline;}

        ul.pagination li a {
            color: black;
            float: left;
            padding: 8px 16px;
            text-decoration: none;
            transition: background-color .3s;
        }

        li a {
            display: block;
            color: #000;
            padding: 8px 16px;
            text-decoration: none;
        }

        li a.active {
            background-color: #4CAF50;
            color: white;
        }

        li a:hover:not(.active) {
            background-color: #555;
            color: white;
        }
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
        }

        /* 头部样式 */
        .header {
            background-color: #f1f1f1;
            padding: 10px;
            text-align: center;
        }

        /* 导航条 */
        .topnav {
            overflow: hidden;
            background-color: #333;
        }

        /* 导航链接 */
        .topnav a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        /* 链接 - 修改颜色 */
        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }


        /* 列后清除浮动 */
        .row:after {
            content: "";
            display: table;
            clear: both;
        }

        div.center {text-align: center;}

        .account_info{
            padding:50px 10px 10px 500px;
            margin: 0 auto;
        }

        input {
            width: 270px;
            height: 42px;
            margin-top: 25px;
            padding: 0 15px;
            -moz-border-radius: 6px;
            -webkit-border-radius: 6px;
            border-radius: 6px;
            border: 1px solid #3d3d3d; /* browsers that don't support rgba */
            border: 1px solid black;
            font-family: 'PT Sans', Helvetica, Arial, sans-serif;
            font-size: 14px;
            color: gray;
            text-shadow: 0 1px 2px rgba(0,0,0,.1);
            -o-transition: all .2s;
            -moz-transition: all .2s;
            -webkit-transition: all .2s;
            -ms-transition: all .2s;
        }


        .confirm_modify {
            margin-left: 550px;
        }
        .confirm_modify button {
            cursor: pointer;
            width: 300px;
            height: 44px;
            margin-top: 25px;
            padding: 0;
            background: rgb(157, 184, 131);
            -moz-border-radius: 6px;
            -webkit-border-radius: 6px;
            border-radius: 6px;
            border: 1px solid darkseagreen;
            font-family: 'PT Sans', Helvetica, Arial, sans-serif;
            font-size: 14px;
            font-weight: 700;
            color: #fff;
            text-shadow: 0 1px 2px rgba(0,0,0,.1);
            -o-transition: all .2s;
            -moz-transition: all .2s;
            -webkit-transition: all .2s;
            -ms-transition: all .2s;
        }

    </style>
</head>
<body>
<jsp:useBean class="com.xxx.mapper.custom_info" id="customer" scope="page"></jsp:useBean>

<div>
    <%--解析域名--%>
    <%
        String ht_pn= String.valueOf(request.getQueryString());
        if (Objects.equals(ht_pn,"null")){
            ht_pn="1";
        }
        int pagenum= Integer.parseInt(ht_pn);
        int total_page=6;
        String ID= (String) request.getSession().getAttribute("uname");
    %>
</div>

<div class="header">
    <h1>智能电脑零部件管理系统</h1>
    <p>用户信息修改</p>
</div>
<!--顶部导航条-->
<div class="topnav">

    <li style="float:right"><a href="#">用户：<%=customer.get_customer_name(ID)%></a></li>
    <li style="float:right"><a href="customer_orders.jsp">我的订单</a></li>
</div>

<!--侧边栏-->
<div class="row">
    <ul class="a1" id="test_2">
        <li><a href="customer_view.jsp">主页</a></li>
        <li><a href="news.jsp">新闻</a></li>
        <li><a href="#">联系</a></li>
        <li><a href="#">关于</a></li>
        <li><a class="active" href="#">账号与安全</a></li>
    </ul>
</div>

    <div class="account_info">
        请输入原密码：<input type="text" name="oupwd" name="oupwd" id="oupwd"><br/>
        请输入新密码：<input type="text" name="nupwd" id="nupwd"><br/>
    </div>
    <div class="confirm_modify">
        <a href="update.jsp"><button  id="update">修改</button></a>
    </div>

</body>
</html>
