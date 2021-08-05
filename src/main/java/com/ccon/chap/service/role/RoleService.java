package com.ccon.chap.service.role;

import com.ccon.chap.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role findByRoleId(int roleId);

    Role findByRoleName(String roleName);

    void createdNewRole(Role newRole);
}