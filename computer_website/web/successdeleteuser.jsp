<%--
  Created by IntelliJ IDEA.
  User: krispao
  Date: 2022/5/11
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:useBean class="com.xxx.mapper.house" id="control" scope="page"></jsp:useBean>
<jsp:useBean class="com.xxx.mapper.custom_info" id="customer" scope="page"></jsp:useBean>
<jsp:useBean class="com.xxx.mapper.computer" id="com" scope="page"></jsp:useBean>
<div>
    <%
        String info_1=request.getParameter("search_1");
        String info_6=request.getParameter("search_6");
        com.deleteblueprint1(info_1);
        com.deleteblueprint2(info_6);
        com. deletecom2(info_1);
        com. deletecomponent(info_6);
        request.setAttribute("s","恭喜你，删除成功！");
        request.getRequestDispatcher("cancel_account.jsp").forward(request,response);
    %>
</div>
</body>
</html>
