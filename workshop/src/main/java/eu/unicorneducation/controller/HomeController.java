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
import eu.unicorneducation.facade.ImportFacade;
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
	
	@Autowired
	private ImportFacade importFacade;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String students(ModelMap model, HttpServletRequest request) {

		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		return "index";
	}
	
	@RequestMapping(value = "/import", method = RequestMethod.GET)
	public String importForm(ModelMap model, HttpServletRequest request) {

		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("properties", loadProperties(request, "import.properties"));
		return "import";
	}

	@RequestMapping(value = "/import_employees", method = RequestMethod.POST)
	public String importEmployees(@RequestParam("file") MultipartFile file) {

		importFacade.importEmployees(file);

		return "inicialization";
	}
	
	@RequestMapping(value = "/inicialization", method = RequestMethod.GET)
	public String inicialization(ModelMap model, HttpServletRequest request) {

		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("properties", loadProperties(request, "inicialization.properties"));
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
	public String employees(ModelMap model, HttpServletRequest request) {

		List<EmployeeModel> list = emplfacade.readAll();
		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
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
	public String branches(ModelMap model, HttpServletRequest request) {
		
		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		return "branches";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(ModelMap model, HttpServletRequest request) {
		
		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		return "employeedetail";
	}

	@RequestMapping(value = "/plannedEvaluation", method = RequestMethod.GET)
	public String plannedEvaluation(ModelMap model, HttpServletRequest request) {
		
		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		return "plannedEvaluation";
	}

	@RequestMapping(value = "/addEvaluation", method = RequestMethod.GET)
	public String addEvaluation(ModelMap model, HttpServletRequest request) {

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

		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("branches", branches);
		model.addAttribute("properties", loadProperties(request, "addEvaluation.properties"));
		return "addEvaluation";
	}

	@RequestMapping(value = "/fillEvaluation", method = RequestMethod.GET)
	public String fillEvaluation(ModelMap model, HttpServletRequest request) {
		
		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		return "fillEvaluation";
	}
	
	private Properties loadProperties(HttpServletRequest request, String propertiesName) {
		Properties prop = new Properties();
		try (InputStream in = request
				.getSession()
				.getServletContext()
				.getResourceAsStream("/WEB-INF/properties/" + propertiesName)) {
			prop.load(in);
		} catch (IOException e) {
			prop = null;
			e.printStackTrace();
		}
		return prop;
	}
}