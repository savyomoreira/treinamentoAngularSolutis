package com.smoreira.spread.repository;

import com.smoreira.spread.models.domain.AccessProfile;
import com.smoreira.spread.models.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccessProfileRepository extends JpaRepository<AccessProfile, Long>,
											JpaSpecificationExecutor<AccessProfile> {

	@Query("select profile from AccessProfile profile " +
			" join fetch profile.permissionList")
	List<AccessProfile> fetchPermissionList();
}
