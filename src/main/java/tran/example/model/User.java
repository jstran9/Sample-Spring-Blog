package tran.example.model;

import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * This class will help with when a user is attempting to be created.
 * @author Todd
 */
public class User {
	
	/* 
	 * for now this class will be separate from the CustomuUser class which is used to help with authentication when a user attempts to log in.
	 * note: in the future I may combine the classes, for now (and for convenience) iIwill separate them
	 */
	// by default these fields are all empty.
	private String userName = "";
	private String password = "";
	private String validatePassword = "";
	private Boolean enabled;
	private String userRole;
	
	private String message = "";

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String password, String validatePassword) {
		this.password = password;
		this.validatePassword = validatePassword;
	}
	
	public User(String userName, String password, String validatePassword) {
		super();
		this.userName = userName;
		this.password = password;
		this.validatePassword = validatePassword;
	}
	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public String encryptUserPassword() {
		return BCrypt.hashpw(this.password, BCrypt.gensalt(14));
	}
	
	public boolean validate() {
		String userNameRegex = "^[a-z0-9_-]{6,35}$";
		String passwordRegex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%])(?!.*\\s).{6,20})";
		
		if(!userName.matches(userNameRegex)) {
			message = "The user name must be at least 6 characters long and up to 35 characters.\nOnly lower case letters, numbers, an underscore , or hyphen are allowed!";
			return false;
		}
		
		if(!password.matches(passwordRegex)) {
			message = "The password must have at least one number, one lower and upper case letter, and one of the special symbols: '@', '#', '$', '%'.\nThe length must be between 6 to 20 characters.";
			return false;
		}
		if(!password.equals(validatePassword)) {
			message = "The entered passwords must match, try again!";
			return false;
		}
				
		return true;
	}

	public boolean validatePasswords() {
		String passwordRegex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%])(?!.*\\s).{6,20})";
		
		if(!password.matches(passwordRegex)) {
			message = "The password must have at least one number, one lower and upper case letter, and one of the special symbols: '@', '#', '$', '%'.\nThe length must be between 6 to 20 characters.";
			return false;
		}
		if(!password.equals(validatePassword)) {
			message = "The entered passwords must match, try again!";
			return false;
		}
				
		return true;
	}
}
