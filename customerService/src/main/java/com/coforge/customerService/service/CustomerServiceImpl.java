package com.coforge.customerService.service;

import com.coforge.customerService.customerRepository.CustomerRepo;
import com.coforge.customerService.dto.CustomerAccounts;
import com.coforge.customerService.dto.Deposit;
import com.coforge.customerService.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CusotmerService{
    @Autowired
    private CustomerProxy template;

    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public Customer registerCustomer(Customer customer) {

        return customerRepo.save(customer);
    }

    @Override
    public List<Customer> customerDetails() {
        return customerRepo.findAll();
    }

    @Override
    public void deleteCustomerAccount(int id) {
        customerRepo.deleteById(id);
    }

    @Override
    public double deposit(Deposit deposit) {
  CustomerAccounts cstact =template.CustomerInfoByCid(deposit.getCid());
  Double balance=cstact.getBalance();

  balance=deposit.getDepositMoney()+balance;
return balance;
    }
}
