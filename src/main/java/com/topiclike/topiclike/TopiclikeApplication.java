package com.topiclike.topiclike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
@ComponentScan("com.topiclike")
public class TopiclikeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopiclikeApplication.class, args);
	}
	
	  @Bean
	  public RestTemplate restTemplate() {
	    return new RestTemplate();
	  }
}
