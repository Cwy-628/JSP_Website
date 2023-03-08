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
        String info_6=request.getParameter("search_6");
        com.deletehouse1(info_1);
        com.deletehouse2(info_6);
        request.getRequestDispatcher("storehouse.jsp").forward(request,response);
    %>
</div>
</body>
</html>