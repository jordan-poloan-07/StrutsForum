package forum.persistence;

import java.util.List;

import org.hibernate.Query;

import forum.beans.TopicCategory;

public class CategoryPersistence {

	public List<TopicCategory> getTopicCategories() {

		List<TopicCategory> categories = null;

		Query q = SessionManager.beginTransaction().createQuery(
				"from TopicCategory");

		categories = q.list();

		return categories;
	}

	public TopicCategory getTopicCategory(int categoryId) {
		TopicCategory category = null;

		Query q = SessionManager.beginTransaction().createQuery(
				"from TopicCategory as tc where tc.t_cat_id=:t_cat_id");
		q.setParameter("t_cat_id", categoryId);

		category = (TopicCategory) q.uniqueResult();

		return category;
	}

}
