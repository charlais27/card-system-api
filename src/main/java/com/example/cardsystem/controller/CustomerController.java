package com.example.cardsystem.controller;

import com.example.cardsystem.model.Customer;
import com.example.cardsystem.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Tag(name = "Customer API", description = "API for managing customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    @Operation(summary = "Get all customers", description = "Returns a list of all customers")
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }
}
