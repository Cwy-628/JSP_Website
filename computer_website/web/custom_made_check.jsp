<%--
  Created by IntelliJ IDEA.
  User: ricky
  Date: 2022/4/16
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean class="com.xxx.mapper.made_computer" id="made" scope="page"></jsp:useBean>
<jsp:useBean class="com.xxx.mapper.custom_info" id="customer" scope="page"></jsp:useBean>
    <%
        String ID= (String) request.getSession().getAttribute("uname");
        String made_name=request.getParameter("made_name");
        String info_1=request.getParameter("search_1");
        String info_2=request.getParameter("search_2");
        String info_3=request.getParameter("search_3");
        String info_4=request.getParameter("search_4");
        String info_5=request.getParameter("search_5");
        String total_price=request.getParameter("total_price");
        String computer_id=made.create_custom_made_computer(made_name,total_price);
        made.create_custom_made_blueprint(computer_id,info_1);
        made.create_custom_made_blueprint(computer_id,info_2);
        made.create_custom_made_blueprint(computer_id,info_3);
        made.create_custom_made_blueprint(computer_id,info_4);
        made.create_custom_made_blueprint(computer_id,info_5);
        if(customer.create_order(ID,computer_id,"1")==0){
            out.println("失败");
        }
        else{
            out.println("成功");
        }
    %>
</body>
</html>
