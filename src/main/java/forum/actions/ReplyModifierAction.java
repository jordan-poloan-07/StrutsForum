package forum.actions;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import forum.beans.Reply;
import forum.beans.User;
import forum.persistence.ReplyPersistence;
import forum.persistence.TopicPersistence;
import forum.persistence.UserPersistence;

public class ReplyModifierAction implements SessionAware {

	private Integer param;
	private Reply reply;

	private Map<String, Object> session;

	public String addReplyInput() {
		return ActionSupport.INPUT;
	}

	public String addReply() {

		UserPersistence up = new UserPersistence();
		TopicPersistence tp = new TopicPersistence();
		ReplyPersistence rp = new ReplyPersistence();

		User user = (User) session.get("user");

		reply.setUser(user);
		reply.setTopic(tp.getTopic(param));
		reply.setT_reply_date(new Date(System.currentTimeMillis()));

		rp.addReply(reply);

		// if no exceptions occur below statements will be done
		up.updateUserReplyCount(user);
		return "inputSuccess";
	}

	public String editInput() {
		reply = new ReplyPersistence().getReply(param);
		// TODO add to properties
		// store the unedit reply to session
		session.put("saveReply", reply);
		return "editInput";
	}

	public String edit() {
		// TODO add to properties

		// if user proceeds
		((Reply) session.get("saveReply")).setT_reply_content(reply
				.getT_reply_content());

		ReplyPersistence rp = new ReplyPersistence();
		rp.editReply((Reply) session.get("saveReply"));
		
		// delete in session
		session.remove("saveReply");
		
		return "editSuccess";
	}

	public String delete() {
		ReplyPersistence rp = new ReplyPersistence();

		reply = rp.getReply(param);

		rp.deleteReply(reply);

		return "deleteSuccess";
	}

	public Integer getParam() {
		return param;
	}

	public void setParam(Integer param) {
		this.param = param;
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

}
