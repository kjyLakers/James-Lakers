<%@ page language="java" contentType="text/html; charset=utf-8" import="java.sql.*" import="java.util.*" import="java.util.Date"
  import="java.text.SimpleDateFormat"   pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	 
	 Connection connect=DriverManager.getConnection("jdbc:mysql://localhost/lakers?user=root&password=kang980628&useUnicode=true&characterEncoding=8859_1");
	 
	 Statement stmt = connect.createStatement();
	 String id =request.getParameter("id");
	   String sql="delete from news where id= '"+id+"'";
	  int ss =stmt.executeUpdate(sql);  
	  
	  
    String title=request.getParameter("title");
    String neirong =request.getParameter("neirong");
 
    String people =(session.getAttribute("username")).toString();
    
    Date today=new Date();
    SimpleDateFormat sss=new SimpleDateFormat("yyyyMMddHHmmss");
    String d=sss.format(today);
   
     
    String sql1="insert into news (title,people,date,neirong,liulanliang,laiyuan)values('"+title+"','"+people+"','"+d+"','"+neirong+"',0,'计算机通信学院')";
    stmt.executeUpdate(sql1);
    out.println("修改成功");
	 }
	 catch(Exception e)
	 {
	 out.print("获得数据错误!");
	 e.printStackTrace();
	 }
%>


</body>
</html>