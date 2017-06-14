package com.topiclike.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.topiclike.data.structure.TopListTopic;
import com.topiclike.model.Topic;
import com.topiclike.service.TopicService;

public class TopicServiceImpl implements TopicService{
	
	public static TopListTopic topicList = new TopListTopic();
	private final static int NUM_MAX_LIST_TOPIC = 20;
	
	public List<Topic> getTopListTopic(int limit){
		List<Topic> topTopics = new ArrayList<>();
		Topic head = topicList.getJ
		do{
			
		}while()
		return topTopics;
	}

	@Override
	public void incrementTopic(String topicName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decrementTopic(String topicName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Topic createTopic(String topicName) {
		// TODO Auto-generated method stub
		
	}

}
