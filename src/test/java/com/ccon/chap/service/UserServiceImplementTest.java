package com.ccon.chap.service;

import com.ccon.chap.configurations.JpaConfiguration;
import com.ccon.chap.entity.Role;
import com.ccon.chap.entity.User;
import com.ccon.chap.service.role.RoleService;
import com.ccon.chap.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SqlGroup({@Sql("/sql/cleaning-data-base.sql"), @Sql("/sql/create-user-table.sql")})
@Sql(scripts = "/sql/cleaning-data-base.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@ContextConfiguration(classes = JpaConfiguration.class)
@WebAppConfiguration
@Transactional
public class UserServiceImplementTest {

    private final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public UserServiceImplementTest(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Test
    void findByUserIdTest() {
        assertEquals(1, userService.findByUserId(1L).getUser_id());
    }

    @Test
    void findByUserLoginTest() {
        assertEquals("Artem", userService.findByUserLogin("CharArtPav").getUser_name());
    }

    @Test
    void findByUserOfBirthTest() {
        Calendar calendar = new GregorianCalendar(1993, Calendar.MARCH, 26);
        LocalDateTime dateBirthday = LocalDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault());
        List<User> userList = userService.findByUserOfBirth(dateBirthday);
        for (User u : userList) {
            assertEquals(dateBirthday.format(TIME_FORMATTER), u.getUser_of_birth().format(TIME_FORMATTER));
        }
    }

    @Test
    void findByUserActiveTest() {
        List<User> userList = userService.findByUserActive(true);
        for (User u : userList) {
            assertTrue(u.isUser_is_active());
        }
    }

    @Test
    void findByUserCreatedAtTest() {
        Calendar calendar = new GregorianCalendar(2020, Calendar.DECEMBER, 30);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault());
        List<User> userList = userService.findByUserCreatedAt(localDateTime);
        for (User u : userList) {
            assertEquals(localDateTime.format(TIME_FORMATTER), u.getUser_created_at().format(TIME_FORMATTER));
        }
    }

    @Test
    void createdNewUserTest() {
        Role role = roleService.findByRoleId(1);
        List<Role> roleList = new LinkedList<>();
        roleList.add(role);

        Calendar calendar = new GregorianCalendar(1993, Calendar.MARCH, 26);
        LocalDate dateBirthday = LocalDate.ofInstant(calendar.toInstant(), ZoneId.systemDefault());

        User userTest1 = new User();
        userTest1.setUser_login("Test11");
        userTest1.setUser_name("Test11");
        userTest1.setUser_surname("Test11");
        userTest1.setUser_patronymic("Test11");
        userTest1.setUser_email("Test11@email.com");
        userTest1.setUser_password("Test11");
        userTest1.setUser_of_birth(dateBirthday);
        userTest1.setUser_created_at(LocalDateTime.now());
        userTest1.setUser_is_active(true);
        userTest1.setRole(roleList);

        userService.createdNewUser(userTest1);
        assertEquals(11, userService.findAll().size());
    }

    @Test
    void deleteUserByIdTest() {
        userService.deleteUserById(1L);
        assertEquals(9, userService.findAll().size());
    }

    @Test
    void deleteUserByLoginTest () {
        userService.deleteUserByLogin("CharArtPav");
        assertEquals(9, userService.findAll().size());
    }

    @Test
    void findByUserEmailTest () {
        User  testUser = userService.findByUserEmail("ArtPavChar@gmail.com");
        assertEquals(1, testUser.getUser_id());
    }

    @Test
    void isPresentLoginTest () {
                assertTrue(userService.isPresentLogin("CharArtPav"));
    }

    @Test
    void isPersentEmailTest(){
        assertTrue(userService.isPresentEmail("ArtPavChar@gmail.com"));
    }
}
