package com.learnspringboot.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
// @ResponseBody
// @RestController // == @Controller + @Controller
public class HelloController {

	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		return "hello world";
	}

	@RequestMapping("/success")
	public String success(Map<String, Object> map) {
		map.put("hello", "Good Morning");
		return "success";
	}

}
