package forum.beans;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 2381833072050972897L;

	private Integer user_id;
	private String username;
	private String email;
	private String password;
	private UsersInfo usersInfo;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public UsersInfo getUsersInfo() {
		return usersInfo;
	}

	public void setUsersInfo(UsersInfo usersInfo) {
		this.usersInfo = usersInfo;
	}

}
