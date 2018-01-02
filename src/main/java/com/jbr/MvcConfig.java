package com.jbr;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/getDeviceIndex").setViewName("getDevice");
		registry.addViewController("/deviceIndex").setViewName("device");
		registry.addViewController("/planIndex").setViewName("plan");
		registry.addViewController("/plan2Index").setViewName("plan2");
		registry.addViewController("/taskIndex").setViewName("task");
		registry.addViewController("/scriptIndex").setViewName("script");
	}

}
