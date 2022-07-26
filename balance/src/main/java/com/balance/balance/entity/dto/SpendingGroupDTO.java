package com.balance.balance.entity.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class SpendingGroupDTO {
    @NotEmpty
    private String name;
    @NotEmpty
    private Integer minCost;
    @NotEmpty
    private Integer maxCost;
}
