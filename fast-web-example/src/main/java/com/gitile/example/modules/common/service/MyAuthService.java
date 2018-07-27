package com.gitile.example.modules.common.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gitile.example.config.FastProperties;
import com.gitile.example.modules.system.mapper.SystemMenuMapper;
import com.gitile.fast.core.web.auth.AuthService;
import com.gitile.fast.core.web.entity.LoginUser;
import com.gitile.fast.core.web.utils.FastAuthUtils;

/**
 * 用户登录验证及权限验证
 */
@Service
public class MyAuthService implements AuthService {

	@Autowired
	private SystemMenuMapper systemMenuMapper;
	
	@Autowired
	private FastProperties fastProperties;

	@Override
	public LoginUser getLoginUser(HttpServletRequest request) {
		//获取用户凭证
		return FastAuthUtils.parserToken(FastAuthUtils.getHeaderToken(request), fastProperties.getJwtSecret());
	}

	@Override
	public boolean isPermission(Long userId, String perms) {
		int count = systemMenuMapper.selectUserPermsCount(userId, perms);
		return count>0;
	}

	@Override
	public String getLoginToken(LoginUser loginUser) {
		return FastAuthUtils.generateToken(loginUser, fastProperties.getJwtSecret(), fastProperties.getJwtExpire());
	}

}