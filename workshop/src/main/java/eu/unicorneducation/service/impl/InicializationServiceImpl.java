package eu.unicorneducation.service.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import eu.unicorneducation.dao.BranchDAO;
import eu.unicorneducation.dao.EmployeeDAO;
import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.enumeration.Category;
import eu.unicorneducation.service.InicializationService;

@Component
public class InicializationServiceImpl implements InicializationService {

	@Autowired
	BranchDAO branchDao;

	@Autowired
	EmployeeDAO employeeDao;

	/**
	 * Thid method serves for inicialization of databaze of branches. First we enter all branches without 
	 * references to their mothers. Then we fill in these refereces.
	 * 
	 * @param file file from which the branches will be parsed
	 */
	public void inicializate(MultipartFile branchesFile, MultipartFile employeesFile) {
		List<Branch> branches = new ArrayList<>();
		List<Employee> employees = new ArrayList<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, String> branchToEmployeeeMap = new HashMap<>();
		Map<String, String> employeeeToBranchMap = new HashMap<>();

		try {
			CSVParser parser = CSVFormat.DEFAULT.parse(new InputStreamReader(
					branchesFile.getInputStream()));

			// first we save all branches to database without their mother specified
			for (CSVRecord r : parser) {
				branches.add(new Branch(removeZeros(r.get(0)), r.get(1), r.get(2), null));
				branchToEmployeeeMap.put(removeZeros(r.get(0)), removeZeros(r.get(3)));
				employeeeToBranchMap.put(removeZeros(r.get(3)), removeZeros(r.get(0)));
			}

			branchDao.createAll(branches);

			// now we add records of mother branches
			parser = CSVFormat.DEFAULT.parse(new InputStreamReader(branchesFile.getInputStream()));
			
			for (CSVRecord r : parser) {
				if (r.get(4).equals("NULL"))
					continue;

				Branch daughter = branchDao.read(removeZeros(r.get(0)));
				daughter.setParrentBranch(branchDao.read(removeZeros(r.get(4))).getId()); //---------TADY----------
				branchDao.modify(daughter);
			}
			
			
			//now we will inicializate employees
			parser = CSVFormat.DEFAULT.parse(new InputStreamReader(employeesFile.getInputStream()));
			for (CSVRecord r : parser) {
				//if employee is already in database, then skip to next record
				if(employeeDao.read(r.get(0)) != null) continue;
				
				try {
					Branch branch = branchDao.read(removeZeros(r.get(3)));
					Employee emp = new Employee(
							r.get(0),
							r.get(1),
							r.get(2),
							branch,
							dateFormat.parse(r.get(4).substring(0, 10)),
							Category.valueOf(r.get(5))
							);
					employeeDao.create(emp);
					
					//if newly created employee is MANAGER, then we set him as manager
					//in his branch
					if(emp.getCategory().equals(Category.MANAGER)) {
						if(emp.getId().equals(branchToEmployeeeMap.get(emp.getBranch()))) {
							branch.setManager(emp);
							branchDao.modify(branch);
						} else if(employeeeToBranchMap.get(emp.getId()) != null) {
								Branch rightBranch = branchDao.read(employeeeToBranchMap.get(emp.getId()));
								emp.setBranch(rightBranch);
								rightBranch.setManager(emp);
								branchDao.modify(rightBranch);
						} else {
							employeeDao.delete(emp);
						}
					}
					
					employees.add(emp);
				} catch (ParseException e) {
					// TODO add error logger
					e.printStackTrace();
				}
			}
			
		} catch (IOException e) {
			// TODO add error logger
			e.printStackTrace();
		}
	}

//	/**
//	 * Method for inicializating and adding new employees.
//	 * 
//	 * @param file file from which the employees will be parsed
//	 */
//	public void inicializateEmployees(MultipartFile file) {
//		List<Employee> employees = new ArrayList<>();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//		try {
//			CSVParser parser = CSVFormat.DEFAULT.parse(new InputStreamReader(
//					file.getInputStream()));
//			for (CSVRecord r : parser) {
//				//if employee is already in database, then skip to next record
//				if(employeeDao.read(r.get(0)) != null) continue;
//				
//				try {
//					Branch branch = branchDao.read(removeZeros(r.get(3)));
//					Employee emp = new Employee(
//							r.get(0),
//							r.get(1), 
//							r.get(2),
//							branch,
//							dateFormat.parse(r.get(4).substring(0, 10)),
//							Category.valueOf(r.get(5))
//							);
//					employeeDao.create(emp);
//					//if newly created employee is MANAGER, then we set him as manager
//					//in his branch
//					if(emp.getCategory().equals(Category.MANAGER)) {
//						branch.setManager(emp);
//						branchDao.modify(branch);
//					}
//					
//					employees.add(emp);
//				} catch (ParseException e) {
//					// TODO add error logger
//					e.printStackTrace();
//				}
//			}
//			
//		} catch (IOException e) {
//			// TODO add error logger
//			e.printStackTrace();
//		}
//	}

	/**
	 * This method will remove zeros befor number part of id
	 * 
	 * @param id
	 *            full id string
	 * @return id string without zeros befor number part
	 */
	private String removeZeros(String id) {
		int lastUnderscoreCharacterPosition = id.lastIndexOf('_');

		// remove zeros before number
		int zerolessId = Integer.parseInt(id.substring(lastUnderscoreCharacterPosition + 1));
		id = id.substring(0, lastUnderscoreCharacterPosition + 1) + zerolessId;
		return id;
	}
}
