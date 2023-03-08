<%--
  Created by IntelliJ IDEA.
  User: ricky
  Date: 2022/4/10
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>定制界面</title>
    <style>
        input{
            margin-top: 2px;
            margin-bottom: 2px;
            width: 28%;
            height: 6%;
            font-size: 25px;
        }
        .form_control{
            display: inline;
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

        ul.pagination {
            display: inline-block;
            padding: 0;
            margin: 0;
        }

        ul.pagination li {display: inline;}

        ul.pagination li a {
            color: black;
            float: left;
            padding: 8px 16px;
            text-decoration: none;
            transition: background-color .3s;
        }
        li a {
            display: block;
            color: #000;
            padding: 8px 16px;
            text-decoration: none;
        }

        li a.active {
            background-color: #4CAF50;
            color: white;
        }

        li a:hover:not(.active) {
            background-color: #555;
            color: white;
        }
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
        }

        /* 头部样式 */
        .header {
            background-color: #f1f1f1;
            padding: 10px;
            text-align: center;
        }

        /* 导航条 */
        .topnav {
            overflow: hidden;
            background-color: #333;
        }

        /* 导航链接 */
        .topnav a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        /* 链接 - 修改颜色 */
        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }
        .row:after {
            content: "";
            display: table;
            clear: both;
        }
        table{
            width: 40%;
        }
        th.line_1{
            width: 15%;
        }
        th.line_3{
            width: 30%;
        }
        table,th,td
        {
            border:1px solid black;
            text-align:center;
        }
        button.s1
        {
            font-size: 30px;
            margin-top: 10px;
            width: 40%;
            height: 7%;
        }
        button.s2
        {
            font-size: 30px;
            width: 40%;
            height: 7%;
        }
        .dropdown {
            position: relative;
            display: inline-block;
        }
        .dropdown-content {
            top:-20%;
            left: 110%;
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            padding: 10px 16px;
        }
        .dropdown:hover .dropdown-content {
            display: block;
        }

        label.sty1{
            display:inline-block;
            min-width: 150px;
            min-height: 50px;
            font-size: 30px;
        }
        div.center {text-align: center;}
        div.side{margin-left:35%;}
        datalist.side{margin-left:35%;}
    </style>
