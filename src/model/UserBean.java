package model;


public class UserBean implements User {
	
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Boolean isPremium;
	
	private String fullName;
	
	public UserBean(){
		
	}
	


	public UserBean(String firstName, String lastName, String email, String password, Boolean isPremium) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.isPremium = isPremium;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		this.fullName = this.firstName + " " + this.lastName;
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	

	public Boolean getIsPremium() {
		return isPremium;
	}



	public void setIsPremium(Boolean isPremium) {
		this.isPremium = isPremium;
	}



	@Override
	public void process() {
		getFullName();
	}
}
