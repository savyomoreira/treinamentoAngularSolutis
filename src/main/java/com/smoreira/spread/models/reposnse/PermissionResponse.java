package com.smoreira.spread.models.reposnse;

import com.smoreira.spread.models.domain.AccessProfile;
import com.smoreira.spread.models.domain.Permission;

import java.util.HashMap;

public class PermissionResponse extends HashMap<String, Object> {
    public PermissionResponse(Permission permission){
        this.put("id", permission.getId());
        this.put("nome", permission.getPermissionName());
    }
}
