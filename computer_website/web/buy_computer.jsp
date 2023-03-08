<%--
  Created by IntelliJ IDEA.
  User: ricky
  Date: 2022/4/4
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下单</title>
</head>
<body>
<jsp:useBean class="com.xxx.mapper.custom_info" id="compuview" scope="page"></jsp:useBean>

<div>
    <%
        String compu_id= String.valueOf(request.getQueryString());
        String ID= (String) request.getSession().getAttribute("uname");
        String number=request.getParameter("compu_num");
        if (compuview.create_order(ID,compu_id,number)==1){
            out.println("下单"+number+"个成功!");
        }
        else
            out.println("下单失败");
    %>
</div>
<a href="customer_view.jsp?1">返回</a>

</body>
</html>
