package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;

/* presentation Layer */
@RestController
public class Lesson02Quiz01RestController {

	// ● 7
	// 필드
	@Autowired StoreBO storeBO;
	
	// http://localhost:8080/lesson02/quiz01
	@RequestMapping("/lesson02/quiz01")
	// ● 1
	public List<Store> quiz02() { // List<DB table name>, request parameter X
		// ● 7-1
		List<Store> storeList = storeBO.getStoreList();
		return storeList;
		
		// return storeBO.getStoreList();
	}
}
