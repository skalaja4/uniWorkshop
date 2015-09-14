package eu.unicorneducation.model;

import java.util.Date;
import java.util.List;

import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.entity.Employee;

public class EvaluationPlanModel {

	private Long id;
	private String name;
	private Date expiration;
	private BranchModel branch;
	List<EmployeeModel> employees;
	
	public EvaluationPlanModel( String name, Date expiration, BranchModel branch,
			List<EmployeeModel> employees) {
		super();
		
		this.name = name;
		this.expiration = expiration;
		this.branch = branch;
		this.employees = employees;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getExpiration() {
		return expiration;
	}
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	public BranchModel getBranch() {
		return branch;
	}
	public void setBranch(BranchModel branch) {
		this.branch = branch;
	}
	public List<EmployeeModel> getEmployees() {
		return employees;
	}
	public void setEmployees(List<EmployeeModel> employees) {
		this.employees = employees;
	}
}
