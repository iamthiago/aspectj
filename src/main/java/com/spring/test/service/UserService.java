package com.spring.test.service;

import com.spring.test.dto.UserDto;


public interface UserService {
	
	UserDto addUserBefore(UserDto userDto);
	UserDto addUserAfter(UserDto userDto);
	UserDto addUserAfterReturning(UserDto userDto);
	UserDto addUserAround(UserDto userDto);
	void addUserBeforeVoid(UserDto userDto);
}
