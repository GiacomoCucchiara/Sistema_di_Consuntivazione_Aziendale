package com.balance.balance.entity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "cost")
public class Cost {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    private String type;

    private double amount;

    private Date date;

    private String place;
    private Boolean confirm;
    private String notes;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "registry_id", referencedColumnName = "id", nullable = false)
    Registry registry;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "spendingGroup_id", referencedColumnName = "id", nullable = false)
    SpendingGroup spendingGroup;

}