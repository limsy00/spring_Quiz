package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.mapper.BookmarkMapper;

@Service
public class BookmarkBO {
	@Autowired
	private BookmarkMapper bookmarkMapper;

	// input X
	// output : List<Bookmark>
	public List<Bookmark> getBookmarkList() {
		return bookmarkMapper.selectBookmarkList();
	}
	
	// input : name, url
	// output X
	public void addBookmark(String name, String url) {
		bookmarkMapper.insertAddBookmark(name, url);
	}
	
	
	// Lesson06Quiz02
	// input : url,  output : boolean -> 가공, 요리
	public boolean isDuplicationUrl(String url) {
		// ● 중복 - [bookmark1, bookmark2, ...]
		// ● 중복X - [] : 비어있는 리스트(null이 아님 주의)
		// ↑ 위의 두 가지 정보(리스트가 비어있는가?)를 가지고 중복인지 아닌지  boolean 으로 판단해!
		List<Bookmark> bookmarkList = bookmarkMapper.selectBookmarkListByUrl(url);
		return bookmarkList.isEmpty() ? false : true;  // 삼항연산자
		// return !bookmarkList.isEmpty(); // 이렇게 사용도 가능!
	}
	
	public int deleteBookmarkById(int id) {
		return bookmarkMapper.deleteBookmarkById(id);
	}
}
