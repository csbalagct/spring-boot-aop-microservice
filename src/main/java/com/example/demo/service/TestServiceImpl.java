package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

	@Override
	public void getTestService() {
	
		System.out.println("It is a test service");
		
		
	}

	@Override
	public String putTestService(String str) {
		
		System.out.println("Before returning " + str);
		
		return str;
	}

}
