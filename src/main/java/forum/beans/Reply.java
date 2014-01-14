package forum.beans;

import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

public class Reply {

	private Integer t_reply_id;
	private Topic topic;
	private User user;
	private String t_reply_content;
	private Date t_reply_date;

	public Integer getT_reply_id() {
		return t_reply_id;
	}

	public void setT_reply_id(Integer t_reply_id) {
		this.t_reply_id = t_reply_id;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getT_reply_content() {
		return t_reply_content;
	}

	public void setT_reply_content(String t_reply_content) {
		this.t_reply_content = t_reply_content;
	}

	public Date getT_reply_date() {
		return t_reply_date;
	}

	public void setT_reply_date(Date t_reply_date) {
		this.t_reply_date = t_reply_date;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Reply) {
			Reply reply = (Reply) obj;
			EqualsBuilder eqb = new EqualsBuilder();
			eqb.append(this.t_reply_id, reply.t_reply_id)
					.append(this.t_reply_date, reply.t_reply_date)
					.append(this.t_reply_content, reply.t_reply_content);
			return eqb.isEquals();
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hsb = new HashCodeBuilder();
		hsb.append(this.t_reply_id).append(this.t_reply_date)
				.append(this.t_reply_content);
		return hsb.toHashCode();
	}

}
