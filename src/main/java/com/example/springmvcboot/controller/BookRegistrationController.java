package com.example.springmvcboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;







//import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springmvcboot.dao.BooksDao;
import com.example.springmvcboot.entity.Books;

@Controller
@RequestMapping("/bookRegistration")
public class BookRegistrationController {

	@Autowired
	private BooksDao booksDao;
	
	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public String getEmployeeForm(ModelMap model) {
		System.out.println("add book");
		Books e=new Books();
		//e.setEmail("sdfsf");
	//	e.setSalary(4564.56f);
		model.addAttribute("bookModel", e);
		return "bookForm";
		
	}
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	binder.registerCustomEditor(Date.class, new CustomDateEditor(
	        dateFormat, false));
	}
	
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String formHandler(@Valid Books books, 
			BindingResult result, Model model) {
		 System.out.println("Alok");
		 System.out.println("Publish Date :" + books.getPublishDate());
		 System.out.println("Book ID :" + books.getBookId());
		
		if(result.hasErrors()){
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			return "bookForm";
		}
		
		booksDao.save(books);
				
		//model.addAttribute("name", employee.getName());
		List <Books>booksList=booksDao.findAll();
		model.addAttribute("bookList",booksList);
		return "bookDetails";
	}
	
}
