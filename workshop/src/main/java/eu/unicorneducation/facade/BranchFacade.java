package eu.unicorneducation.facade;

import java.util.List;

import eu.unicorneducation.model.BranchModel;

public interface BranchFacade {

	List<BranchModel> readAll();
	BranchModel read(String id);
	BranchModel readByName(String name);
}
