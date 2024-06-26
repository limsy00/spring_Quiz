package com.quiz.weather_history;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

import jakarta.servlet.http.HttpServletResponse;

@RequestMapping("/weather-history")
@Controller
public class WeatherHistoryController {

	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	// ● [날씨 입력] 화면 (/weather-history/add-weather-view)
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weather_history/addWeather";
	}
	
	// ● [날씨] 목록 화면 (/weather-history/weather-list-view) -> 화면에 데이터 뿌리기
	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		// select db
		List<WeatherHistory> weatherHistoryList = weatherHistoryBO.getWeatherHistoryList();
		
		// model 담기
		model.addAttribute("weatherHistoryList", weatherHistoryList);
		
		// 화면 이동
		return "weather_history/weatherList";
	}
	
	
	// ● 날씨 추가 기능 (/weather_history/add-weather) -> 추가 완료되면 목록 화면으로 이동!
	@PostMapping("/add-weather")
	public String addWeather(
			//@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
			//@RequestParam("date") LocalDate date,
			@RequestParam("date") String date, // LocalDate여도 됨
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust, 
			@RequestParam("temperatures") double temperatures, 
			@RequestParam("precipitation") double precipitation, 
			@RequestParam("windSpeed") double windSpeed,
			HttpServletResponse response) {
		
		
		// insert db
		weatherHistoryBO.addWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
		// select db → model 담기 → 화면 이동 ▶ 이 작업들은 이미 위에서 수행 (중복할 필요 X)
		
		// 따라서 [날씨] 목록 화면으로 redirect ★★★
		return "redirect:/weather-history/weather-list-view";
	}
}






