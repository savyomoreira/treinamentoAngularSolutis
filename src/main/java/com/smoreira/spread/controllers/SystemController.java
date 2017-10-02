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

    @PostConstruct
    public void init(){
        dataMock();
    }

    private void dataMock(){
        accessProfileRepository.save(new AccessProfile("teste profile"));
        accessProfileRepository.save(new AccessProfile("teste profile2"));

        permissionRepository.save(new Permission("PermissionName"));
        permissionRepository.save(new Permission("PermissionName2"));

        usuarioRepository.save(new User("teste", "teste"));
        usuarioRepository.save(new User("teste1", "teste"));
        usuarioRepository.save(new User("teste2", "teste"));
        usuarioRepository.save(new User("teste3", "teste"));

        systemRepository.save(new System("Sistema Teste", "ST"));
        systemRepository.save(new System("Sistema Teste2", "ST2"));

        accessProfileRepository.findAll().forEach(data -> {
            data.setPermissionList(permissionRepository.findAll());
            accessProfileRepository.save(data);
        });

        usuarioRepository.findAll().forEach(data -> {
            data.setPerfilList(accessProfileRepository.findAll());
            usuarioRepository.save(data);
        });

        systemRepository.findAll().forEach(data -> {
            data.setUserList(usuarioRepository.findAll());
            systemRepository.save(data);
        });
    }

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
    public ResponseEntity<?> save(System permission){
        systemRepository.save(permission);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(Long systemId){
        systemRepository.delete(systemId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
