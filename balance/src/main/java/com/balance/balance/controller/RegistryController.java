package com.balance.balance.controller;

import com.balance.balance.entity.dto.RegistryDTO;
import com.balance.balance.entity.view.RegistryView;
import com.balance.balance.service.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController

public class RegistryController {

    @Autowired
    private RegistryService registryService;

    @GetMapping("/registry")
    public ResponseEntity<List<RegistryView>> listView() {
        return new ResponseEntity<List<RegistryView>>(registryService.listAllViews(), HttpStatus.OK);
    }

    @GetMapping("/registry/group={id}")
    public ResponseEntity<List<RegistryView>> get(@PathVariable Long id) {
        return new ResponseEntity<>(registryService.getViewByUserGroupId(id), HttpStatus.OK);
    }

    @PostMapping("/registry")
    public ResponseEntity<RegistryView> add(@Valid @RequestBody RegistryDTO registryDTO) {
        try {
            RegistryView saved = registryService.saveDTO(registryDTO);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/registry/dell={id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
            registryService.deleteById(id);
            return new ResponseEntity<>( HttpStatus.ACCEPTED);
    }
}
