package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.border.Border;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/quiz02")
@RestController
public class Lesson01Quiz02RestController {
	
	
	// http://localhost:8080/lesson01/quiz02/1
	@ResponseBody
	@RequestMapping("/1")
	public List<Map<String, Object>> quiz02_1() {
		List<Map<String, Object>> movieInfo = new ArrayList<>();
		Map<String, Object> map = new HashMap<>() {
			{
			put("rate", 15);
			put("director", "봉준호");
			put("time", 131);
			put("title", "기생충");
			}
		};
		movieInfo.add(map);
		
		map = new HashMap<>() {
			{
			put("rate", 0);
			put("director", "로베르토 베니니");
			put("time", 116);
			put("title", "인생은 아름다워");
			}
		};
		movieInfo.add(map);
		
		map = new HashMap<>() {
			{
			put("rate", 12);
			put("director", "크리스토퍼 놀란");
			put("time", 147);
			put("title", "인셉션");
			}
		};
		movieInfo.add(map);
		
		map = new HashMap<>() {
			{
			put("rate", 19);
			put("director", "윤종빈");
			put("time", 133);
			put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
			}
		};
		movieInfo.add(map);
		
		
		map = new HashMap<>() {
			{
			put("rate", 15);
			put("director", "프란시스 로렌스");
			put("time", 137);
			put("title", "헝거게임");
			}
		};
		movieInfo.add(map);
		return movieInfo;
	}
	
	// http://localhost:8080/lesson01/quiz02/2
	@RequestMapping("/2")
	public List<Board> quiz02_2() {
		// @ResponseBody + return String ▶ HttpMessageConverter ▶ HTML
		// @ResponseBody + return 객체(Map, List, 객체) ▶ HttpMessageConverter ▶ jackson lib ▶ JSON
		List<Board> list = new ArrayList<>();
		
		Board board1 = new Board();
		board1.setTitle("안녕하세요 가입인사 드립니다.");
		board1.setUser("marobiana");
		board1.setContent("안녕하세요 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		list.add(board1);
		
		Board board2 = new Board();
		board2.setTitle("헐 대박");
		board2.setUser("biana");
		board2.setContent("오늘 목요일이었어... 금요일인줄");
		list.add(board2);
		
		Board board3 = new Board();
		board3.setTitle("오늘 데이트 한 이야기 해드릴게요");
		board3.setUser("maro");
		board3.setContent("...");
		list.add(board3);
		
		return list;
		
	}
	
	// http://localhost:8080/lesson01/quiz02/3
	@RequestMapping("/3")
	public ResponseEntity<Board> quiz02_3(){
		Board board = new Board();
		board.setTitle("안녕하세요 가입인사 드립니다.");
		board.setUser("marobiana");
		board.setContent("안녕하세요 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		
		return new ResponseEntity<Board>(board, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
}
