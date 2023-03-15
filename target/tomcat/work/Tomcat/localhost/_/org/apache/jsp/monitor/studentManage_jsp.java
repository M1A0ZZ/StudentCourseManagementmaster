/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2023-03-08 13:49:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.monitor;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class studentManage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Student</title>\n");
      out.write("</head>\n");
      out.write("<style>\n");
      out.write("    div{margin: 10px;}\n");
      out.write("    tr{border:2px solid black;height: 10px;}\n");
      out.write("    td{border:2px solid black;width: 130px;height: 10px;text-align: center;}\n");
      out.write("    table{caption-side:bottom;border:2px solid black;}\n");
      out.write("\n");
      out.write("    #data-frame{border-width: 20px;border-color: pink;}\n");
      out.write("    #data-table{position: relative;left: 200px;}\n");
      out.write("    #teacher-name,#age-range{width: 90px;}\n");
      out.write("    .func-block{\n");
      out.write("        border: black solid 2px;\n");
      out.write("        padding: 4px;\n");
      out.write("        margin-right: 5px;\n");
      out.write("    }\n");
      out.write("    select{\n");
      out.write("        text-align: center;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("<body>\n");
      out.write("<h1>学生管理</h1>\n");
      out.write("<hr>\n");
      out.write("<div id=\"func\">\n");
      out.write("        <span class=\"func-block\">\n");
      out.write("            查询全部：<input id=\"find-all\" type=\"button\" value=\"检索\">\n");
      out.write("        </span>\n");
      out.write("    <span class=\"func-block\">\n");
      out.write("            按姓名查询：<input id=\"student-name\" maxlength=\"6\" type=\"text\">\n");
      out.write("            <label><input id=\"student-name-submit\" type=\"button\" value=\"提交\"></label>\n");
      out.write("        </span>\n");
      out.write("    <span class=\"func-block\">\n");
      out.write("            按条件查询：\n");
      out.write("            <select id=\"find-by-dept\">\n");
      out.write("                <option selected value=\"全部\">全部院系</option>\n");
      out.write("                <option value=\"计算机科学与技术\">计算机科学与技术</option>\n");
      out.write("                <option value=\"工商管理\">工商管理</option>\n");
      out.write("                <option value=\"信息管理\">信息管理</option>\n");
      out.write("                <option value=\"后勤\">后勤</option>\n");
      out.write("            </select>\n");
      out.write("            <select id=\"find-by-sex\">\n");
      out.write("                <option value=\"全部\">全部性别</option>\n");
      out.write("                <option value=\"男\">男</option>\n");
      out.write("                <option value=\"女\">女</option>\n");
      out.write("            </select>\n");
      out.write("            <input id=\"find-by-cond\" type=\"button\" value=\"检索\">\n");
      out.write("        </span>\n");
      out.write("</div>\n");
      out.write("<div id=\"data-frame\">\n");
      out.write("    <table id=\"data-table\">\n");
      out.write("        <tr id=\"head-row\">\n");
      out.write("            <td>姓名</td>\n");
      out.write("            <td>学号</td>\n");
      out.write("            <td>登录密码</td>\n");
      out.write("            <td>年龄</td>\n");
      out.write("            <td>性别</td>\n");
      out.write("            <td>院系</td>\n");
      out.write("            <td><a href=\"javascript:void(0)\" id=\"add-line\">新增</a></td>\n");
      out.write("        </tr>\n");
      out.write("    </table>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-3.4.1.js\"></script>\n");
      out.write("<script>\n");
      out.write("    $(document).ready(function(){\n");
      out.write("        //加载所有学生的数据\n");
      out.write("        $.ajax({\n");
      out.write("            url: '/student/getAll',\n");
      out.write("            method: 'get',\n");
      out.write("            dataType: 'text',\n");
      out.write("            success: function (res) {\n");
      out.write("                var map=JSON.parse(res);\n");
      out.write("                console.log(res)\n");
      out.write("                var trHTML;\n");
      out.write("                for(var i=0;i<map.length;++i)\n");
      out.write("                {\n");
      out.write("                    trHTML+='<tr id=\"row-'+idRecord+'\" class=\"data-row\">'\n");
      out.write("                        + '<td>'+map[i].sname+'</td>'\n");
      out.write("                        + '<td>'+map[i].sno+'</td>'\n");
      out.write("                        + '<td>'+map[i].spassword+'</td>'\n");
      out.write("                        + '<td>'+map[i].sage+'</td>'\n");
      out.write("                        + '<td>'+map[i].ssex+'</td>'\n");
      out.write("                        + '<td>'+map[i].sdept+'</td>'\n");
      out.write("                        + '<td><span id=\"operate-'+idRecord+'\">'\n");
      out.write("                        +'<a href=\"javascript:deleteLine('+idRecord+')\">删除</a>&nbsp;'\n");
      out.write("                        +'<a href=\"javascript:updateLine('+idRecord+')\">修改</a></span></td></tr>';\n");
      out.write("                    ++idRecord;\n");
      out.write("                }\n");
      out.write("                $('#data-table').append(trHTML);\n");
      out.write("            }\n");
      out.write("        })\n");
      out.write("    })\n");
      out.write("</script>\n");
      out.write("</html>\n");
      out.write("<script type=\"application/javascript\">\n");
      out.write("    $('#find-all').click(function(){\n");
      out.write("        //加载所有教师的数据\n");
      out.write("        $.ajax({\n");
      out.write("            url: '/student/getAll',\n");
      out.write("            method: 'get',\n");
      out.write("            dataType: 'text',\n");
      out.write("            success: function (res) {\n");
      out.write("                //先清空data-table里面的tr标签\n");
      out.write("                $('.data-row').remove();\n");
      out.write("\n");
      out.write("                //再加载相关数据\n");
      out.write("                var map=JSON.parse(res);\n");
      out.write("                console.log(map)\n");
      out.write("                var trHTML=\"\";\n");
      out.write("                for(var i=0;i<map.length;++i)\n");
      out.write("                {\n");
      out.write("                    trHTML+='<tr id=\"row-'+idRecord+'\" class=\"data-row\">'\n");
      out.write("                        + '<td>'+map[i].sname+'</td>'\n");
      out.write("                        + '<td>'+map[i].sno+'</td>'\n");
      out.write("                        + '<td>'+map[i].spassword+'</td>'\n");
      out.write("                        + '<td>'+map[i].sage+'</td>'\n");
      out.write("                        + '<td>'+map[i].ssex+'</td>'\n");
      out.write("                        + '<td>'+map[i].sdept+'</td>'\n");
      out.write("                        + '<td><span id=\"operate-'+idRecord+'\">'\n");
      out.write("                        +'<a href=\"javascript:deleteLine('+idRecord+')\">删除</a>&nbsp;'\n");
      out.write("                        +'<a href=\"javascript:updateLine('+idRecord+')\">修改</a></span></td></tr>';\n");
      out.write("                    ++idRecord;\n");
      out.write("                }\n");
      out.write("                $('#data-table').append(trHTML);\n");
      out.write("            }\n");
      out.write("        })\n");
      out.write("    })\n");
      out.write("    $('#student-name-submit').click(function(){\n");
      out.write("        var data={'Sname':$('#student-name').val()};\n");
      out.write("        data=JSON.stringify(data);\n");
      out.write("        $.ajax({\n");
      out.write("            url:'/student/getStudentName',\n");
      out.write("            method:'post',\n");
      out.write("            dataType:'text',\n");
      out.write("            contentType: \"application/json;charset=utf-8\",\n");
      out.write("            data:data,\n");
      out.write("            success:function(res){\n");
      out.write("\n");
      out.write("                console.log(\"getTeacherName\");\n");
      out.write("                var map=JSON.parse(res);\n");
      out.write("                console.log(res);\n");
      out.write("                console.log(map);\n");
      out.write("                //先清空data-table里面的tr标签\n");
      out.write("                $('.data-row').remove();\n");
      out.write("\n");
      out.write("                var trHTML=\"\";\n");
      out.write("                for(var i=0;i<map.length;++i)\n");
      out.write("                {\n");
      out.write("                    trHTML+='<tr id=\"row-'+idRecord+'\" class=\"data-row\">'\n");
      out.write("                        + '<td>'+map[i].sname+'</td>'\n");
      out.write("                        + '<td>'+map[i].sno+'</td>'\n");
      out.write("                        + '<td>'+map[i].spassword+'</td>'\n");
      out.write("                        + '<td>'+map[i].sage+'</td>'\n");
      out.write("                        + '<td>'+map[i].ssex+'</td>'\n");
      out.write("                        + '<td>'+map[i].sdept+'</td>'\n");
      out.write("                        + '<td><span id=\"operate-'+idRecord+'\">'\n");
      out.write("                        +'<a href=\"javascript:deleteLine('+idRecord+')\">删除</a>&nbsp;'\n");
      out.write("                        +'<a href=\"javascript:updateLine('+idRecord+')\">修改</a></span></td></tr>';\n");
      out.write("                    ++idRecord;\n");
      out.write("                }\n");
      out.write("                $('#data-table').append(trHTML);\n");
      out.write("            }\n");
      out.write("        })\n");
      out.write("    })\n");
      out.write("    $('#find-by-cond').click(function () {\n");
      out.write("        console.log(\"find-by-condition\");\n");
      out.write("        var data={};\n");
      out.write("        var dept=$('#find-by-dept option:selected').attr('value');\n");
      out.write("        var sex=$('#find-by-sex option:selected').attr('value');\n");
      out.write("        if(dept!='全部')\n");
      out.write("        {\n");
      out.write("            //data.append({'tdept':dept});\n");
      out.write("            data['sdept']=dept;\n");
      out.write("        }\n");
      out.write("        if(sex!='全部')\n");
      out.write("        {\n");
      out.write("            //data.append({'tsex':sex});\n");
      out.write("            data['ssex']=sex;\n");
      out.write("        }\n");
      out.write("        data=JSON.stringify(data);\n");
      out.write("        console.log(data);\n");
      out.write("        $.ajax({\n");
      out.write("            url:'/student/findByCond',\n");
      out.write("            data:data,\n");
      out.write("            method:'post',\n");
      out.write("            dataType:'text',\n");
      out.write("            contentType: \"application/json;charset=utf-8\",\n");
      out.write("            success:function(res){\n");
      out.write("                console.log(res);\n");
      out.write("                var map=JSON.parse(res);\n");
      out.write("                //先清空data-table里面的tr标签\n");
      out.write("                $('.data-row').remove();\n");
      out.write("\n");
      out.write("                var trHTML=\"\";\n");
      out.write("                for(var i=0;i<map.length;++i)\n");
      out.write("                {\n");
      out.write("                    trHTML+='<tr id=\"row-'+idRecord+'\" class=\"data-row\">'\n");
      out.write("                        + '<td>'+map[i].sname+'</td>'\n");
      out.write("                        + '<td>'+map[i].sno+'</td>'\n");
      out.write("                        + '<td>'+map[i].spassword+'</td>'\n");
      out.write("                        + '<td>'+map[i].sage+'</td>'\n");
      out.write("                        + '<td>'+map[i].ssex+'</td>'\n");
      out.write("                        + '<td>'+map[i].sdept+'</td>'\n");
      out.write("                        + '<td><span id=\"operate-'+idRecord+'\">'\n");
      out.write("                        +'<a href=\"javascript:deleteLine('+idRecord+')\">删除</a>&nbsp;'\n");
      out.write("                        +'<a href=\"javascript:updateLine('+idRecord+')\">修改</a></span></td></tr>';\n");
      out.write("                    ++idRecord;\n");
      out.write("                }\n");
      out.write("                $('#data-table').append(trHTML);\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        })\n");
      out.write("    })\n");
      out.write("</script>\n");
      out.write("<script type=\"application/javascript\">\n");
      out.write("\n");
      out.write("    var idRecord = 1;\n");
      out.write("    //添加行\n");
      out.write("    $('#add-line').click(function(){\n");
      out.write("        var trHtml = '<tr id=\"row-'+idRecord+'\" class=\"data-row\">'\n");
      out.write("            + '<td><input style=\"text-align: center;width: 110px\" id=\"name-'+idRecord+'\" type=\"text\"></td>'\n");
      out.write("            + '<td><input style=\"text-align: center;width: 110px\" id=\"id-'+idRecord+'\" type=\"text\"></td>'\n");
      out.write("            + '<td><input style=\"text-align: center;width: 110px\" id=\"password-'+idRecord+'\" type=\"text\"></td>'\n");
      out.write("            + '<td><input style=\"text-align: center;width: 110px\" id=\"age-'+idRecord+'\" type=\"text\"></td>'\n");
      out.write("            + '<td><input style=\"text-align: center;width: 110px\" id=\"sex-'+idRecord+'\" type=\"text\"></td>'\n");
      out.write("            + '<td><input style=\"text-align: center;width: 110px\" id=\"dept-'+idRecord+'\" type=\"text\"></td>'\n");
      out.write("            + '<td><span id=\"operate-'+idRecord+'\">'\n");
      out.write("            +'<a href=\"javascript:deleteLine('+idRecord+')\">删除</a>&nbsp;'\n");
      out.write("            + '<a href=\"javascript:saveLine('+idRecord+')\">保存</a></span></td>';\n");
      out.write("        $('#data-table').append(trHtml);\n");
      out.write("        idRecord++;\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    function updateLine(idSuffix){\n");
      out.write("        //计算原位置上的值并将其替换为 input(type=text)\n");
      out.write("        var s=$('#row-'+idSuffix).html().split('>');\n");
      out.write("        var arr=[];\n");
      out.write("        for(var i=0;i<s.length;++i)\n");
      out.write("        {\n");
      out.write("            arr=arr.concat(s[i].split('<'));\n");
      out.write("        }\n");
      out.write("        console.log(arr);//2 6 10 14 18 22\n");
      out.write("        var vals=[arr[2],arr[6],arr[10],arr[14],arr[18],arr[22]];\n");
      out.write("        console.log(vals)\n");
      out.write("\n");
      out.write("        var trHtml = '<tr id=\"row-'+idSuffix+'\" class=\"data-row\">'\n");
      out.write("            + '<td><input style=\"text-align: center;width: 110px\" id=\"name-'+idSuffix+'\" type=\"text\" value='+vals[0]+'></td>'\n");
      out.write("            + '<td id=\"id-'+idSuffix+'\">'+vals[1]+'</td>'\n");
      out.write("            + '<td><input style=\"text-align: center;width: 110px\" id=\"password-'+idSuffix+'\" type=\"text\" value='+vals[2]+'></td>'\n");
      out.write("            + '<td><input style=\"text-align: center;width: 110px\" id=\"age-'+idSuffix+'\" type=\"text\" value='+vals[3]+'></td>'\n");
      out.write("            + '<td><input style=\"text-align: center;width: 110px\" id=\"sex-'+idSuffix+'\" type=\"text\" value='+vals[4]+'></td>'\n");
      out.write("            + '<td><input style=\"text-align: center;width: 110px\" id=\"dept-'+idSuffix+'\" type=\"text\" value='+vals[5]+'></td>'\n");
      out.write("            + '<td><span id=\"operate-'+idSuffix+'\">'\n");
      out.write("            +'<a href=\"javascript:deleteLine('+idSuffix+')\">删除</a>&nbsp;'\n");
      out.write("            + '<a href=\"javascript:saveUpdate('+idSuffix+')\">保存</a></span></td>';\n");
      out.write("        $('#row-'+idSuffix).replaceWith(trHtml);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    function saveUpdate(idSuffix)\n");
      out.write("    {\n");
      out.write("        var id = $('#id-' + idSuffix).text();\n");
      out.write("        var name = $('#name-' + idSuffix).val();\n");
      out.write("        var sex = $('#sex-' + idSuffix).val();\n");
      out.write("        var password=$('#password-'+idSuffix).val();\n");
      out.write("        var dept = $('#dept-' + idSuffix).val();\n");
      out.write("        var age = $('#age-' + idSuffix).val();\n");
      out.write("        var entity = {\n");
      out.write("            'Sno': id,\n");
      out.write("            'Sname': name,\n");
      out.write("            'Ssex': sex,\n");
      out.write("            'Spassword':password,\n");
      out.write("            'Sdept':dept,\n");
      out.write("            'Sage':age\n");
      out.write("        }\n");
      out.write("        //ajax保存\n");
      out.write("        // TODO 保存时需要先看一下数据库里是否有与要保存的内容有冲突的部分(id冲突)\n");
      out.write("        entity=JSON.stringify(entity);\n");
      out.write("        $.ajax({\n");
      out.write("            url:'/student/update',\n");
      out.write("            method:'post',\n");
      out.write("            data:entity,\n");
      out.write("            contentType: \"application/json;charset=utf-8\",\n");
      out.write("            dataType:'text',\n");
      out.write("            traditional: true,\n");
      out.write("            success:function(res){\n");
      out.write("                console.log(res)\n");
      out.write("            }\n");
      out.write("        })\n");
      out.write("\n");
      out.write("        //保存成功后\n");
      out.write("        //$('#id-' + idSuffix).replaceWith(id);\n");
      out.write("        $('#name-' + idSuffix).replaceWith(name);\n");
      out.write("        $('#password-' + idSuffix).replaceWith(password);\n");
      out.write("        $('#sex-' + idSuffix).replaceWith(sex);\n");
      out.write("        $('#dept-' + idSuffix).replaceWith(dept);\n");
      out.write("        $('#age-' + idSuffix).replaceWith(age);\n");
      out.write("        //操作列去掉保存按钮\n");
      out.write("        var fbtn='<span id=\"operate-'+idSuffix+'\">'\n");
      out.write("            +'<a href=\"javascript:deleteLine('+idSuffix+')\">删除</a>&nbsp;'\n");
      out.write("            +'<a href=\"javascript:updateLine('+idSuffix+')\">修改</a></span>';\n");
      out.write("        $('#operate-' + idSuffix).replaceWith(fbtn);\n");
      out.write("\n");
      out.write("        //保存后把主键返回设置成tr的value，此处是我随意够造的字符串\n");
      out.write("        $('#row-' + idSuffix).prop(\"value\", \"id\" + idSuffix);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("\n");
      out.write("    //删除非后台加载的数据\n");
      out.write("    function deleteLine(idSuffix){\n");
      out.write("        var ret=confirm(\"确定删除？\")\n");
      out.write("        if(!ret)return;\n");
      out.write("\n");
      out.write("        //如果该条数据保存过，则会有值\n");
      out.write("        var s=$('#row-'+idSuffix).html()\n");
      out.write("        var no=s.split('/')[1].split('>')[2].split('<')[0]\n");
      out.write("        $('#row-'+idSuffix).remove();\n");
      out.write("\n");
      out.write("\n");
      out.write("        //ajax删除\n");
      out.write("        $.ajax({\n");
      out.write("            url:'/student/delete',\n");
      out.write("            data:no,\n");
      out.write("            method:'post',\n");
      out.write("            contentType: \"application/json;charset=utf-8\",\n");
      out.write("            dataType:'text',\n");
      out.write("            success:function (res) {\n");
      out.write("                console.log(res);\n");
      out.write("            }\n");
      out.write("        })\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    //保存行\n");
      out.write("    function saveLine(idSuffix){\n");
      out.write("        var id = $('#id-' + idSuffix).val();\n");
      out.write("        var name = $('#name-' + idSuffix).val();\n");
      out.write("        var sex = $('#sex-' + idSuffix).val();\n");
      out.write("        var password=$('#password-'+idSuffix).val();\n");
      out.write("        var dept = $('#dept-' + idSuffix).val();\n");
      out.write("        var age = $('#age-' + idSuffix).val();\n");
      out.write("        var entity = {\n");
      out.write("            'Sno': id,\n");
      out.write("            'Sname': name,\n");
      out.write("            'Ssex': sex,\n");
      out.write("            'Spassword':password,\n");
      out.write("            'Sdept':dept,\n");
      out.write("            'Sage':age\n");
      out.write("        }\n");
      out.write("        //ajax保存\n");
      out.write("        // TODO 保存时需要先看一下数据库里是否有与要保存的内容有冲突的部分(id冲突)\n");
      out.write("        entity=JSON.stringify(entity);\n");
      out.write("        $.ajax({\n");
      out.write("            url:'/student/save',\n");
      out.write("            method:'post',\n");
      out.write("            data:entity,\n");
      out.write("            contentType: \"application/json;charset=utf-8\",\n");
      out.write("            dataType:'text',\n");
      out.write("            traditional: true,\n");
      out.write("            success:function(res){\n");
      out.write("                console.log(res);\n");
      out.write("            }\n");
      out.write("        })\n");
      out.write("\n");
      out.write("        //保存成功后\n");
      out.write("        $('#id-' + idSuffix).replaceWith(id);\n");
      out.write("        $('#name-' + idSuffix).replaceWith(name);\n");
      out.write("        $('#password-' + idSuffix).replaceWith(password);\n");
      out.write("        $('#sex-' + idSuffix).replaceWith(sex);\n");
      out.write("        $('#dept-' + idSuffix).replaceWith(dept);\n");
      out.write("        $('#age-' + idSuffix).replaceWith(age);\n");
      out.write("        //操作列去掉保存按钮\n");
      out.write("        var fbtn='<span id=\"operate-'+idSuffix+'\">'\n");
      out.write("            +'<a href=\"javascript:deleteLine('+idSuffix+')\">删除</a>&nbsp;'\n");
      out.write("            +'<a href=\"javascript:updateLine('+idSuffix+')\">修改</a></span>';\n");
      out.write("        $('#operate-' + idSuffix).replaceWith(fbtn);\n");
      out.write("\n");
      out.write("        //保存后把主键返回设置成tr的value，此处是我随意够造的字符串\n");
      out.write("        $('#row-' + idSuffix).prop(\"value\", \"id\" + idSuffix);\n");
      out.write("    }\n");
      out.write("</script>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
