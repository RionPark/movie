package com.movie.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.movie.web.conn.DBConn;
import com.movie.web.dao.TheaterDAO;

public class TheaterDAOImpl implements TheaterDAO {

	@Override
	public List<Map<String, String>> selectTheaterList(Map<String, String> theater) {
		List<Map<String, String>> theaterList = new ArrayList<>();	
		String sql = "select ti_num, ti_name, ti_address, ti_phone1, ti_phone2 from theater_info";
		sql += " order by ti_num desc";
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String, String> th =new HashMap<>();
				th.put("ti_num", rs.getString("ti_num"));
				th.put("ti_name", rs.getString("ti_name"));
				th.put("ti_address", rs.getString("ti_address"));
				th.put("ti_phone1", rs.getString("ti_phone1"));
				th.put("ti_phone2", rs.getString("ti_phone2"));
				theaterList.add(th);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(con,ps,rs);
		}
		return theaterList;
	}

	@Override
	public Map<String, String> selectTheater(int tiNum) {
		String sql = "select ti_num, ti_name, ti_address, ti_phone1, ti_phone2 from theater_info";
		sql += " where ti_num=?";
		sql += " order by ti_num desc";
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, tiNum);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String, String> th =new HashMap<>();
				th.put("ti_num", rs.getString("ti_num"));
				th.put("ti_name", rs.getString("ti_name"));
				th.put("ti_address", rs.getString("ti_address"));
				th.put("ti_phone1", rs.getString("ti_phone1"));
				th.put("ti_phone2", rs.getString("ti_phone2"));
				return th;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(con,ps,rs);
		}
		return null;
	}

	@Override
	public int insertTheater(Map<String, String> theater) {
		String sql = "insert into theater_info(ti_num, ti_name, ti_address, ti_phone1, ti_phone2)";
		sql += "values(seq_ti_num.nextval, ?, ?, ?, ?)";
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, theater.get("ti_name"));
			ps.setString(2, theater.get("ti_address"));
			ps.setString(3, theater.get("ti_phone1"));
			ps.setString(4, theater.get("ti_phone2"));
			int cnt = ps.executeUpdate();
			con.commit();
			return cnt;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(con,ps);
		}
		return 0;
	}

	@Override
	public int updateTheater(Map<String, String> theater) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTheater(int tiNum) {
		String sql = "delete from theater_info where ti_num=?";
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, tiNum);
			int cnt = ps.executeUpdate();
			con.commit();
			return cnt;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(con,ps);
		}
		return 0;
	}
	public static void main(String[] args) {
		TheaterDAO tDAO = new TheaterDAOImpl();
		System.out.println(tDAO.selectTheater(6));
	}
}
