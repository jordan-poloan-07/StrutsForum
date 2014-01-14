package forum.actions;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

import forum.beans.User;
import forum.persistence.UserPersistence;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 6959844238889365355L;

	private User user;
	private String cpassword;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	@SkipValidation
	public String form() {
		return INPUT;
	}

	public String submit() {

		UserPersistence up = new UserPersistence();
		up.registerUser(user);

		return SUCCESS;
	}

	@Override
	public void validate() {
		if (getUser().getUsername().trim().length() == 0) {
			addFieldError("user.username", "Username cannot be null");
		} // username regex checking

		if (getUser().getEmail().trim().length() == 0) {
			addFieldError("user.email", "Email cannot be null");
		} // email regexchecking

		if (getUser().getPassword().trim().length() == 0) {
			addFieldError("user.password", "Password cannot be null");
		} // password regexchecking

		if (getCpassword().trim().length() == 0) {
			addFieldError("cpassword", "Confirmation password cannot be null");
		} // // cpassword regexchecking

		if (!getUser().getPassword().equals(getCpassword())) {
			addFieldError("user.password",
					"Password and confirmation password did not match");
		}
	}
}
