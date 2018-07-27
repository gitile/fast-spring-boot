package com.gitile.fast.core.entity;

import java.util.HashMap;

/**
 * 操作返回信息
 */
public class FastR extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	public static final int SUCCESS = 1;// 成功
	public static final int FAILURE = 0;// 失败
	
	public FastR() {
		put("code", SUCCESS);
	}
	
	public FastR(int code) {
		put("code", code);
	}
	
	public FastR(int code, String msg) {
		put("code", code);
		put("msg", msg);
	}
	
	@Override
	public FastR put(String key, Object value) {
		super.put(key, value);
		return this;
	}

	public static FastR ok() {
		return new FastR(SUCCESS);
	}
	
	public static FastR ok(String msg) {
		return new FastR(SUCCESS, msg);
	}

	public static FastR error() {
		return new FastR(FAILURE);
	}
	
	public static FastR error(String msg) {
		return new FastR(FAILURE, msg);
	}

	public static FastR error(int code, String msg) {
		return new FastR(code, msg);
	}

}