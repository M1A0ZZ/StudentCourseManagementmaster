
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Course</title>
</head>
<style>
    div{margin: 10px;}
    tr{border:2px solid black;height: 10px;}
    td{border:2px solid black;width: 130px;height: 10px;text-align: center;}
    table{caption-side:bottom;border:2px solid black;}

    #data-frame{border-width: 20px;border-color: pink;}
    #data-table{position: relative;left: 200px;}
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
<h1>课程管理</h1>
<hr>
<div id="func">
    <span class="func-block">
        查询全部：<input id="find-all" type="button" value="检索">
    </span>
</div>
<div id="data-frame">
    <table id="data-table">
        <tr id="head-row">
            <td>课程号</td>
            <td>教师号</td>
            <td>课程名</td>
            <td>先修课号</td>
            <td>学分</td>
            <td><a href="javascript:void(0)" id="add-line">新增</a></td>
        </tr>
    </table>
</div>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script>
    $(document).ready(function(){
        //加载所有课程的数据
        $.ajax({
            url: '/course/getAll',
            method: 'get',
            dataType: 'text',

            success: function (res) {
                var map=JSON.parse(res);

                var trHTML;
                for(var i=0;i<map.length;++i)
                {
                    trHTML+='<tr id="row-'+idRecord+'" class="data-row">'
                        + '<td>'+map[i].cno+'</td>'
                        + '<td>'+map[i].tno+'</td>'
                        + '<td>'+map[i].cname+'</td>'
                        + '<td>'+map[i].cpno+'</td>'
                        + '<td>'+map[i].ccredit+'</td>'
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
        //加载所有课程的数据
        $.ajax({
            url: '/course/getAll',
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
                        + '<td>'+map[i].cno+'</td>'
                        + '<td>'+map[i].tno+'</td>'
                        + '<td>'+map[i].cname+'</td>'
                        + '<td>'+map[i].cpno+'</td>'
                        + '<td>'+map[i].ccredit+'</td>'
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
            + '<td><input style="text-align: center;width: 110px" id="cno-'+idRecord+'" type="text"></td>'
            + '<td><input style="text-align: center;width: 110px" id="tno-'+idRecord+'" type="text"></td>'
            + '<td><input style="text-align: center;width: 110px" id="cname-'+idRecord+'" type="text"></td>'
            + '<td><input style="text-align: center;width: 110px" id="cpno-'+idRecord+'" type="text"></td>'
            + '<td><input style="text-align: center;width: 110px" id="ccredit-'+idRecord+'" type="text"></td>'
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
        if(vals[3]=='undefined')vals[3]='';
        console.log('vals0='+vals[0])

        var trHtml = '<tr id="row-'+idSuffix+'" class="data-row">'
            + '<td id="cno-'+idSuffix+'">'+vals[0]+'</td>'
            + '<td><input style="text-align: center;width: 110px" id="tno-'+idSuffix+'" type="text" value='+vals[1]+'></td>'
            + '<td><input style="text-align: center;width: 110px" id="cname-'+idSuffix+'" type="text" value='+vals[2]+'></td>'
            + '<td><input style="text-align: center;width: 110px" id="cpno-'+idSuffix+'" type="text" value='+vals[3]+'></td>'
            + '<td><input style="text-align: center;width: 110px" id="ccredit-'+idSuffix+'" type="text" value='+vals[4]+'></td>'
            + '<td><span id="operate-'+idSuffix+'">'
            +'<a href="javascript:deleteLine('+idSuffix+')">删除</a>&nbsp;'
            + '<a href="javascript:saveUpdate('+idSuffix+')">保存</a></span></td>';
        $('#row-'+idSuffix).replaceWith(trHtml);
    }

    function saveUpdate(idSuffix)
    {
        var cno = $('#cno-' + idSuffix).text();
        var cname = $('#cname-' + idSuffix).val();
        var cpno = $('#cpno-' + idSuffix).val();
        var tno=$('#tno-'+idSuffix).val();
        var ccredit = $('#ccredit-' + idSuffix).val();
        var entity = {
            'Cno': cno,
            'Cname': cname,
            'Cpno': cpno,
            'Tno':tno,
            'Ccredit':ccredit
        }
        //ajax保存
        // TODO 保存时需要先看一下数据库里是否有与要保存的内容有冲突的部分(id冲突)
        entity=JSON.stringify(entity);
        console.log(entity)
        $.ajax({
            url:'/course/update',
            method:'post',
            data:entity,
            contentType: "application/json;charset=utf-8",
            dataType:'text',
            traditional: true,
            success:function(res){
                console.log(res)
            }
        })

        //保存成功后
        // $('#cno-' + idSuffix).replaceWith(cno);
        $('#cname-' + idSuffix).replaceWith(cname);
        $('#cpno-' + idSuffix).replaceWith(cpno);
        $('#tno-' + idSuffix).replaceWith(tno);
        $('#ccredit-' + idSuffix).replaceWith(ccredit);
        //操作列去掉保存按钮
        var fbtn='<span id="operate-'+idSuffix+'">'
            +'<a href="javascript:deleteLine('+idSuffix+')">删除</a>&nbsp;'
            +'<a href="javascript:updateLine('+idSuffix+')">修改</a></span>';
        $('#operate-' + idSuffix).replaceWith(fbtn);

        //保存后把主键返回设置成tr的value，此处是我随意够造的字符串
        // $('#row-' + idSuffix).prop("value", "id" + idSuffix);
    }


    //删除非后台加载的数据
    function deleteLine(idSuffix){
        var ret=confirm("确定删除？")
        if(!ret)return;

        //如果该条数据保存过，则会有值
        var s=$('#row-'+idSuffix).html();
        console.log(s);
        var cno=s.split('/')[0].split('>')[1].split('<')[0];
        var tno=s.split('/')[1].split('>')[2].split('<')[0];
        console.log('cno '+cno+' tno '+tno);
        $('#row-'+idSuffix).remove();

        var data={
            'Cno':cno,
            'Tno':tno
        }
        data=JSON.stringify(data);

        //ajax删除
        $.ajax({
            url:'/course/delete',
            data:data,
            method:'post',
            contentType: "application/json;charset=utf-8",
            dataType:'text',
            success:function (res) {
                console.log(res);
            }
        })
    }

    //保存行
    function saveLine(idSuffix){
        var cno = $('#cno-' + idSuffix).val();
        var cname = $('#cname-' + idSuffix).val();
        var cpno = $('#cpno-' + idSuffix).val();
        var tno=$('#tno-'+idSuffix).val();
        var ccredit = $('#ccredit-' + idSuffix).val();
        var entity = {
            'Cno': cno,
            'Cname': cname,
            'Cpno': cpno,
            'Tno':tno,
            'Ccredit':ccredit
        }
        //ajax保存
        // TODO 保存时需要先看一下数据库里是否有与要保存的内容有冲突的部分(id冲突)
        entity=JSON.stringify(entity);
        $.ajax({
            url:'/course/save',
            method:'post',
            data:entity,
            contentType: "application/json;charset=utf-8",
            dataType:'text',
            traditional: true,
            success:function(res){
                console.log(res);
            }
        })

        //保存成功后
        $('#cno-' + idSuffix).replaceWith(cno);
        $('#cname-' + idSuffix).replaceWith(cname);
        $('#cpno-' + idSuffix).replaceWith(cpno);
        $('#tno-' + idSuffix).replaceWith(tno);
        $('#ccredit-' + idSuffix).replaceWith(ccredit);
        //操作列去掉保存按钮
        var fbtn='<span id="operate-'+idSuffix+'">'
            +'<a href="javascript:deleteLine('+idSuffix+')">删除</a>&nbsp;'
            +'<a href="javascript:updateLine('+idSuffix+')">修改</a></span>';
        $('#operate-' + idSuffix).replaceWith(fbtn);

        //保存后把主键返回设置成tr的value，此处是我随意够造的字符串
        $('#row-' + idSuffix).prop("value", "id" + idSuffix);
    }
</script>
