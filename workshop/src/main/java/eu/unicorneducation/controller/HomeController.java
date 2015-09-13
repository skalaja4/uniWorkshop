package eu.unicorneducation.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import eu.unicorneducation.facade.EmployeeFacade;
import eu.unicorneducation.facade.InicializationFacade;
import eu.unicorneducation.model.BranchModel;
import eu.unicorneducation.model.EmployeeModel;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private EmployeeFacade emplfacade;
	
	@Autowired
	private InicializationFacade iniFacade;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String students(ModelMap model) {

		// model.addAttribute("studentsList", studentsFacade.findAll());

		return "index";
	}

	@RequestMapping(value = "/inicialization", method = RequestMethod.GET)
	public String inicialization(ModelMap model, HttpServletRequest request) {

		Properties prop = new Properties();
		try (InputStream in = request
				.getSession()
				.getServletContext()
				.getResourceAsStream("/WEB-INF/properties/inicializationTexts.config")) {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

		model.addAttribute("properties", prop);
		return "inicialization";
	}

	@RequestMapping(value = "/inicializate_branches", method = RequestMethod.POST)
	public String inicializateBranches(@RequestParam("file") MultipartFile file) {

		iniFacade.inicializateBranches(file);

		return "inicialization";
	}
	
	@RequestMapping(value = "/inicializate_employees", method = RequestMethod.POST)
	public String inicializateEmployees(@RequestParam("file") MultipartFile file) {

		iniFacade.inicializateEmployees(file);

		return "inicialization";
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String employees(ModelMap model) {

		List<EmployeeModel> list = emplfacade.readAll();
		model.addAttribute("listofemployees", list);

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
		return "employeedetail";
	}

	@RequestMapping(value = "/plannedEvaluation", method = RequestMethod.GET)
	public String plannedEvaluation(ModelMap model) {
		return "plannedEvaluation";
	}

	@RequestMapping(value = "/addEvaluation", method = RequestMethod.GET)
	public String addEvaluation(ModelMap model) {

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(
					"src/main/webapp/WEB-INF/addEvaluation.jsp"));
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}

		List<BranchModel> branches = new ArrayList<BranchModel>();
		BranchModel b = new BranchModel();
		b.setId("EU_matka");
		b.setName("EU-Praha");
		b.setAddress("Na P��kopech 1, Praha");

		BranchModel p = new BranchModel();
		p.setId("EU_dcera");
		p.setName("EU-Dcera");
		p.setAddress("Botanick� 2, Brno");

		branches.add(b);
		branches.add(p);

		model.addAttribute("branches", branches);
		model.addAttribute("properties", prop);
		return "addEvaluation";
	}

	@RequestMapping(value = "/fillEvaluation", method = RequestMethod.GET)
	public String fillEvaluation(ModelMap model) {
		return "fillEvaluation";
	}
}