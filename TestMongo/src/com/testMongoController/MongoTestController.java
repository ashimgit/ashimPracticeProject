package com.testMongoController;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

@Controller

public class MongoTestController {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@RequestMapping(value="/insert")
	public String testInsert(HttpServletRequest req,Model model){
		System.out.println("HI");
		DBObject dObj=new BasicDBObject();
		dObj.put("_id", req.getParameter("n1"));
		dObj.put("name", req.getParameter("n2"));
		
		dObj.put("friend_name", req.getParameter("n3"));
		
		
		
		try{
		WriteResult t=mongoTemplate.getDb().getCollection("student").insert(dObj);
		model.addAttribute("key1", "Insertion Successful . . .");
		}catch(Throwable th){
			System.out.println("Exception Occured !!!");
			model.addAttribute("key1", "Insertion Did Not Happened");
		}
		
		//return "index";
		return "redirect:/";
		
	}
	
	
	public String testFetch(){
		
		
		return "redirect:/";
	}
	
}
