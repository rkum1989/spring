package com.spring.basic.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.basic.config.PropertValueFromYmlToBean;
import com.spring.basic.model.MovieCatalog;
import com.spring.basic.model.SimpleMovieLister;

@RestController
public class BasicController {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private MovieCatalog movieCatalog;

	@Autowired
	private Environment env;

	@Value("${server.name}")
	private String serverName;

	@Value("${my.secret}")
	private String secret;

	@Value("${my.number.less.than.ten}")
	private int numberLessThanTen;

	@Value("${my.number.in.range}")
	private int numberInRange;

	@Value("${my.bignumber}")
	private long bigNumber;

	@Autowired
	private PropertValueFromYmlToBean bean;

	@RequestMapping("/hello")
	String getMessage(@RequestParam(value = "name") String name) {
		String rsp = "Hi " + name + " : responded on - " + new Date();
		System.out.println(rsp);
		
		System.err.println(context.getBean(SimpleMovieLister.class));
		System.err.println(movieCatalog.getMovieName());
		System.err.println(context.getBeanDefinitionNames());
		
		System.err.println("server name............" + serverName);
		System.err.println("Random secret value............" + secret);
		System.err.println("Random number LessThan Ten............" + numberLessThanTen);
		System.err.println("Random number In Range............" + numberInRange);
		System.err.println("Random big Number............" + bigNumber);
		
		System.out.println("#################### propert value from bean class #######################");
		System.err.println("Random secret value............" + bean.getSecret());
		System.err.println("Random number LessThan Ten............" + bean.getNumberlessthanten());
		System.err.println("Random number In Range............" + bean.getNumberinrange());
		System.err.println("Random big Number............" + bean.getBignumber());
		System.err.println("Random uuid............" + bean.getUuid());
		System.err.println("check for propertSource key............" + bean.getKey());

		System.out.println("#################### propert value from Environment Interface #######################");
		System.err.println("from Environment " + env.getProperty("key"));
		System.err.println("from Environment " + env.getProperty("server.name"));

		System.out.println("#################### propert value from System class #######################");
		System.err.println("from System  " + System.getProperty("key"));
		System.err.println("from System  " + System.getProperty("server.name"));

		return rsp;
	}
}
