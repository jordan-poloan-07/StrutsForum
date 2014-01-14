package forum.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

import forum.beans.User;
import forum.persistence.UserPersistence;

public class LoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 9121122010923086810L;

	private User user;
	private String message;
	private boolean successful;

	private Map<String, Object> session;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@SkipValidation
	public String form() {
		return INPUT;
	}

	public String submit() {

		// validation
		
		if (getUser().getUsername().trim().length() == 0) {
			setMessage("Username is required");
			return ERROR;
		}

		if (getUser().getPassword().trim().length() == 0) {
			setMessage("Password is required");
			return ERROR;
		}

		//data sending
		UserPersistence up = new UserPersistence();
		User inputUser = up.verifyUser(user);

		if (inputUser == null) {
			setMessage("Invalid username or password");
			setSuccessful(false);
			return ERROR;
		} else {
			setMessage("Login successful");
			setSuccessful(true);
			session.put("user", inputUser);
			return SUCCESS;
		}

	}

}
