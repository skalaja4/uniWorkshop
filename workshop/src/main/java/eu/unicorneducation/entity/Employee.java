package eu.unicorneducation.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public  class Employee {
	
	
	@Id
	@GeneratedValue
	private String id;
	
	private String  firstName ;
	
	private String lastName;
	
	private Date birthDate;
	
	
	@OneToMany
	private Branch branch;
	
	@Enumerated(EnumType.STRING)
	private Category kind;
	
	
	
	
	

	
	
	
	
	
	
	
	

}
