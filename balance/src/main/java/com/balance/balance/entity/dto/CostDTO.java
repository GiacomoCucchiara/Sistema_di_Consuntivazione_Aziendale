package com.balance.balance.entity.dto;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CostDTO {
    @NotEmpty
    private String type;
    @NotEmpty
    private double amount;
    @NotEmpty
    private Date date;
    @NotEmpty
    private String place;
    private String notes;
    private DtoId registry;
    private DToId2 spendingGroupDTO;
}
