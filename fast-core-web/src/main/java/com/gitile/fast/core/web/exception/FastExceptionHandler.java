package com.gitile.fast.core.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.gitile.fast.core.entity.FastR;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 */
public class FastExceptionHandler {
	
	private Log logger = LogFactory.get();

	/**
	 * 拦截业务异常
	 */
	@ExceptionHandler(FastServiceException.class)
	public FastR handlerServiceException(FastServiceException e) {
		logger.warn("FastServiceException:{}", e);
		return FastR.error(e.getMessage());
	}

	/**
	 * 拦截登录认证异常
	 */
	@ExceptionHandler(FastUnLoginException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public FastR handlerFastUnLoginException(Exception e) {
		logger.warn("FastUnLoginException:{}", e);
		return FastR.error(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
	}
	
	/**
	 * 拦截权限异常
	 */
	@ExceptionHandler(FastUnAuthException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public FastR handlerFastUnAuthException(Exception e) {
		logger.warn("FastUnAuthException:{}", e);
		return FastR.error(HttpStatus.FORBIDDEN.value(), e.getMessage());
	}

	/**
	 * 拦截没有路径异常
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public FastR handlerNoFoundException(Exception e) {
		logger.warn("NoHandlerFoundException:{}", e);
		return FastR.error(HttpStatus.NOT_FOUND.value(), e.getMessage());
	}

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public FastR handleRuntimeException(RuntimeException e){
		logger.error("RuntimeException:{}", e);
		return FastR.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
	}

}