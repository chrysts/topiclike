package com.topiclike.model;

import java.util.Date;

public class Topic {

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
	
	
}
