<%--
  Created by IntelliJ IDEA.
  User: ricky
  Date: 2022/5/9
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean class="com.xxx.mapper.custom_info" id="customer" scope="page"></jsp:useBean>
    <%
        String order_id= String.valueOf(request.getQueryString());
        if (customer.customer_accept(order_id)==1){
            out.println("确认收货");
        }
    %>
</body>
</html>
