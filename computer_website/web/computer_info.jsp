<%@ page import="com.xxx.mapper.custom_info" %><%--
  Created by IntelliJ IDEA.
  User: ricky
  Date: 2022/3/15
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        ul.a1{
            list-style-type: none;
            margin: 0;
            padding: 0;
            width: 10%;
            background-color: #f1f1f1;
            position: fixed;
            height: 100%;
            overflow: auto;
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
        table{
            width: 60%;
            margin-left:20%;
        }
        table,th,td
        {
            border:1px solid black;
            text-align:center;
        }
        .header {
            text-align: center;
        }
        div.mid{
            margin-left: 20%;
        }
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
    </style>
    <title>详细信息</title>
</head>
<body>
<jsp:useBean class="com.xxx.mapper.custom_info" id="compuview" scope="page"></jsp:useBean>

<div>
    <%--解析域名--%>
    <%
        String customer_id=(String) request.getSession().getAttribute("uname");
        String compu_id= String.valueOf(request.getQueryString());
        String imga=compuview.get_detail_image(compu_id);
        String buy_path="buy_computer.jsp?"+compu_id;
    %>
</div>

<div class="header">
    <h1>电脑详情</h1>
    <p>笔记本</p>
</div>

<div class="topnav">
    <a href="#">笔记本</a>
    <a href="#">零件</a>
    <a href="custom_made.jsp">定制</a>
    <li style="float:right"><a href="#">用户：<%=compuview.get_customer_name(customer_id)%></a></li>
    <li style="float:right"><a href="customer_orders.jsp">我的订单</a></li>
</div>

<!--侧边栏-->
<div class="row">
    <ul class="a1" id="test_2">
        <li><a class="active" href="#">主页</a></li>
        <li><a href="news.jsp">新闻</a></li>
        <li><a href="#">联系</a></li>
        <li><a href="#">关于</a></li>
        <li><a href="#">账号与安全</a></li>
    </ul>
</div>

<div class="mid">
    <%--电脑图片以及其名称和价格--%>
    <div class="img">
        <a target="_blank">
            <img src=<%=imga%> alt="asd" width="600" height="400">
        </a>
        <div class="desc">name:<%=compuview.get_detail_name(compu_id)%></div>
        <div class="desc">price:<%=compuview.get_detail_price(compu_id)%></div>
    </div>

    <%--电脑使用的零件信息--%>
    详细参数：
    <%=compuview.get_com_detail_component(compu_id)%>

    <form action=<%=buy_path%> method="post">
        数量:<input type="number" name="compu_num" id="compu_num" value="1"><br/>
        <button type="submit">购买</button>
    </form>
</div>
</body>
</html>
