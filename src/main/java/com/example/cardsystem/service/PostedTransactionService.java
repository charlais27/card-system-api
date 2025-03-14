package com.example.cardsystem.service;

import com.example.cardsystem.model.PostedTransaction;
import com.example.cardsystem.repository.PostedTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PostedTransactionService {
    @Autowired
    private PostedTransactionRepository postedTransactionRepository;

    public List<PostedTransaction> getAllTransactions() {
        return postedTransactionRepository.findAll();
    }

	public PostedTransactionRepository getPostedTransactionRepository() {
		return postedTransactionRepository;
	}

	public void setPostedTransactionRepository(PostedTransactionRepository postedTransactionRepository) {
		this.postedTransactionRepository = postedTransactionRepository;
	}

	public PostedTransaction processTransaction(PostedTransaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<PostedTransaction> getTransactionById(Long tranId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PostedTransaction> getTransactionsByAccountAndDate(Long accountId, LocalDate startDate,
			LocalDate endDate) {
		// TODO Auto-generated method stub
		return null;
	}
}
