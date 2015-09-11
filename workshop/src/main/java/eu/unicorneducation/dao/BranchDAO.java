package eu.unicorneducation.dao;

import java.util.List;

import eu.unicorneducation.entity.Branch;

public interface BranchDAO {
public boolean create(Branch branch);
public Branch read(String id);
public boolean updeat(Branch branch);
public boolean delete(Branch branch);
public List<Branch> readAll();
}
