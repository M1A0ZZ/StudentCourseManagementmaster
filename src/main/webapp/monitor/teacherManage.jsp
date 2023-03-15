
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="zh" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8"/>
    <title>教师管理</title>
    <link href="/css/index.css" type="text/css" rel="stylesheet"/>
</head>
<style>
    div{margin: 10px;}
    tr{border:2px solid black;height: 10px;}
    td{border:2px solid black;width: 130px;height: 10px;text-align: center;}
    table{caption-side:bottom;border:2px solid black;}

    #data-frame{border-width: 20px;border-color: pink;}
    #data-table{position: relative;left: 200px;}
    #teacher-name,#age-range{width: 90px;}
    .func-block{
        border: black solid 2px;
        padding: 4px;
        margin-right: 5px;
    }
    select{
        text-align: center;
    }
</style>
<body>
<!--
    #func
        .func-block
            #find-all
            #teacher-name #teacher-name-submit
            #find-by-cond #finnd-by-sex #find-by-dept
    #data-frame
        #data-table
            #head-row
            .data-row
                #row'+idRecord'
                #operate-'+idRecord'
-->

<h1>教师管理</h1>
<hr>
<div id="func">
        <span class="func-block">
            查询全部：<input id="find-all" type="button" value="检索">
        </span>
    <span class="func-block">
            按姓名查询：<input id="teacher-name" maxlength="6" type="text">
            <label><input id="teacher-name-submit" type="button" value="提交"></label>
        </span>
    <span class="func-block">
            按条件查询：
            <select id="find-by-dept">
                <option selected value="全部">全部院系</option>
                <option value="计算机科学与技术">计算机科学与技术</option>
                <option value="工商管理">工商管理</option>
                <option value="信息管理">信息管理</option>
                <option value="后勤">后勤</option>
            </select>
            <select id="find-by-sex">
                <option value="全部">全部性别</option>
                <option value="男">男</option>
                <option value="女">女</option>
            </select>
            <input id="find-by-cond" type="button" value="检索">
        </span>
</div>
<div id="data-frame">
    <table id="data-table">
        <tr id="head-row">
            <td>姓名</td>
            <td>工号</td>
            <td>登录密码</td>
            <td>年龄</td>
            <td>性别</td>
            <td>院系</td>
            <td><a href="javascript:void(0)" id="add-line">新增</a></td>
        </tr>
    </table>
</div>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script>
    //alert("ready");
    // var s='<tr id="row-'+1+'">'
    //     + '<td>'+'tname'+'</td>'
    //     + '<td>'+'tno'+'</td>'
    //     + '<td>'+'tpassword'+'</td>'
    //     + '<td>'+'tage'+'</td>'
    //     + '<td>'+'tsex'+'</td>'
    //     + '<td>'+'tdept'+'</td>'
    //     + '<td><span id="operate-'+1+'">'
    //     +'<a href="javascript:deleteLine('+1+')">删除</a>&nbsp;'
    //     +'<a href="javascript:updateLine('+1+')">修改</a></span></td></tr>';
    // $('#data-table').append(s);
    $(document).ready(function(){
        //加载所有教师的数据
        $.ajax({
            url: '/teacher/getAll',
            method: 'get',
            dataType: 'text',
            success: function (res) {
                var map=JSON.parse(res);

                var trHTML;
                for(var i=0;i<map.length;++i)
                {
                    trHTML+='<tr id="row-'+idRecord+'" class="data-row">'
                        + '<td>'+map[i].tname+'</td>'
                        + '<td>'+map[i].tno+'</td>'
                        + '<td>'+map[i].tpassword+'</td>'
                        + '<td>'+map[i].tage+'</td>'
                        + '<td>'+map[i].tsex+'</td>'
                        + '<td>'+map[i].tdept+'</td>'
                        + '<td><span id="operate-'+idRecord+'">'
                        +'<a href="javascript:deleteLine('+idRecord+')">删除</a>&nbsp;'
                        +'<a href="javascript:updateLine('+idRecord+')">修改</a></span></td></tr>';
                    ++idRecord;
                }
                $('#data-table').append(trHTML);
            }
        })
    })
