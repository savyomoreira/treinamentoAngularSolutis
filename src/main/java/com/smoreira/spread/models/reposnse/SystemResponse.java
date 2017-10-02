package com.smoreira.spread.models.reposnse;

import com.smoreira.spread.models.domain.System;
import com.smoreira.spread.models.domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class SystemResponse extends HashMap<String, Object> {
    public SystemResponse(System system){
        this.put("id", system.getId());
        this.put("nome", system.getName());
        this.put("sigla", system.getInitials());
        this.put("permission",getUserResponse(system.getUserList()));
    }

    private List<UserResponse> getUserResponse(List<User> userList){
        return userList.stream()
                .map(user -> new UserResponse(user))
                .collect(Collectors.toList());
    }
}
