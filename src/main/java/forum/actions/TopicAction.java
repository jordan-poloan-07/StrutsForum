package forum.actions;

import com.opensymphony.xwork2.ActionSupport;

import forum.beans.Reply;
import forum.beans.Topic;
import forum.persistence.TopicPersistence;
import forum.utilities.Utility;

public class TopicAction extends ActionSupport {

	private static final long serialVersionUID = -4883957347404261508L;

	private int topicId;

	private Topic topic;

	public String showReplies() {

		TopicPersistence tp = new TopicPersistence();
		topic = tp.getTopic(topicId);

		Utility u = new Utility();

		// check topic poster's pic here
		u.profilePicChecker(topic.getUser());

		// check individual reply poster's pic here
		for (Reply reply : topic.getTopicreply()) {
			u.profilePicChecker(reply.getUser());
		}

		return SUCCESS;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
