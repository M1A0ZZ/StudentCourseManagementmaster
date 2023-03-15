<%--
  Created by IntelliJ IDEA.
  User: Airsk
  Date: 2022/11/20
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师</title>
</head>
<style>
    ul,ol{
        list-style-type: none;
    }
    #hello{
        font-size:xx-large;
        font-weight: bold;
        text-align: center;
        margin: 8px 0;
    }
    #menu{
        width: 180px;
        float: left;
    }
    .info{
        text-align: center;
    }
    #page-list{
        /* background-color: aqua; */
    }
    .page-list-item{
        height: 20px;
        margin-top: 5px;
        text-align: center;
        /* border: black solid 2px; */
    }
    #myframe{
        width: 1300px;
        height: 700px;
        float: left;
        border-width: 2px;
    }
</style>
<body >
<div id="hello">欢迎登录教师系统</div>
<div id="page">
    <div id="menu">
        <div id="name" class="info">姓名：${name}</div>
        <div id="no" class="info">工号：${no}</div>
        <div id="dept" class="info">院系：${dept}</div>
        <div id="page-list">
            <div class="page-list-item"><a href="javascript:changePage('/teacher/myStudent.jsp')">我的学生</a></div>
        </div>
    </div>
    <iframe id="myframe" src="/teacher/myStudent.jsp"></iframe>
</div>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script>
    $(document).ready(function(){

    })
</script>
</html>
<script type="application/javascript">
    function changePage(page) {
        $('#myframe').remove();
        $('#page').append('<iframe id="myframe" src="'+page+'"></iframe>');
    }
</script>