</head>
<body>
<jsp:useBean class="com.xxx.mapper.made_computer" id="made" scope="page"></jsp:useBean>
<jsp:useBean class="com.xxx.mapper.custom_info" id="customer" scope="page"></jsp:useBean>


    <div>
        <%
            String ID= (String) request.getSession().getAttribute("uname");
            String made_name=request.getParameter("made_name");
            String info_1=request.getParameter("search_1");
            String info_2=request.getParameter("search_2");
            String info_3=request.getParameter("search_3");
            String info_4=request.getParameter("search_4");
            String info_5=request.getParameter("search_5");
            int price_1=made.get_component_price(info_1);
            int price_2=made.get_component_price(info_2);
            int price_3=made.get_component_price(info_3);
            int price_4=made.get_component_price(info_4);
            int price_5=made.get_component_price(info_5);
        %>
    </div>

    <div class="header">
        <h1>智能电脑零部件管理系统</h1>
        <p>定制</p>
    </div>

    <!--顶部导航条-->
    <div class="topnav">
        <a href="customer_view.jsp">笔记本</a>
        <a href="#">零件</a>
        <a href="#">定制</a>
        <li style="float:right"><a href="#">用户：<%=customer.get_customer_name(ID)%></a></li>
        <li style="float:right"><a href="customer_orders.jsp">我的订单</a></li>
    </div>

    <!--侧边栏-->
    <div class="row">
        <ul class="a1" id="test_2">
            <li><a class="active" href="#">主页</a></li>
            <li><a href="news.jsp">新闻</a></li>
            <li><a href="#">联系</a></li>
            <li><a href="#">关于</a></li>
            <li><a href="#">账号与安全</a></li>
        </ul>
    </div>

    <script><!--每次改变后刷新-->
        function change_submit(){
            document.computer_check.submit();
        }
    </script>

    <div class="side">
        <form action="custom_made.jsp" name="computer_check" id="computer_check" method="post">
            <label class="sty1" for="made_name">名称：</label><input onchange="change_submit()" value="mycomputer" type="text" id="made_name" name="made_name" autocomplete="off"><br/>
            <label class="sty1" for="search_1">主板：</label><input onchange="change_submit()" type="search" list="typelist1" name="search_1" id="search_1" placeholder="（ 选择 ）" class="form_control" autocomplete="on">
        <datalist id="typelist1" class="side"><!--下拉选择-->
            　　<%=made.get_mainbord_component()%>
        </datalist>
            <div class="dropdown"><!--鼠标移动上去后显示简介-->
                <p>详情</p>
                <div class="dropdown-content">
                    <p><%=customer.get_component_brief(info_1)%></p>
                </div>
            </div><br/>
            <label class="sty1" for="search_2">cpu：</label><input onchange="change_submit()" type="search" list="typelist2" name="search_2" id="search_2" placeholder="（ 选择 ）" class="form_control" autocomplete="on">
        <datalist id="typelist2" class="side">
            　　<%=made.get_cpu_component()%>
        </datalist>
            <div class="dropdown">
                <p>详情</p>
                <div class="dropdown-content">
                    <p><%=customer.get_component_brief(info_2)%></p>
                </div>
            </div><br/>
            <label class="sty1" for="search_3">内存：</label><input onchange="change_submit()" type="search" list="typelist3" name="search_3" id="search_3" placeholder="（ 选择 ）" class="form_control" autocomplete="on">
        <datalist id="typelist3" class="side">
            　　<%=made.get_memory_component()%>
        </datalist>
            <div class="dropdown">
                <p>详情</p>
                <div class="dropdown-content">
                    <p><%=customer.get_component_brief(info_3)%></p>
                </div>
            </div><br/>
            <label class="sty1" for="search_4">显卡：</label><input onchange="change_submit()" type="search" list="typelist4" name="search_4" id="search_4" placeholder="（ 选择 ）" class="form_control" autocomplete="on">
        <datalist id="typelist4" class="side">
            　　<%=made.get_gpu_component()%>
        </datalist>
            <div class="dropdown">
                <p>详情</p>
                <div class="dropdown-content">
                    <p><%=customer.get_component_brief(info_4)%></p>
                </div>
            </div><br/>
            <label class="sty1" for="search_5">显示器：</label><input onchange="change_submit()" type="search" list="typelist5" name="search_5" id="search_5" placeholder="（ 选择 ）" class="form_control" autocomplete="on">
        <datalist id="typelist5" class="side">
            　　<%=made.get_screen_component()%>
        </datalist>
            <div class="dropdown">
                <p>详情</p>
                <div class="dropdown-content">
                    <p><%=customer.get_component_brief(info_5)%></p>
                </div>
            </div><br/>
        <button class="s1" type="button" id="full_button" onclick="auto_complete()">自动填充</button><br/><br/>
        <table id="sum_info">
            <tr>
                <th class="line_1">类型</th>
                <th>名称</th>
                <th class="line_3">价格</th>
            </tr>
            <tr>
                <td>主板</td>
                <td><%=info_1%></td>
                <td><%=price_1%></td>
            </tr>
            <tr>
                <td>cpu</td>
                <td><%=info_2%></td>
                <td><%=price_2%></td>
            </tr>
            <tr>
                <td>内存</td>
                <td><%=info_3%></td>
                <td><%=price_3%></td>
            </tr>
            <tr>
                <td>显卡</td>
                <td><%=info_4%></td>
                <td><%=price_4%></td>
            </tr>
            <tr>
                <td>显示器</td>
                <td><%=info_5%></td>
                <td><%=price_5%></td>
            </tr>
            <tr>
                <td>统计</td>
                <td><%=made_name%></td>
                <td><%=price_1+price_2+price_3+price_4+price_5%></td>
            </tr>
        </table><br/>
        <input type="hidden" id="total_price" name="total_price">
        <button class="s2" type="button" id="create_button">下单</button>
        </form>
    </div>

    <script>
        function auto_complete(){
            if ($("#search_2").val()!==""){
                if ($("#search_1").val()===""){
                    document.getElementById("search_1").value="<%=made.get_auto_mainboard()%>";
                }
                if ($("#search_3").val()===""){
                    document.getElementById("search_3").value="<%=made.get_auto_memory()%>";
                }
                if ($("#search_4").val()===""){
                    document.getElementById("search_4").value="<%=made.get_auto_gpu()%>";
                }
                if ($("#search_5").val()===""){
                    document.getElementById("search_5").value="<%=made.get_auto_screen()%>";
                }
                document.computer_check.submit();
            }
            else{
                alert("请先选择cpu");
            }
        }
    </script>

    <!--数据回填-->
    <script>
    {
        var made_name="<%=made_name%>";
        var info_1="<%=info_1%>";
        var info_2="<%=info_2%>";
        var info_3="<%=info_3%>";
        var info_4="<%=info_4%>";
        var info_5="<%=info_5%>";
        if (made_name!=="null"){
            document.getElementById("made_name").value=made_name;
        }
        if (info_1!=="null"){
            document.getElementById("search_1").value=info_1;
        }
        if (info_2!=="null"){
            document.getElementById("search_2").value=info_2;
        }
        if (info_3!=="null"){
            document.getElementById("search_3").value=info_3;
        }
        if (info_4!=="null"){
            document.getElementById("search_4").value=info_4;
        }
        if (info_5!=="null"){
            document.getElementById("search_5").value=info_5;
        }
        document.getElementById("total_price").value=<%=price_1+price_2+price_3+price_4+price_5%>;
    }
    </script>

</body>
<!--下单检查-->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
    $("#create_button").click(function (){
        const s1=$("#search_1").val();
        const s2=$("#search_2").val();
        const s3=$("#search_3").val();
        const s4=$("#search_4").val();
        const s5=$("#search_5").val();
        if (s1 === "") {
            alert("主板不可为空");
            return;
        }
        else if (s2 === "") {
            alert("cpu不可为空");
            return;
        }
        else if (s3 === "") {
            alert("内存不可为空");
            return;
        }
        else if (s4 === "") {
            alert("显卡不可为空");
            return;
        }
        else if (s5 === "") {
            alert("显示屏不可为空");
            return;
        }
        document.computer_check.action="custom_made_check.jsp";
        $("#computer_check").submit();
    });
</script>
</html>
