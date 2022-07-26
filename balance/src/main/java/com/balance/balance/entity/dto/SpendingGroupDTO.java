package com.balance.balance.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class SpendingGroupDTO {
    @NotEmpty
    private String name;
    @NotEmpty
    private Integer minCost;
    @NotEmpty
    private Integer maxCost;
}
