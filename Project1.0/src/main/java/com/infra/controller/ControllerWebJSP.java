package com.infra.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infra.entity.Data;
import com.infra.entity.LoginEntity;
import com.infra.entity.Student;
import com.infra.service.LoginService;
import com.infra.service.Service;

@Controller
//@EnableWebMvc
public class ControllerWebJSP {

	@Autowired
	Service service;
	@Autowired
	LoginService loginService;

	
	@RequestMapping(value = "/sinleuser", method = RequestMethod.GET)
	public String singleuser(Model model) {
		System.out.println("single user");
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "../individual";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homepage(Model model) {
		System.out.println("main page enter suceffully");
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "../MainMethod";
	}
	
	@RequestMapping(value="/SingleUser",method=RequestMethod.POST)
	public String getLoginUserById(Model model,@RequestParam("id") int id) {
		System.out.println("enter datafetching individually"+"id is : "+id);
		LoginEntity loginEntity=loginService.getuserByIdIndividual(id);
		System.out.println(loginEntity.getName());
		try {
			if(loginEntity!=null) {
				model.addAttribute("list", loginEntity);
			}else {
				
			}
		}catch(Exception e) {
			System.out.println("Error is : "+e.getMessage());
		}
		return "../loginUserViewById";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginpage(Model model) {
		System.out.println("Login page Suceffully hi");
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "../login";
	}

	@RequestMapping(value = "/editemp/{id}", method = RequestMethod.GET)
	public String checkloginuser(@PathVariable int id, Model model) {

		System.out.println("enter edit temp");
		LoginEntity loginEntityInfo = loginService.checkbyid(id);
		if (loginEntityInfo != null) {
			model.addAttribute("command", loginEntityInfo);
			return "../EditForm";
		}
		return "../login";
	}

	// editsave
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editandSava(@ModelAttribute LoginEntity loginEntity, Model model) {

		System.out.println(" enter  finall");

		loginService.editsave(loginEntity);

		List<LoginEntity> loginEntityInfo = loginService.getuserById();

		for (LoginEntity U : loginEntityInfo) {
			System.out.println(U.getName());
		}
		try {
			if (loginEntityInfo != null) {
				model.addAttribute("list", loginEntityInfo);
			} else {
				model.addAttribute("list", "user is not present pz check");
			}

		} catch (Exception e) {
			model.addAttribute("list", "user is not present pz check");
		}

		return "../loginUserView";

		
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute LoginEntity loginEntity, Model model) {

		System.out.println("enter suceffully");
		System.out.println(loginEntity);
		System.out.println(loginEntity.toString());
		System.out.println(loginEntity.getAdress());
		System.out.println(loginEntity.getId());
		System.out.println(loginEntity.getName());
		try {
			LoginEntity loginEntityInfo = loginService.addLoginEntityRecord(loginEntity);
			if (loginEntityInfo != null) {
				model.addAttribute("empcreated", "loginDetails is stored suceffully" + loginEntity.getId() + "");

			} else {
				model.addAttribute("empcreated",
						"loginDetails not stored suceffully: user already present" + loginEntity.getId() + "");
			}
		} catch (Exception e) {
			model.addAttribute("empcreated",
					"loginDetails not stored suceffully: user already present " + loginEntity.getId() + "");
		}

		return "../login";
	}

//	deleteemp/${loginuser.id}

//	@RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)    
//    public String delete(@PathVariable int id){  
//	public String delete(@RequestParam("id") int i, Model model) {
//        dao.delete(id);    
//        return "redirect:/viewemp";    
//    }     
//	
//	

	@RequestMapping(value = "/deleteById/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id, Model model) {
		System.out.println("enter Delete method ");
		Object object = loginService.deleteStudentRecord(id);
//		if(object.equals("ok")) {
//			model.addAttribute("empcreated", "Login user deleted suceffully" +  " id is : "+i + "");
//		}else {
//			model.addAttribute("empcreated", "User not deleted because not present" +  " id is : "+i + "");
//		}
		// return "../loginUserView";

		List<LoginEntity> loginEntityInfo = loginService.getuserById();

		for (LoginEntity U : loginEntityInfo) {
			System.out.println(U.getName());
		}
		try {
			if (loginEntityInfo != null) {
				model.addAttribute("list", loginEntityInfo);
			} else {
				model.addAttribute("list", "user is not present pz check");
			}

		} catch (Exception e) {
			model.addAttribute("list", "user is not present pz check");
		}

		return "../loginUserView";

	}

	@RequestMapping(value = "/ok", method = RequestMethod.GET)
	public String indexpage(Model model) {
		System.out.println("Home page Suceffully");
		model.addAttribute("msg", "Please Enter Your Login Details");
		model.addAttribute("signal", "Please Enter Your Login Details");
		return "../loginUserViewById";
	}

	// @RequestMapping(value = "/viewalluser", method = RequestMethod.GET)
	@RequestMapping(value = "/viewallusers", method = RequestMethod.GET)
	public String getLoginUserBId(Model model) {
		System.out.println("enter user view all details");
		List<LoginEntity> loginEntityInfo = loginService.getuserById();

		for (LoginEntity U : loginEntityInfo) {
			System.out.println(U.getName());
		}
		try {
			if (loginEntityInfo != null) {
				model.addAttribute("list", loginEntityInfo);
			} else {
				model.addAttribute("list", "user is not present pz check");
			}

		} catch (Exception e) {
			model.addAttribute("list", "user is not present pz check");
		}

		return "../loginUserView";
	}

	
	
	
//	public List<LoginEntity> viewall(){
//		
//	}

}
