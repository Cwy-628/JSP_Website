<%--
  Created by IntelliJ IDEA.
  User: ricky
  Date: 2022/3/29
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean class="com.xxx.mapper.controller_action" id="control" scope="page"></jsp:useBean>
<div>
    <%
        int change=0;
        String order_id= String.valueOf(request.getQueryString());
        String controller_id=(String) request.getSession().getAttribute("uname");
        change=control.abandon_order(controller_id,order_id);
        if (change==1){
            response.sendRedirect("controller_orders_unfinished.jsp");
        }
        else if (change==0){
            out.println("接取失败");
        }
        else{
            out.println("寄了");
        }
    %>
</div>
</body>
</html>
