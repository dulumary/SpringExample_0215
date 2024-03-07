package com.marondal.spring.ex.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.ex.jsp.domain.User;
import com.marondal.spring.ex.jsp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public int addUser(
			String name
			, String birthday
			, String email
			, String introduce) {
		
		int count = userRepository.insertUser(name, birthday, email, introduce);
		return count;
		
	}
	
	public int addUserByObject(User user) {
		
		int count = userRepository.insertUserByObject(user);
		return count;
		
	}
	
	public User getLastUser() {
		User user = userRepository.selectLastUser();
		
		return user;
	}
	
	public List<User> getUserList() {
		
		List<User> userList = userRepository.selectUserList();
		
		return userList;
		
	}
	
	// email 중복여부를 알려주는 기능
	public boolean isDuplicateEmail(String email) {
		
		int count = userRepository.selectCountByEmail(email);
		
		// count가 1이상이면 중복
		if(count >= 1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	

}
