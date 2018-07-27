package com.gitile.fast.core.web.exception;

import com.gitile.fast.core.exception.FastException;

/**
 * 登录认证业务异常
 */
public class FastUnLoginException extends FastException {

	private static final long serialVersionUID = 1L;

	private final String msg;

    public FastUnLoginException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public FastUnLoginException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

}