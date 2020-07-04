package com.learnspringboot.exception;

public class UserNotExistException extends RuntimeException {

	public UserNotExistException() {
		super("User not Exist");
	}
}
