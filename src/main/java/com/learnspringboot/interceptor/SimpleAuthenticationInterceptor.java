package com.learnspringboot.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.IOException;

import com.learnspringboot.bean.UserDto;

@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object object = request.getSession().getAttribute(UserDto.SESSION_USER_KEY);
        if ( object == null ) {
            writeContent(response, "Please Login");
            return false;
        }

        UserDto userDto = (UserDto) object;
        String requestURI = request.getRequestURI();
        if ( userDto.getAuthorities().contains("p1") && requestURI.contains("/r/r1") ) {
            return true;
        }
        if ( userDto.getAuthorities().contains("p2") && requestURI.contains("/r/r2") ) {
            return true;
        }

        writeContent(response, "You do not have right to access");

        return false;
    }

    private void writeContent(HttpServletResponse response, String info) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.print(info);
        writer.close();
        // Do not reset buffer at here it will creates an exception in jetty.
        // response.resetBuffer();
    }
}
