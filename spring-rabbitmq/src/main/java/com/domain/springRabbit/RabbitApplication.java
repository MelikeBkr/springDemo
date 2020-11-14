package com.domain.springRabbit;

import com.domain.springRabbit.model.Notification;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class RabbitApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(RabbitApplication.class,args);
    }
}
