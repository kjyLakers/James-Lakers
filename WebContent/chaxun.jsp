<%@ page language="java" contentType="text/html; charset=utf-8" import="java.sql.*" import="java.util.*"
    pageEncoding="utf-8"%>
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
	 String id =request.getParameter("id");
	   Statement stmt = connect.createStatement();
	   
	   request.setCharacterEncoding("UTF-8");
	   String sql="select * from news where id= '"+id+"'";
      ResultSet ss =stmt.executeQuery(sql);   
      while(ss.next()){
   	   
    	  
   
   	    %>
   	  <div style="text-align: center;"><h1><%=ss.getString(2) %></h1></div><hr>
<!-- 
   	<div>
    <div style="text-align: left;"><%=ss.getString(2) %></div>
   	<div style="text-align: right;"><%=ss.getString(3) %></div>
   	</div>
   	
   -->
   
<div style="position: absolute;">发布人：<%=ss.getString(3) %></div>
<div style="position: absolute; margin-left: 300px;">时间：<%=ss.getString(4) %></div>
<div style="position: absolute; margin-left: 800px;">浏览量：<%=ss.getString(6) %></div>
   <br>
   	  <br>
   	  <br>
   &nbsp;&nbsp;	<%=ss.getString(5)%>
   	
        <%      
	 }

	 }
	 catch(Exception e)
	 {
	 out.print("获得数据错误!");
	 e.printStackTrace();
	 }
%>




</body>
</html>