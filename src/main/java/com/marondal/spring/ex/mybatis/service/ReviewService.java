package com.marondal.spring.ex.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.ex.mybatis.domain.Review;
import com.marondal.spring.ex.mybatis.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	// 전달 받은 id와 일치하는 리뷰 정보 리턴하는 기능
	public Review getReview(int id) {
		Review review = reviewRepository.selectReview(id);
		return review;
	}

}
