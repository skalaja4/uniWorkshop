package eu.unicorneducation.entity;

import java.util.Date;

public class Manager extends Employee {

	
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private Date birthDate;
	
	private BaPoCategory kind;
	
	private Long branch;

	public Manager(Long id, String firstName, String lastName, Date birthDate,
			BaPoCategory kind, Long branch) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.kind = kind;
		this.branch = branch;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public BaPoCategory getKind() {
		return kind;
	}

	public void setKind(BaPoCategory kind) {
		this.kind = kind;
	}

	public Long getBranch() {
		return branch;
	}

	public void setBranch(Long branch) {
		this.branch = branch;
	}
	
	
	
	
	
}
