package com.gitile.fast.core.web.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gitile.fast.core.utils.FastStringUtils;
import com.gitile.fast.core.web.annotion.AuthPermissions;
import com.gitile.fast.core.web.entity.LoginUser;
import com.gitile.fast.core.web.exception.FastUnAuthException;


/**
 * 登录权限(Token)验证
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {

	public static final String REQUEST_USER = "loginUser";// 登录用户保存request关键字
	
	private AuthService authService;// 权限验证业务方法

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 获取登录用户信息
		LoginUser loginUser = authService.getLoginUser(request);
		if(loginUser!=null) {
			// 设置登录信息
			request.setAttribute(REQUEST_USER, loginUser);
			if(handler instanceof HandlerMethod) {
	        	AuthPermissions annotation = ((HandlerMethod) handler).getMethodAnnotation(AuthPermissions.class);
            	// 验证权限
            	String perms = annotation.value();
            	if(FastStringUtils.isNotEmpty(perms)) {
            		boolean hasAuth = authService.isPermission(loginUser.getId(), perms);
            		if(hasAuth) {
            			return true;
            		}
            	}
            	throw new FastUnAuthException("NoPermission");
	        }
			return true;
		}
		return false;
    }

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
}
