package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.entity.Language;

public final class addFilm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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

      out.write("\r\n");
      out.write("\r\n");

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    \r\n");
      out.write("    <title>My JSP 'addFilm.jsp' starting page</title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<!--\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\r\n");
      out.write("\t-->\r\n");
      out.write("\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("  ");
 List<Language> list = (List<Language>)request.getAttribute("languages"); 
      out.write("\r\n");
      out.write("     <form action=\"");
      out.print(path);
      out.write("/addFilm\" method=\"post\">\r\n");
      out.write("    \t<table border=\"1\" cellspacing=\"0\" cellpadding=\"5\" bordercolor=\"silver\" align=\"center\" >\r\n");
      out.write("    \t\t<tr>\r\n");
      out.write("    \t\t\t<td colspan=\"2\" align=\"center\" bgcolor=\"#E8E8E8\">添加电影</td>\r\n");
      out.write("    \t\t</tr>\r\n");
      out.write("    \t\t<tr>\r\n");
      out.write("    \t\t\t<td>电影名：</td>\r\n");
      out.write("    \t\t\t<td><input type=\"text\" name=\"title\"/></td>\t\r\n");
      out.write("    \t\t</tr>\r\n");
      out.write("    \t\t<tr>\r\n");
      out.write("    \t\t\t<td>描述：</td>\r\n");
      out.write("    \t\t\t<td><input type=\"text\" name=\"description\"/></td>\t\t\t\r\n");
      out.write("    \t\t</tr>\r\n");
      out.write("    \t\t<tr>\r\n");
      out.write("    \t\t\t<td>语言：</td>\r\n");
      out.write("    \t\t\t<td>\r\n");
      out.write("    \t\t\t\t<select name=\"select\">\r\n");
      out.write("    \t\t\t\t");
for( Language language:list){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=\"");
      out.print(language.getLanguage_id());
      out.write('"');
      out.write('>');
      out.print(language.getName() );
      out.write("</option>     \t\t\t\r\n");
      out.write("    \t\t\t\t");
} 
      out.write("\r\n");
      out.write("    \t\t\t\t</select>\r\n");
      out.write("    \t\t\t</td>\t\t\t\r\n");
      out.write("    \t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("    \t\t\t<td colspan=\"2\" align=\"center\">\r\n");
      out.write("    \t\t\t\t<input type=\"submit\" value=\"提交\"/>\r\n");
      out.write("    \t\t\t\t<input type=\"reset\" value=\"重置\"/>\r\n");
      out.write("    \t\t\t</td>\r\n");
      out.write("    \t\t</tr>\t\r\n");
      out.write("    \t</table>\r\n");
      out.write("    </form>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
