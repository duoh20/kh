package com.kh.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.controller.EmployeeController;
import com.kh.model.vo.Employee;


public class EmployeeDAO {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rset = null;
	ArrayList<Employee> list = null; //필드에서 생성하면 메소 안에서 매번 값을 비워줘야하므로 변수만 선언함
	
	public ArrayList<Employee> selectAll() {//외워야함!
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //외워야함!!
			//SCOTT 계정에 접속한 후,
			//jdbc타입은 thin, 어떤 아이피에 접속했는지(@127.0.0.1은 내 아이피를 뜻함), 리스너, 종료
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "SCOTT", "SCOTT");
			//쿼리문 끝에 ;는 생략해야함 DB에서 자동으로 ; 붙여주기 때문에 붙이면 에러남			
			String query = "SELECT * FROM EMP";
			
			//Statement VS PreparedStatement
			// 쿼리 완성         쿼리 미완성
			
			stmt = conn.createStatement();
			
			//SELEC 사용 -> ResultSet 반환 -> executeQury()
			//DML(INSERT, UPDATE, DELETE) 사용 -> int 반환 -> executeUpdate()
			
			rset = stmt.executeQuery(query);
			//결과로 0~n개의 데이터가 Employee 객체에 담겨 컬랙션으로 반환 반환될 수 있다.
			list = new ArrayList<Employee>();
			//ResultSet으로 반환되는 Employee 객체들 담은 ArrayList 생성, Employee 타입만 받도록 제한		
			Employee emp = null;
			
			while(rset.next()) { //ResultSet에 다음 값(행)이 있다면 반복문 실행
				int empNo = rset.getInt("EMPNO");
				String empName = rset.getString("ENAME");
				String job = rset.getString("JOB"); 
				int mgr = rset.getInt("MGR"); //NUMBER의 NULL값은 int 기본 값으로 가져옴
				Date hireDate = rset.getDate("HIREDATE"); //DB에 넣을 것이므로 DATE는 sql 패키지를 import함
				int sal = rset.getInt("SAL");
				int comm = rset.getInt("comm"); //컬럼명은 대소문자 구분 안함!
				int deptNo = rset.getInt("DeptNo");
				// !!주의!! 쿼리의 SELECT 구문애 별칭을 붙이면 물리키는 인식 못하기 때문애 별칭으로 가져와야함
				
				emp = new Employee(empNo, empName, job, mgr, hireDate, sal, comm, deptNo);
				list.add(emp);
			}		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public Employee selectEmployee(int empNo) {
		
		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Employee emp = null;
		
		
		try {
			// 드라이버 호출
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 커넥션 생성 (@locallhost = @127.0.0.1 같은 말)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "SCOTT");
			
			//가져올 값에 대한 SQL 구문 생성
			//String query = "SELECT * FROM EMP WHERE EMPNO = " + empNo; // 위치홀더(?)가 없으면 완성임
			String pQuery = "SELECT * FROM EMP WHERE EMPNO = ?";
			
			//완성일 경우 statement（） 메소드 사용
			//stmt = conn.createStatement();
			pstmt = conn.prepareStatement(pQuery); //conn에 해당 계정의 모든 정보 담김
			pstmt.setInt(1, empNo); //1번째 위치홀더에 empNo를 넣음
			//rset = stmt.executßeQuery(query);
			rset = pstmt.executeQuery();
		
			//ResultSet의 결과는0개 아니면 1개, next를 이용해서 순차적으로 값을 읽어오자
			if(rset.next()) {
				String empName = rset.getString("ename");
				String job = rset.getString("job");
				int mgr = rset.getInt("mgr");
				Date hireDate = rset.getDate("hireDate");
				int sal = rset.getInt("sal");
				int comm = rset.getInt("comm");
				int deptNo = rset.getInt("deptNo");
				
				emp = new Employee(empNo, empName, job, mgr, hireDate, sal, comm, deptNo);
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				//stmt.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return emp;
	}
	
	public int insertEmployee(Employee e) {
		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "SCOTT");
			
//			String query = "INSERT INTO EMP VALUES(" + e.getEmpNo() + ", " +
//													e.getEmpName()+ ", " +
//													e.getJob() + ", " +
//													e.getMgr() + ", " +
//													"SYSDATE, " +
//													e.getSal() + ", " +
//													e.getComm() + ", " +
//													e.getDeptNo()+ ", " + ")";
			String query = "INSERT INTO EMP VALUES(?, ?, ?, ?, SYSDATE, ? , ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, e.getEmpNo());
			pstmt.setString(2, e.getEmpName());
			pstmt.setString(3, e.getJob());
			pstmt.setInt(4, e.getMgr());
			pstmt.setInt(5, e.getSal());
			pstmt.setInt(6, e.getComm());
			pstmt.setInt(7, e.getDeptNo());
			
			result = pstmt.executeUpdate();
			if(result > 0) {
					conn.commit();
			} else {
				conn.rollback();
			}
		
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return result;
	}

	public int updateEmployee(Employee e) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "SCOTT");
			
			String query = "UPDATE EMP SET JOB = ?, SAL = ?, COMM = ? WHERE EMPNO =?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, e.getJob());
			pstmt.setInt(2, e.getSal());
			pstmt.setInt(3, e.getComm());
			pstmt.setInt(4, e.getEmpNo());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit(); //확정
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return result;
	}

	public int deleteEmployee(int empNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "SCOTT");
		
			String query = "DELETE FROM EMP WHERE = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, empNo);
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			} 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close(); //자원 반납
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return result;
	}
}
