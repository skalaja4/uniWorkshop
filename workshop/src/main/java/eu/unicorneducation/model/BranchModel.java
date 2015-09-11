package eu.unicorneducation.model;

import java.util.List;

public class BranchModel {
	
	private String id;
	private String name;
	private String address;
	private String parrentBranch;
	private List<EmployeeModel> employees;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getParrentBranch() {
		return parrentBranch;
	}
	public void setParrentBranch(String parrentBranch) {
		this.parrentBranch = parrentBranch;
	}
	public List<EmployeeModel> getEmployees() {
		return employees;
	}
	public void setEmployees(List<EmployeeModel> employees) {
		this.employees = employees;
	}
}