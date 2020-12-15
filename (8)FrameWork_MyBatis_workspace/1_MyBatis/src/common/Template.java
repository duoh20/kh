package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		
		try {
			//MyBatis의 정보를 가지고 있는 mybaits-config.xml 불러옴
			InputStream inputStream = Resources.getResourceAsStream("/mybatis-config.xml");
			
			//1. SqlSessionFactoryBuiler 객체 ssfb 생성
			//SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		
			//2. 가져온 mybatis-config,xml을 ssfb의 builder() 메소드에 보내 SqlSessionFactory 객체 ssf 생성 
			//SqlSessionFactory ssf = ssfb.build(inputStream);
			
			//3. ssf객체의 openSession() 메소드의 인자로 false를 보내 자동 저장 옵션을 해제하여 SqlSession.session 생성
			//sseion = ssf.openSession(false);
			
			session = new SqlSessionFactoryBuilder().build(inputStream).openSession(false);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return session;
	}
}
