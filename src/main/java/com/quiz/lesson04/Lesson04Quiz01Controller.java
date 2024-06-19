package com.quiz.lesson04;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@Controller // 일반 화면
@RequestMapping("/lesson04/quiz01")
public class Lesson04Quiz01Controller {
	
	@Autowired
	private SellerBO sellerBO;

	// 1. 판매자 추가 화면 -> ✅화면으로 주소 치고 들어간다? GET!
	// http://localhost:8080/lesson04/quiz01/add-seller-view
	@GetMapping(path = "/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller"; // 입력란 html 경로
	}
	
	// 판매자 추가 진행
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam(value ="temperature", defaultValue = "36.5") Double temperature) {
		
		// ✅DB 저장 -> insert? POST!
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		// 성공 화면 html 경로로 이동
		return "lesson04/afterAddSeller";
	}
	
	// 2. 가장 최근에 추가된 seller의 정보 화면
	// http://localhost:8080/lesson04/quiz01/seller-info-view
	// http://localhost:8080/lesson04/quiz01/seller-info-view?id=1
	@GetMapping("/seller-info-view")
	public String sellerInfoView(@RequestParam (value = "id", required = false) Integer id,
									Model model) {// ◀◀◀◀ parameter 에 Model 넣기)
		// ✅DB 데이터 조회 -> select? Model에 데이터 담자! -> 어디에? ▲ 
		Seller seller = null;
		
		if (id == null) {
			seller = sellerBO.getLatestSeller();
		} else {
			seller = sellerBO.getSellerById(id);
		}
		
		
		
		// Model 주머니
		model.addAttribute("seller", seller);
		model.addAttribute("title", "최근 판매자 정보 ↓");
		
		// 결과 화면 이동
		return "lesson04/sellerInfo";
	}
	
}
