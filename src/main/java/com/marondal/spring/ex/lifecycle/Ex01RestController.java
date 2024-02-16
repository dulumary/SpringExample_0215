package com.marondal.spring.ex.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller  + @ResponseBody
@RequestMapping("/lifecycle/ex01")
public class Ex01RestController {

	// 직접 만든 클래스 객체 리턴
	@RequestMapping("/3")
	public Person objectResponse() {
		
		Person me = new Person("김인규", 29);
		return me;
	}
	
	@RequestMapping("/4")
	public ResponseEntity<Person> entityResponse() {
		
		Person me = new Person("김인규", 31);
		// HTTP status code
		// 200 OK (정상적인 상태)
		// 404 Not Found: 페이지가 없음 (URL path 확인)
		// 405 Method Not Allow : 메소드가 일치하지 않음 (Get, Post 메소드 확인)
		// 400 Bad Request : 요청이 잘못됨 (파리미터 확인)
		// 500 Internal Server Error : 서버 에러 (자바 코드 확인)
		
		ResponseEntity<Person> entity = new ResponseEntity<>(me, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}
	
	
}
