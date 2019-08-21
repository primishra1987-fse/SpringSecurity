package com.example.springmvcboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springmvcboot.dao.SubjectDao;

@Controller
@RequestMapping("/subjects")
public class SubjectController {

	@Autowired
	private SubjectDao subjectDao;
	
	@GetMapping
	public String getStudents(){
		System.out.println("inside the subject");
		subjectDao.findAll();
		return "subjectDetails";
				
	}
	
}
