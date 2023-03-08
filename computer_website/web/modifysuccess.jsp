<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean class="com.xxx.mapper.house" id="control" scope="page"></jsp:useBean>
<jsp:useBean class="com.xxx.mapper.customer_account" id="com" scope="page"></jsp:useBean>
<jsp:useBean class="com.xxx.mapper.custom_info" id="customer" scope="page"></jsp:useBean>
<div>
    <%
        String info_1=request.getParameter("search_1");
        String info_2=request.getParameter("search_2");
        String i=request.getParameter("search_3");
        String info_4=request.getParameter("search_4");
        String info_6=request.getParameter("search_6");
        com. setcname(info_1,info_2);
        com.setpwd(info_1,info_6);
        request.setAttribute("s","恭喜你，修改成功！");
        request.getRequestDispatcher("account_management.jsp").forward(request,response);
    %>
</div>
</body>
</html>
