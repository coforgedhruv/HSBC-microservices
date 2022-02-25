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
public class Transactions {
    @Id
    private int tid;
    private int cid;
    private String ttype;
    private double amount;
    private String date;

}
