package com.balance.balance.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private PasswordEncoder PasswordEncoderr;

    public void saveDTO(LoginDTO loginDTO) {
        Login login= convertDtoToEntity(loginDTO);
        login.setPassword(PasswordEncoderr.encode(loginDTO.getPassword()));;
        loginRepository.save(login);
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
