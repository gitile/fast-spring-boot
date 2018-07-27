package com.gitile.example.modules.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.gitile.example.modules.system.entity.SystemLog;

/**
 * <p>
 * 系统日志 服务类
 * </p>
 *
 * @author 涂灵峰
 * @since 2018-07-04
 */
public interface SystemLogService extends IService<SystemLog> {
	
	/**
	 * 批量删除日志
	 * @param ids 日志编号
	 */
	boolean deleteBatch(Long[] ids);

}
