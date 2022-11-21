package com.ssafy.passproject.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.passproject.dto.Case;
import com.ssafy.passproject.repository.CaseRepository;
@Service
public class CaseServiceImpl implements CaseService {
	public static CaseRepository caseRepository ;
	
	@Autowired
	public CaseServiceImpl(  CaseRepository caseRepository)  {
		// TODO Auto-generated constructor stub
		this.caseRepository = caseRepository;
	}
	
	@Override
	public List<Case> getCaseAll() throws SQLException {
		// TODO Auto-generated method stub
		return caseRepository.getCaseAll();
	}

	@Override
	public List<Case> getCaseByTrans(String trans) throws SQLException {
		// TODO Auto-generated method stub
		return caseRepository.getCaseByTrans(trans);
	}


	@Override
	public List<Case> getCaseByAge(int sm, int lg) throws SQLException {
		Map<String, Integer> map =new HashMap<>();
		map.put("sm", sm);
		map.put("lg", lg);
		return caseRepository.getCaseByAge(map);
	}
	
	@Override
	public List<Case> getCaseBySex(String sex) throws SQLException {
		return caseRepository.getCaseBySex(sex);
	}

	@Override
	public List<Case> getCaseFit(String sex , String trans ,int sm,  int lg) throws SQLException {
		Map<String, Object> map =new HashMap<>();
		map.put("sex", sex);
		map.put("trans", trans);
		map.put("sm", sm);
		map.put("lg", lg);
		return caseRepository.getCaseFit(map);
	}

	@Override
	public List<Case> getCaseWayout(String slat , String slng , String elat , String elng) throws SQLException {
		Map<String, String> map =new HashMap<>();
		map.put("slat", slat);
		map.put("slng", slng);
		map.put("elat", elat);
		map.put("elng", elng);
		return caseRepository.getCaseWayout(map);
	}


}
