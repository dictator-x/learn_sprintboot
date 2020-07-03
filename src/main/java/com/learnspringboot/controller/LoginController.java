package com.learnspringboot.controller;

import java.util.Arrays;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.util.StringUtils;

@Controller
public class LoginController {

	// @RequestMapping(value = "/user/login", method = RequestMethod.POST)
	@PostMapping("/user/login")
	public String login(@RequestParam("email") String email,
											@RequestParam("password") String password,
											Map<String, Object> msg) {
		System.out.println(email);
		System.out.println(password);
		if ( ! StringUtils.isEmpty(email) && "adminAb1".equals(password) ) {
			return "index";
		} else {
			msg.put("msg", "login fails");
			return "login";
		}
	}

}
