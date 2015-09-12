package eu.unicorneducation.dao;

import java.util.List;

import eu.unicorneducation.entity.Employee;

public interface EmployeeDAO {

	public boolean create(Employee employee);

	public Employee read(String id);

	public boolean delete(Employee employee);

	public List<Employee> readAll();

	public boolean createAll(List<Employee> employees);
}
