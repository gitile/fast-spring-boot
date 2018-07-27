package com.gitile.example.modules.common.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gitile.example.modules.common.service.MyAuthService;
import com.gitile.example.modules.system.service.SystemUserService;
import com.gitile.fast.core.entity.FastR;
import com.gitile.fast.core.web.auth.AuthInterceptor;
import com.gitile.fast.core.web.controller.FastController;
import com.gitile.fast.core.web.entity.LoginUser;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 公共接口
 */
@RestController
@Api(tags= "公共接口")
public class HomeController extends FastController {

	@Autowired
	private MyAuthService myAuthService;
	
	@Autowired
	private SystemUserService systemUserService;

	/**
	 * 首页
	 */
    @GetMapping("/")
    public FastR home() {
    	return FastR.ok();
    }
    
	/**
	 * 登录
	 * @param form
	 * @return
	 */
    @PostMapping("/auth/login")
    @ApiOperation(value="用户登录", notes="使用账号登录系统，返回登录令牌（token）", response=FastR.class)
    @ApiImplicitParams({
		@ApiImplicitParam(name = "username", value = "用户账号", required = true, defaultValue="admin"),
		@ApiImplicitParam(name = "password", value = "用户密码", required = true, defaultValue="admin"),
	})
    @ApiResponses({
		@ApiResponse(code = 200, message = "登录成功")
	})
    public FastR login(@RequestParam("username") String username,
    		@RequestParam("password") String password) {
        //用户登录
    	LoginUser loginUser = systemUserService.login(username, password);
    	if(loginUser!=null) {
    		//生成登录token
        	String token = myAuthService.getLoginToken(loginUser);
        	return FastR.ok().put("token", token);
    	} else {
    		return FastR.error("请输入正确的用户名");
    	}
    }

	/**
	 * 获取个人信息
	 * @param form
	 * @return
	 */
    @GetMapping("/common/initPage")
    @ApiOperation(value="初始化", notes="系统获取初始化数据，返回登录用户信息（loginUser）、用户权限信息（LoginPerms）、用户菜单信息（LoginMenus）。", response=FastR.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "token", value = "认证令牌", required = true),
	})
    @ApiResponses({
		@ApiResponse(code = 200, message = "请求成功")
	})
    public FastR initPage(@RequestHeader("token") String token, 
    		@RequestAttribute(AuthInterceptor.REQUEST_USER) LoginUser loginUser) {
    	List<String> perms = systemUserService.getUserPerms(loginUser.getId());
    	return FastR.ok().put("loginUser", loginUser).put("LoginPerms", perms);
    }

}
