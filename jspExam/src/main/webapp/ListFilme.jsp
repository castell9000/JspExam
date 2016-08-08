<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.Film" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ListFilme.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    //Film film = new Film();
    List<Film> list = (List<Film>)request.getAttribute("filmList");
     %>
     
     <table border="1" cellspacing="0" cellpadding="8" bordercolor="silver" align="center" >
    		<tr>
    			<td colspan="6" align="center" bgcolor="#E8E8E8">电影信息</td>
    		</tr>
    		<tr>
    			<td>ID</td>
		    	<td>名称</td>
		    	<td>语言</td>
		    	<td>描述</td>
		    	<td>删除</td>
		    	<td>编辑</td>
   			</tr>
    		<%for(Film film:list){%>
    		<tr>
    			<td><%=film.getFilm_id() %></td>
    			<td><%=film.getTitle() %></td>
    			<td><%=film.getLanguageName() %></td>
    			<td><%=film.getDescription() %></td>
    			<td><b><a href="#">删除</a></b></td>
    			 <td><b><a href="<%=request.getContextPath()%>/editFilm?title=<%=film.getTitle() %>&description=<%=film.getDescription() %>&name=<%=film.getLanguageName() %>">编辑</a></b></td>
    			<%-- <td><b><a href="<%=request.getContextPath()%>/editFilm?film=<%=film%>">编辑</a></b></td> --%>
    		</tr>
    		<%} %>>
			<tr>
    			<td colspan="6" align="center">
    			<%if(Integer.parseInt(request.getParameter("cur")) == 0){ %>
    				<b>已是第一页</b>
    			<%}else{ %>
    				<b><a href="<%=request.getContextPath()%>/searchFilm?cur=<%=Integer.parseInt(request.getParameter("cur"))-1%>">上页</a></b>
    			<%} %>
    				<b><a href="<%=request.getContextPath()%>/searchFilm?cur=<%=Integer.parseInt(request.getParameter("cur"))+1%>">下页</a></b>
    			</td>
    		</tr>	
    	</table>

  </body>
</html>
