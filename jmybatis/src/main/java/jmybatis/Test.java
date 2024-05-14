package jmybatis;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		
		
		DBUtil my = new DBUtil();
		
		my.init();
		Scanner sc = new Scanner(System.in);
				
		System.out.println("[1.입력 2.수정 3.삭제 4.조회 5.로그인]");
		
		
		while(true) {
		
		int num =sc.nextInt();
		sc.nextLine();
		
		// insert 입력
		
		if(num ==1 ) {
			System.out.println("[값을 입력합니다.]");
			System.out.println("아이디 입력 : ");
			String user_id =sc.nextLine();
			
		
			System.out.println("비번 입력 : ");
			String user_pw=sc.nextLine();
			
			
			System.out.println("이름 입력 : ");
			String name=sc.nextLine();
			
			
			System.out.println("전화번호 입력 (예시:010-0000-0000) : ");
			String phone= sc.nextLine();
			
			System.out.println("등급 입력 : ");
			String grade=sc.nextLine();
			
			System.out.println("나이 입력 : ");
			int age = sc.nextInt();
			
			my.insertUser(user_id, user_pw, name, phone, grade, age);

			System.out.println("[1.입력 2.수정 3.삭제 4.조회]");
		} 
		
		// UPDATE 수정
		
		else if(num==2) {
		System.out.println("[값을 수정합니다.]");
		System.out.println("바꿀 이름 입력 : ");
		String name = sc.nextLine();
		System.out.println("수정할 아이디 입력 : ");
		String user_id = sc.nextLine();
		
		my.updateUser(name, user_id);
		System.out.println("[1.입력 2.수정 3.삭제 4.조회]");
	
	     
	     }
		
		//DELTETE 삭제
		
		
		else if(num==3) {
				System.out.println("[값을 삭제합니다]");
				System.out.println("삭제할 아이디 입력 : ");
				String id = sc.nextLine();
				
				my.deleteUser(id);
				System.out.println("[1.입력 2.수정 3.삭제 4.조회]");
				
				
				
				
			}
		
		//SELECT 조회
		
		
		else if(num==4) {
				
			ArrayList<UserDTO> list =my.getUser();
			System.out.println(list);
			
				
				
			} 
		
		
		// 로그인 조회
		
		
		else if (num ==5) {
			while(true) {
				System.out.println("아이디 입력 : ");
				String id =sc.nextLine();
				
				System.out.println("비번 입력 : ");
				String pw =sc.nextLine();
				
				my.login(id, pw);
				
			}
			
		}
		System.out.println("HIII");
		System.out.println("또 수정함");
		
	}

	}
	}
