package com.coforge.customerService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAccounts {
    private int accno;
    private int cid;
    private String accttype;
    private Double balance;
}
