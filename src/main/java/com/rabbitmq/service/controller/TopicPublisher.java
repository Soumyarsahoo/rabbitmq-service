package com.rabbitmq.service.controller;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.service.entity.Message;
import com.rabbitmq.service.util.RabbitConstants;

@RestController
@RequestMapping("/rabbit")
public class TopicPublisher {

	@Autowired
	TopicExchange topicExchange;

	@Autowired
	RabbitTemplate rabbitTemplate;

	@PostMapping("/publishtopic")
	public String sendTopicMessage(@RequestBody Message message) {

//		if(message.getRoutingKey().contains("|")) {
//			System.out.println("Message Contains multiple systems");
//			for(String system : message.getRoutingKey().split("\\|")) {
//				rabbitTemplate.convertAndSend(RabbitConstants.TOPIC_EXCHANGE, system, message);
//			}
//		}else {
		System.out.println("Routing Key for Topic Exchange " + message.getRoutingKey());
		rabbitTemplate.convertAndSend(RabbitConstants.TOPIC_EXCHANGE, message.getRoutingKey(), message);
//		}

		return "Message published successfully to Topic Exchange";

	}

}
