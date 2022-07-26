package com.balance.balance.service;

import com.balance.balance.entity.dto.CostDTO;
import com.balance.balance.entity.model.Cost;
import com.balance.balance.entity.view.CostView;
import com.balance.balance.repository.CostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CostService {

    @Autowired
    private CostRepository costRepository;
    @Autowired
    private ModelMapper modelMapper;


    public void saveDTO(CostDTO costDTO) {
        Cost cost = DTOToEntity(costDTO);
        costRepository.save(cost);
    }
    public List<CostView> listAllView() {
        return costRepository.findAll()
                .stream()
                .map(this::convertToView)
                .collect(Collectors.toList());
    }

    private CostView convertToView(Cost cost){
        CostView costView= this.modelMapper.map(cost,CostView.class);
        return costView;
    }

    private Cost DTOToEntity(CostDTO costDTO){
        Cost cost = this.modelMapper.map(costDTO, Cost.class);
        return cost;
    }
}
