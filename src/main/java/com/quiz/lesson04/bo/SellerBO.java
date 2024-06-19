package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.mapper.SellerMapper;

@Service
public class SellerBO {
	
	@Autowired
	private SellerMapper sellerMapper;

	// input: 닉네임, 사진 url, 온도
	// output: X
	public void addSeller(String nickname, String profileImageUrl, Double temperature) { // 판매자 추가 성공하면 보여지는 view 함수
		sellerMapper.insertSeller(nickname, profileImageUrl, temperature);
	}
	
	// input: X
	// output: Seller(채워져 있거나 null)
	public Seller getLatestSeller() {
		return sellerMapper.selectLatestSeller();
	}
	
	// input: id
	// output: Seller(채워져 있거나 null)
	public Seller getSellerById(int id) {
		return sellerMapper.selectSellerById(id);
	}
}
