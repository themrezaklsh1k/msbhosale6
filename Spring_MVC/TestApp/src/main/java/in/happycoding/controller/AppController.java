package in.happycoding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import in.happycoding.dao.StudentDAO;
import in.happycoding.model.Student;

@Controller
public class AppController {

	@Autowired
	private StudentDAO studentDAO;
	
	@RequestMapping("/")
	public String indexPage(ModelMap model) {
		
		List<Student> studentsList = studentDAO.getAll();
		
		model.addAttribute("studentsList", studentsList);
		
		return "test";
	}
	
	@RequestMapping("/profile/{rollNumber}")
	public String profilePage(	@PathVariable("rollNumber") int rollNumber,
								ModelMap model) {
		
		Student theStudent = studentDAO.getById(rollNumber);
		
		model.addAttribute("student", theStudent);
		
		return "profile";
	}
	
	
}
