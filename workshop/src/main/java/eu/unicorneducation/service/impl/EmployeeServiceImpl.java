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

}
