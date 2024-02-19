package com.marondal.spring.ex.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.ex.db.domain.UsedGoods;
import com.marondal.spring.ex.db.repository.UsedGoodsRepository;

// 로직(business)를 담당
@Service
public class UsedGoodsService {
	
	@Autowired
	private UsedGoodsRepository usedGoodsRepository;
	
	// 중고물품 게시글 리스트를 리턴 하는 기능
	public List<UsedGoods> getUsedGoodsList() {
		// usedGoods 테이블 데이터 조회
		List<UsedGoods> usedGoodsList = usedGoodsRepository.selectUsedGoodsList();
		return usedGoodsList;
	}

}
