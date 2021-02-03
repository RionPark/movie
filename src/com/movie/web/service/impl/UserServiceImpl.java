package com.movie.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.movie.web.dao.UserDAO;
import com.movie.web.dao.impl.UserDAOImpl;
import com.movie.web.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO = new UserDAOImpl();
	
	@Override
	public List<Map<String, String>> selectUserList(Map<String, String> user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> selectUser(int uiNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> insertUser(Map<String, String> user) {
		Map<String, String> rMap = new HashMap<>();
		rMap.put("msg", "회원가입에 성공하셨습니다.");
		rMap.put("result", "1");
		int result = userDAO.insertUser(user);
		if(result!=1) {
			rMap.put("msg", "회원가입에 실패하였습니다.");
			rMap.put("result", "0");
		}
		return rMap;
	}

	@Override
	public Map<String, String> updateUser(Map<String, String> user) {
		Map<String, String> rMap = new HashMap<>();
		rMap.put("msg", "회원가입에 성공하셨습니다.");
		rMap.put("result", "1");
		int result = userDAO.insertUser(user);
		if(result!=1) {
			rMap.put("msg", "회원가입에 실패하였습니다.");
			rMap.put("result", "0");
		}
		return rMap;
	}

	@Override
	public Map<String, String> deleteUser(int uiNum) {
		// TODO Auto-generated method stub
		return null;
	}

}
