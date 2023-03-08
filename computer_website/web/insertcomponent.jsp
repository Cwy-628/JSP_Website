<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2022/4/22
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改电脑信息</title>
    <link rel="stylesheet" href="../../1/version01/version01/web/css/restyle.css">
    <style>
        tr{width:5px;height:5px}
    </style>
</head>
<body>
<jsp:useBean class="com.xxx.mapper.house" id="control" scope="page"></jsp:useBean>
<jsp:useBean class="com.xxx.mapper.made_computer" id="made" scope="page"></jsp:useBean>
<jsp:useBean class="com.xxx.mapper.custom_info" id="customer" scope="page"></jsp:useBean>
<jsp:useBean class="com.xxx.mapper.computer" id="com" scope="page"></jsp:useBean>
<div class="page-container" id="a" align="center">

    <form action="sinsertcomponent.jsp" method="post">
        <table border="1" >
            <tr>
                <td>零件的ID：</td>
                <td><input onchange="change_submit()" type="text"  name="search_1" id="search_1" value="computer1"></td>
            </tr>
            <tr>
                <td> 零件的名称：</td>
                <td><input onchange="change_submit()" type="text"  name="search_2" id="search_2"  value="computer1"></td>
            </tr>
            <tr>
                <td> 零件的类型：</td>
                <td><input onchange="change_submit()" type="text"  name="search_3" id="search_3" value="0" ></td>
            </tr>
            <tr>
                <td> 零件的价格：</td>
                <td><input onchange="change_submit()" type="text"  name="search_4" id="search_4"  value="0"></td>
            </tr>
        </table>
        <input type="submit" value="确定" id="reButton">
        <input type="reset" onclick="">
        <input type="submit" value="返回" id="return" action="housecomponent.jsp">

    </form>
</div>
</body>
</html>
