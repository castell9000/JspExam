package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.entity.Film;

public final class ListFilme_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>My JSP 'ListFilme.jsp' starting page</title>\r\n");
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
      out.write("    ");

    //Film film = new Film();
    List<Film> list = (List<Film>)request.getAttribute("filmList");
     
      out.write("\r\n");
      out.write("     \r\n");
      out.write("     <table border=\"1\" cellspacing=\"0\" cellpadding=\"8\" bordercolor=\"silver\" align=\"center\" >\r\n");
      out.write("    \t\t<tr>\r\n");
      out.write("    \t\t\t<td colspan=\"6\" align=\"center\" bgcolor=\"#E8E8E8\">电影信息</td>\r\n");
      out.write("    \t\t</tr>\r\n");
      out.write("    \t\t<tr>\r\n");
      out.write("    \t\t\t<td>ID</td>\r\n");
      out.write("\t\t    \t<td>名称</td>\r\n");
      out.write("\t\t    \t<td>语言</td>\r\n");
      out.write("\t\t    \t<td>描述</td>\r\n");
      out.write("\t\t    \t<td>删除</td>\r\n");
      out.write("\t\t    \t<td>编辑</td>\r\n");
      out.write("   \t\t\t</tr>\r\n");
      out.write("    \t\t");
for(Film film:list){
      out.write("\r\n");
      out.write("    \t\t<tr>\r\n");
      out.write("    \t\t\t<td>");
      out.print(film.getFilm_id() );
      out.write("</td>\r\n");
      out.write("    \t\t\t<td>");
      out.print(film.getTitle() );
      out.write("</td>\r\n");
      out.write("    \t\t\t<td>");
      out.print(film.getLanguageName() );
      out.write("</td>\r\n");
      out.write("    \t\t\t<td>");
      out.print(film.getDescription() );
      out.write("</td>\r\n");
      out.write("    \t\t\t<td><b><a href=\"#\">删除</a></b></td>\r\n");
      out.write("    \t\t\t <td><b><a href=\"");
      out.print(request.getContextPath());
      out.write("/editFilm?title=");
      out.print(film.getTitle() );
      out.write("&description=");
      out.print(film.getDescription() );
      out.write("&name=");
      out.print(film.getLanguageName() );
      out.write("\">编辑</a></b></td>\r\n");
      out.write("    \t\t\t");
      out.write("\r\n");
      out.write("    \t\t</tr>\r\n");
      out.write("    \t\t");
} 
      out.write(">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("    \t\t\t<td colspan=\"6\" align=\"center\">\r\n");
      out.write("    \t\t\t");
if(Integer.parseInt(request.getParameter("cur")) == 0){ 
      out.write("\r\n");
      out.write("    \t\t\t\t<b>已是第一页</b>\r\n");
      out.write("    \t\t\t");
}else{ 
      out.write("\r\n");
      out.write("    \t\t\t\t<b><a href=\"");
      out.print(request.getContextPath());
      out.write("/searchFilm?cur=");
      out.print(Integer.parseInt(request.getParameter("cur"))-1);
      out.write("\">上页</a></b>\r\n");
      out.write("    \t\t\t");
} 
      out.write("\r\n");
      out.write("    \t\t\t\t<b><a href=\"");
      out.print(request.getContextPath());
      out.write("/searchFilm?cur=");
      out.print(Integer.parseInt(request.getParameter("cur"))+1);
      out.write("\">下页</a></b>\r\n");
      out.write("    \t\t\t</td>\r\n");
      out.write("    \t\t</tr>\t\r\n");
      out.write("    \t</table>\r\n");
      out.write("\r\n");
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
