package eu.unicorneducation.entity;

public class Branch {

	
	private Long id;
	
	private String name;
	
	private String address;
	
	private Long parrentBranch;

	
	public Branch(Long id, String name, String address, Long parrentBranch) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.parrentBranch = parrentBranch;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getParrentBranch() {
		return parrentBranch;
	}

	public void setParrentBranch(Long parrentBranch) {
		this.parrentBranch = parrentBranch;
	}
	
	
	
	
	
}
