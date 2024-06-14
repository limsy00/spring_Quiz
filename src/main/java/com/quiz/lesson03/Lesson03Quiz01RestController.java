package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.domain.RealEstate;

@RestController
@RequestMapping("/lesson03/quiz01")
public class Lesson03Quiz01RestController {
	@Autowired
	private RealEstateBO realEstateBO;
	
	// ●1. http://localhost:8080/lesson03/quiz01/1?id=20
		@RequestMapping("/1")
		public RealEstate quiz01_1( // 단건으로 리턴
				@RequestParam(value="id") int id) {
			return realEstateBO.getRealEstateById(id);
		}
	
	// ●2. http://localhost:8080/lesson03/quiz01/2?rent_price=90
		@RequestMapping("/2")
		public RealEstate quiz01_2(
				@RequestParam(value="rentPrice") int rentPrice) {
			return realEstateBO.getRealEstateByRentPrice(rentPrice);
		}
}
