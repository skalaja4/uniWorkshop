package eu.unironeducation.facade.test;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eu.unicorneducation.dao.BranchDAO;
import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.facade.EmployeeFacade;
import eu.unicorneducation.model.EmployeeModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans-test.xml")
public class EmployeeFacadeTest {
	
	@Autowired
	EmployeeFacade emplfac;
	
	
	@Autowired
	BranchDAO branchdao;
	
	@Before
	public void beforeTest(){
		
		Branch branch = new Branch("BranchTest1","Test","Testaddress",null);
		
		branchdao.create(branch);
		
	}
	
	@Test
	public void readByIDTest()
	{
		Branch branch = branchdao.read("BranchTest1");
		EmployeeModel mod = new EmployeeModel("EMP_1","name","lname",Calendar.getInstance().getTime(),null,null,branch,eu.unicorneducation.enumeration.Category.NEW);
		Assert.assertEquals(mod.getId(), emplfac.readByID("EMP_1").getId());
		
		
		branchdao.delete(branch);
		
	}
	

}
