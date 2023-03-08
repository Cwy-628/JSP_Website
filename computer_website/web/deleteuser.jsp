<%--
  Created by IntelliJ IDEA.
  User: krispao
  Date: 2022/5/11
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean class="com.xxx.mapper.house" id="control" scope="page"></jsp:useBean>
<jsp:useBean class="com.xxx.mapper.custom_info" id="customer" scope="page"></jsp:useBean>
<jsp:useBean class="com.xxx.mapper.account_cancel" id="com" scope="page"></jsp:useBean>
<div class="page-container" id="a" align="center">

    <form action="sdeleteuser.jsp" method="post">
        <table border="1" >
            <tr>
                <td>用户ID编号：</td>
                <td><input onchange="change_submit()" type="search" list="typelist1" name="search_1" id="search_1" placeholder="（ 选择 ）" class="form_control" autocomplete="on"></td>
            </tr>
        </table>
        <datalist id="typelist1" class="side">
            　  　<%=com.finduser_info()%>
        </datalist>

        <input type="submit" value="确定" id="reButton">
        <input type="reset" onclick="">

        <input type="submit" value="返回" id="return" action="cancel_account.jsp">

    </form>
</body>
</html>
