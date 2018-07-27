package com.gitile.fast.core.web.exception;

import com.gitile.fast.core.exception.FastException;

/**
 * 封装基础业务异常
 */
public class FastServiceException extends FastException {

	private static final long serialVersionUID = 1L;

	private final String msg;

    public FastServiceException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public FastServiceException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

}