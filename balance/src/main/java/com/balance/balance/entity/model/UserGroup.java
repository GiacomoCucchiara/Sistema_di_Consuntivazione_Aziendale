package com.balance.balance.entity.model;

import java.util.List;

import javax.persistence.*;
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
@Table(name = "usergroup")
public class UserGroup {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    @OneToMany(mappedBy = "usergroup", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)

    private List<Registry> registry;
    @NotEmpty @Size(min = 3, max=35)
    private String name;
    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    private List<SpendingGroup> spendingGroup;
}
