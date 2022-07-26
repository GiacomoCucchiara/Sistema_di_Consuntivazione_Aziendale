package com.balance.balance.entity.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SpendingGroupView {
    private String name;
    private Integer minCost;
    private Integer maxCost;
}
