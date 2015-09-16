package eu.unicorneducation.dao.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eu.unicorneducation.dao.BranchDAO;
import eu.unicorneducation.dao.EmployeeDAO;
import eu.unicorneducation.dao.EvaluationPlanDAO;
import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.entity.EvaluationPlan;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans-test.xml")
public class EvaluationPlanDAOImplTest {
	
	@Autowired
	EvaluationPlanDAO evalPlanDAO;
	@Autowired
	BranchDAO branchDAO;
	@Autowired
	EmployeeDAO employeeDAO;
	
	@Before
	public void beforeTest(){
		
		Branch branch = new Branch("id","name","address",null);
		branchDAO.create(branch);
		Employee employee = new Employee("id","first","last",branch,Calendar.getInstance().getTime(),eu.unicorneducation.enumeration.Category.NEW);
		employeeDAO.create(employee);
	}
	
	
	@Test
	public void createDeletTest() {		
		List<Employee> list =new ArrayList<>();
		list.add(employeeDAO.read("id"));
		EvaluationPlan evPlan = new EvaluationPlan("Name",Calendar.getInstance().getTime(),branchDAO.read("id"),list,false);
		Branch branch = branchDAO.read("id");
		Employee emp = employeeDAO.read("id");
		
		
		Assert.assertTrue(evalPlanDAO.create(evPlan));
		employeeDAO.delete(emp);
		Assert.assertTrue(evalPlanDAO.delete(evPlan));
		branchDAO.delete(branch);

	}

}
