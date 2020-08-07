package com.learnspringboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	public static final String SESSION_USER_KEY = "_user";
	private String id;
	private String username;
	private String password;
	private String fullname;
	private String mobile;

	private Set<String> authorities;
}
