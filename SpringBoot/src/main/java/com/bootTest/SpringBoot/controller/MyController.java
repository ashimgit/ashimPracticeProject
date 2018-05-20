package com.bootTest.SpringBoot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@RequestMapping("/hello")
	public List<String> sayHello() {
		List<String> l1= new ArrayList<String>();
		l1.add("Hi ashim");
		l1.add("Hi there");
		
		return l1;
	}
	
	@RequestMapping("/hello1")
	public String sayHello1() {
		
		return "Hi There as String";
	}
}
