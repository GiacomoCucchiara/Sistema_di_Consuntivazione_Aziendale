package com.balance.balance.entity.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CostView {
    private String type;
    private double amount;
    private Date date;
    private String place;
    private Boolean confirm;
    private String notes;
}
