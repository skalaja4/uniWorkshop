package eu.unicorneducation.model;

import java.util.List;

public class BranchModel {

	private String id;
	private String name;
	private String address;
	private String parrentBranch;
	private List<EmployeeModel> employees;
	private EmployeeModel manager;

	

	public BranchModel(String id, String name, String address,
			String parrentBranch, List<EmployeeModel> employees,
			EmployeeModel manager) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.parrentBranch = parrentBranch;
		this.employees = employees;
		this.manager = manager;
	}

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

	public EmployeeModel getManager() {
		return manager;
	}

	public void setManager(EmployeeModel manager) {
		this.manager = manager;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((parrentBranch == null) ? 0 : parrentBranch.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BranchModel other = (BranchModel) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parrentBranch == null) {
			if (other.parrentBranch != null)
				return false;
		} else if (!parrentBranch.equals(other.parrentBranch))
			return false;
		return true;
	}
	
	
}
