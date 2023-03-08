
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息</title>
    <link rel="stylesheet" href="css/restyle.css">
    <style>
        tr{width:5px;height:5px}
    </style>
</head>
<body>
<jsp:useBean class="com.xxx.mapper.house" id="control" scope="page"></jsp:useBean>
<jsp:useBean class="com.xxx.mapper.customer_account" id="com" scope="page"></jsp:useBean>
<jsp:useBean class="com.xxx.mapper.custom_info" id="customer" scope="page"></jsp:useBean>
<div class="page-container" id="a" align="center">

<form action="modifysuccess.jsp"  method="post">
    <table border="1" >
           <tr>
              <td>用户ID：</td>
               <td><input onchange="change_submit()" type="search" list="typelist1" name="search_1" id="search_1" placeholder="（ 选择 ）" class="form_control" autocomplete="on"></td>
           </tr>
        <tr>
            <td> 用户名称：</td>
            <td><input onchange="change_submit()" type="text"  name="search_2" id="search_2"  value=""></td>
        </tr>
        <tr>
            <td> 用户类别：</td>
            <td><input onchange="change_submit()" type="text"  name="search_3" id="search_3" value="" ></td>
        </tr>
        <tr>
            <td> 电话：</td>
            <td><input onchange="change_submit()" type="text"  name="search_4" id="search_4"  value=""></td>
        </tr>
        <tr>
            <td> 地址：</td>
            <td><input onchange="change_submit()" type="text"  name="search_5" id="search_5"  value=""></td>
        </tr>
        <tr>
            <td> 密码：</td>
            <td><input onchange="change_submit()" type="text"  name="search_6" id="search_6"  value=""></td>
        </tr>
    </table>
    <datalist id="typelist1" class="side">
        　  　<%=com.findaccount_customerid()%>
    </datalist>
    <datalist id="typelist2" class="side">
        　　<%=com.findaccount_customername()%>
    </datalist></td>

    <input type="submit" value="确定" id="reButton">
</form>
</div>
</body>
</html>
