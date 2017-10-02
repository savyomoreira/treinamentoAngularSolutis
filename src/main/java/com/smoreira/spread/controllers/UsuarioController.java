package com.smoreira.spread.controllers;

import com.smoreira.spread.models.domain.AccessProfile;
import com.smoreira.spread.models.domain.Permission;
import com.smoreira.spread.models.domain.User;
import com.smoreira.spread.models.reposnse.UserResponse;
import com.smoreira.spread.repository.AccessProfileRepository;
import com.smoreira.spread.repository.PermissionRepository;
import com.smoreira.spread.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
//import com.smoreira.spread.models.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/v1/usuario")
@Transactional
public class UsuarioController {

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

        accessProfileRepository.findAll().forEach(data -> {
                data.setPermissionList(permissionRepository.findAll());
                accessProfileRepository.save(data);
        });

        usuarioRepository.findAll().forEach(data -> {
                data.setPerfilList(accessProfileRepository.findAll());
                usuarioRepository.save(data);
        });
    }

    @GetMapping
    public ResponseEntity<?> getAll(){

        List<UserResponse> usuarioList =
                usuarioRepository.findAll()
                        .parallelStream()
                        .map(data -> new UserResponse(data))
                        .collect(Collectors.toList());

        return new ResponseEntity<List<UserResponse>>(usuarioList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(User user){
        usuarioRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(Long userId){
        usuarioRepository.delete(userId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
