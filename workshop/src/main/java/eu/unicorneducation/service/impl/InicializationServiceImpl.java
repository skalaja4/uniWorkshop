package eu.unicorneducation.service.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
import eu.unicorneducation.service.InicializationService;
import eu.unicroneducation.enumeration.Category;

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
	public void inicializateBranches(MultipartFile file) {
		List<Branch> branches = new ArrayList<>();

		try {
			CSVParser parser = CSVFormat.DEFAULT.parse(new InputStreamReader(
					file.getInputStream()));

			// first we save all branches to database without their mother specified
			for (CSVRecord r : parser) {
				branches.add(new Branch(removeZeros(r.get(0)), r.get(1), r
						.get(2), null));
			}

			branchDao.createAll(branches);

			// now we add records of mother branches
			for (CSVRecord r : parser) {
				if (r.get(4).equals("NULL"))
					continue;

				Branch daughter = branchDao.read(removeZeros(r.get(0)));
				daughter.setParrentBranch(branchDao.read(removeZeros(r.get(4))).getId()); //---------TADY----------
				branchDao.modify(daughter);
			}

		} catch (IOException e) {
			// TODO add error logger
			e.printStackTrace();
		}
	}

	/**
	 * Method for inicializating and adding new employees.
	 * 
	 * @param file file from which the employees will be parsed
	 */
	public void inicializateEmployees(MultipartFile file) {
		List<Employee> employees = new ArrayList<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-ddTHH:mm:ssXXX");

		try {
			CSVParser parser = CSVFormat.DEFAULT.parse(new InputStreamReader(
					file.getInputStream()));
			for (CSVRecord r : parser) {
				//if employee is already in database, then skip to next record
				if(employeeDao.read(r.get(0)) == null) continue;
				
				try {
					Branch branch = branchDao.read(removeZeros(r.get(3)));
					Employee emp = new Employee(
							r.get(0),
							r.get(1),
							r.get(2),
							branch,
							dateFormat.parse(r.get(4)),
							Category.valueOf(r.get(5))
							);
					
					//if newly created employee is MANAGER, then we set him as manager
					//in his branch
					if(emp.getCategory().equals(Category.MANAGER)) {
						branch.setManager(emp);
						branchDao.modify(branch);
					}
					
					employees.add(emp);
				} catch (ParseException e) {
					// TODO add error logger
					e.printStackTrace();
				}
			}
			
			employeeDao.createAll(employees);
		} catch (IOException e) {
			// TODO add error logger
			e.printStackTrace();
		}
	}

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
