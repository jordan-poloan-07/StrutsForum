package forum.persistence;

import java.util.List;

import org.hibernate.Query;

import forum.beans.Reply;

public class ReplyPersistence {

	public List<Reply> getReplies(int topicId) {

		List<Reply> replies;

		Query q = SessionManager.beginTransaction().createQuery(
				"from Reply as r where r.t_id=:t_id");
		q.setParameter("t_id", topicId);

		replies = q.list();

		return replies;
	}

	public List<Reply> getPaginatedReplies(int topicId, int startIndex) {

		List<Reply> replies;

		Query q = SessionManager.beginTransaction().createQuery(
				"from Reply as r where r.t_id=:t_id");
		q.setParameter("t_id", topicId);

		// TODO Add to properties
		q.setFirstResult(startIndex);
		q.setMaxResults(10);

		replies = q.list();

		return replies;
	}

	public Reply getReply(int replyId) {
		Reply reply = null;

		Query q = SessionManager.beginTransaction().createQuery(
				"from Reply as r where r.t_reply_id=:replyId");
		q.setParameter("replyId", replyId);

		reply = (Reply) q.uniqueResult();

		SessionManager.commitTransaction();

		return reply;
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
