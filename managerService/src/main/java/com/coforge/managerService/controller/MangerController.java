package com.coforge.managerService.controller;

import com.coforge.managerService.entity.Accounts;
import com.coforge.managerService.entity.CustomerAccounts;
import com.coforge.managerService.entity.CustomerDto;
import com.coforge.managerService.service.ManagerService;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MangerController {
@Autowired
private ManagerService managerService;
    @GetMapping("/custInfo")
    public ResponseEntity<?> CustomerInfo(){
        ResponseEntity<?> resp=null;
        try{

            List<CustomerAccounts> list=managerService.custInfo();

          resp=new ResponseEntity<List<CustomerAccounts>>( list, HttpStatus.FOUND);
      }catch (Exception e){
            resp=new ResponseEntity<String>( "Customer not found", HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return resp;
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteCustomerById(@PathVariable("id") int id){
        ResponseEntity<?> resp=null;
        try{
            managerService.deleteCustomerAccount(id);
            resp=new ResponseEntity<String>( "cutomer of id= "+id+"is deleted", HttpStatus.OK);

        }catch (Exception e){
            resp=new ResponseEntity<String>( "Customer not deleted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
return resp;
    }
@PostMapping("/create")
public ResponseEntity<?> createAccount(@RequestBody Accounts accounts){
    ResponseEntity<?> resp=null;
    try{
        Accounts accounts1=managerService.createAccount(accounts);
        resp=new ResponseEntity<Accounts>(accounts1, HttpStatus.CREATED);

    }catch (Exception e){
        resp=new ResponseEntity<String>( "Account not creted", HttpStatus.INTERNAL_SERVER_ERROR);
    }
return resp;
}

    @GetMapping("/custInfo/{id}")
    @Retry(name="CUSTOMER-SERVICE", fallbackMethod="dummyComments")
    public ResponseEntity<?> CustomerInfoByCid(@PathVariable("id") int id){
        ResponseEntity<?> resp=null;
        try{

            CustomerAccounts cstAcc=managerService.custInfoById(id);

            resp=new ResponseEntity<CustomerAccounts>( cstAcc, HttpStatus.FOUND);
        }catch (Exception e){
            resp=new ResponseEntity<String>( "Customer of id="+id+"not found", HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return resp;
    }

    public List<CustomerDto> dummyComments(Exception ex){
        List<CustomerDto> comments = new ArrayList();
        comments.add(new CustomerDto(101,"jai","pune"));
        comments.add(new CustomerDto(102,"raju","noida"));
        comments.add(new CustomerDto(103,"vishal","banglore"));

        return comments;
    }
}
