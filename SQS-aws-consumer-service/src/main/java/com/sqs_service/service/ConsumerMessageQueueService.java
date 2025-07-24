package com.sqs_service.service;


import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.QueueDoesNotExistException;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class ConsumerMessageQueueService {

    private static final Logger log = LoggerFactory.getLogger(ConsumerMessageQueueService.class);

    @Value("${app.config.message.queue.topic}")
    private String messageQueueTopic;

    @Autowired
    private AmazonSQS amazonSQSClient;

    @Scheduled(fixedDelay = 5000) //executes on every 5 second gap.
    public void receiveMessages() {
        try {
            String queueUrl = amazonSQSClient.getQueueUrl(messageQueueTopic).getQueueUrl();
            log.info("Reading SQS Queue done: URL {}", queueUrl);

            ReceiveMessageResult receiveMessageResult = amazonSQSClient.receiveMessage(queueUrl);

            if (!receiveMessageResult.getMessages().isEmpty()) {
                Message message = receiveMessageResult.getMessages().get(0);
                log.info("Incoming Message From SQS {}", message.getMessageId());
                log.info("Message Body {}", message.getBody());
                processInvoice(message.getBody());
                amazonSQSClient.deleteMessage(queueUrl, message.getReceiptHandle());
            }

        } catch (QueueDoesNotExistException e) {
            log.error("Queue does not exist {}", e.getMessage());
        }
    }

    private void processInvoice(String body) {
        log.info("Processing invoice generation and sending invoice emails from here..");
    }

}