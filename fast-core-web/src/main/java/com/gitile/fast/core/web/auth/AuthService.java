package com.gitile.fast.core.web.auth;

import javax.servlet.http.HttpServletRequest;

import com.gitile.fast.core.web.entity.LoginUser;

public interface AuthService {
	
	/**
	 * 获取登录令牌
	 * @param request
	 * @return
	 */
	String getLoginToken(LoginUser loginUser);

	/**
	 * 获取登录信息
	 * @param request
	 * @return
	 */
	LoginUser getLoginUser(HttpServletRequest request);

	/**
	 * 判断用户是否有权限
	 * @param userId
	 * @param perms
	 * @return
	 */
	boolean isPermission(Long userId, String perms);

}
