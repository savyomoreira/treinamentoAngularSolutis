package com.smoreira.spread.controllers;

import com.smoreira.spread.models.domain.AccessProfile;
import com.smoreira.spread.models.domain.User;
import com.smoreira.spread.models.reposnse.AccessProfileResponse;
import com.smoreira.spread.models.reposnse.UserResponse;
import com.smoreira.spread.repository.AccessProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//import com.smoreira.spread.models.domain.User;

@RestController
@RequestMapping("/v1/perfil")
@Transactional
public class ProfileController {

    @Autowired
    private AccessProfileRepository profileRepository;

    @PostConstruct
    public void init(){

    }

    @GetMapping
    public ResponseEntity<?> getAll(){

        List<AccessProfileResponse> perfilList =
                profileRepository.findAll()
                        .parallelStream()
                        .map(data -> new AccessProfileResponse(data))
                        .collect(Collectors.toList());

        return new ResponseEntity<List<AccessProfileResponse>>(perfilList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody AccessProfile profile){
        profileRepository.save(profile);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping({"profileId"})
    public ResponseEntity<?> delete(@PathVariable Long profileId){
        profileRepository.delete(profileId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
