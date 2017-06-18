package com.topiclike.model;

import java.io.Serializable;
import java.util.Date;

public class Topic  {

	
	private String topicName;
	private long vote;
	private long increment;
	private long decrement;
	// linked to another topic :

	
	private Date createdDate;

	public Topic(){
		this.topicName = "";
		this.vote = 0;
		this.increment = 0;
		this.decrement = 0;
		
	}
	
	public Topic(String topicName, int vote, int increment, int decrement){
		this.topicName = topicName;
		this.vote = vote;
		this.increment = increment;
		this.decrement = decrement;
		
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
	public long getDecrement() {
		return decrement;
	}

	public void setDecrement(long decrement) {
		this.decrement = decrement;
	}

	public long getIncrement() {
		return increment;
	}

	public void setIncrement(long increment) {
		this.increment = increment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + (int) (decrement ^ (decrement >>> 32));
		result = prime * result + (int) (increment ^ (increment >>> 32));
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
		if (decrement != other.decrement)
			return false;
		if (increment != other.increment)
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
