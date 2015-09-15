package eu.unicorneducation.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import eu.unicorneducation.facade.BranchFacade;
import eu.unicorneducation.facade.EmployeeFacade;
import eu.unicorneducation.facade.EvaluationFacade;
import eu.unicorneducation.facade.EvaluationPlanFacade;
import eu.unicorneducation.facade.ImportFacade;
import eu.unicorneducation.facade.InicializationFacade;
import eu.unicorneducation.facade.PdfFacade;
import eu.unicorneducation.helpers.BranchTreeHelper;
import eu.unicorneducation.model.BranchModel;
import eu.unicorneducation.model.BranchTreeModel;
import eu.unicorneducation.model.EmployeeModel;
import eu.unicorneducation.model.EvaluationModel;
import eu.unicorneducation.model.EvaluationPlanModel;
import eu.unicorneducation.model.EvaluationPlanPartsModel;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private EmployeeFacade emplfacade;

	@Autowired
	private InicializationFacade iniFacade;

	@Autowired
	private ImportFacade importFacade;

	@Autowired
	private BranchFacade branchfacade;

	@Autowired
	private EvaluationPlanFacade evaluationPlanFacade;
	
	@Autowired
	private PdfFacade pdfFacade;
	
	@Autowired
	private EvaluationFacade evalfac;

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
	public String importEmployees(@RequestParam("file") MultipartFile file, ModelMap model, HttpServletRequest request) {

		importFacade.importEmployees(file);
		
		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("properties", loadProperties(request, "import.properties"));
		
		return "import";
	}

	@RequestMapping(value = "/inicialization", method = RequestMethod.GET)
	public String inicialization(ModelMap model, HttpServletRequest request) {

		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("properties", loadProperties(request, "inicialization.properties"));
		return "inicialization";
	}

	@RequestMapping(value = "/inicializate", method = RequestMethod.POST)
	public String inicializateBranches(@RequestParam("branchesFile") MultipartFile branchesFile,
			@RequestParam("employeesFile") MultipartFile employeesFile, ModelMap model, HttpServletRequest request) {

		iniFacade.inicializate(branchesFile, employeesFile);

		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("properties", loadProperties(request, "inicialization.properties"));
		
		return "inicialization";
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String employees(ModelMap model, HttpServletRequest request) {

		List<EmployeeModel> list = emplfacade.readByBranch(request.getParameter("branchid"));
		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("listofemployees", list);
		model.addAttribute("branchid", request.getParameter("branchid"));
		model.addAttribute("lastname", request.getParameter("lastname"));
		

		return "employees-of-branch";
	}

	@RequestMapping(value = "/employeefinder", method = RequestMethod.GET)
	public String find(ModelMap model, HttpServletRequest request) {

		List<EmployeeModel> list = emplfacade.readByLastName(request.getParameter("lastname"));
		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("listofemployees", list);
		
		

		return "employeefinder";
	}
	@RequestMapping(value = "/branches", method = RequestMethod.GET)
	public String branches(ModelMap model, HttpServletRequest request) {
		
		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		List<BranchTreeModel> structure= branchfacade.readStructure();
		model.addAttribute("branches", structure.size());
		for (int i = 0; i < structure.size(); i++) {
			model.addAttribute("branche"+i, BranchTreeHelper.getTreeForBranch("", structure.get(i)));	
		}return "branches";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(ModelMap model, HttpServletRequest request) {
		List<EvaluationModel> evList = evalfac.getEvaluations(request.getParameter("id"));
		EmployeeModel emp = emplfacade.readByID(request.getParameter("id"));
		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("employee", emp);
		model.addAttribute("evList", evList);
		
		branchfacade.readStructureById(emp.getBranch().getId());
		return "employeedetail";
	}

	@RequestMapping(value = "/plannedEvaluation", method = RequestMethod.GET)
	public String plannedEvaluation(ModelMap model, HttpServletRequest request) {

		List<EvaluationPlanPartsModel> plansAfter = evaluationPlanFacade.readAllAfterDate();
		List<EvaluationPlanPartsModel> plansBefore = evaluationPlanFacade.readAllBeforeDate();
		List<EvaluationPlanPartsModel> plansCompleted = evaluationPlanFacade.readAllCompleted();
		model.addAttribute("plansAfter", plansAfter);
		model.addAttribute("plansBefore", plansBefore);
		model.addAttribute("plansCompleted", plansCompleted);
		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		return "plannedEvaluation";
	}

	@RequestMapping(value = "/addEvaluation", method = RequestMethod.GET)
	public String addEvaluation(ModelMap model, HttpServletRequest request) {

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/main/webapp/WEB-INF/addEvaluation.jsp"));
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}

		List<BranchModel> branches = branchfacade.readAll();

		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("branches", branches);
		model.addAttribute("properties", prop);
		return "addEvaluation";
	}

	@RequestMapping(value = "/addEvaluation", method = RequestMethod.POST)
	public String chooseEvaluation(@RequestParam(value = "category") String category, ModelMap model, HttpServletRequest request) {

		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		
		return "choosEmployees";
	}

	@RequestMapping(value = "/chooseEmployees", method = RequestMethod.GET)
	public String choosEmployees(ModelMap model, @RequestParam(value = "branch") String branch,
			@RequestParam(value = "category") String category, @RequestParam(value = "datepicker") String datepicker,
			@RequestParam(value = "name") String name, HttpServletRequest request) {

		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("branch", branch);
		model.addAttribute("name", name);
		model.addAttribute("category", category);
		model.addAttribute("datepicker", datepicker);

		if (!category.equalsIgnoreCase("other")) {
			model.addAttribute("selectedEmployee", emplfacade.readByBranchAndCategory(branch, category));
			model.addAttribute("unselectedEmployee", emplfacade.readByBranchWithoutCategory(branch, category));
		} else {
			List<EmployeeModel> list = new ArrayList<>();
			model.addAttribute("selectedEmployee", list);
			model.addAttribute("unselectedEmployee", emplfacade.readByBranch(branch));
		}

		return "chooseEmployees";
	}

	@RequestMapping(value = "/chooseEmployees", method = RequestMethod.POST)
	public String createEvaluationPlan(ModelMap model, @RequestParam(value = "id") String[] employeeIds,
			@RequestParam(value = "datepicker") String datepicker, @RequestParam(value = "name") String name,
			@RequestParam(value = "branch") String branch, HttpServletRequest request) {

		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		
		if (datepicker.equalsIgnoreCase("")) {
			return "index";
		}

		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		Date date;
		try {
			date = format.parse(datepicker);

			System.out.println(date);
			evaluationPlanFacade.create(new EvaluationPlanModel(name, date, branchfacade.readByName(branch),
					emplfacade.readByIds(employeeIds)), employeeIds);
		} catch (ParseException e) {
			System.err.print("Faild parse date");
			e.printStackTrace();

		}
		return "index";
	}

	@RequestMapping(value = "/fillEvaluation", method = RequestMethod.GET)
	public String fillEvaluation(ModelMap model, HttpServletRequest request) {

		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		return "fillEvaluation";
	}
	
	@RequestMapping(value = "/exportPdf", method = RequestMethod.GET)
	public String exportPdf(@RequestParam("id")String id, ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		InputStream is = pdfFacade.generatePdf(id);
		System.out.println("path" + request.getSession().getServletContext().getContextPath());
		try {
			org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
			response.flushBuffer();
		} catch (IOException e) {
			// TODO logger
			e.printStackTrace();
		}
	      
		
		model.addAttribute("menuProperties", loadProperties(request, "exportPdf.properties"));
		return "exportPdf";
	}

	private Properties loadProperties(HttpServletRequest request, String propertiesName) {
		Properties prop = new Properties();
		try (InputStream in = request.getSession().getServletContext()
				.getResourceAsStream("/WEB-INF/properties/" + propertiesName)) {
			prop.load(in);
		} catch (IOException e) {
			prop = null;
			e.printStackTrace();
		}
		return prop;
	}
}
