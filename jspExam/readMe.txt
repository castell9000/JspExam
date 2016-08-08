运行步骤：

1.进入文件目录jspExam下

2.部署到tomact：  mvn tomcat:run

3.在浏览器输入：http://localhost:8080/jspExam    进入主页面index.jsp，里面包含所有功能链接

4.登录名：例如，MARY 

5.功能：登录功能，电影列表功能，添加功能，生成静态html功能，权限控制，

6.连接数据库配置：在/src/main/java/com/util/路径下的ConnectorFactory.java中修改用户名root及密码shidaiqian为你的用户名及密码
	注：没有用配置文件，在语句中直接修稿

	删除电影未完成，链接无效