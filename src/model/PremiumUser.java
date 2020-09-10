package model;


public class PremiumUser implements User {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Boolean isPremium;
	private String premiumTier;
	
	private String fullName;
	
	public PremiumUser() {
		
	}
	
	

	public PremiumUser(String firstName, String lastName, String email, String password, Boolean isPremium,
			String premiumTier) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.isPremium = isPremium;
		this.premiumTier = premiumTier;
	}



	public Boolean getIsPremium() {
		return isPremium;
	}



	public void setIsPremium(Boolean isPremium) {
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

	public String getPremiumTier() {
		return premiumTier;
	}

	public void setPremiumTier(String premiumTier) {
		this.premiumTier = premiumTier;
	}

	public String getFullName() {
		this.fullName = this.firstName + " " + this.lastName;
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public void process() {
		getFullName();

	}

}
