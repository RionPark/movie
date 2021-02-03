package com.movie.web.dao;

import java.util.List;
import java.util.Map;

public interface UserDAO {

	List<Map<String,String>> selectUserList(Map<String,String> user);
	Map<String,String> selectUser(int uiNum);
	int insertUser(Map<String,String> user);
	int updateUser(Map<String,String> user);
	int deleteUser(int uiNum);
}
