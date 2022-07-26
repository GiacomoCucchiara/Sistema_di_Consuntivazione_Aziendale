package com.balance.balance.entity.dto;

import com.balance.balance.entity.view.RegistryView;
import lombok.*;

import javax.persistence.SecondaryTable;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.sql.Time;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
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
    private List<DtoId> registries;
}
