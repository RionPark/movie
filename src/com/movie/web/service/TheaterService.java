package com.movie.web.service;

import java.util.List;
import java.util.Map;

public interface TheaterService {

	List<Map<String,String>> selectTheaterList(Map<String,String> theater);
	Map<String,String> selectTheater(int tiNum);
	Map<String,String> insertTheater(Map<String,String> theater);
	Map<String,String> updateTheater(Map<String,String> theater);
	Map<String,String> deleteTheater(int tiNum);
}
