package notice.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import notice.model.vo.Notice;

public class NoticeDAO {

	
	private Properties prop = new Properties();
	
	public NoticeDAO() {
		//SQL문을 import하기 위한 propertiy 파일을 불러오기
		String fileName = NoticeDAO.class.getResource("/sql/notice/notice-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		public ArrayList<Notice> selectList(Connection conn) {
			Statement stmt = null;
			ResultSet rset = null;
			ArrayList<Notice> list = new ArrayList<Notice>(); //notice를 담을 객체를 생성해둔다.
			
			String query = prop.getProperty("selectList");
			
			try {
				stmt = conn.createStatement();
				rset = stmt.executeQuery(query);
				
				while(rset.next()) {
					Notice no = new Notice(rset.getInt("notice_no"),
										   rset.getString("notice_title"),
										   rset.getString("notice_content"),
										   null,
										   rset.getString("nickname"),
										   rset.getInt("notice_count"),
										   rset.getDate("notice_Date"));
					list.add(no);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(stmt);
			}
		
			return list;
	}
		public int insertNotice(Connection conn, Notice n) {
			
			PreparedStatement pstmt = null;
			int result = 0;
			 String query = prop.getProperty("insertNotice");
			
			try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1, n.getNoticeTitle());
				pstmt.setString(2, n.getNoticeContent());
				pstmt.setString(3, n.getNoticeWriter());
				pstmt.setDate(4, n.getNoticeDate());
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return result;
		}
		public Notice selectNotice(Connection conn, int no) {
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			Notice notice = null;
			
			String query = prop.getProperty("detailNotice");
			try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setInt(1, no);
				
				rset= pstmt.executeQuery();
				
				if(rset.next()) {
					notice = new Notice(rset.getInt("notice_no"),
										rset.getString("notice_title"),
										rset.getString("notice_content"),
										rset.getString("notice_writer"),
										rset.getString("nickName"),
										rset.getInt("notice_count"),
										rset.getDate("notice_Date"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return notice;
		}
		
		public int updateCount(Connection conn, int no) {
			PreparedStatement pstmt = null;
			int result = 0;
			
			String query = prop.getProperty("updateCount");
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, no);
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
		}
		

}
