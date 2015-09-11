package eu.unicorneducation.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class EvaluationPlan {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="sequence1")
	@SequenceGenerator(name="sequence1", sequenceName="evaluation_plan_sequence", allocationSize=1)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private Date expiration;
	
	@ManyToOne
	private Branch branch;
	
	@OneToMany(mappedBy="plan")
	List<Employee> employees;
	
	public EvaluationPlan() {}

	public EvaluationPlan(String name, Date expiration, Branch branch,
			List<Employee> employees) {
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

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	
}
