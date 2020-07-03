package com.learnspringboot.controller;

import java.util.Arrays;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

	// @RequestMapping(value = "/user/login", method = RequestMethod.POST)
	@PostMapping("/user/login")
	public String login(
		@RequestParam("email") String email,
		@RequestParam("password") String password,
		Map<String, Object> msg,
		HttpSession session
	)
	{
		if ( ! StringUtils.isEmpty(email) && "adminAb1".equals(password) ) {
			// return "redirect:/index";
			session.setAttribute("loginUser", email);
			return "index";
		} else {
			msg.put("msg", "login fails");
			return "login";
		}
	}

}
