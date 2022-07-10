package com.rabbitmq.service.util;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.service.entity.Message;

@Component
public class Listener {
	
	@RabbitListener(queues = RabbitConstants.PRIME_QUEUE)
	public void readPrimeMessage(Message message) {
		System.out.println("Prime Listener Started");
		System.out.println("Prime Listener Message "+message);
	}
	
	@RabbitListener(queues = RabbitConstants.BO_QUEUE)
	public void readBoMessage(Message message) {
		System.out.println("Bo Listener Started");
		System.out.println("Bo Listener Message "+message);
	}

}
