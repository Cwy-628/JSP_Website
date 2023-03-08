<%--
  Created by IntelliJ IDEA.
  User: ricky
  Date: 2022/4/29
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>车间</title>
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
        table.all{width: 80%;}
        td.red{color: red;}
        td.green{color: green;}
        th.line_1{
            width: 30%;
        }
        th.line_3{
            width: 40%;
        }
        table,th,td {
            border:1px solid black;
            text-align:center;
            font-size: 20px;
        }
        .header {text-align: center;
            font-size: 40px;
        }
        div.side{
            width: 30%;
            margin-left: 25%;
            margin-right: 1%;
            float: left;}
        div.mid{
            width: 30%;
            margin-left:1%;
            margin-right: 1%;
            float: left;}
        label.sty1{
            display:inline-block;
            min-width: 80px;}
        .form_control{
            display: inline;
        }
        button.s1{
            width: 80%;
            height: 6%;
        }
        .table_ {
            margin-top: 40px;
            margin-left: 10%;

        }

        .table_ table{
            width: 60%;
            margin-left:20%;
            font-size: 20px;
        }
        .table_ table,th,td
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

        .header h1 {
            font-size: 60px;
            font-family: "Georgia";

        }

        .blank {
            height: 43px;
            background-color: rgb(157, 184, 132);
        }
    </style>
</head>
<body>
<jsp:useBean class="com.xxx.mapper.controller_action" id="control" scope="page"></jsp:useBean>
<jsp:useBean class="com.xxx.mapper.computer_workshop" id="work" scope="page"></jsp:useBean>

    <%
        String ID= (String) request.getSession().getAttribute("uname");
        String house_name=request.getParameter("workhouse");
        String order_id=request.getParameter("order");
        String computer_id="";
        String computer_num="";
        if (order_id!=null&& !order_id.equals("")){
            computer_id=work.get_computer_id(order_id);
            computer_num= String.valueOf(work.get_order_computer_number(order_id));
        }
        else {
            computer_id=request.getParameter("com_id");
            computer_num=request.getParameter("com_num");
        }
        if (house_name!=null&& !house_name.equals("")){request.getSession().setAttribute("house_name",house_name);}
        else {house_name=(String) request.getSession().getAttribute("house_name");}
        String house_id=work.get_house_id(house_name);
        if (computer_num==null){
            computer_num="0";
        }
        String[][] info=work.list_component_num(computer_id, Integer.parseInt(computer_num),house_id);
        request.getSession().setAttribute("computer_id",computer_id);
        request.getSession().setAttribute("computer_num",computer_num);
    %>

    <div class="header">
        <h1>车间</h1>
    </div>
    <div class="blank"></div>
    <div class="row">
        <ul class="a1" id="test_2">
            <li><a href="controller_view.jsp" >返回主页</a></li>
            <li><a href="controller_orders.jsp?0">待接取的订单</a></li>
            <li><a href="controller_orders_unfinished.jsp">未完成的订单</a></li>
            <li><a href="controller_orders_finished.jsp">已完成的订单</a></li>
            <li><a href="#" class="active">车间</a></li>
            <li><a href="#">管理员：<%=control.get_controller_name(ID)%></a></li>
        </ul>
    </div>

    <script><!--每次改变后刷新-->
    function workhouse_submit(){
        document.getElementById("order").value=null
        document.workhouse_choose.submit();
    }
    </script>

    <script><!--每次改变后刷新-->
    function order_submit(){
        if (document.getElementById("workhouse").value===null){
            alert("请先选择仓库");
        }
        else{
            document.order_choose.submit();
        }
    }
    </script>

    <script>
        function check_submit(){
            document.order_choose.submit();
        }
    </script>
<div class="table_">
    <div class="side">
        <form action="workhouse.jsp" method="post" name="workhouse_choose" id="workhouse_choose">
            <label class="sty1" for="workhouse">选择车间：</label>
            <input onchange="workhouse_submit()" type="search" id="workhouse" name="workhouse" list="choose_1" placeholder="（ 选择 ）" class="form_control" autocomplete="on">
            <datalist id="choose_1">
                <%=work.get_all_workhouse(ID)%>
            </datalist>
            <%=work.get_house_component(ID,house_id)%>
        </form>
    </div>

    <div class="mid">
        <form action="workhouse.jsp" method="post" name="order_choose" id="order_choose">
            <label class="sty1" for="order">选择订单：</label>
            <input onchange="order_submit()" type="search" id="order" name="order" list="choose_2" placeholder="（ 选择 ）" class="form_control" autocomplete="on">
            <datalist id="choose_2">
                <%=work.get_all_custom_made_order(ID)%>
            </datalist><br/>
            <label class="sty1" for="com_id">选择电脑：</label>
            <input onchange="check_submit()" type="search" id="com_id" name="com_id" list="choose_3" placeholder="（ 选择 ）" class="form_control" autocomplete="on">
            <datalist id="choose_3">
                <%=work.get_all_computer_id()%>
            </datalist><br/>
            <label class="sty1" for="com_num">数量：</label>
            <input onchange="check_submit()" type="number" id="com_num" name="com_num" class="form_control">
        </form>
        <table class="all">
            <tr>
                <th class="line_1">类型</th>
                <th class="line_1">名称</th>
                <th class="line_3">数量</th>
            </tr>
            <tr>
                <td>主板</td>
                <%=info[0][0]%>
                <%=info[0][1]%>
            </tr>
            <tr>
                <td>cpu</td>
                <%=info[1][0]%>
                <%=info[1][1]%>
            </tr>
            <tr>
                <td>显卡</td>
                <%=info[2][0]%>
                <%=info[2][1]%>
            </tr>
            <tr>
                <td>内存</td>
                <%=info[3][0]%>
                <%=info[3][1]%>
            </tr>
            <tr>
                <td>显示器</td>
                <%=info[4][0]%>
                <%=info[4][1]%>
            </tr>
        </table>
        <form action="workhouse_build.jsp" method="post" id="order_build" name="order_build">
            <button class="s1" type="button" onclick="judge_store()">加工</button>
        </form>
    </div>

    <script>
        function judge_store(){
            var check_store="<%=work.judge_build_possibility(info)%>";
            var house_choice="<%=house_name%>";
            var computer_choice="<%=order_id%>";
            if (house_choice==="null"||computer_choice==="null"){
                alert("未选择完成");
            }
            else if (check_store==="0"){
                alert("库存不足");
            }
            else{
                document.order_build.submit();
            }
        }
    </script>

    <script>
        var house_choice="<%=house_name%>";
        var order_choice="<%=order_id%>";
        var compu_id="<%=computer_id%>";
        var compu_num="<%=computer_num%>";
        if (house_choice!=="null"){
            document.getElementById("workhouse").value=house_choice;
        }
        if (order_choice!=="null"){
            document.getElementById("order").value=order_choice;
            document.getElementById("com_id").value=compu_id;
            document.getElementById("com_num").value=compu_num;
        }
        else {
            if (compu_id !== "null") {
                document.getElementById("com_id").value = compu_id;
            }
            if (compu_num !== "null") {
                document.getElementById("com_num").value = compu_num;
            }
        }
    </script>
</div>
</body>
</html>
