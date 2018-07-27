package com.gitile.example.modules.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gitile.example.modules.system.entity.SystemUser;
import com.gitile.example.modules.system.mapper.SystemMenuMapper;
import com.gitile.example.modules.system.mapper.SystemUserMapper;
import com.gitile.example.modules.system.service.SystemUserService;
import com.gitile.fast.core.web.entity.LoginUser;
import com.gitile.fast.core.web.exception.FastServiceException;
import com.gitile.fast.core.web.utils.FastAuthUtils;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author 涂灵峰
 * @since 2018-07-04
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser> implements SystemUserService {
	
	@Autowired
	private SystemUserMapper systemUserMapper;
	
	@Autowired
	private SystemMenuMapper systemMenuMapper;

	@Override
	public LoginUser login(String username, String password) {
		SystemUser entity = new SystemUser();
		entity.setUsername(username);
		SystemUser result = systemUserMapper.selectOne(entity);
		if(result!=null) {
			// 判断账号是否可用
			if (result.getState()==1) {
				// 验证密码是否正确
				if(FastAuthUtils.validatePassword(result.getPassword(), password)) {
					LoginUser loginUser = new LoginUser();
					loginUser.setId(result.getId());
					loginUser.setName(result.getName());
					loginUser.setUsername(result.getUsername());
					return loginUser;
				} else {
					throw new FastServiceException("您的密码不正确");
				}
			} else {
				throw new FastServiceException("您的账号不可用");
			}
		}
		return null;
	}

	@Override
	public List<String> getUserPerms(Long userId) {
		return systemMenuMapper.selectUserAllPerms(userId);
	}

}
