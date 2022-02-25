package com.coforge.managerService.repository;

import com.coforge.managerService.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerAccountsRepo extends JpaRepository<Accounts,String> {
}
