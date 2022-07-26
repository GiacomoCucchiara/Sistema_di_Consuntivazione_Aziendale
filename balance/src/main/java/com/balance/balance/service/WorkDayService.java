package com.balance.balance.service;


import com.balance.balance.entity.dto.RegistryDTO;
import com.balance.balance.entity.dto.WorkDayDTO;
import com.balance.balance.entity.model.Login;
import com.balance.balance.entity.model.Registry;
import com.balance.balance.entity.model.WorkDay;
import com.balance.balance.entity.view.RegistryView;
import com.balance.balance.entity.view.WorkDayView;
import com.balance.balance.repository.RegistryRepository;
import com.balance.balance.repository.WorkDayRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class WorkDayService {

    @Autowired
    private WorkDayRepository workDayRepository;
    @Autowired
    private RegistryRepository registryRepository;
    @Autowired private ModelMapper modelMapper;



    public void saveDTO(WorkDayDTO workDayDTO){
        WorkDay workday= convertDtoToEntity(workDayDTO);
        workDayRepository.save(workday);
    }


    public List<WorkDayView> listAllViews() {
        return workDayRepository.findAll()
                .stream()
                .map(this::convertEntityToView)
                .collect(Collectors.toList());
    }



    private WorkDay convertDtoToEntity(WorkDayDTO workDayDTO) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        WorkDay workDay = this.modelMapper.map(workDayDTO, WorkDay.class);
        return workDay;
    }
    private WorkDayView convertEntityToView(WorkDay workDay) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        WorkDayView workDayView = this.modelMapper.map(workDay, WorkDayView.class);
        return workDayView;
    }
    public Registry convertRegistry(RegistryDTO registryDTO){
        Registry registry=this.modelMapper.map(registryDTO, Registry.class);
        return registry;
    }



}
