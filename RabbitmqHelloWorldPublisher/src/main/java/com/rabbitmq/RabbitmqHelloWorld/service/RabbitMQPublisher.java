package com.rabbitmq.RabbitmqHelloWorld.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitmq.RabbitmqHelloWorld.model.Employee;

@Service
public class RabbitMQPublisher {

	private static final String EXCHANGE = "helloex";
    private static final String ROUTING_KEY = "employee";
    
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(Employee company) {
		rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, company);
		System.out.println("Send msg = " + company);

	}
}