package com.ssafy.passproject.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.passproject.dto.Case;

public interface CaseService {
	// 1번 기능
		List<Case> getCaseAll()throws SQLException;
		List<Case> getCaseByTrans( String trans )throws SQLException;
		List<Case> getCaseByAge(int sm , int lg)throws SQLException;
		List<Case> getCaseBySex(String sex)throws SQLException;
		
		
		// 2번 기능   sex =null , sm =null , trans =null 로 디폴트 설정한후에
		//  입력받은 값들로 입력.
		List<Case> getCaseFit(String sex , String trans ,int sm,  int lg)throws SQLException;
		
		// 3번 기능
		List<Case> getCaseWayout(String slat , String slng , String elat , String elng)throws SQLException;
		
}
