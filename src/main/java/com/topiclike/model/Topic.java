package com.topiclike.model;

import java.io.Serializable;
import java.util.Date;

public class Topic implements Serializable {

	private static final long serialVersionUID = -7165248560144267L;
	
	private String topicName;
	private long vote;
	// linked to another topic :
	private Topic nextTopic; 
	private Topic prevTopic;
	
	private Date createdDate;

	public Topic(){}
	
	public Topic(String topicName, int vote){
		this.topicName = topicName;
		this.vote = vote;
		nextTopic = null;
		prevTopic = null;
	}
	
	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public long getVote() {
		return vote;
	}

	public void setVote(long vote) {
		this.vote = vote;
	}

	public Topic getPrevTopic() {
		return prevTopic;
	}

	public void setPrevTopic(Topic prevTopic) {
		this.prevTopic = prevTopic;
	}

	public Topic getNextTopic() {
		return nextTopic;
	}

	public void setNextTopic(Topic nextTopic) {
		this.nextTopic = nextTopic;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result
				+ ((nextTopic == null) ? 0 : nextTopic.hashCode());
		result = prime * result
				+ ((prevTopic == null) ? 0 : prevTopic.hashCode());
		result = prime * result
				+ ((topicName == null) ? 0 : topicName.hashCode());
		result = prime * result + (int) (vote ^ (vote >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (nextTopic == null) {
			if (other.nextTopic != null)
				return false;
		} else if (!nextTopic.equals(other.nextTopic))
			return false;
		if (prevTopic == null) {
			if (other.prevTopic != null)
				return false;
		} else if (!prevTopic.equals(other.prevTopic))
			return false;
		if (topicName == null) {
			if (other.topicName != null)
				return false;
		} else if (!topicName.equals(other.topicName))
			return false;
		if (vote != other.vote)
			return false;
		return true;
	}
	
	
}