</script>
</html>
<script type="application/javascript">
    $('#find-all').click(function(){
        //加载所有教师的数据
        $.ajax({
            url: '/teacher/getAll',
            method: 'get',
            dataType: 'text',
            success: function (res) {
                //先清空data-table里面的tr标签
                $('.data-row').remove();

                //再加载相关数据
                var map=JSON.parse(res);
                console.log(map)
                var trHTML="";
                for(var i=0;i<map.length;++i)
                {
                    trHTML+='<tr id="row-'+idRecord+'" class="data-row">'
                        + '<td>'+map[i].tname+'</td>'
                        + '<td>'+map[i].tno+'</td>'
                        + '<td>'+map[i].tpassword+'</td>'
                        + '<td>'+map[i].tage+'</td>'
                        + '<td>'+map[i].tsex+'</td>'
                        + '<td>'+map[i].tdept+'</td>'
                        + '<td><span id="operate-'+idRecord+'">'
                        +'<a href="javascript:deleteLine('+idRecord+')">删除</a>&nbsp;'
                        +'<a href="javascript:updateLine('+idRecord+')">修改</a></span></td></tr>';
                    ++idRecord;
                }
                $('#data-table').append(trHTML);
            }
        })
    })
    $('#teacher-name-submit').click(function(){
        var data={'Tname':$('#teacher-name').val()};
        data=JSON.stringify(data);
        $.ajax({
            url:'/teacher/getTeacherName',
            method:'post',
            dataType:'text',
            contentType: "application/json;charset=utf-8",
            data:data,
            success:function(res){
                console.log("getTeacherName");
                var map=JSON.parse(res);
                console.log(res);
                console.log(map);
                //先清空data-table里面的tr标签
                $('.data-row').remove();

                var trHTML="";
                for(var i=0;i<map.length;++i)
                {
                    trHTML+='<tr id="row-'+idRecord+'" class="data-row">'
                        + '<td>'+map[i].tname+'</td>'
                        + '<td>'+map[i].tno+'</td>'
                        + '<td>'+map[i].tpassword+'</td>'
                        + '<td>'+map[i].tage+'</td>'
                        + '<td>'+map[i].tsex+'</td>'
                        + '<td>'+map[i].tdept+'</td>'
                        + '<td><span id="operate-'+idRecord+'">'
                        +'<a href="javascript:deleteLine('+idRecord+')">删除</a>&nbsp;'
                        +'<a href="javascript:updateLine('+idRecord+')">修改</a></span></td></tr>';
                    ++idRecord;
                }
                $('#data-table').append(trHTML);
            }
        })
    })
    $('#find-by-cond').click(function () {
        console.log("find-by-condition");
        var data={};
        var dept=$('#find-by-dept option:selected').attr('value');
        var sex=$('#find-by-sex option:selected').attr('value');
        if(dept!='全部')
        {
            //data.append({'tdept':dept});
            data['tdept']=dept;
        }
        if(sex!='全部')
        {
            //data.append({'tsex':sex});
            data['tsex']=sex;
        }
        data=JSON.stringify(data);
        console.log(data);
        $.ajax({
            url:'/teacher/findByCond',
            data:data,
            method:'post',
            dataType:'text',
            contentType: "application/json;charset=utf-8",
            success:function(res){
                console.log(res);
                var map=JSON.parse(res);
                //先清空data-table里面的tr标签
                $('.data-row').remove();

                var trHTML="";
                for(var i=0;i<map.length;++i)
                {
                    trHTML+='<tr id="row-'+idRecord+'" class="data-row">'
                        + '<td>'+map[i].tname+'</td>'
                        + '<td>'+map[i].tno+'</td>'
                        + '<td>'+map[i].tpassword+'</td>'
                        + '<td>'+map[i].tage+'</td>'
                        + '<td>'+map[i].tsex+'</td>'
                        + '<td>'+map[i].tdept+'</td>'
                        + '<td><span id="operate-'+idRecord+'">'
                        +'<a href="javascript:deleteLine('+idRecord+')">删除</a>&nbsp;'
                        +'<a href="javascript:updateLine('+idRecord+')">修改</a></span></td></tr>';
                    ++idRecord;
                }
                $('#data-table').append(trHTML);

            }
        })
    })
