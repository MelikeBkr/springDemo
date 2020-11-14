package com.domain.springRabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//The instances created here will serve as components
//that will remain in communication with the queue.
@Configuration
public class RabbitMQConfiguration
{
    @Value("${springRabbit.rabbit.queue.name}")
    private String queueName;
    @Value("${springRabbit.rabbit.exchange.name}")
    private String exchangeName;
    @Value("${springRabbit.rabbit.routing.name}")
    private String routingName;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    //Create a single instance with Dependency Injection and use it elsewhere
    @Bean
    public Queue queue()
    {
        return new Queue(queueName);
    }
    @Bean
    public DirectExchange directExchange()
    {
        return new DirectExchange(exchangeName);
    }
    public Binding binding(final Queue queue, final DirectExchange directExchange)
    {
        //Exchange can be either "Direct" or "Fanout" or "Topic"
        //Direct exchange is selected
        //Binding queue with exchange to communicate these two instances
        return BindingBuilder.bind(queue).to(directExchange).with(routingName);
    }
}
