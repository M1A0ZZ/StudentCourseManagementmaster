<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的学生</title>
</head>
<style>
    tr{border:2px solid black;height: 10px;}
    td{border:2px solid black;width: 130px;height: 10px;text-align: center;}
    table{caption-side:bottom;border:2px solid black;}
    /*.age,.sex,.grade,.update_grade{*/
    /*    width: 80px;*/
    /*}*/
</style>
<body>
<div id="data-frame">
    <table id="data-table">
        <tr id="head-row">
            <td>学号</td>
            <td>姓名</td>
            <td>课程号</td>
            <td>课程名</td>
            <td>院系</td>
            <td class="sex">性别</td>
            <td class="age">年龄</td>
            <td class="grade">成绩</td>
            <td class="update_grade">修改栏</td>
        </tr>
    </table>
</div>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script>
    $(document).ready(function(){
        load();
    })
</script>
<script type="application/javascript">
    var idRecord = 1;
    function load()
    {
        idRecord = 1;
        console.log($('#data-table').html());
        var s='<table id="data-table">\
            <tr id="head-row">\
                <td>学号</td>\
                <td>姓名</td>\
                <td>课程号</td>\
                <td>课程名</td>\
                <td>院系</td>\
                <td class="sex">性别</td>\
                <td class="age">年龄</td>\
                <td class="grade">成绩</td>\
                <td class="update_grade">修改栏</td>\
            </tr>\
        </table>';
        $('#data-table').replaceWith(s);

        // jsp中iframe在子页面和父页面之间传值
        var no=parent.window.$("#no").text().split('：')[1];
        //加载我已经选中的课程
        $.ajax({
            url: '/teacher/myStudent',
            method: 'post',
            data:no,
            contentType: "application/json;charset=utf-8",
            dataType:'text',
            success: function (res) {
                var map=JSON.parse(res);
                console.log(res.split('}'));

                var trHTML="";
                for(var i=0;i<map.length;++i)
                {
                    trHTML+='<tr id="row-'+idRecord+'" class="data-row">'
                        + '<td>'+map[i].Sno+'</td>'
                        + '<td>'+map[i].Sname+'</td>'
                        + '<td>'+map[i].Cno+'</td>'
                        + '<td>'+map[i].Cname+'</td>'
                        + '<td>'+map[i].Ssex+'</td>'
                        + '<td>'+map[i].Sage+'</td>'
                        + '<td>'+map[i].Sdept+'</td>'
                        + '<td id="grade-'+idRecord+'">'+map[i].Grade+'</td>'
                        + '<td id="operator-'+idRecord+'"><a href="javascript:updateGrade('+idRecord+')">修改成绩</a></td></tr>'
                    ++idRecord;
                }
                $('#data-table').append(trHTML);
            }
        });
    }
    function updateGrade(idSuffix) {
        var new_html='<td id="grade-'+idSuffix+'"><input id="new-grade-'+idSuffix+'" type="text"></td>';
        $('#grade-'+idSuffix).replaceWith(new_html);
        new_html='<td id="operator-'+idSuffix+'"><a href="javascript:saveGrade('+idSuffix+')">保存</a></td>'
        $('#operator-'+idSuffix).replaceWith(new_html);
    }
    function saveGrade(idSuffix) {
        var new_html='<td id="grade-'+idSuffix+'">'+$('#new-grade-'+idSuffix).val()+'</td>';
        $('#grade-'+idSuffix).replaceWith(new_html);
        new_html='<td id="operator-'+idSuffix+'"><a href="javascript:updateGrade('+idSuffix+')">修改成绩</a></td>'
        $('#operator-'+idSuffix).replaceWith(new_html);

        //ajax保存
        var s=$('#row-'+idSuffix).html()
        console.log('ajax save')
        s=s.split('>');
        var arr=[];
        for(var i=0;i<s.length;++i)
        {
            arr.push(s[i].split('<'))
        }
        var sno=arr[1][0];
        var cno=arr[5][0];
        var grade=arr[15][0];
        console.log(arr)
        console.log(sno+'+'+cno);
        var data={
            'Sno':sno,
            'Cno':cno,
            'Grade':grade
        };
        data=JSON.stringify(data);
        $.ajax({
            url:'/sc/update',
            method:'post',
            data:data,
            contentType: "application/json;charset=utf-8",
            dataType:'text',
            success:function (res) {
                console.log(res);
            }
        })
    }


</script>
</html>
