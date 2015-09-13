package eu.unicorneducation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.unicorneducation.dao.BranchDAO;
import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.service.BranchService;

@Component
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchDAO branchDAO;
	@Override
	public List<Branch> readAll() {
		return branchDAO.readAll();
		
	}
	@Override
	public Branch read(String id) {
		
		return branchDAO.read(id);
	}
	@Override
	public Branch readByName(String name) {
		
		return branchDAO.readByName(name);
	}
	

}
