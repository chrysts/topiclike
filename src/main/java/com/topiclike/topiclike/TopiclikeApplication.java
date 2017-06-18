package com.topiclike.topiclike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com.topiclike")
public class TopiclikeApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(TopiclikeApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TopiclikeApplication.class);
	}
	
	  @Bean
	  public RestTemplate restTemplate() {
	    return new RestTemplate();
	  }
}
