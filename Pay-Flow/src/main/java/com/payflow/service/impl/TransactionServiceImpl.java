package com.payflow.service.impl;

import com.payflow.entity.Transaction;
import com.payflow.repository.TransactionRepository;
import com.payflow.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    final private TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        // At startup, Spring creates a TransactionRepository bean and injects it here so this service can persist transfers.
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction sendMoney(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
