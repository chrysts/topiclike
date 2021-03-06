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
	private Map<String, Node> mapTopic = new HashMap<>();
	
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
			newNode.prev = topicTail;
			topicTail.next = newNode;
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
		while(higherOrderTopic != null && higherOrderTopic.prev != null &&
				higherOrderTopic.prev.topic.getVote() < currentNode.topic.getVote()){
			higherOrderTopic = higherOrderTopic.prev;
		}
		if(higherOrderTopic != null && higherOrderTopic.topic.getVote() < currentNode.topic.getVote()){
			shiftTopic(higherOrderTopic, currentNode);
		}
	}
	
	private void updateOrderListDecrement(Node currentNode){
		Node lowerOrderTopic = currentNode.next; 
		while(lowerOrderTopic != null && lowerOrderTopic.next != null &&
				lowerOrderTopic.next.topic.getVote() > currentNode.topic.getVote()){
			lowerOrderTopic = lowerOrderTopic.next;
		}
		if(lowerOrderTopic != null && lowerOrderTopic.topic.getVote() > currentNode.topic.getVote()){
			shiftTopic(currentNode, lowerOrderTopic);
		}
	}
	
	public void shiftTopic(Node firstTopicNode, Node secondTopicNode){
		if(topicHead == firstTopicNode){
			topicHead = secondTopicNode;
		}
		if(topicTail == secondTopicNode){
			topicTail = firstTopicNode;
		}
		if(firstTopicNode.prev != null)
			firstTopicNode.prev.next = secondTopicNode;
		if(secondTopicNode.next != null)
			secondTopicNode.next.prev = firstTopicNode;
		Node firstNextTemp = firstTopicNode.next;
		Node secondPrevTemp = secondTopicNode.prev;
		
		
		secondTopicNode.prev = firstTopicNode.prev;
		firstTopicNode.next = secondTopicNode.next;
		if(firstNextTemp != secondTopicNode){
			firstTopicNode.prev = secondPrevTemp;
			secondTopicNode.next = firstNextTemp;
			firstNextTemp.prev = secondTopicNode;
			secondPrevTemp.next = firstTopicNode;
		}else{
			firstTopicNode.prev = secondTopicNode;
			secondTopicNode.next = firstTopicNode;
		}
		
		
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
