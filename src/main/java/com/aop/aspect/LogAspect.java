package com.aop.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aop.dto.UserDto;
import com.aop.service.TestService;

/**
 * @author thiago
 *
 */
@Component
@Aspect
public class LogAspect {
	
	private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
	
	@Autowired TestService testService;
	
	@Pointcut("execution(* com.aop.service.UserService.addUserBefore(..)) && args(userDto)")
	public void getPointcutName(UserDto userDto){}
	
	@Before("getPointcutName(userDto)")
	public void logBeforePointCut(JoinPoint joinPoint, UserDto userDto) throws Throwable {
		log.info("logBeforePointCut() is running!");
		log.info("method: " + joinPoint.getSignature().getName());
		log.info("params: " + Arrays.toString(joinPoint.getArgs()));
		
		log.info("username: " + userDto.getUsername());
		log.info("email: " + userDto.getEmail());
	}
	
	@Before("execution(* com.aop.service.UserService.addUserBefore(..)) && args(userDto)")
	public void logBefore(JoinPoint joinPoint, UserDto userDto) throws Throwable {
		log.info("logBefore() is running!");
		log.info("method: " + joinPoint.getSignature().getName());
		log.info("params: " + Arrays.toString(joinPoint.getArgs()));
		
		log.info("username: " + userDto.getUsername());
		log.info("email: " + userDto.getEmail());
	}
	
	@After("execution(* com.aop.service.UserService.addUserAfter(..)) && args(userDto)")
	public void logAfter(JoinPoint joinPoint, UserDto userDto) throws Throwable {
		log.info("logAfter() is running!");
		log.info("method: " + joinPoint.getSignature().getName());
		log.info("params: " + Arrays.toString(joinPoint.getArgs()));
		
		log.info("username: " + userDto.getUsername());
		log.info("email: " + userDto.getEmail());
	}
	
	@AfterReturning(
			pointcut="execution(* com.aop.service.UserService.addUserAfterReturning(..))",
			returning="userDto")
	public void logAfterReturning(JoinPoint joinPoint, UserDto userDto) {
		log.info("logAfterReturning() is running!");
		log.info("method: " + joinPoint.getSignature().getName());
		
		log.info("username: " + userDto.getUsername());
		log.info("email: " + userDto.getEmail());
	}
	
	@Around("execution(* com.aop.service.UserService.addUserAround(..)) && args(userDto)")
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
	
	@Before("execution(* com.aop.service.UserService.addUserBeforeVoid(..)) && args(userDto)")
	public void logBeforeVoid(JoinPoint joinPoint, UserDto userDto) throws Throwable {
		log.info("logBeforeVoid() is running!");
		log.info("method: " + joinPoint.getSignature().getName());
		
		log.info("username: " + userDto.getUsername());
		log.info("email: " + userDto.getEmail());
		
		testService.testService();
	}
}
