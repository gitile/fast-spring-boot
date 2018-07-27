package com.gitile.fast.core.exception;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 工具类异常
 */
public class FastException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FastException(Throwable e) {
		super(ExceptionUtil.getMessage(e), e);
	}
	
	public FastException(String message) {
		super(message);
	}
	
	public FastException(String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params));
	}
	
	public FastException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public FastException(Throwable throwable, String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params), throwable);
	}

}