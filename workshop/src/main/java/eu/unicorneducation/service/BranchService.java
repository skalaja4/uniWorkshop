package eu.unicorneducation.service;

import java.util.List;

import eu.unicorneducation.entity.Branch;

public interface BranchService {
	List<Branch> readAll();
	Branch read(String id);
	Branch readByName(String name);
}
