package com.example.springmvcboot.controller;

import java.util.List;

import javax.validation.Valid;


//import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springmvcboot.dao.SubjectDao;
import com.example.springmvcboot.entity.Subject;

@Controller
@RequestMapping("/subjectRegistration")
public class SubjectRegistrationController {

	@Autowired
	private SubjectDao subjectDao;
	
	
	
	@RequestMapping(value = "/addSubject", method = RequestMethod.GET)
	public String getSubjectForm(ModelMap model) {
		System.out.println("add subject");
		Subject e=new Subject();
		//e.setEmail("sdfsf");
	//	e.setSalary(4564.56f);
		model.addAttribute("subjectModel", e);
		return "subjectForm";
		
	}
	
	
	@RequestMapping(value = "/addSubject", method = RequestMethod.POST)
	public String formHandler(@Valid Subject subject, 
			BindingResult result, Model model) {
		System.out.println(subject);
		if(result.hasErrors()){
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			return "subjectForm";
		}
		subjectDao.save(subject);
		List <Subject>subjectList=subjectDao.findAll();
		model.addAttribute("subjectList",subjectList);
		return "subjectDetails";
	}
	
}
