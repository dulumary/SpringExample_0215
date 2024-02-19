package com.marondal.spring.ex.db.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.marondal.spring.ex.db.domain.UsedGoods;

@Mapper
public interface UsedGoodsRepository {
	
	// 데이터 베이스에 접속 -> 쿼리 문자열 -> 쿼리 수행 -> 수행 결과 얻어오기 -> 사용하기 편리한 데이터로 변환
	// Mybatis Framework
	
	// used_goods 모든 행 조회 
	public List<UsedGoods> selectUsedGoodsList();
	

}
