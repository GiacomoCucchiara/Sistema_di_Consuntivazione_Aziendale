package com.balance.balance.service;

import com.balance.balance.entity.dto.RegistryDTO;
import com.balance.balance.entity.dto.SpendingGroupDTO;
import com.balance.balance.entity.dto.UserGroupDTO;
import com.balance.balance.entity.model.Registry;
import com.balance.balance.entity.model.SpendingGroup;
import com.balance.balance.entity.model.UserGroup;
import com.balance.balance.entity.model.WorkDay;
import com.balance.balance.entity.view.SpendingGroupView;
import com.balance.balance.repository.SpendingGroupRepository;
import com.balance.balance.repository.UserGroupRepository;
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
    private UserGroupRepository userGroupRepository;

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
        checkGroup(spendingGroupDTO,spendingGroup);
        spendingGroupRepository.save(spendingGroup);
    }
    private SpendingGroup DtoToEntity(SpendingGroupDTO spendingGroupDTO){
        SpendingGroup spendingGroup = this.modelMapper.map(spendingGroupDTO, SpendingGroup.class);
        return  spendingGroup;
    }

    public UserGroup convertUserGroup(UserGroupDTO userGroupDTO) {
        UserGroup userGroup = this.modelMapper.map(userGroupDTO, UserGroup.class);
        return userGroup;}
    public Boolean checkGroup(SpendingGroupDTO spendingGroupDTO,SpendingGroup spendingGroup){
        if(!userGroupRepository.findAll().contains(spendingGroupDTO.getUserGroupDTO().getName())){
            UserGroup userGroup = convertUserGroup(spendingGroupDTO.getUserGroupDTO());
            userGroupRepository.save(userGroup);
            spendingGroup.setUserGroup(convertUserGroup(spendingGroupDTO.getUserGroupDTO()));

        }else{
            spendingGroup.setUserGroup(convertUserGroup(spendingGroupDTO.getUserGroupDTO()));
        }
        return null;
    }
}
