package com.quiz.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {

	// ●1. input: id(int)
	public RealEstate selectRealEstateById(int id);
	
	// ●2. input: rentPrice(int)
	public RealEstate selectRealEstateByRentPrice(int rentPrice);
}
