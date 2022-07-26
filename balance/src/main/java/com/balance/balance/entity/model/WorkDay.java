package com.balance.balance.entity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "workDay")
public class WorkDay {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private Date date;

    private String type;

    private double hours;

    private String morning;

    private String afternoon;
    private String confirm;
    private Boolean notes;
    @ManyToMany(mappedBy = "workDayList")
    List<Registry> registryList = new ArrayList<>();



}
