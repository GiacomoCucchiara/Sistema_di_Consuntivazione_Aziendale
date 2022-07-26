package com.balance.balance.controller;


import com.balance.balance.entity.dto.WorkDayDTO;
import com.balance.balance.entity.view.WorkDayView;
import com.balance.balance.service.WorkDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class WorkDayController {
    @Autowired
    private WorkDayService workDayService;

    @GetMapping("/workday")
    public ResponseEntity<List<WorkDayView>> listAll(){
        return new ResponseEntity<>(workDayService.listAllViews(), HttpStatus.OK);
    }
    @PostMapping("/workday")
    public ResponseEntity<?> add(@RequestBody WorkDayDTO workDayDTO){
        try{
            workDayService.saveDTO(workDayDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.FORBIDDEN);
        }
    }


}
