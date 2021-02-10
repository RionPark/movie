package com.movie.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.movie.web.dao.TheaterDAO;
import com.movie.web.dao.impl.TheaterDAOImpl;
import com.movie.web.service.TheaterService;

public class TheaterServiceImpl implements TheaterService {

	private TheaterDAO theaterDAO = new TheaterDAOImpl();
	@Override
	public List<Map<String, String>> selectTheaterList(Map<String, String> theater) {
		return theaterDAO.selectTheaterList(theater);
	}

	@Override
	public Map<String, String> selectTheater(int tiNum) {
		return theaterDAO.selectTheater(tiNum);
	}

	@Override
	public Map<String, String> insertTheater(Map<String, String> theater) {
		int cnt = theaterDAO.insertTheater(theater);
		Map<String,String> rMap = new HashMap<>();
		rMap.put("msg", "성공 했슈~");
		if(cnt!=1) {
			rMap.put("msg", "까비~");
		}
		rMap.put("result", cnt+"");
		return rMap;
	}

	@Override
	public Map<String, String> updateTheater(Map<String, String> theater) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> deleteTheater(int tiNum) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		TheaterService tService = new TheaterServiceImpl();

		System.out.println(tService.selectTheater(6));
	}
}
