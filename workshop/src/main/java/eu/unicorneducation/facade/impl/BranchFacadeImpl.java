package eu.unicorneducation.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.facade.BranchFacade;
import eu.unicorneducation.model.BranchModel;
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
				employees.add(new EmployeeModel(emp));
			}
			
			BranchModel bm = new BranchModel(branch.getId(),branch.getName(),branch.getAddress(),branch.getParrentBranch(),employees,branch.getManager());
		
			returnedList.add(bm);	
		}
		return returnedList;
		
	}
	@Override
	public BranchModel read(String id) {
		Branch branch= branchService.read(id);
		List<EmployeeModel> employees = new ArrayList<>();
		for (Employee emp : branch.getEmployees()) {
			employees.add(new EmployeeModel(emp));
		}
		
		return new BranchModel(branch.getId(),branch.getName(),branch.getAddress(),branch.getParrentBranch(),employees,branch.getManager());
	}
	@Override
	public BranchModel readByName(String name) {
		
		Branch branch= branchService.readByName(name);
		List<EmployeeModel> employees = new ArrayList<>();
		for (Employee emp : branch.getEmployees()) {
			employees.add(new EmployeeModel(emp));
		}
		
		return new BranchModel(branch.getId(),branch.getName(),branch.getAddress(),branch.getParrentBranch(),employees,branch.getManager());
	}

}
