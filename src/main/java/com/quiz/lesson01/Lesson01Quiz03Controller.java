package com.quiz.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson01Quiz03Controller {

	// http://localhost:8080/lesson01/quiz03
	@RequestMapping("/lesson01/quiz03")
	public String quiz03() {
		/* @ResponseBody가 아닌 상태로 return String을 하면
		 * VeiwResolver에 의해 return된 html 경로를 찾아 화면이 구성된다. */
		return "lesson01/quiz03"; // html 경로
	}
}
