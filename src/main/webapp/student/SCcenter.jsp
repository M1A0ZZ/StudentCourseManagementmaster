
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="zh">
<head>
    <meta charset="UTF-8"/>
    <title>选课中心</title>
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
    #data-table{position: relative;left: 250px;}
</style>
<body>
<div id="hello">选课中心</div>
<div id="func">

</div>
<div id="data-frame">
    <table id="data-table">
        <tr id="head-row">
            <td>课程号</td>
            <td>课程名</td>
            <td>先修课</td>
            <td>开课教师</td>
            <td>学分</td>
            <td>院系</td>
        </tr>
    </table>
</div>
</body>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script>
    $(document).ready(function(){
        //加载所有课程的数据
        $.ajax({
            url: '/course/getAll2',
            method: 'get',
            dataType: 'text',

            success: function (res) {
                var map=JSON.parse(res);

                var trHTML;
                for(var i=0;i<map.length;++i)
                {
                    trHTML+='<tr id="row-'+idRecord+'" class="data-row">'
                        + '<td>'+map[i].cno+'</td>'
                        + '<td>'+map[i].cname+'</td>'
                        + '<td>'+map[i].cpname+'</td>'
                        + '<td>'+map[i].tname+'</td>'
                        + '<td>'+map[i].ccredit+'</td>'
                        + '<td>'+map[i].tdept+'</td></tr>';
                    ++idRecord;
                }
                $('#data-table').append(trHTML);
            }
        })
    })
</script>
</html>
<script type="application/javascript">
    var idRecord = 1;
</script>