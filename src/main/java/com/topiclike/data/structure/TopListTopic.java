package com.topiclike.data.structure;

import java.util.HashMap;
import java.util.Map;

import com.topiclike.model.Topic;

public class TopListTopic {

	
	private final static int ZERO_VOTE = 0;
	private Topic topicHead ;
	private Topic topicTail ;
	Map<String, Topic> mapTopic = new HashMap<>();
	
	public TopListTopic(){
		topicHead = null;
		topicTail = null;
	}
	
	public synchronized void incrementLike(String topicName){
		Topic topic = mapTopic.get(topicName);
		topic.setVote(topic.getVote() + 1);
		updateOrderListIncrement(topic);
	}
	
	public synchronized void decrementLike(String topicName){
		Topic topic = mapTopic.get(topicName);
		topic.setVote(topic.getVote() - 1);
		updateOrderListDecrement(topic);
	}
	
	public synchronized void createTopic(String topicName){
		Topic topic = new Topic(topicName, ZERO_VOTE);
		topicTail.setNextTopic(topic);
		topic.setPrevTopic(topicTail);
		topicTail = topic;
		if(null == topicHead){
			topicHead = topic;
		}
		mapTopic.put(topicName, topic);
	}
	
	private void updateOrderListIncrement(Topic topic){
		Topic higherOrderTopic = topic.getPrevTopic(); 
		if(higherOrderTopic != null && higherOrderTopic.getVote() < topic.getVote()){
			shiftTopic(higherOrderTopic, topic);
		}
	}
	
	private void updateOrderListDecrement(Topic topic){
		Topic lowerOrderTopic = topic.getNextTopic(); 
		if(lowerOrderTopic != null && lowerOrderTopic.getVote() > topic.getVote()){
			shiftTopic(topic, lowerOrderTopic);
		}
	}
	
	public void shiftTopic(Topic firstTopic, Topic secondTopic){
		secondTopic.setPrevTopic(firstTopic.getPrevTopic());
		firstTopic.setNextTopic(secondTopic.getNextTopic());
		firstTopic.setPrevTopic(secondTopic);
		secondTopic.setNextTopic(firstTopic);
	}
	
	public void setTopicHead(Topic topicHead){
		this.topicHead = topicHead;
	}
	
	public void setTopicTail(Topic topicTail){
		this.topicTail = topicTail;
	}
	
}
