package com.topiclike.topiclike.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.topiclike.model.Topic;
import com.topiclike.request.TopicRequest;
import com.topiclike.service.TopicService;


@RestController
@RequestMapping(value = "api/topic")
public class TopicLikeController {
	private static final String NUM_MAX_LIST_TOPIC = "20";
	
	@Autowired
	private TopicService topicService;

	  @PostMapping(value = "/increment", produces = MediaType.APPLICATION_JSON_VALUE)
	  public void increment(@RequestBody TopicRequest topicReq) {
		topicService.incrementTopic(topicReq.getTopicName());
	  }

	  @PostMapping(value = "/decrement", produces = MediaType.APPLICATION_JSON_VALUE)
	  public void decrement(@RequestBody TopicRequest topicReq){
	    topicService.decrementTopic(topicReq.getTopicName());
	  }
	  
	  @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	  public Topic createTopic(@RequestBody TopicRequest topicReq){
	    return topicService.createTopic(topicReq.getTopicName());
	  }
	  
	  @GetMapping(value= "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	  public List<Topic> getTopics(@RequestParam(defaultValue=NUM_MAX_LIST_TOPIC) Integer limit){
		  return topicService.getTopListTopic(limit);
	  }
	  
	  @GetMapping(value= "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	  public String getTest(){
		  return "{\"success\":true}";
	  }
}
