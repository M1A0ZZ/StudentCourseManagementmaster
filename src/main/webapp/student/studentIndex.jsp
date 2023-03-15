<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>学生</title>
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
<div id="hello">欢迎登录学生选课系统</div>
<div id="page">
    <div id="menu">
        <div id="name" class="info">姓名：${name}</div>
        <div id="no" class="info">学号：${no}</div>
        <div id="dept" class="info">院系：${dept}</div>
        <div id="page-list">
            <div class="page-list-item"><a href="javascript:changePage('/student/SCcenter.jsp')">选课中心</a></div>
            <div class="page-list-item"><a href="javascript:changePage('/student/mySC.jsp')">我的选课</a></div>
        </div>
    </div>
    <iframe id="myframe" src="/student/mySC.jsp"></iframe>
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

