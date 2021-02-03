package com.movie.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.movie.web.conn.DBConn;
import com.movie.web.dao.UserDAO;

public class UserDAOImpl implements UserDAO{

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
	public int insertUser(Map<String, String> user) {
		String sql = "insert into user_info( UI_NUM,\r\n" + 
				"UI_NAME,\r\n" + 
				"UI_ID,\r\n" + 
				"UI_PWD,\r\n" + 
				"UI_GENRE,\r\n" + 
				"UI_EMAIL,\r\n" + 
				"UI_PHONE1,\r\n" + 
				"UI_PHONE2,\r\n" + 
				"UI_ADDRESS,\r\n" + 
				"UI_HINT,\r\n" + 
				"UI_ANSWER,\r\n" + 
				"CREDAT,\r\n" + 
				"CRETIM,\r\n" + 
				"MODDAT,\r\n" + 
				"MODTIM)";
		sql += " values(seq_ui_num.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_char(sysdate,'YYYYMMDD'),\r\n" + 
				"TO_CHAR(SYSDATE,'HH24MISS'),to_char(sysdate,'YYYYMMDD'),\r\n" + 
				"TO_CHAR(SYSDATE,'HH24MISS'))";
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.get("ui_name"));
			ps.setString(2, user.get("ui_id"));
			ps.setString(3, user.get("ui_pwd"));
			ps.setString(4, user.get("ui_genre"));
			ps.setString(5, user.get("ui_email"));
			ps.setString(6, user.get("ui_phone1"));
			ps.setString(7, user.get("ui_phone2"));
			ps.setString(8, user.get("ui_address"));
			ps.setString(9, user.get("ui_hint"));
			ps.setString(10, user.get("ui_answer"));
			cnt = ps.executeUpdate();
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(con,ps);
		}
		return cnt;
	}

	@Override
	public int updateUser(Map<String, String> user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(int uiNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {
		UserDAO userDAO = new UserDAOImpl();
		Map<String,String> user = new HashMap<>();
		user.put("ui_name", "name");
		user.put("ui_id", "id");
		user.put("ui_email", "email");
		user.put("ui_pwd", "pwd");
		user.put("ui_address", "address");
		user.put("ui_genre", "genre");
		user.put("ui_phone1", "010");
		user.put("ui_phone2", "62080018");
		user.put("ui_hint", "hint");
		user.put("ui_answer", "answer");
		System.out.println(userDAO.insertUser(user));
	}
}
