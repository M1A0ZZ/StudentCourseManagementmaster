/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2023-03-08 13:49:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.monitor;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class monitorIndex_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\"/>\n");
      out.write("    <title>首页</title>\n");
      out.write("</head>\n");
      out.write("<style>\n");
      out.write("    ul,ol{\n");
      out.write("        list-style-type: none;\n");
      out.write("    }\n");
      out.write("    #menu{\n");
      out.write("        float: left;\n");
      out.write("    }\n");
      out.write("    .menu-item{\n");
      out.write("        height: 30px;\n");
      out.write("        width: 100px;\n");
      out.write("        margin: 5px;\n");
      out.write("        text-align: center;\n");
      out.write("    }\n");
      out.write("    #myframe{\n");
      out.write("        width: 1300px;\n");
      out.write("        height: 700px;\n");
      out.write("        float: left;\n");
      out.write("        border-width: 2px;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("<body >\n");
      out.write("<div id=\"page\">\n");
      out.write("    <ul id=\"menu\">\n");
      out.write("        <li class=\"menu-item\"><a href=\"javascript:changePage('/monitor/teacherManage.jsp')\">教师管理</a></li>\n");
      out.write("        <li class=\"menu-item\"><a href=\"javascript:changePage('/monitor/studentManage.jsp')\">学生管理</a></li>\n");
      out.write("        <li class=\"menu-item\"><a href=\"javascript:changePage('/monitor/courseManage.jsp')\">课程管理</a></li>\n");
      out.write("        <li class=\"menu-item\"><a href=\"javascript:changePage('/monitor/SCManage.jsp')\">选课管理</a></li>\n");
      out.write("    </ul>\n");
      out.write("    <iframe id=\"myframe\" src=\"/monitor/teacherManage.jsp\"></iframe>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-3.4.1.js\"></script>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<script type=\"application/javascript\">\n");
      out.write("    function changePage(page) {\n");
      out.write("        $('#myframe').remove();\n");
      out.write("        $('#page').append('<iframe id=\"myframe\" src=\"'+page+'\"></iframe>');\n");
      out.write("    }\n");
      out.write("</script>");
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
