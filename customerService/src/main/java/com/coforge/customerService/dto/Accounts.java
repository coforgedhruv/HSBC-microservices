package com.coforge.customerService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Accounts {
    private String accttype;
    private int deposit;
    private Double mainbalance;
    private Double roi;
}
