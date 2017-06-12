package com.topiclike.topiclike.controller;

import org.springframework.stereotype.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class TopicLikeController {

	@GetMapping(value = "/increment", produces = MediaType.APPLICATION_JSON_VALUE)
	  public String increment() {
	    return "";
	  }

	  @GetMapping(value = "/decrement", produces = MediaType.APPLICATION_JSON_VALUE)
	  public String decrement(){
	    return "";
	  }
	  
	  @PostMapping(value = "/topic/new", produces = MediaType.APPLICATION_JSON_VALUE)
	  public String createTopic(@RequestParam String topic){
	    return "";
	  }
}
