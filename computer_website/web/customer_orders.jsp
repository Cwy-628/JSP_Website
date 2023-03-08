<%--
  Created by IntelliJ IDEA.
  User: ricky
  Date: 2022/4/4
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户订单</title>
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
    </style>
</head>
<body>
<jsp:useBean class="com.xxx.mapper.custom_info" id="customer" scope="page"></jsp:useBean>

    <div>
        <%
            String customer_id=(String) request.getSession().getAttribute("uname");
        %>
    </div>

    <div class="header">
        <h1>查看订单</h1>
    </div>

    <%
        out.println(customer.get_customer_orders(customer_id));
    %>

</body>
</html>
