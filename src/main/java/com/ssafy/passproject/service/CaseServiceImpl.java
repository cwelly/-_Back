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
	public List<Case> getCaseFit(String sex , String trans ,String age) throws SQLException {
		Map<String, Object> map =new HashMap<>();
		System.out.println("서비스로 들어온  sex값 : "+sex+" , age값 : "+age+" , trans 값 : "+trans );
		map.put("sex", sex);
		map.put("trans", trans);
		if(age.equals("null")) {
			map.put("sm","null");
		}else {
			int realAge = Integer.parseInt(age);
			if(realAge<6) {
				map.put("sm",0);
				map.put("lg",5);
			}
			else if(realAge<13) {
				map.put("sm",6);
				map.put("lg",12);				
			}
			else if(realAge<19) {
				map.put("sm",13);
				map.put("lg",18);
			}
			else if(realAge<30) {
				map.put("sm",19);
				map.put("lg",29);
			}
			else if(realAge<50) {
				map.put("sm",30);
				map.put("lg",49);
			}
			else if(realAge<65) {
				map.put("sm",50);
				map.put("lg",64);
			}
			else {
				map.put("sm",65);
				map.put("lg",100);
			}
		}
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
