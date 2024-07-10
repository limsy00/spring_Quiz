package com.quiz.booking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.booking.domain.Booking;

@Mapper
public interface BookingMapper {

	public List<Booking> selectBookingList(); // 예약 목록 화면
	
	public int deleteBookingById(int id); // AJAX - 예약 id로 삭제
	
	// AJAX - 예약 추가
	public void insertBooking( 
			@Param("name") String name, 
			@Param("date") String date, 
			@Param("day") int day, 
			@Param("headcount") int headcount, 
			@Param("phoneNumber") String phoneNumber); // map
	
	// AJAX - 예약 조회
	// input: bo에게 받아옴(name, phoneNumber), output: 여러개 행 조회한 것을 바로 bo한테 보낼거야(List<Booking>)
	public List<Booking> selectBookingListByNamePhoneNumber(
			@Param("name") String name, 
			@Param("phoneNumber") String phoneNumber); // map : 파라미터가 두개 이상이면 map으로 만들어
}
