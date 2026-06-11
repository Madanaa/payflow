package com.payflow.service;

import com.payflow.entity.Transaction;

public interface TransactionService {
    Transaction sendMoney(Transaction transaction);
}
