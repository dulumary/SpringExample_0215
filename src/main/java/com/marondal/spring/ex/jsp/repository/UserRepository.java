package com.marondal.spring.ex.jsp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.marondal.spring.ex.jsp.domain.User;

@Mapper
public interface UserRepository {
	
	public int insertUser(
			@Param("name") String name
			, @Param("birthday") String birthday
			, @Param("email") String email
			, @Param("introduce") String introduce);
	
	public int insertUserByObject(User user);
	
	public User selectLastUser();
	
	public List<User> selectUserList();
	
	// 전달 받은 email 이 포함된 행의 개수 조회 
	public int selectCountByEmail(@Param("email") String email);
	
	
}
