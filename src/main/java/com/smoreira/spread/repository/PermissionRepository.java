package com.smoreira.spread.repository;

import com.smoreira.spread.models.domain.AccessProfile;
import com.smoreira.spread.models.domain.Permission;
import com.smoreira.spread.models.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PermissionRepository extends JpaRepository<Permission, Long>,
											JpaSpecificationExecutor<Permission> {



}
