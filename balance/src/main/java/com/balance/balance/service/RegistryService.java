package com.balance.balance.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balance.balance.entity.dto.LoginDTO;
import com.balance.balance.entity.dto.RegistryDTO;
import com.balance.balance.entity.dto.UserGroupDTO;
import com.balance.balance.entity.model.Login;
import com.balance.balance.entity.model.Registry;
import com.balance.balance.entity.model.UserGroup;

import com.balance.balance.entity.view.RegistryView;

import com.balance.balance.repository.LoginRepository;
import com.balance.balance.repository.RegistryRepository;
import com.balance.balance.repository.UserGroupRepository;

@Service
@Transactional
public class RegistryService {

    @Autowired
    private RegistryRepository registryRepository;
    @Autowired
    private UserGroupRepository userGroupRepository;
    @Autowired
    private LoginRepository loginRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    public void saveDTO (RegistryDTO registryDTO){
        Registry registry = convertDtoToEntity(registryDTO);
        checkGroup(registryDTO,registry);
        Login login = convertLogin(registryDTO.getLoginDTO());
        registry.setLogin(login);
        registryRepository.save(registry);
    }

    public List<RegistryView> listAllViews() {
        return registryRepository.findAll()
                .stream()
                .map(this::convertEntityToView)
                .collect(Collectors.toList());

    }

    public void getById(Long id) {
        registryRepository.findById(id);
    }

    public String getByName(String name) {
        return registryRepository.findByName(name);
    }

    public List<Registry> getBySurname(String surname) {
        return registryRepository.findBySurname(surname);
    }

    public List<RegistryView> getViewByUserGroupId(Long id) {
        return registryRepository.findByUserGroupId(id)
                .stream()
                .map(this::convertEntityToView)
                .collect(Collectors.toList());
    }

    private Registry convertDtoToEntity(RegistryDTO registryDTO) {
        Registry registry = new Registry();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
         this.modelMapper.map(registryDTO, registry);
        return registry;

    }

    private RegistryView convertEntityToView(Registry registry) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        RegistryView registryView = this.modelMapper.map(registry,RegistryView.class);
        return registryView;

    }

    public UserGroup convertUserGroup(UserGroupDTO userGroupDTO) {
        UserGroup userGroup = this.modelMapper.map(userGroupDTO, UserGroup.class);
        return userGroup;
    }

    public Boolean checkGroup(RegistryDTO registryDTO, Registry registry){
        if(!userGroupRepository.findAll().contains(registryDTO.getUserGroupDTO().getName())){
            UserGroup userGroup = convertUserGroup(registryDTO.getUserGroupDTO());
            userGroupRepository.save(userGroup);
            registry.setUsergroup(convertUserGroup(registryDTO.getUserGroupDTO()));
        }else{
            registry.setUsergroup(convertUserGroup(registryDTO.getUserGroupDTO()));
        }
        return null;
    }


    public Login convertLogin(LoginDTO loginDTO) {
        Login login = this.modelMapper.map(loginDTO, Login.class);
        loginRepository.save(login);
        return login;
    }

}
