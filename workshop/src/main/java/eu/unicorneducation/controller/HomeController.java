package eu.unicorneducation.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String students(ModelMap model) {

		// model.addAttribute("studentsList", studentsFacade.findAll());

		return "index";
	}

	@RequestMapping(value = "/inicialization", method = RequestMethod.GET)
	public String inicialization(ModelMap model) {

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/main/webapp/WEB-INF/properties/inicializationTexts.config"));
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}

		model.addAttribute("properties", prop);
		return "inicialization";
	}

	
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String employees(ModelMap model) {

		
		return "employees-of-branch";
	}
	// @RequestMapping(value = "/student", method = RequestMethod.GET)
	// public ModelAndView students() {
	// return new ModelAndView("new_student", "command", new StudentModel());
	// }
	//
	// @RequestMapping(value = "/student", method = RequestMethod.POST)
	// public String addStudent(@ModelAttribute("SpringWeb")StudentModel
	// student, ModelMap model) {
	// studentsFacade.save(student);
	// return students(model);
	// }
	@RequestMapping(value = "/branches", method = RequestMethod.GET)
	public String branches() {
		return "branches";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(ModelMap model) {

		// model.addAttribute("studentsList", studentsFacade.findAll());

		return "employeedetail";
	}
	@RequestMapping(value = "/plannedEvaluation", method = RequestMethod.GET)
	public String plannedEvaluation(ModelMap model) {

		// model.addAttribute("studentsList", studentsFacade.findAll());

		return "plannedEvaluation";
	}
}