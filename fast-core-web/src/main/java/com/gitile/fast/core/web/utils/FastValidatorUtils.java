package com.gitile.fast.core.web.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.gitile.fast.core.web.exception.FastServiceException;

/**
 * 表单验证工具类
 */
public class FastValidatorUtils {

	/**
	 * 构造方法
	 */
	private FastValidatorUtils() {
		throw new IllegalStateException("Utility class");
	}

	private static Validator validator;

	static {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	/**
	 * 校验对象
	 * 
	 * @param object 待校验对象
	 * @param groups 待校验的组
	 */
	public static void validateEntity(Object object, Class<?>... groups) {
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
		if (!constraintViolations.isEmpty()) {
			StringBuilder msg = new StringBuilder();
			for (ConstraintViolation<Object> constraint : constraintViolations) {
				msg.append(constraint.getMessage()).append("<br>");
			}
			throw new FastServiceException(msg.toString());
		}
	}
}
