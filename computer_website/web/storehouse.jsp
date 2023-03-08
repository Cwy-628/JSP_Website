<%--
  Created by IntelliJ IDEA.
  User: ricky
  Date: 2022/5/9
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        ul.a1{
            list-style-type: none;
            margin: 0;
            padding: 0;
            width: 20%;
            background-color: #f1f1f1;
            position: fixed;
            height: 100%;
            overflow: auto;
        }
        li a {
            display: block;
            color: #000;
            padding: 8px 16px;
            text-decoration: none;
            font-size: 30px;
        }

        li a.active {
            background-color: #4CAF50;
            color: white;
        }

        li a:hover:not(.active) {
            background-color: #555;
            color: white;
        }
        .select_choice {
            margin-left:20%;
        }
        table{
            font-size: 20px;
            width: 60%;
            margin-left:20%;
        }
        table,th,td
        {
            border:1px solid black;
            text-align:center;
        }
        .header {
            height: 150px;
            line-height: 160px;
            text-align: center;
            background-color: rgb(247, 246, 246);
        }
        table.side{
            width: 30%;
            margin-left: 25%;
            margin-right: 1%;
            float: left;}
        table.mid{
            width: 25%;
            margin-left:1%;
            margin-right: 1%;
            float: left;}

        .blank {
            height: 43px;
            background-color: rgb(157, 184, 132);
        }
    </style>
    <title>仓库管理</title>
</head>
<body>
<jsp:useBean class="com.xxx.mapper.controller_action" id="control" scope="page"></jsp:useBean>
<jsp:useBean class="com.xxx.mapper.computer_workshop" id="work" scope="page"></jsp:useBean>

<!--获取管理员id
    若直接从此页面进入则无法获取，无法对订单操作-->
<div>
    <%
        String ID=(String) request.getSession().getAttribute("uname");
        String house_name=request.getParameter("storehouse");
        String house_id=work.get_house_id(house_name);
        if (house_id!=null){
            request.getSession().setAttribute("house_id",house_id);
        }
    %>
</div>

<!--标题-->
<div class="header">
    <h1>仓库管理</h1>
</div>
<div class="blank"></div>
<!--侧边栏-->
<div class="row">
    <ul class="a1" id="test_2">
        <li><a href="controller_view.jsp" >返回主页</a></li>
        <li><a href="insertcomponenthouse.jsp">增加零件类型</a></li>
        <li><a href="deletehouse.jsp">删除零件类型</a></li>
        <li><a href="inserthousecom.jsp">增加电脑类型</a></li>
        <li><a href="deletehouse.jsp">删除电脑类型</a></li>
        <li><a href="#">管理员：<%=control.get_controller_name(ID)%></a></li>
    </ul>
</div>


<script>
    function storehouse_submit(){
        document.storehouse_choose.submit();
    }
</script>

    <form action="storehouse.jsp" method="post" name="storehouse_choose" id="storehouse_choose">
        <label class="sty1" for="storehouse">选择仓库：</label>
        <input onchange="storehouse_submit()" type="search" id="storehouse" name="storehouse" list="choose_1" placeholder="（ 选择 ）" class="form_control" autocomplete="on">
        <datalist id="choose_1">
            <%=control.get_controlled_house(ID)%>
        </datalist>
        <%=control.get_house_component(ID,house_id)%>
        <%=control.get_house_computer(ID,house_id)%>
    </form>

<script>
    var house_choice="<%=house_name%>";
    if (house_choice!=="null"){
        document.getElementById("storehouse").value=house_choice;
    }
</script>


</body>
</html>
