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
        String info_2=request.getParameter("search_2");
        double i=Double.parseDouble(request.getParameter("search_3"));
        com.insertcom(info_1,info_2,i);
        request.setAttribute("s","success");
        request.getRequestDispatcher("housecomputer.jsp").forward(request,response);
    %>
</div>
</body>
</html>
