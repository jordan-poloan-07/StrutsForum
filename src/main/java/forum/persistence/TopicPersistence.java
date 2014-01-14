package forum.persistence;

import java.util.List;

import org.hibernate.Query;

import forum.beans.Topic;

public class TopicPersistence {

	public List<Topic> getTopics(int categoryId) {

		// TODO add to managedQuery

		List<Topic> topics = null;

		Query q = SessionManager.beginTransaction().createQuery(
				"from Topic as t where t.t_cat_id=:t_cat_id");
		q.setParameter("t_cat_id", categoryId);

		topics = q.list();

		SessionManager.commitTransaction();

		return topics;
	}

	public List<Topic> getPaginatedTopics(int categoryId, int startIndex) {

		// TODO add to managedQuery

		List<Topic> paginatedTopics = null;

		Query q = SessionManager.beginTransaction().createQuery(
				"from Topic as t where t.t_cat_id=:t_cat_id");
		q.setParameter("t_cat_id", categoryId);

		// TODO add to Properties
		q.setFirstResult(startIndex);
		q.setMaxResults(10);

		paginatedTopics = q.list();

		return paginatedTopics;
	}

	public void addTopic(Topic topic) {

		SessionManager.beginTransaction().save(topic);

		SessionManager.commitTransaction();

	}

	public void editTopic(Topic topic) {

		SessionManager.beginTransaction().update(topic);

		SessionManager.commitTransaction();

	}

	public void deleteTopic(Topic topic) {

		SessionManager.beginTransaction().delete(topic);

		SessionManager.commitTransaction();
	}

	public Topic getTopic(Integer topicId) {

		// TODO add to managedQuery

		Topic topic = null;

		Query q = SessionManager.beginTransaction().createQuery(
				"from Topic as t where t.t_id=:t_id ");

		q.setParameter("t_id", topicId);

		topic = (Topic) q.uniqueResult();

		SessionManager.commitTransaction();

		return topic;
	}
}
