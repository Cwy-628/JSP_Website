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
    <title>零件修改</title>
    <style>
        div.mid{
            margin-top: 10%;
            margin-left: 35%;
        }
    </style>
</head>
<body>
<%
    String house_id=(String) request.getSession().getAttribute("house_id");
    String component_id= request.getQueryString();
    request.getSession().setAttribute("component_id",component_id);
%>
<div class="mid">
    仓库编号：<%=house_id%><br/>
    零件编号：<%=component_id%><br/>
    <form action="alter_computer_do.jsp">
        <label for="change_num">修改零件数量：</label>
        <input id="change_num" name="change_num" type="number">
        <button type="submit">修改</button>
    </form>
</div>
</body>
</html>
