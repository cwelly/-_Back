package com.ssafy.passproject.repository;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.passproject.dto.Dong;
import com.ssafy.passproject.dto.Region;
@Mapper
public interface RegionRepository {

	List<Dong> findInterestRegionByUserno(int userno) throws SQLException;
	List<Region> findSidoList() throws SQLException;
	List<Region> findGugunList(String sidoCode) throws SQLException;
	List<Region> findDongList(String gugunName) throws SQLException;
}
