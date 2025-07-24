package com.sqs_service.controller;

import com.sqs_service.model.CreateExpenseDto;
import com.sqs_service.service.MessageQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/expenses")
public class ExpensesController {

    @Autowired
    private MessageQueueService messageQueueService;

    @PostMapping
    public ResponseEntity<Void> createExpense(@RequestBody CreateExpenseDto createExpenseDto) {
        messageQueueService.publishExpense(createExpenseDto);
        return ResponseEntity.ok().build();
    }

}