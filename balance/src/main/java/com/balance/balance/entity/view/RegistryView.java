package com.balance.balance.entity.view;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class RegistryView {
    private String name;
    private String surname;
    private Date birthdate;
    private String taxCode;
    private UserGroupView userGroupView;
    private LoginView loginView;
}
