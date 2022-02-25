package com.coforge.customerService.service;

import com.coforge.customerService.dto.CustomerAccounts;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="MANAGER-SERVICE", url="http://localhost:9899/")
public interface CustomerProxy {
    @GetMapping("/custInfo")
    public List<CustomerAccounts> CustomerInfo();

    @GetMapping("/custInfo/{id}")
    public CustomerAccounts CustomerInfoByCid(@PathVariable("id") int id);
}
