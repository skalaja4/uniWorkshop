package workshop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import eu.unicorneducation.dao.impl.BranchDAOImpl;
import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.entity.EvaluationPlan;
import eu.unicorneducation.enumeration.Category;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans-test.xml")
public class EmployeeDAOTest {
	
	
	@Autowired
	BranchDAO branchDAO;
	@Autowired
	EmployeeDAO employeeDAO;
	
	@Before
	public void beforeTest(){
		
		Branch branch = new Branch("id1","name","address",null);
		branchDAO.create(branch);
		
	}
	
	

		@Test
		public void createDeletTest() {		
			
			Branch branch = branchDAO.read("id1");
			Employee employee = new Employee("EMP_10001","Josef","Vomacka",branch,Calendar.getInstance().getTime(),eu.unicorneducation.enumeration.Category.NEW);
			employeeDAO.create(employee);
			
			Assert.assertTrue(employeeDAO.create(employee));
			
			Assert.assertTrue(employeeDAO.delete(employee));
			branchDAO.delete(branch);

		}

	
	
	
	

}