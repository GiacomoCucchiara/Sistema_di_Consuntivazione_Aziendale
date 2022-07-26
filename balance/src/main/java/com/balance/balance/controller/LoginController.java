package com.balance.balance.controller;

import com.balance.balance.entity.model.Login;
import com.balance.balance.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

 /*   @GetMapping("/loginView")
    public ResponseEntity<List<Login>> list(){
       return ResponseEntity<>(LoginService.ListAll(), HttpStatus.OK)
    }*/
}
