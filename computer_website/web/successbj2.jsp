<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2022/4/22
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean class="com.xxx.mapper.house" id="control" scope="page"></jsp:useBean>
<jsp:useBean class="com.xxx.mapper.made_computer" id="made" scope="page"></jsp:useBean>
<jsp:useBean class="com.xxx.mapper.custom_info" id="customer" scope="page"></jsp:useBean>
<jsp:useBean class="com.xxx.mapper.computer" id="com" scope="page"></jsp:useBean>
<div>
    <%
        String info_1=request.getParameter("search_1");
        double i=Double.parseDouble(request.getParameter("search_7"));
        com.setprice2(info_1,i);
        request.setAttribute("r","恭喜你，修改成功！");
        request.getRequestDispatcher("housecomponent.jsp").forward(request,response);
    %>
</div>
</body>
</html>