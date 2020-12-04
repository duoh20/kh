package common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	//커넥션 객체를 반환하는 템플릿 생성
	
	
	private JDBCTemplate() {}
	
	
	/* 커넥션을 생성하는 메소드 */
	public static Connection getConnection() {
		
		String fileName = JDBCTemplate.class.getResource("/sql/driver.properties").getPath();
		//JDB템플릿 안 클래스에서 자원을 경로에서 가져오겠다.
		
		//반환할 Connection 객체 생성
		Connection conn = null;
		
		//Properties 객체 생성
		Properties prop = new Properties();
		
		
		//properties 파일 읽어오기
		try {
			prop.load(new FileReader(fileName));
			
			//driver 생성, driver 주소는 properies 파일에서 불러옴
			Class.forName(prop.getProperty("driver"));
			
			conn = DriverManager.getConnection(prop.getProperty("url"),
										       prop.getProperty("username"),
											   prop.getProperty("password"));
			
			//자동으로 커밋하지 않도록 설정
			conn.setAutoCommit(false);
			
		} catch (IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	
	/* 자원 반납 메소드 생성 */
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rest) {
		try {
			if(rest != null && !rest.isClosed()) {
				rest.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		try {
			if(pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/* commit, rollback 메소드 생성 */
	public static void commit(Connection conn) {
		try {
			if(conn != null && conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}