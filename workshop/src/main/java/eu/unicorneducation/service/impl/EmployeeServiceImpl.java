package eu.unicorneducation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.unicorneducation.dao.EmployeeDAO;
import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.service.EmployeeService;
@Component
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO employeeDao;

	public List<Employee> readAll() {
		
		return employeeDao.readAll();
		
	}

	@Override
	public List<Employee> readByBranchAndCategory(String branch, String category) {
		
		return employeeDao.readByBranchAndCategory(branch, category);
		
	}

	@Override
	public List<Employee> readByBranchWithoutCategory(String branch, String category) {
		return employeeDao.readByBranchWithoutCategory(branch, category);
	}

	@Override
	public List<Employee> readByBranch(String branch) {
		return employeeDao.readByBranch(branch);
	}

	@Override
	public List<Employee> readByIds(String[] employeeIds) {
		return employeeDao.readByIds(employeeIds);
	}

	@Override
	public Employee readByID(String employeeId) {
		return employeeDao.readById(employeeId);
	
	}

}
