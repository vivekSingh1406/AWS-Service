package com.sqs_service.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.*;
import com.sqs_service.model.CreateExpenseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageQueueService {

    private static final Logger log = LoggerFactory.getLogger(MessageQueueService.class);

    @Value("${app.config.message.queue.topic}")
    private String messageQueueTopic;

    @Autowired
    private AmazonSQS amazonSQSClient;

    public void createMessageQueue() {
        log.info("Creating message queue on AWS SQS");

        CreateQueueRequest request = new CreateQueueRequest().withQueueName(messageQueueTopic);

        try {
            CreateQueueResult queue = amazonSQSClient.createQueue(request);
            log.info("Queue created successfully: {}", queue.getQueueUrl());
        } catch (QueueNameExistsException e) {
            log.warn("Queue already exists: {}", e.getErrorMessage());
        } catch (AmazonSQSException e) {
            log.error("Error creating SQS queue: {}", e.getMessage());
        }
    }

    public void publishExpense(CreateExpenseDto createExpenseDto) {
        try {
            GetQueueUrlResult queueUrl = amazonSQSClient.getQueueUrl(messageQueueTopic);
            log.info("SQS queue found: URL = {}", queueUrl.getQueueUrl());

            String message = createExpenseDto.getType() + ":" + createExpenseDto.getDescription();
            amazonSQSClient.sendMessage(queueUrl.getQueueUrl(), message);

            log.info("Message sent to SQS: {}", message);
        } catch (QueueDoesNotExistException e) {
            log.error("Queue does not exist: {}", e.getMessage());
        } catch (InvalidMessageContentsException e) {
            log.error("Invalid message content: {}", e.getMessage());
        } catch (AmazonSQSException e) {
            log.error("Error sending message to SQS: {}", e.getMessage());
        }
    }
}
