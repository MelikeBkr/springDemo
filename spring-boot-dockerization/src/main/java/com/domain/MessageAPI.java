package com.domain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageAPI
{
    @GetMapping
    public String sendMessage()
    {
        return "A message from Docker Image";
    }
}
