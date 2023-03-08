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

    <form action="sinsertblueprint.jsp" method="post">
        <table border="1" >
            <tr>
                <td>电脑的ID：</td>
                <td><input onchange="change_submit()" type="search" list="typelist1" name="search_1" id="search_1" placeholder="（ 选择 ）" class="form_control" autocomplete="on"></td>
            </tr>
            <tr>
                <td>零件的ID：</td>
                <td><input onchange="change_submit()" type="search" list="typelist2" name="search_2" id="search_2" placeholder="（ 选择 ）" class="form_control" autocomplete="on"></td>
            </tr>
            <tr>
                <td> 零件的个数：</td>
                <td><input onchange="change_submit()" type="text"  name="search_3" id="search_3" value="0" ></td>
            </tr>
            <datalist id="typelist1" class="side">
                　  　<%=com.findhouse_computerid()%>
            </datalist>
            <datalist id="typelist2" class="side">
                　  　<%=com.findhouse_componentid()%>
            </datalist>

        </table>
        <input type="submit" value="确定" id="reButton">
        <input type="reset" onclick="">
        <input type="submit" value="返回" id="return" action="housecomponent.jsp">

    </form>
</div>
</body>
</html>
