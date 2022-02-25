package com.coforge.customerService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transactions {
    private int tid;
    private int cid;
    private String ttype;
    private double amount;
    private String date;

}
