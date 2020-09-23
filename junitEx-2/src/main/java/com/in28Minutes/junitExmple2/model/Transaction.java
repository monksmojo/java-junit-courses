package com.in28Minutes.junitExmple2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Transaction {
    private Long toAccountId;
    private Long fromAccountId;
    private Double amount;

    @Override
    public String toString() {
        return "Transaction{" +
                "toAccountId=" + toAccountId +
                ", fromAccountId=" + fromAccountId +
                ", amount=" + amount +
                '}';
    }
}
