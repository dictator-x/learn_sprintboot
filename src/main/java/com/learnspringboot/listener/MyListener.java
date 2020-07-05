package com.learnspringboot.listener;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

public class MyListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized...web");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestryed...web");
	}
}
