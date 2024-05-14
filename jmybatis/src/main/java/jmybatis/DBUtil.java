package jmybatis;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {
	SqlSessionFactory sqlSessionFactory;
	
	public void init() {
		
	
	
	try {
		String resource = "jmybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		
		
		
	} catch(Exception e) { 
		System.out.println("mybatis 설정 파일 가져오기 실패");
		
	e.printStackTrace();
	}
	}

	public ArrayList<UserDTO> getUser() {
		//sql문 처리
		SqlSession session = sqlSessionFactory.openSession();
			  UserMapper mapper = session.getMapper(UserMapper.class);
			  ArrayList<UserDTO> userlist=mapper.getUser();
			  
			  return userlist;
			
	}
	
	//INSERT
	
	public void insertUser(String user_id, String user_pw, String name, String phone, String grade, int age) {
		
		SqlSession session = sqlSessionFactory.openSession();
		 UserMapper mapper = session.getMapper(UserMapper.class);
		UserDTO userDTO =new UserDTO(user_id, user_pw, name, phone, grade, age);
		mapper.insertUser(userDTO);
		session.commit(); // insert, update, delete 에만 해당 (필수)
	}
	
	//update
	
	public void updateUser(String name, String user_id) {
		
		SqlSession session = sqlSessionFactory.openSession();
		  UserMapper mapper = session.getMapper(UserMapper.class);
		
		mapper.updateUser(name, user_id);
		session.commit();
	}
	
	
	//delete
	public void deleteUser(String user_id) {
		SqlSession session = sqlSessionFactory.openSession();
		  UserMapper mapper = session.getMapper(UserMapper.class);
		
		mapper.deleteUser(user_id);
		session.commit();
		
	}

	

		
	

	public void login(String user_id, String user_pw ) {
		UserDTO dto = new UserDTO();
		
		
		SqlSession session = sqlSessionFactory.openSession();
		int count =session.selectOne("loginCh", user_id);
		  
		if(count==0) {
			System.out.println("아이디 존재 xx");
		}else {
			dto =session.selectOne("login", user_id);
			if(user_pw.equals(dto.getUser_pw())) {
				System.out.println(dto.getName()+"로그인 성공");
			} else {
				System.out.println("비번 존재 xx");
			}
		}
		  
		
	}
	
	
	
	
	
	
}
