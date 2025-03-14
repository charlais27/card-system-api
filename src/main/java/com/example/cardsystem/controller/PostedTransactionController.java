package com.example.cardsystem.controller;

import com.example.cardsystem.model.PostedTransaction;
import com.example.cardsystem.service.PostedTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class PostedTransactionController {
    @Autowired
    private PostedTransactionService postedTransactionService;

    @GetMapping
    public List<PostedTransaction> getTransactions() {
        return postedTransactionService.getAllTransactions();
    }
}
