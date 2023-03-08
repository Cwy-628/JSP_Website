<%--
  Created by IntelliJ IDEA.
  User: ricky
  Date: 2022/5/11
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="refresh" content="3;url=http://localhost:8080/re/customer_view.jsp" />
    <title>Title</title>
</head>
<body>
<jsp:useBean class="com.xxx.mapper.custom_info" id="customer" scope="page"></jsp:useBean>
<%
    String order_id= String.valueOf(request.getQueryString());
    customer.set_not_wanted_order(order_id);
    out.println("取消成功");
%>
</body>
</html>
