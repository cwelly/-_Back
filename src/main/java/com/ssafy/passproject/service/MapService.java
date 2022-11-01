package com.ssafy.passproject.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.passproject.dto.MapInfo;

public interface MapService {
	List<MapInfo> searchDong(String sido ,String dong, String gugun) throws SQLException;
	List<MapInfo> searchName(String name) throws SQLException;
	List<MapInfo> sortAmount(List<MapInfo> list);
	List<MapInfo> sortArea(List<MapInfo> list);
	List<MapInfo> sortYear(List<MapInfo> list);
	
}
