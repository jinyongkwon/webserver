package site.metacoding.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.metacoding.mvc.config.web.MyUserController;

// http://localhost:8000/ 
// http://localhost:8000/hello => /뒤에 뭐가 붙든 여기로 들어오게됨  => http://localhost:8000/과 같게 들어옴
// http://localhost:8000/myuser => myUserController로 보냄 
//http://localhost:8000/mypost => myPostController로 보냄 
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DBconn.getConnection(); // DB연결 테스트
		String domain = request.getRequestURI();
		
		System.out.println("유알아이 : "+ domain);
		if(domain.equals("/myuser")) {
			MyUserController controller = new MyUserController(request, response); // 컨트롤러가 많아지기 떄문에 전역으로 설정 x
			
			String idstr = request.getParameter("id");
			
			if(idstr == null) {
				controller.getAll();
			}else {
				int id = Integer.parseInt(idstr);
				controller.getOne(id);
			}
		}
	} // Dispather 스레드가 종료 (1. 클라이언트에게 연결된 response 선 짤림, 2. request 메모리영역 삭제, 3. DB Connection 반납)

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	} // Dispather 스레드가 종료

}
