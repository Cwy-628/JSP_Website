
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单管理</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

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
        li a {
            display: block;
            color: #000;
            padding: 8px 16px;
            text-decoration: none;
            font-size: 30px;
        }

        li a.active {
            background-color: #4CAF50;
            color: white;
        }

        li a:hover:not(.active) {
            background-color: #555;
            color: white;
        }
        .select_choice {
            margin-left:20%;
        }
        .table_ {
            margin-top: 40px;
            margin-left: 10%;

        }

        .table_ table{
            width: 60%;
            margin-left:20%;
            font-size: 20px;
        }
        .table_ table,th,td
        {
            border:1px solid black;
            text-align:center;
        }
        .header {
            height: 150px;
            line-height: 160px;
            text-align: center;
            background-color: rgb(247, 246, 246);
        }

        .header h1 {
            font-size: 60px;
            font-family: "Georgia";

        }

        .blank {
            height: 43px;
            background-color: rgb(157, 184, 132);
        }
    </style>
</head>
<body>
<jsp:useBean class="com.xxx.mapper.controller_action" id="control" scope="page"></jsp:useBean>

<!--该页面详情见controller_orders，若有办法将三个页面合为一个最好-->

<div>
    <%
        String controller_id=(String) request.getSession().getAttribute("uname");
    %>
</div>

<div class="header">
    <h1>订单管理</h1>
</div>
<div class="blank"></div>
<div class="row">
    <ul class="a1" id="test_2">
        <li><a href="controller_view.jsp" >返回主页</a></li>
        <li><a href="controller_orders.jsp?0">待接取的订单</a></li>
        <li><a href="controller_orders_unfinished.jsp">未完成的订单</a></li>
        <li><a href="#" class="active">已完成的订单</a></li>
        <li><a href="workhouse.jsp">车间</a> </li>
        <li><a href="#">管理员：<%=control.get_controller_name(controller_id)%></a></li>
    </ul>
</div>
<div class="table_">
    <%
        out.println(control.get_finished_orders(controller_id));
    %>
</div>
</body>
</html>
