package com.gitile.fast.core.web.entity;

import java.io.Serializable;

public class LoginUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;// 编号
	private String name;// 姓名
	private String username;// 登录账号

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}