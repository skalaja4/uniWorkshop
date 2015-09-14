package eu.unicorneducation.model.transformation;

import java.util.ArrayList;
import java.util.List;

import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.model.BranchModel;

public class BranchTransformation {
	
	public static BranchModel transToModel(Branch branch) {
		BranchModel model = new BranchModel(branch.getId(), branch.getName(),
				branch.getAddress(), branch.getParrentBranch(),
				EmployeeTransformation.transToModelList(branch.getEmployees()),
				EmployeeTransformation.transToModel(branch.getManager()));
		return model;
	}
	
	public static Branch transToEntity(BranchModel model){
		Branch branch = new Branch(model.getId(), model.getName(),
				model.getAddress(), model.getParrentBranch(),
				EmployeeTransformation.transToEntity(model.getManager()),
				EmployeeTransformation.transToEntityList(model.getEmployees()));
		return branch;		
	}
	
	public static List<BranchModel> transToModelList(List<Branch> list) {
		List<BranchModel> modelList = new ArrayList<BranchModel>();
		for (Branch branch : list) {
			modelList.add(transToModel(branch));
		}
		return modelList;
	}

	public static List<Branch> transToEntityList(List<BranchModel> list) {
		List<Branch> branchList = new ArrayList<Branch>();
		for (BranchModel model : list) {
			branchList.add(transToEntity(model));
		}
		return branchList;
	}
}
