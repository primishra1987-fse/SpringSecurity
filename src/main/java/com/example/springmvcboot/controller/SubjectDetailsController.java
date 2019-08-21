package com.example.springmvcboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springmvcboot.dao.BooksDao;
import com.example.springmvcboot.dao.SubjectDao;
import com.example.springmvcboot.entity.Subject;




@Controller
@RequestMapping("/subjectDetails")
public class SubjectDetailsController {
	
	@Autowired
	private SubjectDao subjectDao;
	
	@Autowired
	private BooksDao booksDao;
	
	@RequestMapping("/list")
	public String getSubjectDetails(
			//HttpSession session, 
			//@SessionAttribute("username") String username,
			ModelMap model){
		//System.out.println(session.getId());
		//System.out.println(username);
		//System.out.println("inside list."+session.getAttribute("username"));
	//	System.out.println("inside list."+username);
		List <Subject>subjectList=subjectDao.findAll();
		model.addAttribute("subjectList",subjectList);
		return "subjectDetails";
	}
	
	@RequestMapping("/subject")
	public String getSubjectDetailsById(@RequestParam long id, Model model){
		System.out.println("ID:"+id);
		Optional<Subject> e=subjectDao.findById(id);
		model.addAttribute("subject",e.get());
		return "subjectView";
	}
	
	
	
	@RequestMapping("/deleteSubject")
	public String deleteBookById(@RequestParam long id, Model model){
		System.out.println("Deleting id:"+ id);
		subjectDao.deleteSubjectByID(id);
		
		
		
		return "successResponse";
	}
	
}
