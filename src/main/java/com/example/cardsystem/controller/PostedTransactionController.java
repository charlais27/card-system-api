package com.example.cardsystem.controller;

import com.example.cardsystem.model.PostedTransaction;
import com.example.cardsystem.service.PostedTransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
@Tag(name = "Transaction API", description = "Operations related to posted transactions")
public class PostedTransactionController {

    @Autowired
    private PostedTransactionService postedTransactionService;

    /**
     * Retrieves a list of all transactions.
     * @return List<PostedTransaction> containing all registered transactions
     */
    @GetMapping
    @Operation(summary = "Get all transactions", description = "Returns a list of all transactions")
    public List<PostedTransaction> getTransactions() {
        return postedTransactionService.getAllTransactions();
    }

    /**
     * Processes a new transaction.
     * @param transaction PostedTransaction object (JSON payload)
     * @return The processed transaction with HTTP 201 Created
     */
    @PostMapping
    @Operation(summary = "Process a new transaction", description = "Adds a new transaction to the system")
    public ResponseEntity<PostedTransaction> processTransaction(@RequestBody PostedTransaction transaction) {
        PostedTransaction savedTransaction = postedTransactionService.processTransaction(transaction);
        return ResponseEntity.status(201).body(savedTransaction);
    }

    /**
     * Retrieves a transaction by its ID.
     * @param tranId Transaction ID
     * @return Transaction details if found, otherwise 404 Not Found
     */
    @GetMapping("/{tran_id}")
    @Operation(summary = "Get transaction by ID", description = "Fetch a single transaction by its transaction ID")
    public ResponseEntity<PostedTransaction> getTransactionById(@PathVariable("tran_id") Long tranId) {
        Optional<PostedTransaction> transactionOptional = postedTransactionService.getTransactionById(tranId);
        return transactionOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Fetches transactions for a specific account within a date range.
     * @param accountId Account ID
     * @param startDate Start date of range (format: yyyy-MM-dd)
     * @param endDate End date of range (format: yyyy-MM-dd)
     * @return List of transactions matching the criteria
     */
    @GetMapping(params = {"account_id", "date_range"})
    @Operation(summary = "Get transactions by account and date range", 
               description = "Fetch transactions for a specific account within a given date range")
    public ResponseEntity<List<PostedTransaction>> getTransactionsByAccountAndDate(
            @RequestParam("account_id") Long accountId,
            @RequestParam("date_range") String dateRange) {
        
        // Parsing the date range assuming format "startDate:endDate"
        String[] dates = dateRange.split(":");
        if (dates.length != 2) {
            return ResponseEntity.badRequest().build();
        }
        
        LocalDate startDate = LocalDate.parse(dates[0]);
        LocalDate endDate = LocalDate.parse(dates[1]);

        List<PostedTransaction> transactions = postedTransactionService.getTransactionsByAccountAndDate(accountId, startDate, endDate);
        return ResponseEntity.ok(transactions);
    }

    /**
     * Updates an existing transaction by ID.
     * @param tranId Transaction ID
     * @param updatedTransaction Updated transaction data (JSON payload)
     * @return Updated transaction if found, otherwise 404 Not Found
     */
    @PutMapping("/{tran_id}")
    @Operation(summary = "Update transaction details", description = "Updates a transaction if business rules allow")
    public ResponseEntity<PostedTransaction> updateTransaction(
            @PathVariable("tran_id") Long tranId,
            @RequestBody PostedTransaction updatedTransaction) {

        Optional<PostedTransaction> transactionOptional = postedTransactionService.getTransactionById(tranId);
        if (transactionOptional.isPresent()) {
            PostedTransaction existingTransaction = transactionOptional.get();
            existingTransaction.setTranTypeCd(updatedTransaction.getTranTypeCd());
            existingTransaction.setTranCatCd(updatedTransaction.getTranCatCd());
            existingTransaction.setTranSource(updatedTransaction.getTranSource());
            existingTransaction.setTranDescription(updatedTransaction.getTranDescription());
            existingTransaction.setTranAmt(updatedTransaction.getTranAmt());
            existingTransaction.setMerchantId(updatedTransaction.getMerchantId());
            existingTransaction.setMerchantName(updatedTransaction.getMerchantName());
            existingTransaction.setMerchantCity(updatedTransaction.getMerchantCity());
            existingTransaction.setMerchantState(updatedTransaction.getMerchantState());
            existingTransaction.setMerchantZip(updatedTransaction.getMerchantZip());
            existingTransaction.setTranTimestamp(updatedTransaction.getTranTimestamp());

            return ResponseEntity.ok(postedTransactionService.processTransaction(existingTransaction));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

