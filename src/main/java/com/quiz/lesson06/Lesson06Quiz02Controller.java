package com.quiz.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/lesson06/quiz02")
public class Lesson06Quiz02Controller {
	@Autowired
	private BookmarkBO bookmarkBO;
	
	// 즐찾 추가화면
	@GetMapping("/add-bookmark-view")
	public String addUserView() {
		return "lesson06/quiz02AddBookmark";
	}
	
	// url 중복확인 (AJAX 요청)
	@ResponseBody
	@PostMapping("/is-duplication-url")
	public Map<String, Object> isDuplicationUrl(
			@RequestParam("url") String url) {
		// db select
		boolean isDuplication = bookmarkBO.isDuplicationUrl(url);
		
		// 응답 json => map
		Map<String, Object> result = new HashMap<>(); // breakpoint 걸고 확인 필수!!★★★
		result.put("code", 200);
		result.put("is_duplication", isDuplication);
		
		return result;
	}
	
	// AJAX 요청 - id로 삭제
	// http://localhost:8080/lesson06/quiz02/delete-bookmark?id=3
	@ResponseBody
	//@GetMapping("/delete-bookmark")
	@DeleteMapping("/delete-bookmark")// 주소를 직접 치고 확인 불가 - 해킹 대비
	public Map<String, Object> deleteBookmark(
			@RequestParam("id") int id) {
		
		// db delete
		int rowCount = bookmarkBO.deleteBookmarkById(id);
		
		// 응답 json
		Map<String, Object> result = new HashMap<>(); // breakpoint 걸고 확인 필수!!★★★
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("is_duplication", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제할 항목이 존재하지 않습니다."); // 에러 이유를 알려줄게 (로직 상 실패)
		}
		
		
		return result;
	}

}
