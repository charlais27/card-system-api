package com.example.cardsystem.repository;

import com.example.cardsystem.model.CustomerCardXref;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCardXrefRepository extends JpaRepository<CustomerCardXref, String> {
}
