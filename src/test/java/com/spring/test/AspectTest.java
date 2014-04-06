package com.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.test.dto.UserDto;
import com.spring.test.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class AspectTest {
	
	@Autowired private UserService userService;
	
	@Test
	public void aspectBeforeTest() {
		userService.addUserBefore(new UserDto(new Long(1), "thiago", "thiago@gmail.com"));
	}
	
	@Test
	public void aspectAfterTest() {
		userService.addUserAfter(new UserDto(new Long(1), "thiago", "thiago@gmail.com"));
	}
	
	@Test
	public void aspectAfterReturningTest() {
		userService.addUserAfterReturning(new UserDto(new Long(1), "thiago", "thiago@gmail.com"));
	}
	
	@Test
	public void aspectAroundTest() {
		userService.addUserAround(new UserDto(new Long(1), "thiago", "thiago@gmail.com"));
	}
}