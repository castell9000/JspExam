<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.Language" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addFilm.jsp' starting page</title>
    
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
  <% List<Language> list = (List<Language>)request.getAttribute("languages"); %>
     <form action="<%=path%>/addFilm" method="post">
    	<table border="1" cellspacing="0" cellpadding="5" bordercolor="silver" align="center" >
    		<tr>
    			<td colspan="2" align="center" bgcolor="#E8E8E8">添加电影</td>
    		</tr>
    		<tr>
    			<td>电影名：</td>
    			<td><input type="text" name="title"/></td>	
    		</tr>
    		<tr>
    			<td>描述：</td>
    			<td><input type="text" name="description"/></td>			
    		</tr>
    		<tr>
    			<td>语言：</td>
    			<td>
    				<select name="select">
    				<%for( Language language:list){ %>
						<option value="<%=language.getLanguage_id()%>"><%=language.getName() %></option>     			
    				<%} %>
    				</select>
    			</td>			
    		</tr>
			<tr>
    			<td colspan="2" align="center">
    				<input type="submit" value="提交"/>
    				<input type="reset" value="重置"/>
    			</td>
    		</tr>	
    	</table>
    </form>
  </body>
</html>
