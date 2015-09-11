package eu.unicorneducation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String students(ModelMap model) {
		
//		model.addAttribute("studentsList", studentsFacade.findAll());
		
		return "index";
	}
	
	@RequestMapping(value = "/inicialization", method = RequestMethod.GET)
	public String inicialization() {
		return "inicialization";
	}
	
//	@RequestMapping(value = "/student", method = RequestMethod.GET)
//	public ModelAndView students() {
//		return new ModelAndView("new_student", "command", new StudentModel());
//	}
//	
//	@RequestMapping(value = "/student", method = RequestMethod.POST)
//	public String addStudent(@ModelAttribute("SpringWeb")StudentModel student, ModelMap model) {
//		studentsFacade.save(student);
//		return students(model);
//	}
	@RequestMapping(value = "/branches/", method = RequestMethod.GET)
	public String branches() {
		return "branches";
	}
}