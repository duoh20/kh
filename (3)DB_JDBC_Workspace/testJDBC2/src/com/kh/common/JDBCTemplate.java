package com.kh.common;

import java.io.FileNotFoundException;
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
	//중복되는 JDBC 구문을 구현하는 클래스 생성^^*
	//싱글턴 패턴(ex_Callendar 클래스)으로 설정하여 객체 생성 없이 사용할 수 있는 클래스를 만든다.
	//	객체를 생성하지 못하도록 생성자를 private로 설정하여, 메소드 자체로 사용하게 하는 패턴
	
	private static Connection conn = null;
	
	private JDBCTemplate(){}; //싱글턴 패턴
	
	/*  */
	public static Connection getConnection() { //한 번 생성하면 계속 사용할 수 있도록 static으로 지정
		
		if(conn == null) {
			try {
				//1) 직접 입력하기
				//Class.forName("orcle.jdbc.driver.OracleDriver"); //properties 파일로 만들어서 동적으로 주소를 관리하여 유지보수를 용이하게 한다.
				//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KH", "KH");
				
				//2) Properties를 사용하여 동적으로 관리
				//properties 파일로 만들어서 동적으로 주소를 관리하여 유지보수를 용이하게 한다.
				Properties prop = new Properties();
				prop.load(new FileReader("driver.properties"));
				Class.forName(prop.getProperty("driver"));
				conn = DriverManager.getConnection(prop.getProperty("url"),
												   prop.getProperty("user"),
												   prop.getProperty("password"));
				
				conn.setAutoCommit(false); //자동커밋 설정 off
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return conn;
	}
	
	/* */
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) { //conn이 null이 아니고, 닫혀있지 않다면
				conn.close(); //conn을 닫는다
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) { //다형성 특성으로 인해 PrepareStatement는 따로 구현하지 않고 이 메소드로 사용 가능
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
