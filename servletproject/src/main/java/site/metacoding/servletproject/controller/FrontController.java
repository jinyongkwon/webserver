package site.metacoding.servletproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http 프로토콜 최초버전 (GET)
// http1.0 프로토콜 (GET, POST)
// http1.1 프로토콜 (GET(주소요청), POST(폼태그), DELETE(자바스크립트), PUT(자바스크립트))

// http://localhost:80/front
@WebServlet("/front")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FrontController() {
    	System.out.println("나 메모리에 떳어 : FrontController");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Front 컨트롤러로 요청들어옴.");
		
		// 1. 라우터 만들기
		String path =  request.getParameter("path");
		System.out.println("path : "+ path);
		if(path.equals("login")) {
			response.sendRedirect("/login.jsp"); // 다시 재요청 하는 것. => 나갔다가 다시 요청할때 URL방식으로 다시 요청. 
																				// ex) localhost/front?path=login => localhost/login.jsp로 다시요청
			// 로그인페이지를 응답
//			PrintWriter out = response.getWriter();
//			out.println("<!DOCTYPE html>");
//			out.println("<html>");
//			out.println("<head>");
//			out.println("<meta charset=\"UTF-8\">");
//			out.println("<title>Insert title here</title>");
//			out.println("</head>");
//			out.println("<body>");
//			out.println("<h1>LoginPage</h1>");
//			out.println("</body>");
//			out.println("</html>");
			
		}else if(path.equals("join")) {
			response.sendRedirect("/join.jsp");
			// 조인페이지를 응답
//			PrintWriter out = response.getWriter();
//			out.println("<!DOCTYPE html>");
//			out.println("<html>");
//			out.println("<head>");
//			out.println("<meta charset=\"UTF-8\">");
//			out.println("<title>Insert title here</title>");
//			out.println("</head>");
//			out.println("<body>");
//			out.println("<h1>JoinPage</h1>");
//			out.println("</body>");
//			out.println("</html>");
		}
	}

}
