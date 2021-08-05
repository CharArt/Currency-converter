package com.ccon.chap.service;

import com.ccon.chap.configurations.JpaConfiguration;
import com.ccon.chap.entity.Role;
import com.ccon.chap.service.role.RoleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SqlGroup({@Sql("/sql/cleaning-data-base.sql"), @Sql("/sql/create-user-table.sql")})
@Sql(scripts = "/sql/cleaning-data-base.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@ContextConfiguration(classes = JpaConfiguration.class)
@WebAppConfiguration
@Transactional
public class RoleSeviceImplementTest {

    private final RoleService roleService;

    @Autowired
    public RoleSeviceImplementTest(RoleService roleService) {
        this.roleService = roleService;
    }

    @Test
    void findAllTest() {
        assertEquals(2, roleService.findAll().size());
    }

    @Test
    void findByRoleIdTest() {
        assertEquals(1, roleService.findByRoleId(1).getRole_id());
    }

    @Test
    void findByRoleNameTest() {
        assertEquals("ADMIN", roleService.findByRoleName("ADMIN").getRole_name());
    }

    @Test
    void createdNewRoleTest() {
        Role newRole = new Role();
        newRole.setRole_name("SUPERUSER");
        roleService.createdNewRole(newRole);
        assertEquals("SUPERUSER", roleService.findByRoleName("SUPERUSER").getRole_name());
    }
}
