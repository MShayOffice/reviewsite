package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addMovie_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("        <script language=\"JavaScript\">\n");
      out.write("        function validate(form) {\n");
      out.write("            if (form.movieName.value==\"\") {\n");
      out.write("                alert(\"Please provide the movie's name\");\n");
      out.write("                form.movieName.focus();\n");
      out.write("            }\n");
      out.write("            else if (form.year.value==\"\") {\n");
      out.write("                alert(\"Please enter a year of release\");\n");
      out.write("                form.year.focus();\n");
      out.write("            }\n");
      out.write("            else if (form.description.value==\"\") {\n");
      out.write("                alert(\"Please enter a description\");\n");
      out.write("                form.description.focus();\n");
      out.write("            }\n");
      out.write("            else {\n");
      out.write("                form.submit();\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        <body>\n");
      out.write("\n");
      out.write("        <h1>Please fill the fields to add a new movie.</h1>\n");
      out.write("\n");
      out.write("        <form action=\"addMovie\" method=\"post\">\n");
      out.write("            <table cellspacing=\"5\" border=\"0\">\n");
      out.write("                <tr>\n");
      out.write("                    <td align=\"right\">Movie name:</td>\n");
      out.write("                    <td><input type=\"text\" name=\"movieName\" \n");
      out.write("                            value=\"\">\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td align=\"right\">Year of release:</td>\n");
      out.write("                    <td><input type=\"text\" name=\"year\" \n");
      out.write("                            value=\"\">\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td align=\"right\" valign=\"top\">Description:</td>\n");
      out.write("                    <td><textarea name=\"description\" rows=3 cols=30 \n");
      out.write("                            value=\"\"></textarea>\n");
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td><input type=\"button\" value=\"Submit\" \n");
      out.write("                            onClick=\"validate(this.form)\"></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${idTest}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
