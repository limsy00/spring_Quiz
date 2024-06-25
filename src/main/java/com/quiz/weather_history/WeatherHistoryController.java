package com.quiz.weather_history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@RequestMapping("/weather-history")
@Controller
public class WeatherHistoryController {

	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	// ● [날씨 입력] 화면 (/weather-history/add-weather-view)
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weather-history/addWeather";
	}
	
	// ● [날씨] 목록 화면 (/weather-history/weather-list-view) -> 화면에 데이터 뿌리기
	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		// select db
		List<WeatherHistory> weatherHistoryList = weatherHistoryBO.getWeatherHistoryList();
		
		// model 담기
		model.addAttribute("weatherHistoryList", weatherHistoryList);
		
		// 화면 이동
		return "weather-history/weatherList";
	}
	
	
	// ● 날씨 추가 기능 (/weather_history/add-weather) -> 추가 완료!
//	@PostMapping("/add-weather")
//	public String addWeather(
//			@RequestParam("date") 타입 ,
//			@RequestParam("date") 타입 ,
//			@RequestParam("date") 타입 
//			@RequestParam("date") 타입 
//			@RequestParam("date") 타입 
//			@RequestParam("date") 타입 ) {
		
//	}
}






