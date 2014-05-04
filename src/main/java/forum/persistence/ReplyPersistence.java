package forum.persistence;

import java.util.List;

import org.hibernate.Query;

import forum.beans.Reply;

public class ReplyPersistence {

	public List<Reply> getReplies(int topicId) {

		Query q = SessionManager.beginTransaction().createQuery(
				"from Reply as r where r.t_id=:t_id");
		q.setParameter("t_id", topicId);

		return q.list();
	}

	public List<Reply> getPaginatedReplies(int topicId, int startIndex) {

		Query q = SessionManager.beginTransaction().createQuery(
				"from Reply as r where r.t_id=:t_id");
		q.setParameter("t_id", topicId);

		// TODO Add to properties
		q.setFirstResult(startIndex);
		q.setMaxResults(10);

		return q.list();
	}

	public Reply getReply(int replyId) {

		Query q = SessionManager.beginTransaction().createQuery(
				"from Reply as r where r.t_reply_id=:replyId");
		q.setParameter("replyId", replyId);

		return (Reply) q.uniqueResult();
	}

	public void addReply(Reply reply) {

		SessionManager.beginTransaction().save(reply);

		SessionManager.commitTransaction();
	}

	public void editReply(Reply reply) {
		SessionManager.beginTransaction().update(reply);

		SessionManager.commitTransaction();
	}

	public void deleteReply(Reply reply) {
		SessionManager.beginTransaction().delete(reply);

		SessionManager.commitTransaction();
	}
}
