package forum.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import forum.beans.TopicCategory;
import forum.beans.User;
import forum.persistence.CategoryPersistence;
import forum.utilities.Utility;

public class ForumAction implements SessionAware {

	private List<TopicCategory> categories;
	private User user;

	private Map<String, Object> session;

	public String home() {
		// TODO to properties
		user = (User) session.get("user");

		Utility u = new Utility();

		u.profilePicChecker(user);
		
		return "success";
	}

	public String categories() {
		CategoryPersistence cp = new CategoryPersistence();
		setCategories(cp.getTopicCategories());
		return "success";
	}

	public List<TopicCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<TopicCategory> categories) {
		this.categories = categories;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

}
