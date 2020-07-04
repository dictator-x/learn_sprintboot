package com.learnspringboot.controller;

import java.util.Arrays;
import java.util.Map;
import com.learnspringboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	// @RequestMapping({"/", "/index.html"})
	// public String index() {
	// 	return "success";
	// }

	@RequestMapping("/success")
	public String success(Map<String, Object> map) {
		map.put("hello", "<h1>Good Morning</h1>");
		map.put("users", Arrays.asList("Kobe", "Jordan", "James"));
		return "success";
	}

	@ResponseBody
	@RequestMapping("/hellouser")
	public String hello(
		@RequestParam("user") String user
	)
	{
		if ( user.equals("aaa") ) {
			throw new UserNotExistException();
		}
		return "Hello World";
	}
}
