<%@ page contentType="text/html; charset=gb2312" %>
<%@ page language="java" import="java.sql.*" import="java.sql.*" import="java.util.Date" import="java.text.SimpleDateFormat" 
pageEncoding="UTF-8"  %>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>

<html>
<head>
<base href="<%= basePath %>">
<title>helloworld.jsp</title>
</head>
<body>


<%
 try{
 Class.forName("org.gjt.mm.mysql.Driver");
 }
 catch(Exception e)
 {
 out.println("加载Mysql Driver失败!<br>");
 e.printStackTrace();
 }
 
 try{
 
 Connection connect=DriverManager.getConnection("jdbc:mysql://localhost/lakers?user=root&password=kang980628&useUnicode=true&characterEncoding=utf-8");
 //jdbc:mysql://localhost/testdb?user=root&password=mysql&useUnicode=true&characterEncoding=8859_1
 //jdbc:mysql://localhost/数据库名user=数据库登陆用户名&password=数据库登陆密码&useUnicode=是否允许设置字符编码&characterEncoding=允许设置编码时，要设置的编码;
     
   Statement stmt = connect.createStatement();
   request.setCharacterEncoding("UTF-8");
   String title=request.getParameter("title");
   String neirong =request.getParameter("neirong");
   String people =(session.getAttribute("username")).toString();
   Date today=new Date();
   
   SimpleDateFormat ss=new SimpleDateFormat("yyyyMMddHHmmss");
   String d=ss.format(today);
  
   String sql="delete from news where title=title";
   stmt.executeUpdate(sql);
   out.println("删除成功");
   
   
   

 }
 
 catch(Exception e)
 {
 out.print("获得数据错误!");
 e.printStackTrace();
 }


%>
	 <hr>
 <a href="zhucaidan.jsp"target="_self">返回主菜单</a><br/>
 
 
 
 
</body>
</html>