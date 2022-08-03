package com.balance.balance.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.balance.balance.entity.dto.RegistryDTO;
import com.balance.balance.entity.model.Registry;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balance.balance.entity.dto.UserGroupDTO;
import com.balance.balance.entity.model.UserGroup;

import com.balance.balance.entity.view.UserGroupView;
import com.balance.balance.repository.UserGroupRepository;

@Service
@Transactional
public class UserGroupService {
    @Autowired
    private  UserGroupRepository userGroupRepository;
    @Autowired
    private ModelMapper modelMapper;
    public UserGroupView saveDTO(UserGroupDTO userGroupDTO) {
            UserGroup saved = new UserGroup();
        if(!userGroupRepository.findAll().contains(userGroupDTO.getName())){
            saved = userGroupRepository.save(convertDtoToEntity(userGroupDTO));
        } else{
            return userGroupRepository.findByName(userGroupDTO.getName());
        }
        return convertEntityToView(saved);
    }
    public void delete(Long id){
        userGroupRepository.deleteById(id);
    }


    public List<UserGroupView> listAllView() {
        return userGroupRepository.findAll()
                .stream()
                .map(this::convertEntityToView)
                .collect(Collectors.toList());
    }



    public Optional<UserGroup> getById(Long id) {
        return userGroupRepository.findById(id);
    }

    public List<UserGroupView> getByName(String name) {
        return userGroupRepository.findOneByNameEquals(name)
                .stream()
                .collect(Collectors.toList());
    }

    private UserGroup convertDtoToEntity(UserGroupDTO userGroupDTO) {
        UserGroup userGroup = this.modelMapper.map(userGroupDTO, UserGroup.class);
       // userGroup.setId(userGroupDTO.getId());
        return userGroup;
    }
    private UserGroupDTO convertEntityToDTO (UserGroup userGroup) {
        UserGroupDTO userGroupDTO = this.modelMapper.map(userGroup, UserGroupDTO.class);
        // userGroup.setId(userGroupDTO.getId());
        return userGroupDTO;
    }

    private UserGroupView convertEntityToView(UserGroup userGroup) {
        UserGroupView userGroupView = this.modelMapper.map(userGroup, UserGroupView.class);
        return userGroupView;
    }


}
