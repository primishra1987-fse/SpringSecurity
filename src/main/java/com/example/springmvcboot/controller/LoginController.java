package com.example.springmvcboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springmvcboot.dao.AuthorityDao;
import com.example.springmvcboot.dao.RegisterDao;
import com.example.springmvcboot.entity.Authorities;
import com.example.springmvcboot.entity.Users;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String showLogin(){
		return "login";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String doLogin(){
		return "j_spring_security_check";
	}
	
	@Autowired
	private RegisterDao registerDao;
	

	@Autowired
	private AuthorityDao authorityDao;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm(ModelMap model) {
		System.out.println("add user");
		Users e=new Users();
		//e.setEmail("sdfsf");
	//	e.setSalary(4564.56f);
		model.addAttribute("userModel", e);
		return "registration";
		
	}
	
	@ModelAttribute("role")
	public List<String> setValues(){
		List<String> designations=new ArrayList<String>();
		designations.add("LIBRARIAN");
		designations.add("PRINCIPAL");
		
		return designations;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String formHandler(@Valid Users user, 
			BindingResult result, Model model) {
		
		if(result.hasErrors()){
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			return "registration";
		}
		
		Authorities authorities = new Authorities();
		authorities.setRole(user.getRole());
		authorities.setUserName(user.getUserName());
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		registerDao.save(user);
		authorities.setRole(authorities.getRole().trim());
		authorityDao.save(authorities);
		
				
		return "home";
	}
	

	
}