</script>
<script type="application/javascript">

    var idRecord = 1;
    //添加行
    $('#add-line').click(function(){
        var trHtml = '<tr id="row-'+idRecord+'" class="data-row">'
            + '<td><input style="text-align: center;width: 110px" id="name-'+idRecord+'" type="text"></td>'
            + '<td><input style="text-align: center;width: 110px" id="id-'+idRecord+'" type="text"></td>'
            + '<td><input style="text-align: center;width: 110px" id="password-'+idRecord+'" type="text"></td>'
            + '<td><input style="text-align: center;width: 110px" id="age-'+idRecord+'" type="text"></td>'
            + '<td><input style="text-align: center;width: 110px" id="sex-'+idRecord+'" type="text"></td>'
            + '<td><input style="text-align: center;width: 110px" id="dept-'+idRecord+'" type="text"></td>'
            + '<td><span id="operate-'+idRecord+'">'
            +'<a href="javascript:deleteLine('+idRecord+')">删除</a>&nbsp;'
            + '<a href="javascript:saveLine('+idRecord+')">保存</a></span></td>';
        $('#data-table').append(trHtml);
        idRecord++;
    });

    function updateLine(idSuffix){
        //计算原位置上的值并将其替换为 input(type=text)
        var s=$('#row-'+idSuffix).html().split('>');
        var arr=[];
        for(var i=0;i<s.length;++i)
        {
            arr=arr.concat(s[i].split('<'));
        }
        console.log(arr);//2 6 10 14 18 22
        var vals=[arr[2],arr[6],arr[10],arr[14],arr[18],arr[22]];
        console.log(vals)

        var trHtml = '<tr id="row-'+idSuffix+'" class="data-row">'
            + '<td><input style="text-align: center;width: 110px" id="name-'+idSuffix+'" type="text" value='+vals[0]+'></td>'
            + '<td id="id-'+idSuffix+'">'+vals[1]+'</td>'
            + '<td><input style="text-align: center;width: 110px" id="password-'+idSuffix+'" type="text" value='+vals[2]+'></td>'
            + '<td><input style="text-align: center;width: 110px" id="age-'+idSuffix+'" type="text" value='+vals[3]+'></td>'
            + '<td><input style="text-align: center;width: 110px" id="sex-'+idSuffix+'" type="text" value='+vals[4]+'></td>'
            + '<td><input style="text-align: center;width: 110px" id="dept-'+idSuffix+'" type="text" value='+vals[5]+'></td>'
            + '<td><span id="operate-'+idSuffix+'">'
            +'<a href="javascript:deleteLine('+idSuffix+')">删除</a>&nbsp;'
            + '<a href="javascript:saveUpdate('+idSuffix+')">保存</a></span></td>';
        $('#row-'+idSuffix).replaceWith(trHtml);
    }

    function saveUpdate(idSuffix)
    {
        var id = $('#id-' + idSuffix).text();
        var name = $('#name-' + idSuffix).val();
        var sex = $('#sex-' + idSuffix).val();
        var password=$('#password-'+idSuffix).val();
        var dept = $('#dept-' + idSuffix).val();
        var age = $('#age-' + idSuffix).val();
        var entity = {
            'Tno': id,
            'Tname': name,
            'Tsex': sex,
            'Tpassword':password,
            'Tdept':dept,
            'Tage':age
        }
        //ajax保存
        // TODO 保存时需要先看一下数据库里是否有与要保存的内容有冲突的部分(id冲突)
        entity=JSON.stringify(entity);
        $.ajax({
            url:'/teacher/update',
            method:'post',
            data:entity,
            contentType: "application/json;charset=utf-8",
            dataType:'text',
            traditional: true,
            success:function(res){
                //
            }
        })

        //保存成功后
        //$('#id-' + idSuffix).replaceWith(id);
        $('#name-' + idSuffix).replaceWith(name);
        $('#password-' + idSuffix).replaceWith(password);
        $('#sex-' + idSuffix).replaceWith(sex);
        $('#dept-' + idSuffix).replaceWith(dept);
        $('#age-' + idSuffix).replaceWith(age);
        //操作列去掉保存按钮
        var fbtn='<span id="operate-'+idSuffix+'">'
            +'<a href="javascript:deleteLine('+idSuffix+')">删除</a>&nbsp;'
            +'<a href="javascript:updateLine('+idSuffix+')">修改</a></span>';
        $('#operate-' + idSuffix).replaceWith(fbtn);

        //保存后把主键返回设置成tr的value，此处是我随意够造的字符串
        $('#row-' + idSuffix).prop("value", "id" + idSuffix);
    }


    //删除非后台加载的数据
    function deleteLine(idSuffix){
        var ret=confirm("确定删除？")
        if(!ret)return;

        //如果该条数据保存过，则会有值
        var s=$('#row-'+idSuffix).html()
        var no=s.split('/')[1].split('>')[2].split('<')[0]
        $('#row-'+idSuffix).remove();


        //ajax删除
        $.ajax({
            url:'/teacher/delete',
            data:no,
            method:'post',
            contentType: "application/json;charset=utf-8",
            dataType:'text',
            success:function (res) {
                //alert(res);
            }
        })
    }

    //保存行
    function saveLine(idSuffix){
        var id = $('#id-' + idSuffix).val();
        var name = $('#name-' + idSuffix).val();
        var sex = $('#sex-' + idSuffix).val();
        var password=$('#password-'+idSuffix).val();
        var dept = $('#dept-' + idSuffix).val();
        var age = $('#age-' + idSuffix).val();
        var entity = {
            'Tno': id,
            'Tname': name,
            'Tsex': sex,
            'Tpassword':password,
            'Tdept':dept,
            'Tage':age
        }
        //ajax保存
        // TODO 保存时需要先看一下数据库里是否有与要保存的内容有冲突的部分(id冲突)
        entity=JSON.stringify(entity);
        $.ajax({
            url:'/teacher/save',
            method:'post',
            data:entity,
            contentType: "application/json;charset=utf-8",
            dataType:'text',
            traditional: true,
            success:function(res){
                //
            }
        })

        //保存成功后
        $('#id-' + idSuffix).replaceWith(id);
        $('#name-' + idSuffix).replaceWith(name);
        $('#password-' + idSuffix).replaceWith(password);
        $('#sex-' + idSuffix).replaceWith(sex);
        $('#dept-' + idSuffix).replaceWith(dept);
        $('#age-' + idSuffix).replaceWith(age);
        //操作列去掉保存按钮
        var fbtn='<span id="operate-'+idSuffix+'">'
            +'<a href="javascript:deleteLine('+idSuffix+')">删除</a>&nbsp;'
            +'<a href="javascript:updateLine('+idSuffix+')">修改</a></span>';
        $('#operate-' + idSuffix).replaceWith(fbtn);

        //保存后把主键返回设置成tr的value，此处是我随意够造的字符串
        $('#row-' + idSuffix).prop("value", "id" + idSuffix);
    }
</script>