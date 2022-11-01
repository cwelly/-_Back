package com.ssafy.passproject.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.passproject.dto.Dong;
import com.ssafy.passproject.dto.Region;

public interface RegionService {
	
	List<Dong> getInterestRegionByUserno(int userno) throws SQLException;
	List<Region> getSidoList() throws SQLException;
	List<Region> getGugunList(String sidoCode) throws SQLException;
	List<Region> getDongList(String dongName) throws SQLException;
}
