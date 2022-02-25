package com.coforge.managerService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerAccounts {
    @Id
    private int accno;
    private int cid;
    private String accttype;
    private String date;
}
