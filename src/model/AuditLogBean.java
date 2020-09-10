package model;



public class AuditLogBean implements AuditLog {

	private String user;
	private String action;
	private String description;
	private String date;
	
	public AuditLogBean() {
		
	}
	
	public AuditLogBean( String user, String action, String description, String date) {
		super();
		this.user = user;
		this.action = action;
		this.description = description;
		this.date = date;
	}


	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	public String getAction() {
		return action;
	}



	public void setAction(String action) {
		this.action = action;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	@Override
	public void process() {
		// TODO Auto-generated method stub

	}

}
