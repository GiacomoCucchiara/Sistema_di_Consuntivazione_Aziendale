package com.balance.balance.controller;

import java.util.List;

import com.balance.balance.entity.dto.UserGroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.balance.balance.entity.view.UserGroupView;
import com.balance.balance.service.UserGroupService;

@RestController
public class UserGroupController {
    @Autowired
    private UserGroupService userGroupservice;

    @GetMapping("/usergroup")
    public ResponseEntity<List<UserGroupView>> list() {
        return new ResponseEntity<>(userGroupservice.listAllView(), HttpStatus.OK);
    }

    // NON FUNZIONA
    @GetMapping("/usergroup/{name}")
    public ResponseEntity<List<UserGroupView>> get(@PathVariable String name) {
        return new ResponseEntity<>(userGroupservice.getByName(name), HttpStatus.OK);
    }

    @PostMapping("/usergroup")
    public ResponseEntity<?> add(@RequestBody UserGroupDTO userGroupDTO) {
        try {
            userGroupservice.saveDTO(userGroupDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e , HttpStatus.FORBIDDEN);
        }
    }

}
