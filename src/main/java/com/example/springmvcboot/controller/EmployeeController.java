package com.example.springmvcboot.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("hello")
	public ModelAndView sayHello(){
		System.out.println("hello1");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("hello");
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping("bookHome")
	public ModelAndView sayHello1(){
		System.out.println("bookHome");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("bookHome");
		return mv;
	}
	
	@GetMapping("bookHome")
	public ModelAndView sayHello21(){
		System.out.println("bookHome");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("bookHome");
		return mv;
	}
	
	@PostMapping("home")
	public ModelAndView sayHello13(){
		System.out.println("bookHome");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	@PostMapping("failure")
	public ModelAndView sayfailure(){
		System.out.println("failure");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("failure");
		return mv;
	}
	
	@GetMapping("home")
	public ModelAndView sayHello213(){
		System.out.println("home");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	@PostMapping("subjectHome")
	public ModelAndView sayHello12(){
		System.out.println("subjectHome");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("subjectHome");
		return mv;
	}
	
	@GetMapping("subjectHome")
	public ModelAndView sayHello22(){
		System.out.println("subjectHome");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("subjectHome");
		return mv;
	}
	

	@GetMapping("logout")
	public ModelAndView logout(HttpServletRequest request) throws ServletException{
		request.logout();
		System.out.println("logout");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
}