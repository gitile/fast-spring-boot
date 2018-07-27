package com.gitile.fast.core.web.controller;

import com.gitile.fast.core.web.auth.AuthInterceptor;
import com.gitile.fast.core.web.entity.LoginUser;
import com.gitile.fast.core.web.utils.FastHttpUtils;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

/**
 * 基础Controller
 */
public abstract class FastController {

	protected Log logger = LogFactory.get();
	
	/**
	 * 获取登录用户信息
	 * @return
	 */
	protected LoginUser getLoginUser() {
		Object object = FastHttpUtils.getRequest().getAttribute(AuthInterceptor.REQUEST_USER);
		if(object!=null) {
			return (LoginUser) object;
		}
		return null;
	}

}
