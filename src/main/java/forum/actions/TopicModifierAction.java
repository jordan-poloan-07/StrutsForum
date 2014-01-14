package forum.actions;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import forum.beans.Topic;
import forum.beans.User;
import forum.persistence.TopicPersistence;
import forum.persistence.UserPersistence;

public class TopicModifierAction implements SessionAware {

	private Integer param;
	private Topic topic;

	private Map<String, Object> session;

	private String message;
	private boolean successful;

	public String addTopicInput() {
		return ActionSupport.INPUT;
	}

	public String editInput() {

		TopicPersistence tp = new TopicPersistence();
		topic = tp.getTopic(param);

		// TODO add to properties
		// store the unedit topic to session
		session.put("saveTopic", topic);

		return "editInput";
	}

	public String deleteInput() {

		TopicPersistence tp = new TopicPersistence();
		topic = tp.getTopic(param);

		return "deleteInput";
	}

	public String addTopic() {

		TopicPersistence tp = new TopicPersistence();
		UserPersistence up = new UserPersistence();

		// TODO put to properties
		topic.setUser(((User) session.get("user")));
		topic.setT_cat_id(param);
		topic.setT_date(new Date(System.currentTimeMillis()));

		tp.addTopic(topic);
		// TODO put to properties
		up.updateUserTopicCount((User) session.get("user"));

		setMessage("Topic added");
		setSuccessful(true);

		return "inputSuccess";
	}

	public String edit() {
		// TODO add to properties

		// if user proceeds
		((Topic) session.get("saveTopic")).setT_title(topic.getT_title());
		((Topic) session.get("saveTopic")).setT_desc(topic.getT_desc());

		// delete in session

		TopicPersistence tp = new TopicPersistence();
		tp.editTopic((Topic) session.get("saveTopic"));

		session.remove("saveTopic");

		setMessage("Topic edited");
		setSuccessful(true);

		return "editSuccess";
	}

	public String delete() {
		TopicPersistence tp = new TopicPersistence();

		topic = tp.getTopic(param);

		tp.deleteTopic(topic);

		setMessage("Topic deleted");
		setSuccessful(true);

		return "deleteSuccess";
	}

	public Integer getParam() {
		return param;
	}

	public void setParam(Integer param) {
		this.param = param;
	}

	public Topic getTopic() {
		return topic;
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

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
