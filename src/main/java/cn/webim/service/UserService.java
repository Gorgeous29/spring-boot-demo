package cn.webim.service;

import cn.webim.domain.User;
import cn.webim.exception.LoginException;
import cn.webim.exception.UserExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public User login(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if(user == null) {
            LOGGER.warn("登录失败");
            throw new LoginException("用户名或密码错误");
        }
        return user;
    }

    public User create(User user) {
        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            LOGGER.warn("用户名已经存在");
            throw new UserExistException("用户已经存在");
        }
    }
}
