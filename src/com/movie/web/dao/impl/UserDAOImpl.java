package com.movie.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		String sql = "select * from user_info where ui_num=?";
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, uiNum);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String, String> rUser = new HashMap<>();
				rUser.put("ui_num", rs.getString("ui_num"));
				rUser.put("ui_id", rs.getString("ui_id"));
				rUser.put("ui_pwd", rs.getString("ui_pwd"));
				rUser.put("ui_name", rs.getString("ui_name"));
				rUser.put("ui_address", rs.getString("ui_address"));
				rUser.put("ui_credat", rs.getString("credat"));
				rUser.put("ui_cretim", rs.getString("cretim"));
				rUser.put("ui_moddat", rs.getString("moddat"));
				rUser.put("ui_modtim", rs.getString("modtim"));
				rUser.put("ui_phone1", rs.getString("ui_phone1"));
				rUser.put("ui_phone2", rs.getString("ui_phone2"));
				rUser.put("ui_genre", rs.getString("ui_genre"));
				rUser.put("ui_email", rs.getString("ui_email"));
				rUser.put("ui_hint", rs.getString("ui_hint"));
				rUser.put("ui_answer", rs.getString("ui_answer"));
				rUser.put("ui_img", rs.getString("ui_img"));
				return rUser;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(con,ps,rs);
		}
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
				"MODTIM,ui_img)";
		sql += " values(seq_ui_num.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_char(sysdate,'YYYYMMDD'),\r\n" + 
				"TO_CHAR(SYSDATE,'HH24MISS'),to_char(sysdate,'YYYYMMDD'),\r\n" + 
				"TO_CHAR(SYSDATE,'HH24MISS'),?)";
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
			ps.setString(11, user.get("ui_img"));
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
		String sql = "update user_info"
				+ " set ui_pwd=?,"
				+ " ui_genre=?,"
				+ " ui_email=?,"
				+ " ui_phone1=?,"
				+ " ui_phone2=?,"
				+ " ui_address=?,"
				+ " ui_hint=?,"
				+ " ui_answer=?,"
				+ " moddat=to_char(sysdate,'YYYYMMDD'),"
				+ " modtim=to_char(sysdate,'HH24MISS')"
				+ " WHERE ui_num=?";
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.get("ui_pwd"));
			ps.setString(2, user.get("ui_genre"));
			ps.setString(3, user.get("ui_email"));
			ps.setString(4, user.get("ui_phone1"));
			ps.setString(5, user.get("ui_phone2"));
			ps.setString(6, user.get("ui_address"));
			ps.setString(7, user.get("ui_hint"));
			ps.setString(8, user.get("ui_answer"));
			ps.setString(9, user.get("ui_num"));
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
	public int deleteUser(int uiNum) {
		String sql = "delete from user_info where ui_num=?";
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, uiNum);
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
	public Map<String, String> selectUser(Map<String, String> user) {
		String sql = "select * from user_info where ui_id=? and ui_pwd=?";
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.get("ui_id"));
			ps.setString(2, user.get("ui_pwd"));
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String, String> rUser = new HashMap<>();
				rUser.put("ui_num", rs.getString("ui_num"));
				rUser.put("ui_id", rs.getString("ui_id"));
				rUser.put("ui_pwd", rs.getString("ui_pwd"));
				rUser.put("ui_name", rs.getString("ui_name"));
				rUser.put("ui_address", rs.getString("ui_address"));
				rUser.put("ui_credat", rs.getString("credat"));
				rUser.put("ui_cretim", rs.getString("cretim"));
				rUser.put("ui_moddat", rs.getString("moddat"));
				rUser.put("ui_modtim", rs.getString("modtim"));
				rUser.put("ui_phone1", rs.getString("ui_phone1"));
				rUser.put("ui_phone2", rs.getString("ui_phone2"));
				rUser.put("ui_genre", rs.getString("ui_genre"));
				rUser.put("ui_email", rs.getString("ui_email"));
				rUser.put("ui_hint", rs.getString("ui_hint"));
				rUser.put("ui_answer", rs.getString("ui_answer"));
				rUser.put("ui_img", rs.getString("ui_img"));
				return rUser;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(con,ps,rs);
		}
		return null;
	}
}
