<%@ page language="java" contentType="text/html; charset=utf-8" import="java.sql.*" import="java.util.*"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="fabuxinxi.jsp"target="_self">发布新信息</a><br/>
<hr>
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
	 //jdbc:mysql://localhost/testdb?user=root&password=mysql&useUnicode=true&characterEncoding=8859_1
	 //jdbc:mysql://localhost/数据库名user=数据库登陆用户名&password=数据库登陆密码&useUnicode=是否允许设置字符编码&characterEncoding=允许设置编码时，要设置的编码;

	   Statement stmt = connect.createStatement();
	   request.setCharacterEncoding("UTF-8");
	   String sql="select  *  from   news order by date desc ";
       ResultSet ss =stmt.executeQuery(sql);  
       out.println("<table><tr><td>标题</td><td>发布时间</td><td>操作</td></tr>");
       
       while(ss.next()){
    	   out.println("<tr><td>"+ss.getString(2)+"</td><td>"+ss.getString(4)+"</td>");
    	   String id=ss.getString(1);
    	    %>
    	  
    	 <td>  <a href="chaxun.jsp?id=<%=id %>">查询</a></td>
    	 <td>  <a href="xiugai.jsp?id=<%=id %>">修改</a></td>
    	 <td>  <a href="delete.jsp?id=<%=id %>">删除</a></td> 
      </tr>
         <%      
	 }	 
       out.print("</table>");
	 }
	 catch(Exception e)
	 {
	 out.print("获得数据错误!");
	 e.printStackTrace();
	 }
%>





</body>
</html>