package com.gitile.fast.core.web.annotion;

import java.lang.annotation.*;

/**
 * 登录效验
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthPermissions {

	String value();

}
