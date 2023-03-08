
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员界面</title>
    <style>

        
        body {
            background-image: url("img/3.jpg");
        }
        li {
            list-style: none;
        }

        h1 {
            font-size:80px;
        }
        h2 {
            text-align: center;
            font-size:50px;
        }

        a {
            text-decoration: none;
        }
        .header {
            text-align: center;
            background-color: transparent;
            width: 1200px;
            margin : 40px auto;
            color: #000000;
        }

        .list_ ul li {
            width: 400px;
            margin: -10px auto;
            border:1px solid transparent;
        }

    </style>
</head>
<body>

    <div class="header">
        <h1>管理员界面</h1>
    </div>

    <div class="list_">
        <ul>
            <li><a href="account_management.jsp"><h2>用户管理</h2></a></li>
            <li><a href="controller_orders.jsp?0"><h2>订单管理</h2></a></li>
            <li><a href="storehouse.jsp"><h2>仓库管理</h2></a></li>
            <li><a href="housecomputer.jsp"><h2>零部件管理</h2></a></li>
        </ul>
    </div>
</body>
</html>
