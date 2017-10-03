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
    public ResponseEntity<?> save(@RequestBody User user){
        usuarioRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam Long userId){
        usuarioRepository.delete(userId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
