package site.metacoding.servletproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:80/index.jsp (URL)
// http://localhost:80/hello (URI)
@WebServlet("/hello") // 주소 뒤에 /hello가 들어오면 자동으로 Get이 요청됨.
public class TestServlet extends HttpServlet {

	// protected : 자식만 쓸수있는 메서드
	// request를 담아서 response로 응답.
	@Override 
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	// 사용자에게 받은 http body, http header 정보를 HttpServletRequest req 에 담고
	// 그 친구한테 응답될 빈 객체 HttpServletResponse resp를 만들어서
	// doGet(req,rest); 담아서 호출해준다. (아파치/톰캣에 의해 호출됨)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Get 요청됨");
		
		String name = "Jinyong";
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello EveryOne "+name+"</h1>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
