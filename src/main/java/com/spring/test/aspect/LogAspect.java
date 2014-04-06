package com.spring.test.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.test.dto.UserDto;

@Aspect
public class LogAspect {
	
	private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
	
	@Before("execution(* com.spring.test.service.UserService.addUserBefore(..)) && args(userDto)")
	public void logBefore(JoinPoint joinPoint, UserDto userDto) throws Throwable {
		log.info("logBefore() is running!");
		log.info("method: " + joinPoint.getSignature().getName());
		log.info("params: " + Arrays.toString(joinPoint.getArgs()));
		
		log.info("username: " + userDto.getUsername());
		log.info("email: " + userDto.getEmail());
	}
	
	@After("execution(* com.spring.test.service.UserService.addUserAfter(..)) && args(userDto)")
	public void logAfter(JoinPoint joinPoint, UserDto userDto) throws Throwable {
		log.info("logAfter() is running!");
		log.info("method: " + joinPoint.getSignature().getName());
		log.info("params: " + Arrays.toString(joinPoint.getArgs()));
		
		log.info("username: " + userDto.getUsername());
		log.info("email: " + userDto.getEmail());
	}
	
	@AfterReturning(
			pointcut="execution(* com.spring.test.service.UserService.addUserAfterReturning(..))",
			returning="userDto")
	public void logAfterReturning(JoinPoint joinPoint, UserDto userDto) {
		log.info("logAfterReturning() is running!");
		log.info("username: " + userDto.getUsername());
		log.info("email: " + userDto.getEmail());
	}
	
	@Around("execution(* com.spring.test.service.UserService.addUserAround(..)) && args(userDto)")
	public void logAround(ProceedingJoinPoint joinPoint, UserDto userDto) throws Throwable {
		log.info("logAround() is running!");
		log.info("method: " + joinPoint.getSignature().getName());
		log.info("params: " + Arrays.toString(joinPoint.getArgs()));
		
		log.info("username: " + userDto.getUsername());
		log.info("email: " + userDto.getEmail());
		
		log.info("around before is running!");
		
		joinPoint.proceed();
		
		log.info("around after is running");
	}
}
