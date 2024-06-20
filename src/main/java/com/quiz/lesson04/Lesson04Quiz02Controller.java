package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

@Controller
@RequestMapping("/lesson04/quiz02")
public class Lesson04Quiz02Controller {
	
	@Autowired
	private RealtorBO realtorBO;
	
	@GetMapping("/add-realtor-view")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	
	// DB insert -> select -> view
	@PostMapping("/add-realtor")
	public String addRealtor(Model model,
			@ModelAttribute Realtor realtor) {
		
		// insert
		realtorBO.addRealtor(realtor);
		
		// id 가지고 db select
		int id = realtor.getId();
		Realtor realtorInfo = realtorBO.getRealtorById(id); // 뿌리는 객체 선언
		
		// model
		model.addAttribute("title", "공인중개사 정보");
		model.addAttribute("realtor", realtorInfo); // 뿌리는 객체 담기
		
		// view
		return "lesson04/realtorInfo";
	}
}
