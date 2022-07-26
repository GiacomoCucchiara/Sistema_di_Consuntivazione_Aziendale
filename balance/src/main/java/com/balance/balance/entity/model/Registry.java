package com.balance.balance.entity.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "registry")
public class Registry {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    private String name;

    private String surname;
    private Date birthdate;

    private String taxCode;
    private Boolean admin;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usergroup_id", referencedColumnName = "id", nullable = false)
    private UserGroup usergroup;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "login_id", referencedColumnName = "id")
    private Login login;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name="workDay_has_registry",
                joinColumns = @JoinColumn(name = "registry_id"),
                inverseJoinColumns = @JoinColumn(name = "workDay_id")
    )
    List<WorkDay> workDayList = new ArrayList<>();
    @OneToMany(mappedBy = "registry", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    List<Cost> cost;
}
