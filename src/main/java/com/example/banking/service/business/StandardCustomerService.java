package com.example.banking.service.business;

import org.springframework.stereotype.Service;

import com.example.banking.document.CustomerDocument;
import com.example.banking.repository.CustomerMongoRepository;
import com.example.banking.service.CustomerService;
import com.example.banking.service.business.exception.CustomerNotFoundException;

@Service
public class StandardCustomerService implements CustomerService {

	private CustomerMongoRepository customerMongoRepository;

	public StandardCustomerService(CustomerMongoRepository customerMongoRepository) {
		this.customerMongoRepository = customerMongoRepository;
	}

	@Override
	public CustomerDocument findCustomerByIdentity(String identity) {
		return customerMongoRepository.findById(identity).orElseThrow(() -> new CustomerNotFoundException(
				String.format("Cannot find the customer with identity %s", identity), identity));
	}

}
