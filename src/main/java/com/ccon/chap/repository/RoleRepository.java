package com.ccon.chap.repository;

import com.ccon.chap.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(value = "SELECT * FROM role WHERE role_name=?;", nativeQuery = true)
    Role findByRoleName(String roleName);
}
