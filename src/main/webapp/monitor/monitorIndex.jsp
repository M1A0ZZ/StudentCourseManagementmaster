<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8"/>
    <title>首页</title>
</head>
<style>
    ul,ol{
        list-style-type: none;
    }
    #menu{
        float: left;
    }
    .menu-item{
        height: 30px;
        width: 100px;
        margin: 5px;
        text-align: center;
    }
    #myframe{
        width: 1300px;
        height: 700px;
        float: left;
        border-width: 2px;
    }
</style>
<body >
<div id="page">
    <ul id="menu">
        <li class="menu-item"><a href="javascript:changePage('/monitor/teacherManage.jsp')">教师管理</a></li>
        <li class="menu-item"><a href="javascript:changePage('/monitor/studentManage.jsp')">学生管理</a></li>
        <li class="menu-item"><a href="javascript:changePage('/monitor/courseManage.jsp')">课程管理</a></li>
        <li class="menu-item"><a href="javascript:changePage('/monitor/SCManage.jsp')">选课管理</a></li>
    </ul>
    <iframe id="myframe" src="/monitor/teacherManage.jsp"></iframe>
</div>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.js"></script>
</html>

<script type="application/javascript">
    function changePage(page) {
        $('#myframe').remove();
        $('#page').append('<iframe id="myframe" src="'+page+'"></iframe>');
    }
</script>