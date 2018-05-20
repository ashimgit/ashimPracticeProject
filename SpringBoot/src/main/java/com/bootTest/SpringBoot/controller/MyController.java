package com.bootTest.SpringBoot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootTest.pojo.Student;

@RestController
public class MyController {
	@RequestMapping("/hello")
	public List<String> sayHello() {
		List<String> l1 = new ArrayList<String>();
		l1.add("Hi ashim");
		l1.add("Hi there");

		return l1;
	}

	@RequestMapping("/hello1")
	public String sayHello1() {
		return "Hi There as String";
	}
	
	@RequestMapping("/hello2")
	public List<Student> sayHello2() {
		List<Student> l1=new ArrayList<>();
		l1.add(new Student("s01","naba","Deb"));
		l1.add(new Student("s02","Ashim","Kol"));
		l1.add(new Student("s03","Apu","Deb"));
		l1.add(new Student("s04","Roni","KNJ"));
		l1.add(new Student("s05","Raghunath","RNG"));
		l1.add(new Student("s06","Utsab","Power House Para"));
		l1.add(new Student("s07","Anup","BTH"));
		l1.add(new Student("s08","Protap","Chowrasta"));
		l1.add(new Student("s09","pinki","DDJ"));
		
		
		return l1;
	}
	
}
