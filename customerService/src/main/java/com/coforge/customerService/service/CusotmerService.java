package com.coforge.customerService.service;

import com.coforge.customerService.dto.Deposit;
import com.coforge.customerService.entity.Customer;

import java.util.List;

public interface CusotmerService {
    public Customer registerCustomer(Customer customer);
    public List<Customer> customerDetails();
    void deleteCustomerAccount(int id);
    double deposit(Deposit deposit);
   /* void withdrawn(String name, int withdrawal);*/
}
