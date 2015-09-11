package eu.unicorneducation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import eu.unicorneducation.dao.EmployeeDAO;
import eu.unicorneducation.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO employeeDao;

	public List<Employee> readAll() {
		
		return employeeDao.readAll();
		
	}

}
