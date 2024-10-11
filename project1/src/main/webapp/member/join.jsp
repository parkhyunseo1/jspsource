<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%
 	//한글 처리
 	request.setCharacterEncoding("utf-8");
 
 	String phonenum = request.getParameter("phonenum");
 	String name = request.getParameter("name");
 	String password = request.getParameter("password");
 	String id = request.getParameter("id");
 
 %>
 <ul>
 	<li>이름 : <%=name %></li>
 	<li>전화번호 : <%=phonenum %></li>
 	<li>password : <%=password %></li>
 	<li>아이디 : <%=id %></li>
 </ul>
</body>
</html>