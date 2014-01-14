package forum.beans;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

import forum.persistence.ReplyPersistence;

public class Topic {

	private Integer t_id;
	private Integer t_cat_id;
	private User user;
	private String t_title;
	private String t_desc;
	private Date t_date;
	private Set<Reply> topicreply = new TreeSet<Reply>();

	public Integer getT_id() {
		return t_id;
	}

	public void setT_id(Integer t_id) {
		this.t_id = t_id;
	}

	public Integer getT_cat_id() {
		return t_cat_id;
	}

	public void setT_cat_id(Integer t_cat_id) {
		this.t_cat_id = t_cat_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getT_title() {
		return t_title;
	}

	public void setT_title(String t_title) {
		this.t_title = t_title;
	}

	public String getT_desc() {
		return t_desc;
	}

	public void setT_desc(String t_desc) {
		this.t_desc = t_desc;
	}

	public Date getT_date() {
		return t_date;
	}

	public void setT_date(Date t_date) {
		this.t_date = t_date;
	}

	public Set<Reply> getTopicreply() {
		return topicreply;
	}

	public void setTopicreply(Set<Reply> topicreply) {
		this.topicreply = topicreply;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Topic) {
			Topic topic = (Topic) obj;
			EqualsBuilder eqb = new EqualsBuilder();
			eqb.append(this.t_id, topic.t_id).append(this.t_date, topic.t_date)
					.append(this.t_desc, topic.t_desc)
					.append(this.t_title, topic.t_title);
			return eqb.isEquals();
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hsb = new HashCodeBuilder();
		hsb.append(this.t_id).append(this.t_date).append(this.t_desc)
				.append(this.t_title);
		return hsb.toHashCode();
	}

	/**
	 * public void getReplies(int startIndex) { // this would replace topics if
	 * necessary for reply pagination ReplyPersistence rp = new
	 * ReplyPersistence(); rp.getPaginatedReplies(this.t_id, startIndex); }
	 **/
}
