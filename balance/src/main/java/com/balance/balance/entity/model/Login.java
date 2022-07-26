package com.balance.balance.entity.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "Login")
public class Login {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    private String nickname;
    private String password;
    @MapKey
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "login")

    private Registry registry;
}
