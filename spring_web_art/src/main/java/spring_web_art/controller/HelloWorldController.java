package spring_web_art.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring_web_art.jdbc.bean.Department;

@Controller
public class HelloWorldController {
	private static final String RequestedMethod = null;

	@RequestMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("greeting", "Hello this is first SPRING-WEB-MVC");
		model.addAttribute("key1", "Hey, this is key 1");

		return "helloWorld";
	}

	@RequestMapping("/url1")
	public String url1(Model model) {
		String s1 = " Testing String S1 ";

		model.addAttribute("key2", "This is another Model : " + "URL-1" + s1);

		// return "helloWorld";
		return "login";
	}

	@RequestMapping("/url2")
	// public ModelAndView url2(HttpServletRequest req, HttpServletResponse
	// res){
	public String url2(HttpServletRequest req, HttpServletResponse res, Model model) {

		String userid = req.getParameter("userid");
		String pass = req.getParameter("pass");

		System.out.println(userid + "******" + pass);
		// ModelAndView model = new ModelAndView("result");

		model.addAttribute("key1", userid);
		model.addAttribute("key2", pass);

		// return model;
		return "result";
	}

	@RequestMapping("/url3")
	public String url3(Model model) {

		return "result";
	}

	/********************* Simple Login ********************/
	@RequestMapping("/findSimpleLogin")

	public String findSimpleLogin() {
		// String uname=((ServletRequest) request).getParameter("txtName");
		System.out.println("Request :");
		return "simpleLoginPage";
	}

	@RequestMapping(value = "/SimpleLogin", method = RequestMethod.GET)
	/*
	 * public String SimpleLogin(HttpServletRequest request,HttpServletResponse
	 * response,Model model){
	 * 
	 * String uname=((ServletRequest) request).getParameter("txtName"); String
	 * pass=((ServletRequest) request).getParameter("txtPass");
	 * 
	 * model.addAttribute("key1", uname); model.addAttribute("key2", pass);
	 * 
	 * return "result"; }
	 */
	// OR
	/**/
	public String SimpleLogin(@RequestParam String txtName, @RequestParam String txtPass, Map<String, Object> map) {
		// public String SimpleLogin(@RequestParam String txtName, @RequestParam
		// String txtPass) {

		// Model model1 = new ExtendedModelMap();
		// model1.addAttribute("key1", txtName);
		// model1.addAttribute("key2", txtPass);

		// Map<String, Object> model=new HashMap<String, Object>();
		// model.addAttribute("key1", (String)txtName);
		// model.addAttribute("key2", (String)txtPass);

		map.put("key1", txtName);
		map.put("key2", txtPass);

		System.out.println(txtName + "----" + txtPass);

		return "result";
	}/**/

	// Returning List/Collection
	@RequestMapping("/transferToviewToReturnCollection")
	public String transferToviewToReturnCollection() {
		return "viewToReturnCollection";
	}

	@RequestMapping(value = "/collectionReturn", method = RequestMethod.POST)
	public String collectionReturn(HttpServletRequest request, Model model) {
		ArrayList<Department> alDept = new ArrayList<Department>();

		String s1 = request.getParameter("txtCollege");
		if (s1.equals("hit")) {
			alDept.add(new Department("d1", "MCA", "m1"));
			alDept.add(new Department("d2", "CSE", "cs1"));
			alDept.add(new Department("d3", "IT", "it1"));

		}
		model.addAttribute("key1", "hit");
		model.addAttribute("key2", alDept);

		System.out.println("Hello There" + s1);

		return "resultCollection";
	}

	// **************************AJAX Testing
	@RequestMapping(value = "/spring_web_art/myAjax",method=RequestMethod.GET)
	public List doMyajax(HttpServletRequest req, Model model) {
	//public @ResponseBody String doMyajax(HttpServletRequest req, Model model) {
		
		System.out.println("This is ajax within controller");
		String name="";//req.getParameter("name");
		name+="This is from Controller";
		List l= new ArrayList<String>();
		l.add(name);
		return l;
		//return "hello ajax";
	}

	// **************************AJAX Testing

}
