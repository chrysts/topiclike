package com.topiclike.topiclike;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.topiclike.data.structure.TopListTopic;
import com.topiclike.model.Topic;

public class TopListTopicTest {

	private TopListTopic topListTopic = new TopListTopic();
	Map<String, Topic> mapTopic = new HashMap<>();
	
	public class Task implements Runnable {

		   private volatile boolean isRunning = true;
		   private TopListTopic  topListTopic = new TopListTopic();
		   private boolean inc = false;
		   private String topicName;
		   
		   public Task(TopListTopic topListTopic, boolean inc, String topicName){
			   this.topListTopic = topListTopic;
			   this.inc = inc;
			   this.topicName = topicName;
		   }

		   public void run() {
			   if(!inc)
				   topListTopic.decrementLike(topicName);
			   else 
				   topListTopic.incrementLike(topicName);
		   }

		   public void kill() {
		       isRunning = false;
		   }

		}
	
	@Test
	public void testConcurrent(){
		Topic topic = new Topic();
		topic.setTopicName("test-1");
		topic.setVote(11);
		mapTopic.put("test-1", topic);
		
		Topic topic2 = new Topic();
		topic2.setTopicName("test-2");
		topic2.setVote(11);
		mapTopic.put("test-2", topic2);
		
		topic2.setPrevTopic(topic);
		topic.setNextTopic(topic2);
		
		topListTopic.setTopicHead(topic);
		topListTopic.setTopicTail(topic);
		topListTopic.setMapTopic(mapTopic);
		
		Task task1 = new Task(topListTopic, true, "test-2"); //inc
		Task task2 = new Task(topListTopic, true, "test-1"); //dec
		task1.run();
		task2.run();
		task2.run();
	}
}
