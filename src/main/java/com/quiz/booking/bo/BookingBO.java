package com.quiz.booking.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service // ★★★.xml 쿼리는 단순하게! bo에서 로직 가공!
public class BookingBO {
	@Autowired
	private BookingMapper bookingMapper; 
	
	// 예약 목록 화면
	// input X, output: List<Booking> - 여러건일 경우 List
	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList();
	}
	
	// AJAX - 예약 id로 삭제
	// input: id, output: int
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}

	// AJAX - 예약 추가
	public void addBooking(String name, String date, int day, int headcount, String phoneNumber) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	
	// AJAX - 예약 조회
	// input: name, phoneNumber, output: Booking (최신)단건 or null 
	public Booking getLatestBookingByNamePhoneNumber(String name, String phoneNumber) {
		// 없을 때: []    있을 때: [booking1, booking2, booking3]
		List<Booking> bookingList = bookingMapper.selectBookingListByNamePhoneNumber(name, phoneNumber);
//		if (bookingList.isEmpty()) {
//			return null;
//		}
		
		return bookingList.isEmpty() ? null : bookingList.get(bookingList.size() - 1);
	}
}
