package com.learnspringboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import java.util.Map;
import java.util.HashMap;

@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

	@Override
	public Map<String, Object> getErrorAttributes(
		WebRequest webRequest,
		ErrorAttributeOptions options
	)
	{
		//TODO: may be diff in difference version of spring.
		return null;
	}
}
