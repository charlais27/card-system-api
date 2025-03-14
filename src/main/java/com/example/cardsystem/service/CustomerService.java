package com.example.cardsystem.service;

import com.example.cardsystem.model.Customer;
import com.example.cardsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

	public Optional<Customer> getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		
	}

	public CustomerRepository getCustomerRepository() {
		return customerRepository;
	}

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
}
