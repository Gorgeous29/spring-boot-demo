package cn.webim.service;

import cn.webim.Application;
import cn.webim.domain.User;
import cn.webim.exception.LoginException;
import cn.webim.exception.UserExistException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testLogin() throws Exception {
        User user = new User();
        user.setUsername("tao2");
        user.setPassword("123g3t");
        userService.create(user);

        userService.login("tao2", "123g3t");
    }


    @Test(expected = LoginException.class)
    public void testLoginError() throws Exception {
        User user = new User();
        user.setUsername("tao3");
        user.setPassword("123g3t");
        userService.create(user);

        userService.login("tao3", "123");
    }

    @Test(expected = UserExistException.class)
    public void testCreate() throws Exception {
        User user = new User();
        user.setUsername("tao");
        user.setPassword("222");

        userService.create(user);

        user = new User();
        user.setUsername("tao");
        user.setPassword("222");

        userService.create(user);
    }
}