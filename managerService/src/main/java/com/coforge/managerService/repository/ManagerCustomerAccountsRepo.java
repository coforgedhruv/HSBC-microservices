package com.coforge.managerService.repository;

import com.coforge.managerService.entity.CustomerAccounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerCustomerAccountsRepo extends JpaRepository<CustomerAccounts,Integer> {
}
