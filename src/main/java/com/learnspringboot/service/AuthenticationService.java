package com.learnspringboot.service;

import com.learnspringboot.bean.AuthenticationRequest;
import com.learnspringboot.bean.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

@Service
public class AuthenticationService {
    public UserDto authentication(AuthenticationRequest authenticationRequest) {
        if ( authenticationRequest == null ||
                StringUtils.isEmpty(authenticationRequest.getUsername()) ||
                StringUtils.isEmpty(authenticationRequest.getPassword()) )
        {
            throw new RuntimeException("Username or Password is empty");
        }

        UserDto user = getUserDto(authenticationRequest.getUsername());
        if ( user == null ) throw new RuntimeException("Can not find user");
        if ( ! authenticationRequest.getPassword().equals(user.getPassword()) ) {
            throw new RuntimeException("Password error");
        }
        return user;
    }

    private UserDto getUserDto(String username) {
        return userMap.get(username);
    }

    private Map<String, UserDto> userMap = new HashMap<>();
    {
        Set<String> authorities1 = new HashSet<String>();
        authorities1.add("p1");
        Set<String> authorities2 = new HashSet<String>();
        authorities2.add("p2");

        userMap.put("messi", new UserDto("1010", "messi", "123", "MESSI", "133443", authorities1));
        userMap.put("kobe", new UserDto("1011", "kobe", "456", "KOBE", "144553", authorities2));
    }
}
