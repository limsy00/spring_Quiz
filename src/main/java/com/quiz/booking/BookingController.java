package com.quiz.booking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {
	@Autowired
	private BookingBO bookingBO;

	// 예약 목록 화면
	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {
		
		// db select
		List<Booking> bookingList =  bookingBO.getBookingList(); // ●breakpoint 걸고 확인
		// modle
		model.addAttribute("bookingList", bookingList);
		// 화면 뿌리기
		return "booking/bookingList";
	}
	
	// 1. AJAX - 예약 id로 삭제
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {
		// db delete
		int rowCount = bookingBO.deleteBookingById(id);
		// 응답값
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제할 데이터가 없습니다.");
		}
		
		return result;
	}

	// 예약하기 화면
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}
	
	// 2. AJAX - 예약 추가
	@ResponseBody
	@PostMapping("/make-booking")
	public Map<String, Object> makeBooking(
			@RequestParam("name") String name,
			@RequestParam("date") String date, // LocalDate 가능
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		// db insert
		bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		// 응답값 - rowCount 변수 저장 없이 바로!
		Map<String, Object> result = new HashMap<>(); // ●breakpoint 걸고 확인!
		result.put("code", 200);
		result.put("result", "성공");
		
		return result;
	}
	

	// 예약확인 화면
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		return "booking/checkBooking";
	}
	
	// 3. AJAX - 예약 조회
	@ResponseBody
	@PostMapping("/check-booking")
	public Map<String, Object> checkBooking(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		// db select
				Booking booking = bookingBO.getLatestBookingByNamePhoneNumber(name, phoneNumber);
				
		// 응답값 => JSON
		Map<String, Object> result = new HashMap<>();
		if (booking != null) {
			// {"code":200, "result":booking 객체}
			// {"code":200, "result":{"id":3, "name":"신보람"....}}
			result.put("code", 200);
			result.put("result", booking);
		} else {
			// {"code":500, "error_message":"예약 내역이 없습니다."}
			result.put("code", 500);
			result.put("error_message", "예약 내역이 없습니다.");
		}
		
		return result;
	}
}