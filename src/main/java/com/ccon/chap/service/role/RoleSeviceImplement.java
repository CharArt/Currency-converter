package com.ccon.chap.service.role;

import com.ccon.chap.entity.Role;
import com.ccon.chap.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleSeviceImplement implements RoleService {

    private final RoleRepository repository;

    @Autowired
    public RoleSeviceImplement(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public Role findByRoleId(int roleId) {
        return repository.getOne(roleId);
    }

    @Override
    public Role findByRoleName(String roleName) {
        return repository.findByRoleName(roleName);
    }

    @Override
    public void createdNewRole(Role newRole) {
        repository.save(newRole);
    }
}
