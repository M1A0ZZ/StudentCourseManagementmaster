<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SC</title>
</head>
<style>
    tr{border:2px solid black;height: 10px;}
    td{border:2px solid black;width: 130px;height: 10px;text-align: center;}
    table{caption-side:bottom;border:2px solid black;}
</style>
<body>
<div id="data-frame">
    <table id="data-table">
        <tr id="head-row">
            <td>学号</td>
            <td>姓名</td>
            <td>课程号</td>
            <td>课程名</td>
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
    //加载数据
    function load()
    {
        idRecord = 1;
        console.log($('#data-table').html());
        var s='<table id="data-table">\
            <tr id="head-row">\
                <td>学号</td>\
                <td>课程号</td>\
                <td class="grade">成绩</td>\
                <td class="update_grade">修改栏</td>\
            </tr>\
        </table>';
        $('#data-table').replaceWith(s);

        //加载我已经选中的课程
        $.ajax({
            url: '/sc/findAll',
            method: 'get',
            contentType: "application/json;charset=utf-8",
            dataType:'text',
            success: function (res) {
                var map=JSON.parse(res);

                var trHTML="";
                for(var i=0;i<map.length;++i)
                {
                    trHTML+='<tr id="row-'+idRecord+'" class="data-row">'
                        + '<td>'+map[i].sno+'</td>'
                        + '<td>'+map[i].cno+'</td>'
                        + '<td id="grade-'+idRecord+'">'+map[i].grade+'</td>'
                        + '<td id="operator-'+idRecord+'">'
                        +'<a href="javascript:deleteLine('+idRecord+')">删除</a>&nbsp;'
                        +'<a href="javascript:updateGrade('+idRecord+')">修改</a></td></tr>'
                    ++idRecord;
                }
                $('#data-table').append(trHTML);
            }
        });
    }

    //删除数据
    function deleteLine(idSuffix){
        var ret=confirm("确定删除？")
        if(!ret)return;

        //如果该条数据保存过，则会有值
        var s=$('#row-'+idSuffix).html()
        // console.log('delete '+s);
        var sno=s.split('/')[0].split('>')[1].split('<')[0];
        var cno=s.split('/')[1].split('>')[2].split('<')[0];
        // console.log(sno+'=sno cno='+cno)
        $('#row-'+idSuffix).remove();


        var data={
            "Sno":sno,
            "Cno":cno
        };
        data=JSON.stringify(data);
        // ajax删除
        $.ajax({
            url:'/sc/delete',
            data:data,
            method:'post',
            contentType: "application/json;charset=utf-8",
            dataType:'text',
            success:function (res) {
                console.log(res);
            }
        })
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
        new_html='<td id="operator-'+idSuffix+'">'
            +'<a href="javascript:deleteLine('+idSuffix+')">删除</a>&nbsp;'
            +'<a href="javascript:updateGrade('+idSuffix+')">修改</a></td>'
        $('#operator-'+idSuffix).replaceWith(new_html);

        //ajax保存
        var s=$('#row-'+idSuffix).html()
        console.log('ajax save')
        console.log(s);
        var sno=s.split('/')[0].split('>')[1].split('<')[0];
        var cno=s.split('/')[1].split('>')[2].split('<')[0];
        var grade=s.split('/')[2].split('>')[2].split('<')[0];
        console.log(sno+'=sno cno='+cno+' grade='+grade);
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
