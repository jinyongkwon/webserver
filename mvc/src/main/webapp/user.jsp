<%@page import="java.util.List"%>
<%@page import="site.metacoding.mvc.config.domain.MyUser"%>
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
List<MyUser> myUsers = (List<MyUser>)request.getAttribute("myUsers");
for(MyUser myUser : myUsers){ 
%>

아이디 : <%=myUser.getId() %> <br/>
유저네임 : <%=myUser.getUsername()%> <br/>
패스워드 : <%=myUser.getPassword()%> <br/>
이메일 : <%=myUser.getEmail() %> <br/>

<%} %>
</body>
</html>