package com.balance.balance.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class LoginDTO {
    @NotEmpty
    private String nickname;
    @NotEmpty
    @Size(min = 8, max=16)
    private String password;
}
