package com.example.cardsystem.controller;

import com.example.cardsystem.model.Customer;
import com.example.cardsystem.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
@Tag(name = "Customer API", description = "Operations related to customer management")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * Retrieves a list of all customers.
     * @return List<Customer>
     */
    @GetMapping
    @Operation(summary = "Get all customers", description = "Returns a list of all customers")
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    /**
     * Retrieves a customer by ID.
     * @param id Customer ID
     * @return Customer details if found, otherwise 404 Not Found
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get customer by ID", description = "Fetch a single customer by its ID")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Creates a new customer.
     * @param customer Customer object (JSON payload)
     * @return The created customer with HTTP 201 Created
     */
    @PostMapping
    @Operation(summary = "Create a new customer", description = "Adds a new customer to the system")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.createCustomer(customer);
        return ResponseEntity.status(201).body(savedCustomer);
    }

    /**
     * Updates an existing customer by ID.
     * @param id Customer ID
     * @param updatedCustomer Updated customer data (JSON payload)
     * @return Updated customer if found, otherwise 404 Not Found
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update customer details", description = "Updates the information of an existing customer")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        Optional<Customer> customerOptional = customerService.getCustomerById(id);
        if (customerOptional.isPresent()) {
            Customer existingCustomer = customerOptional.get();
            existingCustomer.setFirstName(updatedCustomer.getFirstName());
            existingCustomer.setLastName(updatedCustomer.getLastName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setPhone_1(updatedCustomer.getPhone_1());
            existingCustomer.setPhone_2(updatedCustomer.getPhone_2());
            existingCustomer.setEftAccountId(updatedCustomer.getEftAccountId());
            existingCustomer.setFicoCreditScore(updatedCustomer.getFicoCreditScore());
            return ResponseEntity.ok(customerService.createCustomer(existingCustomer));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a customer by ID.
     * @param id Customer ID
     * @return HTTP 204 No Content if successful, 404 Not Found otherwise
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a customer", description = "Removes a customer from the system (if business rules allow)")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.getCustomerById(id);
        if (customerOptional.isPresent()) {
            customerService.deleteCustomer(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Retrieves only the phone numbers of a customer.
     * @param id Customer ID
     * @return JSON object with phone_1 and phone_2 if customer exists, otherwise 404 Not Found
     */
    @GetMapping("/{id}/phones")
    @Operation(summary = "Get customer phone numbers", description = "Fetches phone_1 and phone_2 of a customer")
    public ResponseEntity<?> getCustomerPhones(@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.getCustomerById(id);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return ResponseEntity.ok(new PhoneResponse(customer.getPhone_1(), customer.getPhone_2()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Updates only the phone numbers of a customer.
     * @param id Customer ID
     * @param phoneUpdateRequest JSON payload containing phone_1 and phone_2
     * @return Updated customer if found, otherwise 404 Not Found
     */
    @PutMapping("/{id}/phones")
    @Operation(summary = "Update customer phone numbers", description = "Updates only the phone numbers of a customer")
    public ResponseEntity<Customer> updateCustomerPhones(@PathVariable Long id, @RequestBody PhoneRequest phoneUpdateRequest) {
        Optional<Customer> customerOptional = customerService.getCustomerById(id);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            customer.setPhone_1(phoneUpdateRequest.getPhone_1());
            customer.setPhone_2(phoneUpdateRequest.getPhone_2());
            return ResponseEntity.ok(customerService.createCustomer(customer));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Retrieves the credit score of a customer.
     * @param id Customer ID
     * @return JSON object with fico_credit_score if customer exists, otherwise 404 Not Found
     */
    @GetMapping("/{id}/credit-score")
    @Operation(summary = "Get customer credit score", description = "Fetches the FICO credit score of a customer")
    public ResponseEntity<?> getCustomerCreditScore(@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.getCustomerById(id);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return ResponseEntity.ok(new CreditScoreResponse(customer.getFicoCreditScore()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Updates only the credit score of a customer.
     * @param id Customer ID
     * @param creditScoreRequest JSON payload containing fico_credit_score
     * @return Updated customer if found, otherwise 404 Not Found
     */
    @PutMapping("/{id}/credit-score")
    @Operation(summary = "Update customer credit score", description = "Updates only the FICO credit score of a customer")
    public ResponseEntity<Customer> updateCustomerCreditScore(@PathVariable Long id, @RequestBody CreditScoreRequest creditScoreRequest) {
        Optional<Customer> customerOptional = customerService.getCustomerById(id);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            customer.setFicoCreditScore(creditScoreRequest.getFicoCreditScore());
            return ResponseEntity.ok(customerService.createCustomer(customer));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Inner DTO classes for request/response
    private static class PhoneResponse {
        public String phone_1;
        public String phone_2;
        public PhoneResponse(String phone_1, String phone_2) {
            this.phone_1 = phone_1;
            this.phone_2 = phone_2;
        }
		public PhoneResponse(Object phone_12, Object phone_22) {
			// TODO Auto-generated constructor stub
		}
    }

    private static class PhoneRequest {
        public String phone_1;
        public String phone_2;
		public Object getPhone_1() {
			// TODO Auto-generated method stub
			return null;
		}
		public Object getPhone_2() {
			// TODO Auto-generated method stub
			return null;
		}
    }

    private static class CreditScoreResponse {
        public Integer fico_credit_score;
        public CreditScoreResponse(Integer fico_credit_score) {
            this.fico_credit_score = fico_credit_score;
        }
		public CreditScoreResponse(Object ficoCreditScore) {
			// TODO Auto-generated constructor stub
		}
    }

    private static class CreditScoreRequest {
        public Integer fico_credit_score;

		public Object getFicoCreditScore() {
			// TODO Auto-generated method stub
			return null;
		}
    }
}
