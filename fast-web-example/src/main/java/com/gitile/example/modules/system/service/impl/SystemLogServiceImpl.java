package com.gitile.example.modules.system.service.impl;

import com.gitile.example.modules.system.entity.SystemLog;
import com.gitile.example.modules.system.mapper.SystemLogMapper;
import com.gitile.example.modules.system.service.SystemLogService;
import com.gitile.fast.core.web.exception.FastServiceException;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import java.util.Arrays;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author 涂灵峰
 * @since 2018-07-04
 */
@Service
public class SystemLogServiceImpl extends ServiceImpl<SystemLogMapper, SystemLog> implements SystemLogService {

	@Override
	@Transactional
	public boolean deleteBatch(Long[] ids) {
		Integer count = baseMapper.deleteBatchIds(Arrays.asList(ids));
		if(count==ids.length) {
			return true;
		}
		throw new FastServiceException("删除失败，要删除条数和删除成功条数不一致");
	}

}
