<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/nav.css">
</head>


<body>
<% if(request.getParameter("ww")!=null){
    String aa=request.getParameter("ww");
    if(aa.equals("error")){
    out.println("<script>alert('用户名和密码错误')</script>");
    }
}
%>  

  <div class="login">
 <h3 >用户登录</h3>

<form  method="post" action="yanzhengdenglu.jsp" class="login_form">  
    账户: 
	<input  type="text"  name="lakers"  class="user"/>
	<br>
	密码: 
    <input  type="password"  name="lakers"   class="password"/><br> 
    
    
 <input type="submit" value="确定" class="ok" style="color:#fff;" />
    <input type="reset" value="重置" class="reset"  /></form>
    
    <br>
    
    <form  method="post" action="zhuce.jsp" class="reg_form">
 
  
 </form><br>
 </div>
   </center>
</body>
</html> 






