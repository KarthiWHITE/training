/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.21
 * Generated at: 2015-08-03 13:19:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Sign Up</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style/design.css\"/>\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery17.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/signupScript.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"singnupForm\">\n");
      out.write("            <span>Sign up with us</span>\n");
      out.write("            ");
 if (request.getSession().getAttribute("userid") != null) {
                    response.sendRedirect("userabout");
                }
      out.write("\n");
      out.write("            <form method=\"post\" action=\"signup\" >\n");
      out.write("                <div class=\"input-grp\">\n");
      out.write("                    <label>User Name</label>                <br/>\n");
      out.write("                    <input type=\"text\" name=\"username\" class=\"cb-input username\" placeholder=\"User name\" /> <br/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"input-grp\">\n");
      out.write("                    <label>Email</label><br/>\n");
      out.write("                    <input id=\"user-email\" type=\"email\" name=\"email\" class=\"cb-input email\"/>\n");
      out.write("                    <div class=\"email-status\"></div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"input-grp\">\n");
      out.write("                    <label>Conform Email</label><br/>\n");
      out.write("                    <input type=\"email\" name=\"con_email\" class=\"cb-input confrm-email\"/><br/>\n");
      out.write("                    <div class=\"email-match-status\"></div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"input-grp\">\n");
      out.write("                    <label>Pass word</label><br/>\n");
      out.write("                    <input type=\"password\" name=\"password\" class=\"cb-input password\"/><br/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"input-grp\">\n");
      out.write("                    <label>Conform Password</label><br/>\n");
      out.write("                    <input type=\"password\" name=\"con_password\" class=\"cb-input confrm-password\"/>\n");
      out.write("                    <div class=\"password-status\"></div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"input-grp\">\n");
      out.write("                    <label>Phone number</label><br/>\n");
      out.write("                    <input type=\"text\" name=\"phone\" class=\"cb-input\"/><br/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"input-grp\">\n");
      out.write("                    <input type=\"reset\" value=\"Reset\" style=\"margin-right: 20px;\"/><input id=\"submitBtn\" type=\"submit\" value=\"Sign up\"/><br/>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("            <div class=\"form-status\"></div>\n");
      out.write("        </div>\n");
      out.write("        <div style=\"position: absolute;    right: 20px;    top: 20px;\"><a href=\"login\">User Login</a></div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
