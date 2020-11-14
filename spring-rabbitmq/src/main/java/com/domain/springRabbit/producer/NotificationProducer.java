package com.domain.springRabbit.producer;

import com.domain.springRabbit.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
public class NotificationProducer
{
    @Value("${springRabbit.rabbit.routing.name}")
    private String routingName;
    @Value("${springRabbit.rabbit.exchange.name}")
    private String exchangeName;
    //PostConstruct: after the object correctly initialized
    @PostConstruct
    public void init()
    {
        Notification notification = new Notification();
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setCreationDate(new Date());
        notification.setMessage("Test notification from mel");
        notification.setSeen(Boolean.FALSE);
        sendToQueue(notification);
    }
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void sendToQueue(Notification notification)
    {
        System.out.println("Notification with ID: "+notification.getNotificationId()+" is sent.");
        rabbitTemplate.convertAndSend(exchangeName,routingName, notification);
    }
}
