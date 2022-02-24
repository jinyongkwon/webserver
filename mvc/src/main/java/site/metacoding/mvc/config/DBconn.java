package site.metacoding.mvc.config;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBconn {

	// 책임 : Connection 객체를 return
	public static Connection getConnection() { // 이미 만들어진 Connection을 리턴받기위한 메서드 => 연결하는 코드 x 연결되있는 것을 찾아 접근하는 코드 o
		Connection  conn = null; // 책임에 대한 것이기 때문에 전역으로 선언. 
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env"); // 정해진 것이라 고칠 필요가 없다 
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle"); // 이름이 뭔지 정하는 것이니 바꿔줘야 할수도 있다!!
			conn = ds.getConnection();
			System.out.println("DB연결 성공");
		} catch (Exception e) {
			System.out.println("DB연결 실패");
			e.printStackTrace();
			
		}
		
		return conn;
	}
}
