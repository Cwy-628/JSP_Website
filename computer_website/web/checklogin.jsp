<%--
  Created by IntelliJ IDEA.
  User: ricky
  Date: 2022/3/8
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录验证</title>
</head>
<body>
<jsp:useBean class="com.xxx.mapper.UserDao" id="user" scope="page"></jsp:useBean>
<div style="text-align: center">
    <%
        int checked=0;
        String ID=request.getParameter("uname");
        String PSW=request.getParameter("upwd");
        String type=request.getParameter("type");
        if (type.equals("a")){//判断登录类型
            checked=user.check_pwd(ID,PSW);
            if (checked==1){
                request.getSession().setAttribute("uname",ID);
                response.sendRedirect("customer_view.jsp?1");
            }
            else if (checked==0){
                out.println("登录失败");
            }
            else {
                out.println("账号不存在");
            }
        }
        else{
            checked=user.check_controller(ID,PSW);
            if (checked==1){
                request.getSession().setAttribute("uname",ID);
                response.sendRedirect("controller_view.jsp");
            }
            else if (checked==0){
                out.println("登录失败");
            }
            else {
                out.println("账号不存在");
            }
        }
    %>
    <a href="login.jsp">返回</a>
</div>
</body>
</html>
