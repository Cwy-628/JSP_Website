<%--
  Created by IntelliJ IDEA.
  User: ricky
  Date: 2022/3/29
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>电脑零件管理</title>
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
<%
    String t = (String)request.getAttribute("t");         // 获取错误属性
    if(t != null) {
%>
<script type="text/javascript" language="javascript">
    alert("<%=t%>");                                            // 弹出错误信息
    window.location='houseblueprint.jsp' ;                            // 跳转到登录界面
</script>
<%
    }
%>
<jsp:useBean class="com.xxx.mapper.house" id="control" scope="page"></jsp:useBean>
<jsp:useBean class="com.xxx.mapper.made_computer" id="made" scope="page"></jsp:useBean>
<jsp:useBean class="com.xxx.mapper.custom_info" id="customer" scope="page"></jsp:useBean>
<jsp:useBean class="com.xxx.mapper.computer" id="com" scope="page"></jsp:useBean>

<div>
    <%
        String controller_id=(String) request.getSession().getAttribute("uname");
        String controller_name =control.findname(controller_id);
    %>
</div>

<div class="header">
    <h1>电脑零件管理</h1>
</div>
<div class="blank">
    <a href ="bianji_blueprint.jsp">编辑</a>
    <a href ="delete1.jsp">删除</a>
    <a href ="insertblueprint.jsp">添加</a>
</div>
<div class="row">
    <ul class="a1" id="test_2">
        <li><a href="controller_view.jsp" >返回主页</a></li>
        <li><a href="housecomputer.jsp">电脑信息查询</a></li>
        <li><a href="housecomponent.jsp">零件查询</a></li>
        <li><a href="#" class="active">图纸匹配查询 </a></li>
        <li><a href="#">管理员：<%=controller_id%></a></li>
    </ul>
</div>

<div class="table_">
    <!--列表填充-->
    <%
        out.println(control.findblueprint());
    %>
</div>

</body>
</html>

