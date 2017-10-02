package com.smoreira.spread.models.reposnse;

import com.smoreira.spread.models.domain.AccessProfile;
import com.smoreira.spread.models.domain.Permission;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AccessProfileResponse extends HashMap<String, Object> {
    public AccessProfileResponse(AccessProfile perfil){
        this.put("id", perfil.getId());
        this.put("nome", perfil.getNomePerfil());
        this.put("permission",getPermission(perfil.getPermissionList()));
    }

    private List<PermissionResponse> getPermission(List<Permission> permissionList){
        List<PermissionResponse> perfiliResponceList =
                permissionList.stream().map(permission -> new PermissionResponse(permission)).collect(Collectors.toList());
        return perfiliResponceList;
    }
}
