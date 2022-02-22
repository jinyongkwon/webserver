<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
	<li>
		<a href="/user/login.html">로그인페이지</a>
	</li>
	<li>
		<a href="/user/join.html">회원가입페이지</a>
	</li>
	<li>
		<a href="/user/userInfo.jsp">회원정보페이지</a>
	</li>
	<li>
		<a href="/post/list.html">글목록페이지</a>
	</li>
</ul>

<%
	// request는 BufferedReader로 읽는 모든 정보를 자바 오브젝트로 바꾼 결정체 (톰켓이 해줌)
	// http://localhost/user/userInfo.jsp?name=권진용
	// getParameter() 쿼리스트링 파싱해주는 메서드
	//String name = request.getParameter("name");
	//String phone = request.getParameter("phone");
	// DB연결 - SELECT
	//String name = "권진용";
	//String phone = "01024781178";
	
	// 1. 테이블 생성
	
	// 2. 쿼리스트링 파싱
	int id = Integer.parseInt(request.getParameter("id"));
	String name =null;
	String phone= null;
	// 3. DB연결 코드
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
	// 4. SELECT로 id, name, phone 받기
	String sql = "SELECT id, name, phone FROM userlist WHERE id=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, id);
	pstmt.executeQuery();
	ResultSet rs = pstmt.executeQuery();
	
	// 5. 뿌려주기
	rs.next();
	id=rs.getInt("id");
	name = rs.getString("name");
	phone = rs.getString("phone");
	
%>

<h1>회원정보 페이지입니다. - 인증 필요</h1>
<h3>아이디 : <%=id %> 이름 : <%=name %> 전화번호 : <%=phone %></h3>
<hr/>
</body>
</html>