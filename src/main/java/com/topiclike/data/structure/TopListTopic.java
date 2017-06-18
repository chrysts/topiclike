package com.topiclike.data.structure;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.topiclike.model.Topic;

public class TopListTopic {

	
	private final static int ZERO_VOTE = 0;
	private Node topicHead ;
	private Node topicTail ;
	Map<String, Node> mapTopic = new HashMap<>();
	
	private class Node{
		Topic topic;
		private Node next;
		private Node prev;
		
		public Node(Topic topic){
			next = null;
			prev = null;
			this.topic = topic;
		}
	}
	
	
	public TopListTopic(){
		topicHead = null;
		topicTail = null;
	}
	
	public synchronized void incrementLike(String topicName){
		Node currentNode = mapTopic.get(topicName);
		Topic topic = currentNode.topic;
		topic.setVote(topic.getVote() + 1);
		topic.setIncrement(topic.getIncrement() + 1);
		updateOrderListIncrement(currentNode);
		
	}
	
	public synchronized void decrementLike(String topicName){
		Node currentNode = mapTopic.get(topicName);
		Topic topic = currentNode.topic;
		topic.setVote(topic.getVote() - 1);
		topic.setDecrement(topic.getDecrement() + 1);
		
		
		
		updateOrderListDecrement(currentNode);
	
	}
	
	public synchronized Topic createTopic(String topicName){
		Topic topic = new Topic(topicName, ZERO_VOTE, ZERO_VOTE, ZERO_VOTE);
		topic.setCreatedDate(new Date());
		Node newNode = new Node(topic);
		if(null == topicHead){
			topicHead = newNode;
			topicTail = newNode;
			
		}else{
			topicTail.next = newNode;
			newNode.prev = topicTail;
			topicTail = newNode;
			
		}
		mapTopic.put(topicName, newNode);
		return topic;
	}
	
	public synchronized List<Topic> getTopics(int limit){
		List<Topic> topTopics = new ArrayList<>();
		Node cursor = topicHead;
		int sum = 0;
		while(cursor != null && sum++ < limit){
			topTopics.add(cursor.topic);
			cursor = cursor.next;
		}
		
		return topTopics;
	} 
	
	private void updateOrderListIncrement(Node currentNode){
		Node higherOrderTopic = currentNode.prev; 
		if(higherOrderTopic != null && higherOrderTopic.topic.getVote() < currentNode.topic.getVote()){
			shiftTopic(higherOrderTopic, currentNode);
		}
	}
	
	private void updateOrderListDecrement(Node currentNode){
		Node lowerOrderTopic = currentNode.next; 
		if(lowerOrderTopic != null && lowerOrderTopic.topic.getVote() > currentNode.topic.getVote()){
			shiftTopic(currentNode, lowerOrderTopic);
		}
	}
	
	public void shiftTopic(Node firstTopicNode, Node secondTopicNode){
		if(topicHead.topic == firstTopicNode.topic){
			topicHead = secondTopicNode;
		}
		if(topicTail.topic == secondTopicNode.topic){
			topicTail = firstTopicNode;
		}
		secondTopicNode.prev = firstTopicNode.prev;
		firstTopicNode.next = secondTopicNode.next;
		firstTopicNode.prev = secondTopicNode;
		secondTopicNode.next = firstTopicNode;
	}
	
	public void setTopicHead(Node topicHead){
		this.topicHead = topicHead;
	}
	
	public void setTopicTail(Node topicTail){
		this.topicTail = topicTail;
	}
	
	public Node getTopicHead(){
		return topicHead;
	}
	
	public Node getTopicTail(){
		return topicTail;
	}
	
	public Map<String, Node> getMapTopic() {
		return mapTopic;
	}

	public void setMapTopic(Map<String, Node> mapTopic) {
		this.mapTopic = mapTopic;
	}
}
