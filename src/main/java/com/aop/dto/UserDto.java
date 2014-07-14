package com.aop.dto;

import java.io.Serializable;

/**
 * @author thiago
 *
 */
public class UserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5812214388272578996L;
	
	private Long id;
	private String username;
	private String email;
	
	public UserDto(Long id, String username, String email) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
