package site.metacoding.mvc.config.web;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.metacoding.mvc.config.domain.MyUser;
import site.metacoding.mvc.config.domain.MyUserRepository;

// 회원 관련 요청만 컨트롤 
// usertbl만 관리하는 컨트롤러 => user만 관리함.
public class MyUserController {
	private MyUserRepository repo;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public MyUserController(HttpServletRequest request,HttpServletResponse response) {
		this.request = request;
		this.response = response;
		repo = new MyUserRepository();
	}
	
	// GET:http://localhost:8000/myuser
	public void getAll() {
		List<MyUser> myUsers = repo.selectAll();
		request.setAttribute("myUsers", myUsers);
		try {
			RequestDispatcher dis = request.getRequestDispatcher("/user.jsp"); // 재요청할때 앞에 Request를 자기의 Request 덮어씌움 
			dis.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// GET:http://localhost:8000/myuser?id=1
	public void getOne(int id) {
		System.out.println("getOne 호출됨");
		MyUser myUser = repo.selectById(id);
		System.out.println("myUser : "+ myUser.getUsername());
		request.setAttribute("myUser", myUser); // 왼쪽은 키값을 저장, 오른쪽은 값을 저장.
		try {
			// response.sendRedirect("/userInfo.jsp"); // userInfo가 없을수도 있기 때문에 try-catch사용 // 재요청하면서 request삭제됨
			RequestDispatcher dis = request.getRequestDispatcher("/userInfo.jsp"); // 재요청할때 앞에 Request를 자기의 Request 덮어씌움 
			dis.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
