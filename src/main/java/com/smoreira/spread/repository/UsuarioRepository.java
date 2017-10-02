package com.smoreira.spread.repository;

import com.smoreira.spread.models.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UsuarioRepository extends JpaRepository<User, Long>,
											JpaSpecificationExecutor<User> {



}
