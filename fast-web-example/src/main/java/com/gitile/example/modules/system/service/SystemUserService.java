package com.gitile.example.modules.system.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.gitile.example.modules.system.entity.SystemUser;
import com.gitile.fast.core.web.entity.LoginUser;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author 涂灵峰
 * @since 2018-07-04
 */
public interface SystemUserService extends IService<SystemUser> {

	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	LoginUser login(String username, String password);
	
	/**
	 * 获取用户权限列表
	 * @param userId 用户编号
	 * @return
	 */
	List<String> getUserPerms(Long userId);

}
