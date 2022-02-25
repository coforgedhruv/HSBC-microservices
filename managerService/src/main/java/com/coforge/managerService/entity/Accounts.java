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
public class Accounts {
    @Id
    private String accttype;
    private Double mainbalance;
    private Double roi;
}
