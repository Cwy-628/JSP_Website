<%--
  Created by IntelliJ IDEA.
  User: ricky
  Date: 2022/4/30
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>制造</title>
</head>
<body>
<jsp:useBean class="com.xxx.mapper.computer_workshop" id="work" scope="page"></jsp:useBean>
    <%
        String house_name=(String) request.getSession().getAttribute("house_name");
        String computer_id=(String) request.getSession().getAttribute("computer_id");
        String computer_num=(String) request.getSession().getAttribute("computer_num");
        if (work.build_computer(computer_id, Integer.parseInt(computer_num),work.get_house_id(house_name))>=5){
            response.sendRedirect("workhouse.jsp");
        }
        out.println("加工失败");
    %>
</body>
</html>
