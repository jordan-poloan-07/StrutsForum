package forum.persistence;

import java.util.List;

import org.hibernate.Query;

import forum.beans.TopicCategory;

public class CategoryPersistence {

	public List<TopicCategory> getTopicCategories() {

		Query q = SessionManager.beginTransaction().createQuery(
				"from TopicCategory");

		return q.list();
	}

	public TopicCategory getTopicCategory(int categoryId) {

		Query q = SessionManager.beginTransaction().createQuery(
				"from TopicCategory as tc where tc.t_cat_id=:t_cat_id");
		q.setParameter("t_cat_id", categoryId);

		return (TopicCategory) q.uniqueResult();
	}

}
