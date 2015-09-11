package eu.unicorneducation.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="EVALUATION")
public class Evaluation {
	
	private Long id;
	private String name;
	private Date fill_date;

	
	
		
}
