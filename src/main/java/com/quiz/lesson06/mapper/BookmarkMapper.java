package com.quiz.lesson06.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson06.domain.Bookmark;

@Mapper
public interface BookmarkMapper {

	public List<Bookmark> selectBookmarkList();
	
	public void insertAddBookmark(
			@Param("name") String name,
			@Param("url") String url); // map
	
	// Lesson06Quiz02
	// input : url -> 데이터가 있어?, output(쿼리 결과를 생각하고 설계해) : boolean? count가 XX -> 여러개를 가져오니 List<Bookmark>
	// ★★ 중복확인과 url 찾는 것 동시에 가능한 함수이다.
	public List<Bookmark> selectBookmarkListByUrl(String url); 
	
	public int deleteBookmarkById(int id);
}
