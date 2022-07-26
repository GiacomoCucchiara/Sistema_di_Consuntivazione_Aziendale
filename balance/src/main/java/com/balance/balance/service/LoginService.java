package com.balance.balance.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balance.balance.entity.dto.LoginDTO;
import com.balance.balance.entity.model.Login;
import com.balance.balance.entity.view.LoginView;
import com.balance.balance.repository.LoginRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private ModelMapper modelMapper;

    public void saveDTO(LoginDTO loginDTO) {
        loginRepository.save(convertDtoToEntity(loginDTO));
    }
    public List<LoginView> listAll(){
        return loginRepository.findAll()
                .stream()
                .map(this::convertEntityToView)
                .collect(Collectors.toList());
    }
    private Login convertDtoToEntity(LoginDTO loginDTO) {
        Login login = this.modelMapper.map(loginDTO, Login.class);
        return login;

    }
    private LoginView convertEntityToView(Login login) {
        LoginView loginView = this.modelMapper.map(login,LoginView.class);
        return loginView;

    }
}
