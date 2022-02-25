package com.coforge.managerService.service;

import com.coforge.managerService.entity.Accounts;
import com.coforge.managerService.entity.CustomerAccounts;
import com.coforge.managerService.entity.CustomerDto;
import com.coforge.managerService.repository.ManagerAccountsRepo;
import com.coforge.managerService.repository.ManagerCustomerAccountsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    ManagerProxy templte;
    @Autowired
    private ManagerCustomerAccountsRepo customerAccountsRepo;

    @Autowired
    private ManagerAccountsRepo managerAccountsRepo;
    @Override
    public List<CustomerAccounts> custInfo() {
        List<CustomerDto> list=templte.getCustomerDetials();
        List<Integer> cid=list.stream().map(CustomerDto::getCid).collect(Collectors.toList());
        //int cid=list.stream().map(CustomerDto::getCid);
        List<CustomerAccounts> list1=customerAccountsRepo.findAll();
        CustomerAccounts custAc=new CustomerAccounts();
        for(int cid1:cid){
        custAc.setCid(cid1);}

        list1.add(custAc);

        return list1;
    }

    @Override
    public void deleteCustomerAccount(int id) {
        templte.deleteAccountById(id);
    }

    @Override
    public Accounts createAccount(Accounts account) {
       return managerAccountsRepo.save(account);
    }

    @Override
    public CustomerAccounts custInfoById(int id) {
        Optional<CustomerAccounts> opt=customerAccountsRepo.findById(id);
        return opt.get();
    }
}
