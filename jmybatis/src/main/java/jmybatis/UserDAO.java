package jmybatis;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
//데이터가 있는 저장소로 접근하는 유일한 객체 
	//직접 db에 접근해서 데이터를 삽입, 삭제, 조회 등등 조작 할수 있는 기능 수행
	//(crud를 수행함)
	
	
	// 데이터를 실제 db에 저장함 (mvc 패턴에서 model 역할)
	
	
	Connection conn =null;
	
	//쿼리문을 해석해주느 역할
	PreparedStatement pt = null;
	
	String dbDriver = "com.mysql.cj.jdbc.Driver";
	String dbUrl = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8 & serverTimezone=UTC";
	String dbId= "root";
	String dbPw= "1234";
	
	
	//insert문 구현
	//user table 데이터를 저장
	
	public void insertUser(UserDTO userDTO) {
		try {
			
			
			//jdbc 드라이버 로드 
			Class.forName(dbDriver);
			
			
			//db 연결하기
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			
			// sql 문, ?가 서진 순서로 변수를 구분함
			String insertSQL ="insert into user values(?, ?, ?, ?, ?, ?)";
			
			//conn에 sql문 전송 / db로 전달한다는 뜻
			pt =conn.prepareStatement(insertSQL);
			
			//sql 입력 값 설정
			pt.setString(1, userDTO.getUser_id());
			pt.setString(2, userDTO.getUser_pw());
			pt.setString(3, userDTO.getName());
			pt.setString(4, userDTO.getPhone());
			pt.setString(5, userDTO.getGrade());
			pt.setInt(6, userDTO.getAge());
			
			
			pt.executeUpdate();
			
			pt.close();
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
//select 문 구현
	
	public void selectUser() {
		List<UserDTO> users = new ArrayList<UserDTO>();
		
		try {
			
			
				Class.forName(dbDriver);
			
			
		
				conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			
				String selectSQL="select * from user";
			
				pt =conn.prepareStatement(selectSQL);
				ResultSet rs = pt.executeQuery();
				
				while(rs.next()) {
					UserDTO dto = new UserDTO(rs.getString("user_id"), rs.getString("user_pw"),
							rs.getString("name"), rs.getString("phone"), rs.getString("grade"),
							rs.getInt("age")
							
							
							);
							
					users.add(dto);
					
				}
				//한 행씩 출력
				
				for(UserDTO oneuser : users) {
					System.out.println(oneuser);
					
				}
				
				pt.close();
				conn.close();
				
				
				
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

// 업데이트랑 DELETE  구현
	
	public void updateUser(String name, String user_id) {
		try {
			Class.forName(dbDriver);
		
		
		
		conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
	
		String updateSQL="update user set name= ? where user_id=?";
		
		pt =conn.prepareStatement(updateSQL);
		
		pt.setString(1, name);
		pt.setString(2, user_id);
		
		pt.executeUpdate();
		
		pt.close();
		conn.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	
	
	
	
	
	public  void deleteUser(String id) {
		try {
			Class.forName(dbDriver);
			
			
			
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
		
			String deleteSQL="delete from user where user_id= ? ";
			pt =conn.prepareStatement(deleteSQL);
			
			pt.setString(1, id);
			
			pt.executeUpdate();
			
			pt.close();
			conn.close();
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}





