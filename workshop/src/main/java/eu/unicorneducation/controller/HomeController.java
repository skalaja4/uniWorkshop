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
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import eu.unicorneducation.entity.Employee;
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

/**
 * Controller shared for complete application.
 * It dispatch requests and responses on given addresses.
 */
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

	/**
	 * Method for showing main page.
	 * @param model build model of data for use with UI build model of data for use with UI 
	 * @param request provide request information for HTTP servlets 
	 * @return page index
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String workshop(ModelMap model, HttpServletRequest request) {

		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		return "index";
	}
	
	/**
	 * Method for showing response on some actions such as operation was successful etc.
	 * @param model build model of data for use with UI build model of data for use with UI 
	 * @param request provide request information for HTTP servlets
	 * @return feedback
	 */
	@RequestMapping(value = "/feedback", method = RequestMethod.GET)
	public String feedback(ModelMap model, HttpServletRequest request) {
		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("message",request.getAttribute("message"));
		return "feedback";
	}

	/**
	 * Method showing loading filled with data.
	 * @param model build model of data for use with UI build model of data for use with UI 
	 * @param request provide request information for HTTP servlets
	 * @return import
	 */
	@RequestMapping(value = "/import", method = RequestMethod.GET)
	public String importForm(ModelMap model, HttpServletRequest request) {

		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("properties", loadProperties(request, "import.properties"));
		return "import";
	}

	/**
	 * Method for loading filling data.
	 * @param file that is imported.
	 * @param model build model of data for use with UI build model of data for use with UI 
	 * @param request provide request information for HTTP servlets
	 * @return import
	 * @throws ParseException 
	 * @throws IOException 
	 */
	@RequestMapping(value = "/import_employees", method = RequestMethod.POST)
	public String importEmployees(@RequestParam("file") MultipartFile file, ModelMap model, HttpServletRequest request) throws IOException, ParseException {

		importFacade.importEmployees(file);
		
		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("properties", loadProperties(request, "import.properties"));
		
		return "import";
	}

	/**
	 * Method for showing init loading data fot the app.
	 * @param model build model of data for use with UI data for use with UI 
	 * @param request provide request information for HTTP servlets
	 * @return
	 */
	@RequestMapping(value = "/inicialization", method = RequestMethod.GET)
	public String inicialization(ModelMap model, HttpServletRequest request) {

		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("properties", loadProperties(request, "inicialization.properties"));
		return "inicialization";
	}

	/**
	 * Method for importing files with data to the app.
	 * @param branchesFile file of branch informations with specific format
	 * @param employeesFile file of employees with specific format
	 * @param model build model of data for use with UI data for use with UI 
	 * @param request provide request information for HTTP servlets
	 * @return feedback
	 * @throws ParseException 
	 * @throws IOException 
	 */
	@RequestMapping(value = "/inicializate", method = RequestMethod.POST)
	public String inicializateBranches(@RequestParam("branchesFile") MultipartFile branchesFile,
			@RequestParam("employeesFile") MultipartFile employeesFile, ModelMap model, HttpServletRequest request) throws IOException, ParseException {

		iniFacade.inicializate(branchesFile, employeesFile);

		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		//model.addAttribute("properties", loadProperties(request, "inicialization.properties"));
		model.addAttribute("message","Data vložena.");
		
		return "feedback";
	}

	/**
	 * Method for showing employees of branch.
	 * @param model build model of data for use with UI data for use with UI 
	 * @param request provide request information for HTTP servlets
	 * @return
	 */
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String employees(ModelMap model, HttpServletRequest request) {

		List<EmployeeModel> list = emplfacade.readByBranch(request.getParameter("branchid"));
		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("listofemployees", list);

		request.getParameter("branchid");

		model.addAttribute("branchid", request.getParameter("branchid"));
		model.addAttribute("lastname", request.getParameter("lastname"));
		model.addAttribute("properties", loadProperties(request, "employees-of-branch.properties"));
		

		return "employees-of-branch";
	}
	
	/**
	 * Employees for given branch.
	 * @param model build model of data for use with UI
	 * @param request provide request information for HTTP servlets
	 * @return
	 */
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public String finder(ModelMap model, HttpServletRequest request) {

		List<EmployeeModel> list = emplfacade.readByLastName(request.getParameter("lastname"), request.getParameter("branchid"));
		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("listofemployees", list);
		model.addAttribute("branchid", request.getParameter("branchid"));
		model.addAttribute("lastname", request.getParameter("lastname"));
		model.addAttribute("properties", loadProperties(request, "employees-of-branch.properties"));
		

		return "employees-of-branch";
	}

	/**
	 * Method for showing branches structure.
	 * @param model build model of data for use with UI
	 * @param request provide request information for HTTP servlets
	 * @return branches
	 */
	@RequestMapping(value = "/branches", method = RequestMethod.GET)
	public String branches(ModelMap model, HttpServletRequest request) {
		
		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("properties", loadProperties(request, "branches.properties"));
		List<BranchTreeModel> structure= branchfacade.readStructure();
		model.addAttribute("branches", structure.size());
		for (int i = 0; i < structure.size(); i++) {
			model.addAttribute("branche"+i, BranchTreeHelper.getTreeForBranch("", structure.get(i)));	
		}return "branches";
	}

	/**
	 * Method for showing employee detail.
	 * @param model build model of data for use with UI
	 * @param request provide request information for HTTP servlets
	 * @return employee detail
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(ModelMap model, HttpServletRequest request) {
		List<EvaluationModel> evList = evalfac.getEvaluations(request.getParameter("id"));
		EmployeeModel emp = emplfacade.readByID(request.getParameter("id"));
		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("properties", loadProperties(request, "employeedetail.properties"));
		model.addAttribute("employee", emp);
		model.addAttribute("evList", evList);
		
		model.addAttribute("branches", branchfacade.readStructureById(emp.getBranch().getId()));
		return "employeedetail";
	}

	/**
	 * Method for showing planed evaluations.
	 * @param model build model of data for use with UI
	 * @param request provide request information for HTTP servlets
	 * @return plan evaluation
	 */
	@RequestMapping(value = "/plannedEvaluation", method = RequestMethod.GET)
	public String plannedEvaluation(ModelMap model, HttpServletRequest request) {

		List<EvaluationPlanPartsModel> plansAfter = evaluationPlanFacade.readAllAfterDate();
		List<EvaluationPlanPartsModel> plansBefore = evaluationPlanFacade.readAllBeforeDate();
		List<EvaluationPlanPartsModel> plansCompleted = evaluationPlanFacade.readAllCompleted();
		model.addAttribute("plansAfter", plansAfter);
		model.addAttribute("plansBefore", plansBefore);
		model.addAttribute("plansCompleted", plansCompleted);
		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("properties", loadProperties(request, "plannedEvaluation.properties"));
		return "plannedEvaluation";
	}

	/**
	 * Method for showing addition of new evaluation to the plan.
	 * @param model build model of data for use with UI
	 * @param request provide request information for HTTP servlets
	 * @return add evaluation
	 */
	@RequestMapping(value = "/addEvaluation", method = RequestMethod.GET)
	public String addEvaluation(ModelMap model, HttpServletRequest request) {

		

		List<BranchModel> branches = branchfacade.readAll();

		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("properties", loadProperties(request, "addEvaluation.properties"));
		model.addAttribute("branches", branches);
		
		return "addEvaluation";
	}

	/**
	 * Method for adding new Evaluation to the plan.
	 * @param category of employees that should be evaluated
	 * @param model build model of data for use with UI
	 * @param request provide request information for HTTP servlets
	 * @return choose employees
	 */
	@RequestMapping(value = "/addEvaluation", method = RequestMethod.POST)
	public String chooseEvaluation(@RequestParam(value = "category") String category, ModelMap model, HttpServletRequest request) {

		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("properties", loadProperties(request, "choosEmployees.properties"));
		
		return "choosEmployees";
	}

	/**
	 * Method for showing evaluation plan.
	 * @param model build model of data for use with UI
	 * @param branch given branch for evaluating
	 * @param category given category of employees for evaluation
	 * @param datepicker date of evaluation
	 * @param name name of evaluation
	 * @param request provide request information for HTTP servlets
	 * @return
	 */
	@RequestMapping(value = "/chooseEmployees", method = RequestMethod.GET)
	public String choosEmployees(ModelMap model, @RequestParam(value = "branch") String branch,
			@RequestParam(value = "category") String category, @RequestParam(value = "datepicker") String datepicker,
			@RequestParam(value = "name") String name, HttpServletRequest request) {

		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("properties", loadProperties(request, "chooseEmployees.properties"));
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
			model.addAttribute("unselectedEmployee", emplfacade.readByBranchAndNotPlanned(branch));
		}

		return "chooseEmployees";
	}

	/**
	 * Method for creating evaluation plan.
	 * @param model build model of data for use with UI
	 * @param employeeIds employee ids 
	 * @param datepicker date when it will be evaluated
	 * @param name for planned evaluating
	 * @param branch parameter is chosen for
	 * @param request provide request information for HTTP servlets
	 * @return feedback
	 */
	@RequestMapping(value = "/chooseEmployees", method = RequestMethod.POST)
	public String createEvaluationPlan(ModelMap model, @RequestParam(value = "id") String[] employeeIds,
			@RequestParam(value = "datepicker") String datepicker, @RequestParam(value = "name") String name,
			@RequestParam(value = "branch") String branch, HttpServletRequest request) {

		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("properties", loadProperties(request, "index.properties"));
		
		if (datepicker.equalsIgnoreCase("")) {
			model.addAttribute("message","Plán ohodnocení je vytvoøen.");
			
			return "feedback";
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
		model.addAttribute("message","Plán ohodnocení je vytvoøen.");
		
		return "feedback";
	}

	/**
	 * Method showing new filling form for given plan.
	 * @param model build model of data for use with UI
	 * @param id parameter of plan to be shown
	 * @param request provide request information for HTTP servlets
	 * @return fillevaluation
	 */
	@RequestMapping(value = "/fillEvaluation", method = RequestMethod.GET)
	public String fillEvaluation(ModelMap model, @RequestParam(value = "idOfPlan") Long id , HttpServletRequest request) {
		
		
		EvaluationPlanModel plan = evaluationPlanFacade.read(id);
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		Date date = plan.getExpiration();
		
		model.addAttribute("plan_id", plan.getId());
		System.out.println(plan.getId());
		model.addAttribute("plan_name", plan.getName());
		model.addAttribute("plan_date", format.format(date));
		model.addAttribute("plan_employees",plan.getEmployees());
		model.addAttribute("plan_branch",plan.getBranch().getName());
		
		model.addAttribute("fill", loadProperties(request, "fillEvaluation.properties"));
		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		model.addAttribute("quest", loadProperties(request, "questions.properties"));
		return "fillEvaluation";
	}
	
	/**
	 * Method for filling evaluations.
	 * @param model build model of data for use with UI
	 * @param id of type Long identifying evaluation plan
	 * @param employeeIds is an array of string values of employees PK 
	 * @param quest1 is an array of values for question NO.1
	 * @param quest2 is an array of values for question NO.2
	 * @param quest3 is an array of values for question NO.3
	 * @param quest4 is an array of values for question NO.4
	 * @param quest5 is an array of values for question NO.5
	 * @param quest6 is an array of values for question NO.6
	 * @param quest7 is an array of values for question NO.7
	 * @param quest8 is an array of values for question NO.8
	 * @param quest9 is an array of values for question NO.9
	 * @param info is an array of values for addition information
	 * @param request provide request information for HTTP servlets
	 * @return feedback
	 * @throws Exception throws exception if something goes wrong
	 */
	@RequestMapping(value = "/fillEvaluation", method = RequestMethod.POST)
	public String fillEvaluation(ModelMap model,@RequestParam(value="plan")Long id,
			@RequestParam(value = "employeeIds") String[] employeeIds,
			@RequestParam(value = "v1") String[] quest1,
			@RequestParam(value = "v2") String[] quest2,
			@RequestParam(value = "v3") String[] quest3,
			@RequestParam(value = "v4") String[] quest4,
			@RequestParam(value = "v5") String[] quest5,
			@RequestParam(value = "v6") String[] quest6,
			@RequestParam(value = "v7") String[] quest7,
			@RequestParam(value = "v8") String[] quest8,
			@RequestParam(value = "v9") String[] quest9,
			@RequestParam(value = "info") String[] info,
			HttpServletRequest request) throws Exception {
		System.out.println(quest1.length);
		
		EvaluationPlanModel plan = evaluationPlanFacade.read(id);
		
		int count = plan.getEmployees().size();
		
		model.addAttribute("menuProperties", loadProperties(request, "menu.properties"));
		
		
		for (int i = 0; i < count; i++) {
			Date date = new Date();
			if (info[i].length()>4000){
				throw new Exception("Chyba délky.");
			}
			EmployeeModel emp = emplfacade.readByID(employeeIds[i]);
			Employee e = new Employee(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getBranch(), emp.getBirthDate(), emp.getCategory());
			EvaluationModel model1;
			try {
				model1 = new EvaluationModel(plan.getName(), date, Integer.parseInt(quest1[i]),
						Integer.parseInt(quest2[i]), Integer.parseInt(quest3[i]), Integer.parseInt(quest4[i]),
						Integer.parseInt(quest5[i]), Integer.parseInt(quest6[i]), Integer.parseInt(quest7[i]),
						Integer.parseInt(quest8[i]), Integer.parseInt(quest9[i]),info[i],e);
				System.out.println("tady1");
				if (evalfac.create(model1)) {
					System.out.println("tady2");
					evaluationPlanFacade.setCompleted(id);
				}
			} catch (NumberFormatException exe) {
				System.err.print("Faild parse date");
				exe.printStackTrace();
			}
		}

		model.addAttribute("message","Plán ohodnocení je vytvoøen.");
		return "feedback";
	}
	
	/**
	 * Method for generating pdf.
	 * @param id parameter for generating pdf
	 * @param model build model of data for use with UI
	 * @param request provide request information for HTTP servlets
	 * @param response
	 * @return
	 */
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
	
	/**
	 * Method for testing catching exception.
	 * @throws exception  
	 */
	@RequestMapping(value = "/errorTest", method = RequestMethod.GET)
	public String errorTest() {

		throw new IllegalStateException("Chyba!");
	}
	
	final static Logger LOGGER = Logger.getLogger(HomeController.class);
	
	/**
	 * Method for covering exception.
	 * @param req provide request information for HTTP servlets
	 * @param exception
	 * @return model and view
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest req, Exception exception) {

		LOGGER.log(Priority.ERROR, exception.getMessage(), exception);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");
		return mav;
	}

	/**
	 * Method for loading properties from given file.
	 * @param request provide request information for HTTP servlets
	 * @param propertiesName Name of file that should be read.
	 * @return properties
	 */
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
