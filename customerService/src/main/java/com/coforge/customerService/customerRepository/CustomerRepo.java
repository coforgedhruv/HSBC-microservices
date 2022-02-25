package com.coforge.customerService.customerRepository;

import com.coforge.customerService.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
