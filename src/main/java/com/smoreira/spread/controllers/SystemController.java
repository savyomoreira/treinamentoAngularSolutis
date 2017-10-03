package com.smoreira.spread.controllers;

import com.smoreira.spread.models.domain.AccessProfile;
import com.smoreira.spread.models.domain.Permission;
import com.smoreira.spread.models.domain.System;
import com.smoreira.spread.models.domain.User;
import com.smoreira.spread.models.reposnse.PermissionResponse;
import com.smoreira.spread.models.reposnse.SystemResponse;
import com.smoreira.spread.models.reposnse.UserResponse;
import com.smoreira.spread.repository.AccessProfileRepository;
import com.smoreira.spread.repository.PermissionRepository;
import com.smoreira.spread.repository.SystemRepository;
import com.smoreira.spread.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/sistema")
public class SystemController {

    @Autowired
    private SystemRepository systemRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AccessProfileRepository accessProfileRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll(){

         List<SystemResponse> systemList = systemRepository
                        .findAll()
                        .parallelStream()
                        .map(data -> new SystemResponse(data))
                        .collect(Collectors.toList());

          return new ResponseEntity<List<SystemResponse>>(systemList, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<?> save(@RequestParam System permission){
        systemRepository.save(permission);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam Long systemId){
        systemRepository.delete(systemId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
