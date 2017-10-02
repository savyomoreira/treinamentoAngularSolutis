package com.smoreira.spread.repository;

import com.smoreira.spread.models.domain.AccessProfile;
import com.smoreira.spread.models.domain.System;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SystemRepository extends JpaRepository<System, Long>,
											JpaSpecificationExecutor<System> {


}
