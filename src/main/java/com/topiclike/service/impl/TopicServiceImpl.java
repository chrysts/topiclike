package com.topiclike.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.topiclike.data.structure.TopListTopic;
import com.topiclike.model.Topic;
import com.topiclike.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService{
	
	private static TopListTopic topicList = new TopListTopic();
	
	public List<Topic> getTopListTopic(int limit){
		return topicList.getTopics(limit);
	}

	@Override
	public void incrementTopic(String topicName) {
		topicList.incrementLike(topicName);
	}

	@Override
	public void decrementTopic(String topicName) {
		topicList.decrementLike(topicName);
	}

	@Override
	public Topic createTopic(String topicName) {
		return topicList.createTopic(topicName);
	}

}
