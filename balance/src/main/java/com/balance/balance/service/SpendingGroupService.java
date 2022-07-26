package com.balance.balance.service;

import com.balance.balance.entity.dto.SpendingGroupDTO;
import com.balance.balance.entity.model.SpendingGroup;
import com.balance.balance.entity.model.WorkDay;
import com.balance.balance.entity.view.SpendingGroupView;
import com.balance.balance.repository.SpendingGroupRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SpendingGroupService {

    @Autowired
    private SpendingGroupRepository spendingGroupRepository;
    @Autowired
    private ModelMapper modelMapper;
    public List<SpendingGroupView> listAllView() {
        return spendingGroupRepository.findAll()
                .stream()
                .map(this::EntityToView)
                .collect(Collectors.toList());
    }

    private SpendingGroupView EntityToView(SpendingGroup spendingGroup){
        SpendingGroupView spendingGroupView = this.modelMapper.map(spendingGroup, SpendingGroupView.class);
        return spendingGroupView;
    }

    public void saveDTO(SpendingGroupDTO spendingGroupDTO) {
        SpendingGroup spendingGroup= DtoToEntity(spendingGroupDTO);
        spendingGroupRepository.save(spendingGroup);
    }
    private SpendingGroup DtoToEntity(SpendingGroupDTO spendingGroupDTO){
        SpendingGroup spendingGroup = this.modelMapper.map(spendingGroupDTO, SpendingGroup.class);
        return  spendingGroup;
    }
}
