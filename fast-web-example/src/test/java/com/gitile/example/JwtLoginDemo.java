package com.gitile.example;

import java.util.HashMap;

import com.gitile.fast.core.web.utils.FastHttpUtils;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

/**
 * 模拟登录
 */
public class JwtLoginDemo {

	public static void main(String[] args) {
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("username", "admin");
		paramMap.put("password", "admin");
		String content = FastHttpUtils.fastPost("http://localhost:8080/auth/login", paramMap);
		JSONObject result = JSONUtil.parseObj(content);
		String token = result.getStr("token");
		System.out.println(token);
	}

}
