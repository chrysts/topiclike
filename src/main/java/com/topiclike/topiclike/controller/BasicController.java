package com.topiclike.topiclike.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BasicController {

	@RequestMapping("/")
	public ModelAndView home(Map<String, Object> model, HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("index");
		modelView.addObject("applicationBasePathLocation", req.getLocalAddr());
		return modelView;
	}
}
