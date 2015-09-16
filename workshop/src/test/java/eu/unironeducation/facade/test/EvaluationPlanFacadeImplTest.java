package eu.unironeducation.facade.test;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eu.unicorneducation.facade.EvaluationPlanFacade;
import eu.unicorneducation.model.EvaluationPlanPartsModel;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans-test.xml")
public class EvaluationPlanFacadeImplTest {
	@Autowired
	EvaluationPlanFacade evalPlanFacade;
	
	
	
	@Test
	public void readAllAfterDateTest(){
		
		List<EvaluationPlanPartsModel> evPlanModel = evalPlanFacade.readAllAfterDate();
		if(evPlanModel.size()>0){
			System.out.println(Calendar.getInstance().getTime());
			for(EvaluationPlanPartsModel parts:evPlanModel){
				System.out.println(parts.getExpiration());
				if(parts.getExpiration().after(Calendar.getInstance().getTime())){
					Assert.assertTrue(true);
				}else{
					Assert.assertTrue(false);
				}
			}
			
			
			
		}
		
		
	}
}
