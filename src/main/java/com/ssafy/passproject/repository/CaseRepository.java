package com.ssafy.passproject.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.passproject.dto.Case;

@Mapper
public interface CaseRepository {
	
	// 1번 기능
	List<Case> getCaseAll()throws SQLException;
	List<Case> getCaseByTrans( String trans )throws SQLException;
	List<Case> getCaseByAge(Map<String, Integer> map)throws SQLException;
	List<Case> getCaseBySex(String sex)throws SQLException;
	
	
	// 2번 기능   sex =null , sm =null , trans =null 로 디폴트 설정한후에
	//  입력받은 값들로 입력.
	List<Case> getCaseFit(Map<String, Object> map)throws SQLException;
	
	// 3번 기능
	List<Case> getCaseWayout(Map<String, String> map)throws SQLException;
	
}
