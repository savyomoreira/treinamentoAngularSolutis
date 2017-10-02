package com.smoreira.spread.models.reposnse;

import com.smoreira.spread.models.domain.AccessProfile;
import com.smoreira.spread.models.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class UserResponse extends HashMap<String, Object> {

    public UserResponse(User user){
        this.put("id", user.getId());
        this.put("nome", user.getName());
        this.put("email", user.getEmail());
        this.put("telefone", user.getTelefone());
        this.put("profile", getAccessProfile(user.getPerfilList()));
    }

    private List<AccessProfileResponse> getAccessProfile(List<AccessProfile> perfilList){
        return perfilList.stream()
                .map(accessProfile -> new AccessProfileResponse(accessProfile))
                .collect(Collectors.toList());
    }
}
