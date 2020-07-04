package com.learnspringboot.controller;

import com.learnspringboot.exception.UserNotExistException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {

	// @ResponseBody
	// @ExceptionHandler(UserNotExistException.class)
	// public Map handleException(Exception e) {
	// 	Map<String, Object> map = new HashMap<String, Object>();
	// 	map.put("code", "user.notexist");
	// 	map.put("message", e.getMessage());
	// 	return map;
	// }

	@ExceptionHandler(UserNotExistException.class)
	public String handleException(Exception e, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		request.setAttribute("javax.servlet.error.status_code", 400);
		map.put("code", "user.notexist");
		map.put("message", e.getMessage());
		// let spring BasicErrorController handle error.
		return "forward:/error";
	}

}
