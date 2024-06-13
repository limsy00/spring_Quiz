package com.quiz.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson02.domain.Store;

/* persistence Layer - repository */
@Mapper
public interface StoreMapper {

	// → input : BO 한테 받은 parameter X
	
	// ● 4
	// ← output(BO) : List<Store> 한테 selectStoreList() 전달
	public List<Store> selectStoreList();
}