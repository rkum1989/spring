package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootSampleProjectApplicationTests {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void contextLoads() {
		 logger.debug("This is a debug message");
	        logger.info("This is an info message");
	        logger.warn("This is a warn message");
	        logger.error("This is an error message");
	}

}
