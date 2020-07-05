//TODO: check diff between Filter and HandlerIntercept.
package com.learnspringboot.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(
		ServletRequest req,
		ServletResponse resp,
		FilterChain chain
	) throws IOException, ServletException
	{
		System.out.println("doing filter");
		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {

	}
}
