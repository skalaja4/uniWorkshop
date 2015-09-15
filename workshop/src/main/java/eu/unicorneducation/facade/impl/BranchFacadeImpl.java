package eu.unicorneducation.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.facade.BranchFacade;
import eu.unicorneducation.model.BranchModel;
import eu.unicorneducation.model.BranchTreeModel;
import eu.unicorneducation.model.EmployeeModel;
import eu.unicorneducation.service.BranchService;

@Component
public class BranchFacadeImpl implements BranchFacade {

	@Autowired
	BranchService branchService;

	@Override
	public List<BranchModel> readAll() {
		List<Branch> list = branchService.readAll();
		List<BranchModel> returnedList = new ArrayList<>();
		for (Branch branch : list) {

			List<EmployeeModel> employees = new ArrayList<>();
			for (Employee emp : branch.getEmployees()) {
				employees.add(new EmployeeModel(emp.getId(),
						emp.getFirstName(), emp.getLastName(), emp
								.getBirthDate(), emp.getPlan(), emp
								.getEvaluation(), emp.getBranch(), emp
								.getCategory()));
			}

			BranchModel bm = new BranchModel(branch.getId(), branch.getName(),
					branch.getAddress(), branch.getParrentBranch(), employees,
					branch.getManager());

			returnedList.add(bm);
		}
		return returnedList;

	}

	@Override
	public BranchModel read(String id) {
		Branch branch = branchService.read(id);
		List<EmployeeModel> employees = new ArrayList<>();
		for (Employee emp : branch.getEmployees()) {
			employees.add(new EmployeeModel(emp.getId(), emp.getFirstName(),
					emp.getLastName(), emp.getBirthDate(), emp.getPlan(), emp
							.getEvaluation(), emp.getBranch(), emp
							.getCategory()));
		}

		return new BranchModel(branch.getId(), branch.getName(),
				branch.getAddress(), branch.getParrentBranch(), employees,
				branch.getManager());
	}

	@Override
	public BranchModel readByName(String name) {

		Branch branch = branchService.readByName(name);
		List<EmployeeModel> employees = new ArrayList<>();
		for (Employee emp : branch.getEmployees()) {
			employees.add(new EmployeeModel(emp.getId(), emp.getFirstName(),
					emp.getLastName(), emp.getBirthDate(), emp.getPlan(), emp
							.getEvaluation(), emp.getBranch(), emp
							.getCategory()));
		}

		return new BranchModel(branch.getId(), branch.getName(),
				branch.getAddress(), branch.getParrentBranch(), employees,
				branch.getManager());

	}

	@Override
	public List<BranchTreeModel> readStructure() {
		
		return branchService.readStructure();

		
	
	}

	@Override
	public String readStructureById(String id) {
		return branchService.readStructureById(id);
		
	}

}
