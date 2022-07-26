package com.balance.balance.entity.dto;

import com.balance.balance.entity.view.RegistryView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.sql.Time;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkDayDTO {

    private Date date;
    @NotEmpty
    private String type;
    @NotEmpty
    private double hours;
    @NotEmpty
    private String morning;
    @NotEmpty
    private String afternoon;

    private Boolean notes;
    RegistryDTO registryDTO;
}
