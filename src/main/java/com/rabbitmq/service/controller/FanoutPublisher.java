package com.rabbitmq.service.controller;

import org.springframework.amqp.core.FanoutExchange;
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
public class FanoutPublisher {
	
	@Autowired
	FanoutExchange fanoutExchange;
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@PostMapping("/publishfanout")
	public String sendFanoutMessage(@RequestBody Message message) {
		rabbitTemplate.convertAndSend(RabbitConstants.FANOUT_EXCHANGE, null, message);
		return "Message published successfully to Fanout Exchange";
		
	}
	
	

}
