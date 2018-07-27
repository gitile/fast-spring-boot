package com.gitile.example.modules.system.mapper;

import com.gitile.example.modules.system.entity.SystemMenu;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 菜单管理 Mapper 接口
 * </p>
 *
 * @author 涂灵峰
 * @since 2018-07-04
 */
public interface SystemMenuMapper extends BaseMapper<SystemMenu> {

	/**
	 * 获取用户全部权限
	 * @param userId
	 * @return
	 */
	List<String> selectUserAllPerms(@Param("userId") Long userId);
	
	/**
	 * 判断用户是否有某一权限
	 * @param userId
	 * @return
	 */
	int selectUserPermsCount(@Param("userId")Long userId, @Param("perms") String perms);

}
