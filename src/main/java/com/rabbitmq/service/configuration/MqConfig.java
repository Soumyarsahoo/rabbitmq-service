package com.rabbitmq.service.configuration;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.service.util.RabbitConstants;

@Configuration
public class MqConfig {

	@Bean
	TopicExchange topicExchange() {
		return new TopicExchange(RabbitConstants.TOPIC_EXCHANGE);
	}

	@Bean
	FanoutExchange fanoutExchange() {
		return new FanoutExchange(RabbitConstants.FANOUT_EXCHANGE);
	}

	@Bean
	Queue primeQueue() {
		return new Queue(RabbitConstants.PRIME_QUEUE);
	}

	@Bean
	Queue boQueue() {
		return new Queue(RabbitConstants.BO_QUEUE);
	}

	@Bean
	Binding primeFanoutBinding(FanoutExchange exchange) {
		return BindingBuilder.bind(primeQueue()).to(exchange);
	}

	@Bean
	Binding boFanoutBinding(FanoutExchange exchange) {
		return BindingBuilder.bind(boQueue()).to(exchange);
	}

	@Bean
	Binding primeTopicBinding(TopicExchange exchange) {
		return BindingBuilder.bind(primeQueue()).to(exchange).with("#." + primeQueue().getName() + ".#");
	}

	@Bean
	Binding boTopicBinding(TopicExchange exchange) {
		return BindingBuilder.bind(boQueue()).to(exchange).with("#." + boQueue().getName() + ".#");
	}

	@Bean
	MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	AmqpTemplate template(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter());
		return rabbitTemplate;
	}

}
