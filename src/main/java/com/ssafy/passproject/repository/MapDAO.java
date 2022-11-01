package com.ssafy.passproject.repository;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.passproject.dto.MapInfo;
@Mapper
public interface MapDAO {
	List<MapInfo> searchDong(String dong) throws SQLException;
	List<MapInfo> searchName(String name) throws SQLException;
}
