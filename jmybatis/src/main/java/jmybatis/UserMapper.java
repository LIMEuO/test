package jmybatis;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	//리턴 타입, 메서드명, 매게변수
	

//select
	public ArrayList<UserDTO> getUser();
	
	//insert
	public void insertUser(UserDTO userDTO);
	
	//update
	public void updateUser(@Param("name") String name, @Param("user_id") String user_id);
	// 안될예정
	
	//delete
	public void deleteUser(String user_id);


	
	//id check
	public void longinCh(String user_id);
	
	//login
	public UserDTO login(String user_id, String user_pw);

	
	
	
}
