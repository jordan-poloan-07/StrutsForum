package forum.actions;

import com.opensymphony.xwork2.ActionSupport;

import forum.beans.Topic;
import forum.beans.TopicCategory;
import forum.persistence.CategoryPersistence;
import forum.utilities.Utility;

public class CategoryAction extends ActionSupport{

	private static final long serialVersionUID = 8229451239638271410L;

	private int categoryId;

	private TopicCategory topicCategory;

	public String showTopics() {

		CategoryPersistence cp = new CategoryPersistence();

		topicCategory = cp.getTopicCategory(categoryId);

		Utility u = new Utility();

		for (Topic topic : topicCategory.getTopics()) {

			u.profilePicChecker(topic.getUser());

		}

		// for pagination

		return SUCCESS;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public TopicCategory getTopicCategory() {
		return topicCategory;
	}

	public void setTopicCategory(TopicCategory topicCategory) {
		this.topicCategory = topicCategory;
	}

}
