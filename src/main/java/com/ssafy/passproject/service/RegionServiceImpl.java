package com.ssafy.passproject.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.passproject.dto.Dong;
import com.ssafy.passproject.dto.Region;
import com.ssafy.passproject.repository.RegionRepository;

@Service
public class RegionServiceImpl implements RegionService {
	
	
	
	private RegionRepository regionRepository;
	@Autowired
	private RegionServiceImpl( RegionRepository regionRepository ) {
		this.regionRepository = regionRepository;
	}
	
	

	@Override
	public List<Dong> getInterestRegionByUserno(int userno) throws SQLException {
		return regionRepository.findInterestRegionByUserno(userno);
	}

	@Override
	public List<Region> getSidoList() throws SQLException {
		return regionRepository.findSidoList();
	}

	@Override
	public List<Region> getGugunList(String sidoCode) throws SQLException {
		return regionRepository.findGugunList(sidoCode);
	}

	@Override
	public List<Region> getDongList(String gugunName) throws SQLException {
		return regionRepository.findDongList(gugunName);
	}

}
