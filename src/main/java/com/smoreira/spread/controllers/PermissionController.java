package com.smoreira.spread.controllers;

import com.smoreira.spread.models.domain.AccessProfile;
import com.smoreira.spread.models.domain.Permission;
import com.smoreira.spread.models.reposnse.AccessProfileResponse;
import com.smoreira.spread.models.reposnse.PermissionResponse;
import com.smoreira.spread.repository.AccessProfileRepository;
import com.smoreira.spread.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//import com.smoreira.spread.models.domain.User;

@RestController
@RequestMapping("/v1/permission")
public class PermissionController {

    @Autowired
    private PermissionRepository permissionRepository;

    @PostConstruct
    public void init(){

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll(){

        List<PermissionResponse> permissionResponseList = permissionRepository
                        .findAll()
                        .parallelStream()
                        .map(data -> new PermissionResponse(data))
                        .collect(Collectors.toList());

       return new ResponseEntity<List<PermissionResponse>>(permissionResponseList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(Permission permission){
        permissionRepository.save(permission);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(Long permissionId){
        permissionRepository.delete(permissionId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
