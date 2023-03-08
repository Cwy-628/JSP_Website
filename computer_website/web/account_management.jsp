<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息管理</title>
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
            margin-left: 20%;
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
<jsp:useBean class="com.xxx.mapper.account_management" id="control" scope="page"></jsp:useBean>

    <!--标题-->
    <div class="header">
        <h1>用户管理</h1>
    </div>

    <%--    菜单栏--%>
    <div class="blank"></div>
    <!--侧边栏-->
    <div class="row">
        <ul class="a1" id="test_2">
            <li><a href="controller_view.jsp" >返回主页</a></li>
            <li><a href="#" class="active">用户信息</a></li>
            <li><a href="cancel_account.jsp">用户注销</a></li>
        </ul>
    </div>

    <div class="table_">
    <!--列表填充-->
        <%
            out.println(control.get_enabled_orders());
        %>
    </div>

</body>
</html>
