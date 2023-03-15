
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="zh">
<head>
    <meta charset="UTF-8"/>
    <title>我的选课</title>
</head>
<style>
    tr{border:2px solid black;height: 10px;}
    td{border:2px solid black;width: 130px;height: 10px;text-align: center;}
    table{caption-side:bottom;border:2px solid black;}

    #hello{
        font-size:xx-large;
        font-weight: bold;
        text-align: center;
        margin: 8px 0;
    }
    #choose-course{
        margin-bottom: 10px;
        height: 30px;
        /* background-color: greenyellow; */
    }
    #search-frame{
        border:2px solid black;
        width: 250px;
        float: left;
        margin-right: 10px;
    }
    #input-cno{
        width: 80px;
        margin-right: 10px;
    }
    #output{
        border:2px solid black;
        float: left;
        width: 600px;
        margin-right: 10px;
    }
    #choose{
        float: right;
    }
    #refresh{
        border:2px solid black;
        float: left;
    }
    #data-table{position: relative;left: 80px;}
</style>
<body>
<div id="hello">我的选课</div><hr>
<div id="func">
    <div id="choose-course">
        <div id="search-frame">按选课号选课：<input value="201" type="text" id="input-cno"><input type="button" id="search" value="检索"></div>
        <div id="output">
            结果：<span id="output-text"></span>
            <label><input type="button" id="choose" value="选取"></label>
        </div>
        <div id="refresh"><input type="button" value="刷新" id="refresh-button"></div>
    </div>
</div><hr>
<div id="data-frame">
    <table id="data-table">
        <tr id="head-row">
            <td>课程号</td>
            <td>课程名</td>
            <td>先修课</td>
            <td>开课教师</td>
            <td>学分</td>
            <td>院系</td>
            <td>成绩</td>
            <td>退选栏</td>
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
</html>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script type="application/javascript">
    var idRecord = 1;
    $('#refresh-button').click(function(){
        load();
    })
    function deleteSC(idSuffix) {
        var ret=confirm("确定删除？");
        if(!ret)return;
        var cno=$('#row-'+idSuffix+'-cno').text();
        var sno=parent.window.$("#no").text().split('：')[1];
        var data={
            'Sno':sno,
            'Cno':cno
        };
        data=JSON.stringify(data);
        $('#row-'+idSuffix).remove();

        $.ajax({
            url:'/sc/delete',
            method:'post',
            data:data,
            contentType: "application/json;charset=utf-8",
            dataType:'text',
            success:function (res) {
                console.log(res);
            }
        })

    }
    function load()
    {
        idRecord = 1;
        console.log($('#data-table').html());
        $('#data-table').replaceWith("<table id='data-table'><tr id=\"head-row\">" +
            "<td>课程号</td><td>课程名</td><td>先修课</td>" +
            "<td>开课教师</td><td>学分</td><td>院系</td>" +
            "<td>成绩</td><td>退选栏</td></tr></table>");
        // jsp中iframe在子页面和父页面之间传值
        var no=parent.window.$("#no").text().split('：')[1];
        //加载我已经选中的课程
        $.ajax({
            url: '/sc/myCourse',
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
                        + '<td id="row-'+idRecord+'-cno">'+map[i].cno+'</td>'
                        + '<td>'+map[i].cname+'</td>'
                        + '<td>'+map[i].cpname+'</td>'
                        + '<td>'+map[i].tname+'</td>'
                        + '<td>'+map[i].ccredit+'</td>'
                        + '<td>'+map[i].tdept+'</td>'
                        + '<td>'+map[i].grade+'</td>'
                        + '<td><a href="javascript:deleteSC('+idRecord+')">退选</a></td></tr>'
                    ++idRecord;
                }
                $('#data-table').append(trHTML);
            }
        });
    }

    $('#search').click(function () {
        var cno=$('#input-cno').val();
        console.log(cno);
        if(cno=="")
        {
            alert('请输入课程号！');
        }
        else{
            $.ajax({
                url:"/course/findById",
                method:"post",
                data:cno,
                contentType: "application/json;charset=utf-8",
                dataType:'text',
                success:function (res) {
                    if(res=='null'){
                        alert('课程号不存在！');
                        $('#output-text').replaceWith('<span id="output-text"></span>');
                    }
                    else{
                        var map=JSON.parse(res);
                        var retHTML="<span id=\"output-text\">课程号="+map.Cno
                            +" | 课程名="+map.Cname
                            +" | 授课教师="+map.Tname
                            +" | 学分="+map.Ccredit+" | </span>";
                        console.log(retHTML);
                        $('#output-text').replaceWith(retHTML);
                    }
                }
            })
        }
    });
    $('#choose').click(function () {
        var ot=$('#output-text').text();
        if(ot=="")
        {
            console.log('output-text==""');
        }
        else{
            var ret=confirm("确定选课？")
            if(!ret)return;
            console.log(ot);
            var cno=ot.split('=')[1].split('|')[0].trim();
            var sno=parent.window.$("#no").text().split('：')[1];
            var data={
                'Cno':cno,
                'Sno':sno
            }
            data=JSON.stringify(data);
            $.ajax({
                url:'/sc/insert',
                method:'post',
                data:data,
                contentType: "application/json;charset=utf-8",
                dataType:'text',
                success:function (res) {
                    console.log("insert success : "+res);
                },
                error:function () {
                    console.log('insert error');
                }
            })
        }
    })
</script>