package eu.unicorneducation.dao.test;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eu.unicorneducation.dao.BranchDAO;
import eu.unicorneducation.dao.EmployeeDAO;
import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.entity.Employee;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans-test.xml")
public class EmployeeDAOTest {
	
	
	@Autowired
	BranchDAO branchDAO;
	@Autowired
	EmployeeDAO emplDAO;
	
	@Before
	public void beforeTest(){
		
		Branch branch = new Branch("BranchTest","Test","Testaddress",null);
		branchDAO.create(branch);
		
	}
	
	

		@Test
		public void createDeletTest() {		
			
			Branch branch = branchDAO.read("BranchTest");
			Employee employee = new Employee("EMP_1000","Josef","Vomacka",branch,Calendar.getInstance().getTime(),eu.unicorneducation.enumeration.Category.NEW);
			emplDAO.create(employee);
			
			Assert.assertTrue(emplDAO.create(employee));
			
			Assert.assertTrue(emplDAO.delete(employee));
			branchDAO.delete(branch);

		}

	
	
	
	

}