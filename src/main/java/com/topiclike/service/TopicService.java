package com.topiclike.service;

import java.util.List;

import com.topiclike.model.Topic;

public interface TopicService {
	public void incrementTopic(String topicName);
	
	public void decrementTopic(String topicName);
	
	public Topic createTopic(String topicName);
	
	public List<Topic> getTopListTopic(int limit);
	
	
}
