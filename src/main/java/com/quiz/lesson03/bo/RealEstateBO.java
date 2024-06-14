package com.quiz.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {
	@Autowired
	private RealEstateMapper realEstateMapper;

	// ●1. input: id(int), output: RealEstate(단건) or null
	 public RealEstate getRealEstateById(int id) { 
		 return realEstateMapper.selectRealEstateById(id); 
		}
	
	// ●2. input : rentPrice(int),  output: RealEstate(여러건) or null
	public RealEstate getRealEstateByRentPrice(int rentPrice) {
		return realEstateMapper.selectRealEstateByRentPrice(rentPrice);
	}
}
