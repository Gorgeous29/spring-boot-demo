package cn.webim.controller;

import cn.webim.domain.User;
import cn.webim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public User register(@Valid User user) {
        return userService.create(user);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public User login(String username, String password, HttpSession session) {
        User user = userService.login(username, password);
        session.setAttribute("user", user);
        return user;
    }

    @RequestMapping(method = RequestMethod.GET, value = "logout")
    public String login(HttpSession session) {
        if(session != null) {
            session.invalidate();
        }
        return "redirect:/login.html";
    }
}
