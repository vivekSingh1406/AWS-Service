package com.sqs_service.configuration;

import com.sqs_service.service.MessageQueueService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfiguration {

    @Autowired
    private MessageQueueService messageQueueService;

    @PostConstruct
    public void initializeMessageQueue() {
        messageQueueService.createMessageQueue();
    }
}