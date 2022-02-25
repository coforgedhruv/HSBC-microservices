package com.coforge.customerService.controller;

import com.coforge.customerService.dto.Deposit;
import com.coforge.customerService.entity.Customer;
import com.coforge.customerService.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping("/create")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {
        ResponseEntity<?> resp = null;
        try {
            Customer cust1 = customerService.registerCustomer(customer);

            resp = new ResponseEntity<Customer>(cust1, HttpStatus.CREATED);

        } catch (Exception e) {
            resp = new ResponseEntity<String>("Customer is not saved", HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return resp;

    }

    @GetMapping("/getcutomer")
    public ResponseEntity<?> getCustomerDetials() {

        ResponseEntity<?> resp = null;
        try {
            List<Customer> listOfCust = customerService.customerDetails();

            resp = new ResponseEntity<List<Customer>>(listOfCust, HttpStatus.FOUND);

        } catch (Exception e) {
            resp = new ResponseEntity<String>("Customer is not fectched", HttpStatus.INTERNAL_SERVER_ERROR);

        }

return resp;
    }

    @DeleteMapping("/delete/id")
    public ResponseEntity<?>deleteAccountById(@PathVariable("id") int id){
        ResponseEntity<?> resp = null;

        try{
            customerService.deleteCustomerAccount(id);
            resp = new ResponseEntity<String>("customer of id= "+id+"deleted", HttpStatus.OK);
        }catch (Exception e){

            resp = new ResponseEntity<String>("customer of id= "+id+"not deleted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return resp;
    }

@PostMapping("/deposit")
    public ResponseEntity<?> depositInAccount(@RequestBody Deposit deposit){
    ResponseEntity<?> resp=null;
    try{

        double bal=customerService.deposit(deposit);
        resp=new ResponseEntity<>(bal,HttpStatus.FOUND);
    }catch (Exception e){

        resp=new ResponseEntity<String>("not able to deposit",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return resp;
    }
    }



