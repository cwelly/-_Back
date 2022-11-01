package com.ssafy.passproject.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.passproject.dto.MapInfo;
import com.ssafy.passproject.repository.MapDAO;

@Service
public class MapServiceImpl implements MapService {
	public static MapDAO mapDAO ;
	
	@Autowired
	public MapServiceImpl( MapDAO mapDAO)  {
		// TODO Auto-generated constructor stub
		this.mapDAO = mapDAO;
	}
	
	@Override
	public List<MapInfo> searchDong(String sido, String dong, String gugun) throws SQLException {

		return mapDAO.searchDong( dong);
	}

	@Override
	public List<MapInfo> searchName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return mapDAO.searchName(name);
	}

// 세션에서 받아온 list를 정렬 해서 , 다시 리턴하는 함수
	@Override
	public List<MapInfo> sortAmount(List<MapInfo> list) {
		List<MapInfo> sortedList = null;
		// 정렬 구현 코드
		Collections.sort(list, new Comparator<MapInfo>() {
			@Override
			public int compare(MapInfo o1, MapInfo o2) {
				String match = "[^0-9]";
				String str = o1.getDealAmount().replaceAll(match, "");
				int o1Amount = Integer.parseInt(str);
				str = o2.getDealAmount().replaceAll(match, "");
				int o2Amount = Integer.parseInt(str);

				return o1Amount - o2Amount;
			}
		});

		sortedList = list;
		//
		return sortedList;
	}

	@Override
	public List<MapInfo> sortArea(List<MapInfo> list) {
		List<MapInfo> sortedList = null;
		// 정렬 구현 코드
		Collections.sort(list, new Comparator<MapInfo>() {
			@Override
			public int compare(MapInfo o1, MapInfo o2) {
				double o1Area = Double.parseDouble(o1.getArea());
                double o2Area = Double.parseDouble(o2.getArea());
                                                
                return Double.compare(o1Area, o2Area);
			}
		});

		sortedList = list;
		//
		return sortedList;
	}

	@Override
	public List<MapInfo> sortYear(List<MapInfo> list) {
		List<MapInfo> sortedList = null;
		// 정렬 구현 코드
		Collections.sort(list, new Comparator<MapInfo>() {
			@Override
			public int compare(MapInfo o1, MapInfo o2) {
				String match = "[^0-9]";
				String str = o1.getBuildYear().replaceAll(match, "");
				int o1Amount = Integer.parseInt(str);
				str = o2.getBuildYear().replaceAll(match, "");
				int o2Amount = Integer.parseInt(str);

				return o1Amount - o2Amount;
			}
		});

		sortedList = list;
		//
		return sortedList;
	}
}
