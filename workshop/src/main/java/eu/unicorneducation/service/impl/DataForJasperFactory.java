package eu.unicorneducation.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.entity.Evaluation;
import eu.unicorneducation.enumeration.Category;

public class DataForJasperFactory {

	public static List<Employee> getList() {
		List<Employee> result = new ArrayList<>();
		
		Employee e1 = new Employee("emp_1", "adam", "nikdo", null, Calendar.getInstance().getTime(), Category.STABLE);
		
		List<Evaluation> list = new ArrayList<>();
		
		Evaluation eva1 = new Evaluation(1L, "evaluation", Calendar.getInstance().getTime(), 1, 2, 3, 4, 5, 1, 2, 3, 4, "bla bla bla", e1);
		Evaluation eva2 = new Evaluation(2L, "evaluation2", Calendar.getInstance().getTime(), 3, 3, 3, 3, 5, 3, 3, 3, 4, "bla bla bla", e1);

		list.add(eva1);
		list.add(eva2);
		e1.setEvaluation(list);
		result.add(e1);
		
		return result;
	}
	
}
