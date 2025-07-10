package com.coder.spring.repository;

import java.util.Optional;

import com.coder.spring.models.EmployeeRole;
import com.coder.spring.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

  Optional<Role> findByName(EmployeeRole name);
}
