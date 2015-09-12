package eu.unicorneducation.dao;

import java.util.List;

import eu.unicorneducation.entity.Branch;

public interface BranchDAO {
	public boolean create(Branch branch);

	public boolean createAll(List<Branch> branches);

	public Branch read(String id);

	public boolean delete(Branch branch);

	public List<Branch> readAll();

	public void modify(Branch branch);
}
