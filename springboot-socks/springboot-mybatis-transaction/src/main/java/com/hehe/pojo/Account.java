package com.hehe.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {

    private String accountId;
    private String accountName;
    private BigDecimal balance;

    // Override toString Method ..
    // Getter & Setters  ..
}