<%@ page import="java.util.Objects" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户界面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
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

        /* 电脑的排列 */
        .column {
            float: left;
            padding: 10px;
        }

        .column.side {
            margin-left:20%;
            width: 20%;
        }

        .column.middle {
            width: 20%;
        }

        /* 链接 - 修改颜色 */
        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }



        /* 列后清除浮动 */
        .row:after {
            content: "";
            display: table;
            clear: both;
        }

        div.center {text-align: center;}

    </style>
</head>
<body>
<jsp:useBean class="com.xxx.mapper.custom_info" id="customer" scope="page"></jsp:useBean>

<div>
    <%--解析域名--%>
    <%
        String ht_pn= String.valueOf(request.getQueryString());
        if (Objects.equals(ht_pn,"null")){
            ht_pn="1";
        }
        int pagenum= Integer.parseInt(ht_pn);
        int total_page=6;
        String ID= (String) request.getSession().getAttribute("uname");
    %>
</div>

<div class="header">
    <h1>智能电脑零部件管理系统</h1>
    <p>笔记本</p>
</div>

<!--顶部导航条-->
<div class="topnav">
    <a href="#">笔记本</a>
    <a href="#">零件</a>
    <a href="custom_made.jsp">定制</a>
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
        <li><a href="user_modify.jsp">账号与安全</a></li>
    </ul>
</div>

<!--电脑信息与分页-->
<div>
    <%
        String outhtml="";
        //所有电脑信息
        outhtml=customer.get_all_com_image(pagenum);
        int temp=pagenum==1?1:pagenum-1;//上一页，若已经是1便继续是1
        outhtml+="<div class=\"center\"><ul class=\"pagination\"><li><a href=\"customer_view.jsp?"+temp+"\">《</a>";
        for(int i=1;i<total_page;i++){
            if (i!=pagenum){
                outhtml+="<li><a href=\"customer_view.jsp?"+i+"\">"+i+"</a></li>";//分页显示
            }
            else {
                outhtml+="<li><a class=\"active\" href=\"customer_view.jsp?"+i+"\">"+i+"</a></li>";//当前页高亮
            }
        }
        temp=pagenum+1;//下一页
        outhtml+="<li><a href=\"customer_view.jsp?"+temp+"\">》</a></li></ul></div>";
        out.println(outhtml);//填充html
    %>
</div>

</body>
</html>
