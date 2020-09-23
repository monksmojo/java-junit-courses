package com.in28Minutes.junitExmple2.controller;

import com.in28Minutes.junitExmple2.model.Transaction;
import com.in28Minutes.junitExmple2.service.TransactionService;
import com.in28Minutes.junitExmple2.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/send-money")
public class TransactionController {

    @Autowired
    private TransactionServiceImpl transactionService;


    @GetMapping()
    ResponseEntity sendMoney(@RequestParam Long toAccountId,
                             @RequestParam Long fromAccountId,
                             @RequestParam Double amount){
        Boolean success=transactionService.transactionProcess(new Transaction(toAccountId,fromAccountId,amount));
        System.out.println("success-->"+success);

        if (success){
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
