package com.in28Minutes.junitExmple2.service;

import com.in28Minutes.junitExmple2.model.Transaction;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl  {
    public Boolean transactionProcess(Transaction transaction) {
        return false;
    }
}
