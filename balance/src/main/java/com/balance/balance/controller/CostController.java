package com.balance.balance.controller;


import com.balance.balance.entity.dto.CostDTO;
import com.balance.balance.entity.model.Cost;
import com.balance.balance.entity.view.CostView;
import com.balance.balance.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CostController {

    @Autowired
    private CostService costService;

    @GetMapping("/cost")
    public ResponseEntity<List<CostView>> listView (){
        return new ResponseEntity<List<CostView>>(costService.listAllView(), HttpStatus.OK);
    }
    @PostMapping("/cost")
    public ResponseEntity<?> add(@RequestBody CostDTO costDTO){
        try{
            costService.saveDTO(costDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.FORBIDDEN);
        }
    }
}
