package com.balance.balance.entity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "spendingGroup")
public class SpendingGroup {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    private String name;

    private Integer minCost;
    private Integer maxCost;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usergroup_id", referencedColumnName = "id", nullable = false)
    UserGroup userGroup;
    @OneToMany(mappedBy = "spendingGroup", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    List<Cost> cost;

}
