package com.learnspringboot.controller;

import javax.servlet.http.HttpSession;

import com.learnspringboot.service.AuthenticationService;
import com.learnspringboot.bean.UserDto;
import com.learnspringboot.bean.AuthenticationRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SessionController {

    @Autowired
    AuthenticationService authenticationService;

    @GetMapping("/session")
    public String sessionLogin() {
        return "sessionLoginDemo.html";
    }

    @GetMapping("/sessionlogout")
    @ResponseBody
    public String sessionLogout(HttpSession httpSession) {
        httpSession.invalidate();
        return "Logout success!!!";
    }

    @PostMapping("/doSession")
    @ResponseBody
    public String authenticationLogin(AuthenticationRequest authenticationRequest, HttpSession httpSession) {
        System.out.println(authenticationRequest.getUsername());
        UserDto userDto = authenticationService.authentication(authenticationRequest);
        httpSession.setAttribute(UserDto.SESSION_USER_KEY, userDto);
        return userDto.getUsername() + " Login Success!!";
    }

    @GetMapping("/r/r1")
    @ResponseBody
    public String checkSessioned1(HttpSession httpSession) {
        String fullname = null;
        Object object = httpSession.getAttribute(UserDto.SESSION_USER_KEY);
        if ( object == null ) {
            fullname = "no session";
        } else {
            UserDto userDto = (UserDto) object;
            fullname = userDto.getUsername();
        }
        return fullname;
    }

    @GetMapping("/r/r2")
    @ResponseBody
    public String checkSessioned2(HttpSession httpSession) {
        String fullname = null;
        Object object = httpSession.getAttribute(UserDto.SESSION_USER_KEY);
        if ( object == null ) {
            fullname = "no session";
        } else {
            UserDto userDto = (UserDto) object;
            fullname = userDto.getUsername();
        }
        return fullname;
    }
}
