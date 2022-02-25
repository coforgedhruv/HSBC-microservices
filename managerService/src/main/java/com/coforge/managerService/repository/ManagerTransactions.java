package com.coforge.managerService.repository;

import com.coforge.managerService.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerTransactions extends JpaRepository<Transactions,Integer> {
}
