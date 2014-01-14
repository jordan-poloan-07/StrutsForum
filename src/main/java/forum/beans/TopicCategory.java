package forum.beans;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

import forum.persistence.TopicPersistence;

public class TopicCategory implements Serializable {

	private static final long serialVersionUID = -4570185790194763486L;

	private Integer t_cat_id;
	private String t_cat_name;
	private String t_cat_desc;
	private Set<Topic> topics;

	public Integer getT_cat_id() {
		return t_cat_id;
	}

	public void setT_cat_id(Integer t_cat_id) {
		this.t_cat_id = t_cat_id;
	}

	public String getT_cat_name() {
		return t_cat_name;
	}

	public void setT_cat_name(String t_cat_name) {
		this.t_cat_name = t_cat_name;
	}

	public String getT_cat_desc() {
		return t_cat_desc;
	}

	public void setT_cat_desc(String t_cat_desc) {
		this.t_cat_desc = t_cat_desc;
	}

	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TopicCategory) {
			TopicCategory tCat = (TopicCategory) obj;
			EqualsBuilder eqb = new EqualsBuilder();
			eqb.append(this.t_cat_id, tCat.t_cat_id)
					.append(this.t_cat_name, tCat.t_cat_name)
					.append(this.t_cat_desc, tCat.t_cat_desc);
			return eqb.isEquals();
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hsb = new HashCodeBuilder();
		hsb.append(this.t_cat_id).append(this.t_cat_name)
				.append(this.t_cat_desc);
		return hsb.toHashCode();
	}

	/**
	 * public void getReplies(int startIndex) { // this would replace topics if
	 * necessary for topic pagination TopicPersistence tp = new
	 * TopicPersistence(); tp.getPaginatedTopics(this.t_cat_id, startIndex); }
	 **/
}
