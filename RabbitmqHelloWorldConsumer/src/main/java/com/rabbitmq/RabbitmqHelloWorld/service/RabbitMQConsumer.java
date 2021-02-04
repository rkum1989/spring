package com.rabbitmq.RabbitmqHelloWorld.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rabbitmq.RabbitmqHelloWorld.model.Employee;

@Service
@RabbitListener(queues="helloq}", containerFactory="helloFactory")
public class RabbitMQConsumer {

	@RabbitHandler
    public void recievedMessage(Employee emp) {
        System.out.println("Recieved Message: " + emp);
    }
}