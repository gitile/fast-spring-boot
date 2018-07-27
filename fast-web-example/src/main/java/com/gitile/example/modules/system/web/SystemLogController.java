package com.gitile.example.modules.system.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.gitile.example.modules.system.entity.SystemLog;
import com.gitile.example.modules.system.service.SystemLogService;
import com.gitile.fast.core.entity.FastR;
import com.gitile.fast.core.web.annotion.AuthPermissions;
import com.gitile.fast.core.web.controller.FastController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * <p>
 * 系统日志 前端控制器
 * </p>
 *
 * @author 涂灵峰
 * @since 2018-07-04
 */
@RestController
@RequestMapping("/system/log")
@Api(tags= "系统日志")
public class SystemLogController extends FastController {
	
	@Autowired
	private SystemLogService systemLogService;
	
	/**
	 * 分页获取系统日志列表
	 */
	@GetMapping("list")
	@AuthPermissions("system:log:view")
	@ApiOperation(value="分页获取系统日志列表", notes="管理员根据条件查询日志信息列表，支持分页")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "认证令牌", required = true),
		@ApiImplicitParam(name = "pageNo", value = "第几页", required = true, defaultValue="1"),
		@ApiImplicitParam(name = "pageSize", value = "每页几条数据", required = true, defaultValue="20"),
	})
	@ApiResponses({
		@ApiResponse(code = 200, message = "查询成功")
	})
	public FastR list(@RequestHeader("token") String token,
			@RequestParam("pageNo") Integer pageNo, 
			@RequestParam("pageSize") Integer pageSize) {
		EntityWrapper<SystemLog> warpper = new EntityWrapper<>();
		warpper.eq("user_id", 1);
		Page<SystemLog> page = systemLogService.selectPage(new Page<SystemLog>(1, 20), warpper);
		return FastR.ok().put("page", page);
	}
	
	/**
	 * 删除系统日志
	 */
	@PostMapping("delete")
	@AuthPermissions("system:log:delete")
	@ApiOperation(value="删除系统日志", notes="删除系统日志，支持批量删除")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "认证令牌", required = true),
		@ApiImplicitParam(name = "ids", value = "日志编号，多个以逗号隔开", required = true, defaultValue="1"),
	})
	@ApiResponses({
		@ApiResponse(code = 200, message = "删除成功")
	})
	public FastR delete(@RequestHeader("token") String token,
			@RequestParam("ids") Long[] ids) {
		boolean delete = systemLogService.deleteBatch(ids);
		if(delete) {
			return FastR.ok("删除成功");
		}
		return FastR.error("删除失败，请稍后重试");
	}

}

