package org.example.customermanageaspect.service;

import org.example.customermanageaspect.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll() throws Exception;
    Customer findOne(Long id) throws Exception;
}
