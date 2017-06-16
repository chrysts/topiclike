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
import com.topiclike.service.TopicService;


@RestController
@RequestMapping(value = "api/base")
public class TopicLikeController {
	private static final String NUM_MAX_LIST_TOPIC = "20";
	
	@Autowired
	private TopicService topicService;

	  @GetMapping(value = "/increment", produces = MediaType.APPLICATION_JSON_VALUE)
	  public void increment(@RequestParam String topicName) {
		topicService.incrementTopic(topicName);
	  }

	  @GetMapping(value = "/decrement", produces = MediaType.APPLICATION_JSON_VALUE)
	  public void decrement(@RequestParam String topicName){
	    topicService.decrementTopic(topicName);
	  }
	  
	  @PostMapping(value = "/topic/create", produces = MediaType.APPLICATION_JSON_VALUE)
	  public Topic createTopic(@RequestBody String topicName){
	    return topicService.createTopic(topicName);
	  }
	  
	  @GetMapping(value= "/topic/get", produces = MediaType.APPLICATION_JSON_VALUE)
	  public List<Topic> getTopics(@RequestParam(defaultValue=NUM_MAX_LIST_TOPIC) Integer limit){
		  return topicService.getTopListTopic(limit);
	  }
	  
	  @GetMapping(value= "/topic/test", produces = MediaType.APPLICATION_JSON_VALUE)
	  public String getTest(){
		  return "{\"success\":true}";
	  }
}
