package gst.resnovae.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

//import com.google.gson.Gson;

import gst.resnovae.bean.MasParty;

import gst.resnovae.dao.MasUserDao;
import gst.resnovae.impl.MasUserImpl;
import gst.resnovae.model.TestModel;
import gst.resnovae.pojo.EmpTestFormSubmit_1;
import gst.test.TestDaoImpl;
import gst.test.TestEmployee;

@Controller
public class ResnovaeController {
	@Autowired
	TestModel testModel;

	@Autowired
	TestDaoImpl testDao;
	@Autowired
	MasUserDao masUserImpl;// =new MasUserImpl();

	@RequestMapping("/login")
	public String login(HttpServletRequest requset, Model model) {
		testModel.getRes();
		testDao.insert("1", "a");

		return "homepage";
	}

	@RequestMapping("/userEntry.do")
	public String userEntry(HttpServletRequest request, Model model) {

		return "userEntry";
	}

	@RequestMapping("/employee")
	public ModelAndView showForm() {
		return new ModelAndView("userEntry", "user", new TestEmployee());
	}

	@RequestMapping("/userEntry")
	/*
	 * public String do_UserEntry(@Validated @ModelAttribute("employee")
	 * TestEmployee user, BindingResult result, ModelMap modelMap) { if
	 * (result.hasErrors()) { System.out.println(
	 * "Errors have been ocurred : do_UserEntry");
	 * 
	 * } else { modelMap.addAttribute("eid", user.getEid());
	 * modelMap.addAttribute("ename", user.getEname());
	 * System.out.println(user.getEid() + " ******* " + user.getEname()); }
	 * return "userEntry"; }
	 */

	public String do_UserEntry(HttpServletRequest request, Model model) {
		String username;
		String addr1;
		String addr2;
		String addr3;
		String pin;
		String state;
		String ph1;
		String ph2;
		String email;
		String pan;
		String gstin;
		String remarks;
		String role;
		String type;
		username = request.getParameter("username");
		addr1 = request.getParameter("addr1");
		addr2 = request.getParameter("addr2");
		addr3 = request.getParameter("addr3");
		pin = request.getParameter("pin");
		state = request.getParameter("state");
		ph1 = request.getParameter("ph1");
		ph2 = request.getParameter("ph2");
		email = request.getParameter("email");
		pan = request.getParameter("pan");
		gstin = request.getParameter("gstin");
		remarks = request.getParameter("remarks");

		MasParty users = new MasParty();
		users.setUsername(username);
		users.setAddr1(addr1);
		users.setAddr2(addr2);
		users.setAddr3(addr3);
		users.setPin(pin);
		users.setState(state);
		users.setPh1(ph1);
		users.setPh2(ph2);
		users.setEmail(email);
		users.setPan(pan);
		users.setGstin(gstin);
		users.setRemarks(remarks);

		masUserImpl.insertMasParty(users);
		return "userEntry";
	}
	//
	@RequestMapping(value="/productEntry.do")
	public String red_productEntry(){
		
		return "productEntry";
	}
	
	@RequestMapping(value="/ProductHeader",method={RequestMethod.POST,RequestMethod.GET} ,produces={"application/json"})
	//@ResponseBody
	public @ResponseBody String prodMaster(HttpServletResponse res,Model model){
		System.out.println("Hello");
		List<String> l=new ArrayList<String>();
		String jsonStr="";
		Gson gson=new Gson();
		try{
		l.add("afadgsdf");
		
		
		jsonStr=gson.toJson(masUserImpl.productMaster());
		/*try {
			//res.getWriter().write(jsonStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("jsonStr="+jsonStr);
		}catch(Exception e){System.out.println("e="+e);}
		//return jsonStr;
		
		
		return gson.toJson("hi, its from ajax controller");
		
		//System.out.println("MYAJAX");
		//return masUserImpl.productMaster();
	/*	TestEmployee te=new TestEmployee();
		te.setEid("10");;
		te.setEname("jhbjbgvgcd");
		*///////////////////////////////////////////
		/*MappingJackson2HttpMessageConverter jsonConverter=new MappingJackson2HttpMessageConverter();
		MediaType mediaType=MediaType.APPLICATION_JSON;
		Object jsonBean=new String("hello ajax");
		
		if(jsonConverter.canWrite(jsonBean.getClass(), mediaType)){
			try {
				jsonConverter.write(jsonBean, mediaType,new ServletServerHttpResponse(res));
			} catch (HttpMessageNotWritableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		
		
		//return "This is ajax";//"userEntry";
	}
	

	//**************************************************form submit
	@RequestMapping(value="/addStudent", method=RequestMethod.GET)
	//public String addEmp(@ModelAttribute("empForm") EmpTestFormSubmit_1 empForm,ModelMap modelMap){ //1
	//public String addEmp(@ModelAttribute("empForm") EmpTestFormSubmit_1 empForm,Model modelMap){ //2
	public String addEmp( EmpTestFormSubmit_1 empForm,Model modelMap){
		modelMap.addAttribute("name", empForm.getName());
		modelMap.addAttribute("age", empForm.getAge());
		System.out.println(empForm.getName()+" -- "+empForm.getAge());
		return "form_submit_result_1";
	}
	@RequestMapping("/submitForm.do")
	public ModelAndView submitForm() {

		return new ModelAndView("form_submit_test1","command",new EmpTestFormSubmit_1());
	}

}
