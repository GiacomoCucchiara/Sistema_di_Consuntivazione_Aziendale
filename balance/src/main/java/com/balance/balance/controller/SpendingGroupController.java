package com.balance.balance.controller;

import com.balance.balance.entity.dto.RegistryDTO;
import com.balance.balance.entity.dto.SpendingGroupDTO;
import com.balance.balance.entity.model.SpendingGroup;
import com.balance.balance.entity.view.CostView;
import com.balance.balance.entity.view.SpendingGroupView;
import com.balance.balance.service.SpendingGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SpendingGroupController {
    @Autowired
    private SpendingGroupService spendingGroupService;

    @GetMapping("/cost")
    public ResponseEntity<List<SpendingGroupView>> listView (){
        return new ResponseEntity<>(spendingGroupService.listAllView(), HttpStatus.OK);
    }
    @PostMapping("/cost")
    public ResponseEntity<?> add(@Valid @RequestBody SpendingGroupDTO spendingGroupDTO) {
        try {
            spendingGroupService.saveDTO(spendingGroupDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.FORBIDDEN);
        }
    }


}
