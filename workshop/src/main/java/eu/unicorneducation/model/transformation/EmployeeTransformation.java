package eu.unicorneducation.model.transformation;

import java.util.ArrayList;
import java.util.List;

import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.model.EmployeeModel;

public class EmployeeTransformation {

	public static EmployeeModel transToModel(Employee employee) {
		EmployeeModel model = new EmployeeModel(employee.getId(),
				employee.getFirstName(), employee.getLastName(),
				employee.getBirthDate(),
				EvaluationPlanTransformation.transToModel(employee.getPlan()),
				EvaluationTransformation.transToModelList(employee
						.getEvaluation()),
				BranchTransformation.transToModel(employee.getBranch()),
				employee.getCategory());
		return model;
	}

	public static Employee transToEntity(EmployeeModel model) {
		Employee employee = new Employee(model.getId(), model.getFirstName(),
				model.getLastName(), model.getBirthDate(),
				EvaluationPlanTransformation.transToEntity(model.getPlan()),
				EvaluationTransformation.transToEntityList(model
						.getEvaluation()),
				BranchTransformation.transToEntity(model.getBranch()),
				model.getCategory());
		return employee;

	}

	public static List<EmployeeModel> transToModelList(List<Employee> list) {
		List<EmployeeModel> modelList = new ArrayList<EmployeeModel>();
		for (Employee employee : list) {
			modelList.add(transToModel(employee));
		}
		return modelList;
	}

	public static List<Employee> transToEntityList(List<EmployeeModel> list) {
		List<Employee> employeeList = new ArrayList<Employee>();
		for (EmployeeModel employeeModel : list) {
			employeeList.add(transToEntity(employeeModel));
		}
		return employeeList;
	}

}
