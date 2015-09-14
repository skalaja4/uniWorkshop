package eu.unicorneducation.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.unicorneducation.facade.BranchFacade;
import eu.unicorneducation.model.BranchModel;
import eu.unicorneducation.model.transformation.BranchTransformation;
import eu.unicorneducation.service.BranchService;

@Component
public class BranchFacadeImpl implements BranchFacade {

	@Autowired
	BranchService branchService;

	@Override
	public List<BranchModel> readAll() {
		return BranchTransformation.transToModelList(branchService.readAll());
	}

	@Override
	public BranchModel read(String id) {
		return BranchTransformation.transToModel(branchService.read(id));
	}

	@Override
	public BranchModel readByName(String name) {
		return BranchTransformation.transToModel(branchService.readByName(name));		
	}

}
