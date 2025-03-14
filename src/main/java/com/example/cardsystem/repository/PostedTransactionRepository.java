package com.example.cardsystem.repository;

import com.example.cardsystem.model.PostedTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostedTransactionRepository extends JpaRepository<PostedTransaction, Long> {
}
