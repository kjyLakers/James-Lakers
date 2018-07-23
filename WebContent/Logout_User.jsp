<%@ page language="java" contentType="text/html; charset=utf-8" import="java.sql.*" errorPage=""
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注销登录</title>
</head>
<body>
<%
session.removeAttribute("username");   //清空Session变量
response.sendRedirect("zhucaidan.jsp");

%>
</body>
</html>