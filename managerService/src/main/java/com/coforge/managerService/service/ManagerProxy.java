package com.coforge.managerService.service;

import com.coforge.managerService.entity.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CUSTOMER-SERVICE", url="http://localhost:9898/")
public interface ManagerProxy {
    @GetMapping("/getcutomer")
    public List<CustomerDto> getCustomerDetials();

    @DeleteMapping("/delete/id")
    public ResponseEntity<?>deleteAccountById(@PathVariable("id") int id);
}
