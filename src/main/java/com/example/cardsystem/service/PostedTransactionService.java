package com.example.cardsystem.service;

import com.example.cardsystem.model.PostedTransaction;
import com.example.cardsystem.repository.PostedTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostedTransactionService {
    @Autowired
    private PostedTransactionRepository postedTransactionRepository;

    public List<PostedTransaction> getAllTransactions() {
        return postedTransactionRepository.findAll();
    }
}
