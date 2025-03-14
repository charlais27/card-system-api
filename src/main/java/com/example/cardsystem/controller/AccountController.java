package com.example.cardsystem.controller;

import com.example.cardsystem.model.Account;
import com.example.cardsystem.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
@Tag(name = "Account API", description = "Operations related to account management")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * Retrieves a list of all accounts.
     * @return List<Account> containing all registered accounts
     */
    @GetMapping
    @Operation(summary = "Get all accounts", description = "Returns a list of all registered accounts")
    public List<Account> getAccounts() {
        return accountService.getAllAccounts();
    }

    /**
     * Retrieves an account by its ID.
     * @param id Account ID
     * @return Account details if found, otherwise 404 Not Found
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get account by ID", description = "Fetch a single account by its ID")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Optional<Account> accountOptional = accountService.getAccountById(id);
        return accountOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Creates a new account.
     * @param account Account object (JSON payload)
     * @return The created account with HTTP 201 Created
     */
    @PostMapping
    @Operation(summary = "Create a new account", description = "Adds a new account to the system")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account savedAccount = accountService.createAccount(account);
        return ResponseEntity.status(201).body(savedAccount);
    }

    /**
     * Updates an existing account by ID.
     * @param id Account ID
     * @param updatedAccount Updated account data (JSON payload)
     * @return Updated account if found, otherwise 404 Not Found
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update account details", description = "Updates the information of an existing account")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account updatedAccount) {
        Optional<Account> accountOptional = accountService.getAccountById(id);
        if (accountOptional.isPresent()) {
            Account existingAccount = accountOptional.get();
            existingAccount.setActiveStatus(updatedAccount.getActiveStatus());
            existingAccount.setCurrentBalance(updatedAccount.getCurrentBalance());
            existingAccount.setCreditLimit(updatedAccount.getCreditLimit());
            existingAccount.setCashCreditLimit(updatedAccount.getCashCreditLimit());
            existingAccount.setAccountOpenDate(updatedAccount.getAccountOpenDate());
            existingAccount.setExpirationDate(updatedAccount.getExpirationDate());
            existingAccount.setReissueDate(updatedAccount.getReissueDate());
            existingAccount.setStatementDate(updatedAccount.getStatementDate());
            existingAccount.setCurrentCycCredit(updatedAccount.getCurrentCycCredit());
            existingAccount.setCurrentCycDebit(updatedAccount.getCurrentCycDebit());
            existingAccount.setGroupId(updatedAccount.getGroupId());
            return ResponseEntity.ok(accountService.createAccount(existingAccount));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deactivates (closes) an account by ID.
     * @param id Account ID
     * @return HTTP 204 No Content if successful, 404 Not Found otherwise
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Deactivate an account", description = "Marks an account as inactive instead of deleting it")
    public ResponseEntity<Void> deactivateAccount(@PathVariable Long id) {
        Optional<Account> accountOptional = accountService.getAccountById(id);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            account.setActiveStatus(false); // Mark the account as inactive
            accountService.createAccount(account); // Save the updated status
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
