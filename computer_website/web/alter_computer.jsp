<%--
  Created by IntelliJ IDEA.
  User: ricky
  Date: 2022/5/9
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        div.mid{
            margin-top: 10%;
            margin-left: 35%;
        }
    </style>
    <title>修改电脑信息</title>
</head>
<body>
<%
    String house_id=(String) request.getSession().getAttribute("house_id");
    String computer_id= request.getQueryString();
    request.getSession().setAttribute("computer_id",computer_id);
%>
<div class="mid">
    仓库编号：<%=house_id%><br/>
    电脑编号：<%=computer_id%><br/>
    <form action="alter_computer_do.jsp">
        <label for="change_num">修改电脑数量：</label>
        <input id="change_num" name="change_num" type="number">
        <button type="submit">修改</button>
    </form>
</div>

</body>
</html>
