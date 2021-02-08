package com.movie.web.service;

import java.util.List;
import java.util.Map;

public interface UserService {

	List<Map<String,String>> selectUserList(Map<String,String> user);
	Map<String,String> selectUser(int uiNum);
	Map<String,String> login(Map<String,String> user);
	Map<String,String> insertUser(Map<String,String> user);
	Map<String,String> updateUser(Map<String,String> user);
	Map<String,String> deleteUser(Map<String,String> user);
}
