package eu.unicorneducation.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="EMPLOYEE")
public  class Employee {
	
	
	@Id
	private String id;
	
	private String  firstName ;
	
	private String lastName;
	
	private Date birthDate;
	
	
	@ManyToOne
	private EvaluationPlan plan;
	
	
	@OneToMany(mappedBy="employee")
	private List<Evaluation> evaluation;
	
	
	@ManyToOne
	private Branch branch;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	public Employee() {
		
	}

	public Employee(String id, String firstName, String lastName,
			Date birthDate, Branch branch, Category category) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.branch = branch;
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public EvaluationPlan getPlan() {
		return plan;
	}

	public void setPlan(EvaluationPlan plan) {
		this.plan = plan;
	}

	public List<Evaluation> getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(List<Evaluation> evaluation) {
		this.evaluation = evaluation;
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	

}
