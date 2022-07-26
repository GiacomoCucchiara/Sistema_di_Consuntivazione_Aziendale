package com.balance.balance.entity.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class LoginDTO {
    @NotEmpty
    private String nickname;
    @NotEmpty
    @Size(min = 8, max=16)
    private String password;
}
