package com.balance.balance.entity.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.rmi.registry.Registry;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class WorkDayView {

    private Date date;
    private String type;
    private double hours;
    private String morning;
    private String afternoon;
    private String confirm;
    private Boolean notes;
    RegistryView registryViews;
}
