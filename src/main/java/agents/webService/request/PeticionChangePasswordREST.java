package agents.webService.request;

public class PeticionChangePasswordREST {

	private String username;
	private String password;
	private String newPassword;
	
	public PeticionChangePasswordREST() {

	}

	public PeticionChangePasswordREST(String username, String password, String newPassword) {
		super();
		this.password = password;
		this.newPassword = newPassword;
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getNewPassword() {
		return newPassword;
	}

}
