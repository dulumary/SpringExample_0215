package com.marondal.spring.ex.lifecycle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller  + @ResponseBody
public class Ex01RestController {

	// 직접 만든 클래스 객체 리턴
	@RequestMapping("/lifecycle/ex01/3")
	public Person objectResponse() {
		
		Person me = new Person("김인규", 29);
		return me;
	}
	
}
