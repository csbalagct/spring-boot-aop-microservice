package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TestService;

@RestController
public class TestController {
	
	@Autowired
	private TestService testService;

	 @GetMapping(path = "/test")
	 public ResponseEntity<String> test(){
		 
		 testService.putTestService("welcome");
		 testService.getTestService();
		 
		 return ResponseEntity.ok().build();
	 }
}
