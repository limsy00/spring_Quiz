package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.mapper.StoreMapper;

/* business Layer - service */
@Service
public class StoreBO {
	
	// ● 6 아래 단계인 interface 객체 선언(DI)
	@Autowired
	private StoreMapper storeMapper;
	
	// → input x : quiz02() - request parameter X : select all
	
	// ● 3
	public List<Store> getStoreList() {
		// ● 6-1  
		// ← output : selectStoreList() ▶ List<Store>
		return storeMapper.selectStoreList();
		
		/* List<Store> storeList = storeMapper.selectStoreList(); 
		 * -> 먼저 수행 후 return 
		 * return storeList; */
		 
	}
	
}
