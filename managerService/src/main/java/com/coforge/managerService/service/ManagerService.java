package com.coforge.managerService.service;

import com.coforge.managerService.entity.Accounts;
import com.coforge.managerService.entity.CustomerAccounts;

import java.util.List;

public interface ManagerService {
public List<CustomerAccounts> custInfo();
public void deleteCustomerAccount(int id);

   public Accounts createAccount(Accounts accounts);
   public CustomerAccounts custInfoById(int id);
    /*public List<Accounts> custAccInfo();*/
}
