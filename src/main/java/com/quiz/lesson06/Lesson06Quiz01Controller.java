package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Quiz01Controller {
	@Autowired
	private BookmarkBO bookmarkBO; 

	// 즐겨찾기 추가 화면 http://localhost:8080/lesson06/quiz01/add-bookmark-view
	@GetMapping("/add-bookmark-view")
	public String addBookmarView() {
		return "lesson06/addBookmark";
	}
	
	// 즐겨찾기 성공 화면 -> 추가 성공! 
	/* ★★★AJAX 는 무조건 @ResponseBody 에 내리고 응답값은 String!!
	 * AJAX가 하는 요청 - 즐겨찾기 추가 로직 
	 * (AJAX를 통해 추가 성공 시, 목록 화면으로 돌아가도록 요청함 ↓ )  */
	@ResponseBody 
	@PostMapping("/add-bookmark")
	public Map<String, Object> addBookmark(
			@RequestParam("name") String name, 
			@RequestParam("url") String url) {
		
		// db insert
		bookmarkBO.addBookmark(name, url);
		
		// 성공에 대한 JSON : 코드번호가 200이거나 result 값이 성공이거나
		// {"code":200, "result":"성공"}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		// 응답 내리기 (JSON String)
		return result;
	}
	
	// 즐겨찾기 목록 화면
	@GetMapping("/bookmark-list-view")
	public String bookmarkListView(Model model) {
		
		// db select -> List<Bookmark>
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();
		
		// model 담기
		model.addAttribute("bookmarkList", bookmarkList);
		
		return "lesson06/bookmarkList";
	}
}
