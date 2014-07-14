package com.aop.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aop.Application;
import com.aop.dto.UserDto;
import com.aop.service.UserService;

/**
 * @author thiago
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
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
	
	@Test
	public void aspectBeforeVoidTest() {
		userService.addUserBeforeVoid(new UserDto(new Long(1), "thiago", "thiago@gmail.com"));
	}
}