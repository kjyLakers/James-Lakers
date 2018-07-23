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


   
  <form  method="post" action="querenxiugai.jsp?id=<%=id %>">
      标题: 
	<textarea cols="100" rows="1" name="title"> <%=ss.getString(2) %></textarea>
	<br>
	内容:<br> 
    <textarea cols="100" rows="35" name="neirong"> <%=ss.getString(5) %></textarea>
 <input type="submit" value="确认修改"  />
    <input type="reset" value="重置"  /></form>

   	
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