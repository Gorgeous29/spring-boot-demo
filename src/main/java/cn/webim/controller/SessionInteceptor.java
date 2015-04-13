package cn.webim.controller;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

/**
 * session 过滤
 */
public class SessionInteceptor extends HandlerInterceptorAdapter {

private final static Set<String> excludePath = new HashSet<String>();

    static {
        excludePath.add("user/login");
        excludePath.add("user/logout");
        excludePath.add("/user");
        excludePath.add("/error");
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        if(excludePath.contains(request.getRequestURI())) {
            return true;
        }

        HttpSession session = request.getSession();
        if(session.getAttribute("user") != null) {
            return true;
        }

        response.sendRedirect("login.html");
        return false;
    }
}
