package com.gitile.example.modules.system.service.impl;

import com.gitile.example.modules.system.entity.SystemMenu;
import com.gitile.example.modules.system.mapper.SystemMenuMapper;
import com.gitile.example.modules.system.service.SystemMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author 涂灵峰
 * @since 2018-07-04
 */
@Service
public class SystemMenuServiceImpl extends ServiceImpl<SystemMenuMapper, SystemMenu> implements SystemMenuService {

}
