<%--
  Created by IntelliJ IDEA.
  User: ricky
  Date: 2022/5/9
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean class="com.xxx.mapper.controller_action" id="control" scope="page"></jsp:useBean>
<%
    String house_id=(String) request.getSession().getAttribute("house_id");
    String component_id=(String) request.getSession().getAttribute("component_id");
    String change_num=request.getParameter("change_num");
    if (control.alter_component_storage(house_id,component_id,change_num)==1){
        out.println("success");
    }
%>
</body>
</html>
