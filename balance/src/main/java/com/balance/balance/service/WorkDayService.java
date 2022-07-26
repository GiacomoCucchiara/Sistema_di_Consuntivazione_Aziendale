package com.balance.balance.service;


import com.balance.balance.entity.dto.RegistryDTO;
import com.balance.balance.entity.dto.WorkDayDTO;
import com.balance.balance.entity.model.Registry;
import com.balance.balance.entity.model.WorkDay;
import com.balance.balance.entity.view.RegistryView;
import com.balance.balance.entity.view.WorkDayView;
import com.balance.balance.repository.RegistryRepository;
import com.balance.balance.repository.WorkDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class WorkDayService {

    @Autowired
    WorkDayRepository workDayRepository;
    @Autowired
    RegistryRepository registryRepository;

    public void saveDTO(WorkDayDTO workDayDTO){
        WorkDay workDay = convertDtoToEntity(workDayDTO);
        Registry registry  = convertRegistry(workDayDTO.getRegistryDTO());
        workDayRepository.save(convertDtoToEntity(workDayDTO));
    }




    public List<WorkDayView> listAllViews() {
        return workDayRepository.findAll()
                .stream()
                .map(this::convertEntityToView)
                .collect(Collectors.toList());
    }



    private WorkDay convertDtoToEntity(WorkDayDTO workDayDTO) {
        WorkDay workDay = new WorkDay();
        workDay.setDate(workDayDTO.getDate());
        workDay.setType(workDayDTO.getType());
        workDay.setHours(workDayDTO.getHours());
        workDay.setMorning(workDayDTO.getMorning());
        workDay.setAfternoon(workDayDTO.getAfternoon());
        workDay.setNotes(workDayDTO.getNotes());
        return workDay;
    }
    private WorkDayView convertEntityToView(WorkDay workDay) {
        WorkDayView workDayView = new WorkDayView();
        workDayView.setDate(workDay.getDate());
        workDayView.setType(workDay.getType());
        workDayView.setHours(workDay.getHours());
        workDayView.setMorning(workDay.getMorning());
        workDayView.setAfternoon(workDay.getAfternoon());
        workDayView.setNotes(workDay.getNotes());
        return workDayView;
    }
    public Registry convertRegistry(RegistryDTO registryDTO){
        Registry registry=new Registry();
        registry.setName(registryDTO.getName());
        registry.setSurname(registryDTO.getSurname());
        return registry;
    }

}
