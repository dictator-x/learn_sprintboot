package com.learnspringboot.component;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginHandlerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(
		HttpServletRequest request,
		HttpServletResponse response,
		Object handler
	) throws Exception
	{
		Object email = request.getSession().getAttribute("loginUser");
		if ( email == null ) {
			request.setAttribute("msg", "do not authorize");
			request.getRequestDispatcher("/index.html").forward(request, response);
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(
		HttpServletRequest request,
		HttpServletResponse response,
		Object handler,
		ModelAndView modelAndView
	) throws Exception
	{

	}

	@Override
	public void afterCompletion(
		HttpServletRequest request,
		HttpServletResponse response,
		Object handler,
		Exception ex
	) throws Exception
	{

	}
}
