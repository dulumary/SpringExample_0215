package com.marondal.spring.ex.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	
	// 이름과 생년월일을 전달 받고, 이름과 나이를 response로 돌려주는 기능
	// Response 에 json 문자열 형태의 데이터를 담는 페이지 
	// API 
	@GetMapping("/ajax/person")
	@ResponseBody
	public Map<String, Object> personInfo(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthday) {
		
		// 20131109
		int year = Integer.parseInt(birthday.substring(0, 4));
		
		int age = 2024 - year + 1;
		// {"name":"김인규", "age":22}
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("name", name);
		resultMap.put("age", age);
		
		return resultMap;
	}
	
	
	// Response 에 html 문자열을 담는 페이지 
	// View page
	@GetMapping("/ajax/ex01")
	public String ex01() {
		return "ajax/ex01";
	}

}
