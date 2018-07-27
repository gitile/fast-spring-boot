package com.gitile.fast.core.web.exception;

import com.gitile.fast.core.exception.FastException;

/**
 * 没有权限异常
 */
public class FastUnAuthException extends FastException {

	private static final long serialVersionUID = 1L;

	private final String msg;

    public FastUnAuthException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public FastUnAuthException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

}