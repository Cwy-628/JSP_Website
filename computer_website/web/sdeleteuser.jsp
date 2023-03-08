<%--
  Created by IntelliJ IDEA.
  User: krispao
  Date: 2022/5/10
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<jsp:useBean class="com.xxx.mapper.house" id="control" scope="page"></jsp:useBean>
<jsp:useBean class="com.xxx.mapper.custom_info" id="customer" scope="page"></jsp:useBean>
<jsp:useBean class="com.xxx.mapper.account_cancel" id="com" scope="page"></jsp:useBean>
<body>
<%
    String info_1=request.getParameter("search_1");
    com.delete_user(info_1);
    request.getRequestDispatcher("cancel_account.jsp").forward(request,response);
%>
</body>
</html>
