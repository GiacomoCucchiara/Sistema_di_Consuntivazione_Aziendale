package com.balance.balance.entity.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserGroupDTO {
    Long id;
    @NotEmpty @Size(min = 3, max=35)
    String name;

}
