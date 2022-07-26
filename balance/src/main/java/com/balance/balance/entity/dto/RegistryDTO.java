package com.balance.balance.entity.dto;

import java.sql.Date;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistryDTO {
    @NotEmpty @Size(min = 3, max= 35)
    private String name;
    @NotEmpty @Size(min = 3, max= 35)
    private String surname;
    private Date birthdate;
    @NotEmpty @Size(min = 16, max=16)
    private String taxCode;
    UserGroupDTO userGroupDTO;
    LoginDTO loginDTO;

}
