package com.balance.balance.entity.dto;

import com.balance.balance.entity.model.UserGroup;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class SpendingGroupDTO {
    @NotEmpty
    private String name;

    private Integer minCost;
    private Integer maxCost;
    @NotNull
    private UserGroupDTO userGroupDTO;
}
