<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link rel=" stylesheet" type="text/css" href="/css/login.css">
</head>
<style>
    #status{
        font-size: 0px;
    }
</style>
<body>

<p id="status">${message}</p>
<div class="content">
    <div class="middle_column">
        <div class="zh_title">学生选课管理系统</div>
        <div class="en_title">Student Selection Management System</div>
        <div class="layui-form-item">
            <label class="layui-form-label">账号:</label>
            <span class="layui-input-block">
                <input value="1" type="text" name="username" id="username" lay-verify="required" lay-reqtext="用户名是必填项，岂能为空？" placeholder="学生请填写学号/老师填账号" autocomplete="off" class="layui-input account_input">
            </span>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码:</label>
            <span class="layui-input-block">
                <input value="1" type="password" name="password" id="password" lay-verify="required" lay-reqtext="密码是必填项，岂能为空？" placeholder="请输入账号密码" autocomplete="off" class="layui-input account_input">
            </span>
        </div>
        <div class="layui-form-item" pane="">
            <label class="layui-form-label role_title">账号权限:</label>
            <label class="layui-input-block" id="check_type">
                <input type="radio" class="role_input" name="type" value="1" title="学生"><span class="label">学生</span>
                <input type="radio" class="role_input" name="type" value="2" title="教师"><span class="label">教师</span>
                <input type="radio" class="role_input" name="type" value="3" title="管理员" checked><span class="label">管理员</span>
                <!--disabled=""-->
            </label>
        </div>
        <div class="sub_column">
            <button type="button" class="layui-btn layui-btn-lg" id="login_btn">登录</button>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script>
    $(document).ready(function(){
        $("#login_btn").click(function(){
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var check_type = $('#check_type input[name="type"]:checked ').val();
            var data;
            if(check_type=='1')
            {
                data = {
                    'Sno':username,
                    'Spassword': password
                };
            }
            else if(check_type=='2')
            {
                data = {
                    'Tno':username,
                    'Tpassword': password
                };
            }
            else
            {
                data = {
                    'Mno':username,
                    'Mpassword': password
                };
            }

            data = JSON.stringify(data);
            $.ajax({
                url: '1' == check_type ? '/student/login' : ('2' == check_type?'/teacher/login':'/manage/login'),
                method: 'post',
                data: data,
                contentType: "application/json;charset=utf-8",
                traditional: true,
                dataType: 'html',
                success: function (res) {
                    console.log(res);

                    //alert(typeof res);
                    document.write(res);
                    document.close();

                    //FIXME 此处而可能有点问题，如果res返回的不是登录界面，即登录成功了，是没有status这个id的
                    var s=$('#status').text();
                    if(s=='error')alert("账号或密码错误");
                }
            });
        });
    })

</script>
</html>