/**
 * 
 */
package com.spring.test.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.spring.test.service.TestService;

/**
 * @author Thiago
 *
 */
@Service
public class TestServiceImpl implements TestService {

	private static final Logger log = LoggerFactory.getLogger(TestServiceImpl.class);
	
	public void testService() {
		log.info("testService() is running!");
	}
}
