package com.gitile.fast.core.web.utils;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gitile.fast.core.entity.FastR;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;

public class FastHttpUtils extends HttpUtil {
	
	/**
	 * 构造方法
	 */
	private FastHttpUtils() {
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * 获取 HttpServletResponse
	 */
	public static HttpServletResponse getResponse() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
	}

	/**
	 * 获取HttpServletRequest
	 * 
	 * @return request
	 */
	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 获取域名
	 * @return
	 */
	public static String getDomain(){
		HttpServletRequest request = getRequest();
		StringBuffer url = request.getRequestURL();
		return url.delete(url.length() - request.getRequestURI().length(), url.length()).toString();
	}

	/**
	 * 获取Origin
	 * @return
	 */
	public static String getOrigin(){
		HttpServletRequest request = getRequest();
		return request.getHeader("Origin");
	}

	/**
	 * 打印json
	 * @param httpResponse
	 * @param result
	 * @throws IOException 
	 */
	public static void printJson(FastR result) throws IOException {
		HttpServletResponse httpResponse = getResponse();
        httpResponse.setContentType("application/json;charset=utf-8");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Origin", getOrigin());
        httpResponse.getWriter().print(JSONUtil.parseFromMap(result));
	}

	/**
	 * post请求
	 */
	public static String fastPost(String url, Map<String, Object> paramMap) {
		return fastPost(url, null, paramMap);
	}

	
	/**
	 * post请求(登录权限验证)
	 */
	public static String fastPost(String url, String token, Map<String, Object> paramMap) {
		HttpRequest request = FastHttpUtils.createPost(url).form(paramMap);
		if(token!=null) {
			request.header("token", token);
		}
		return request.execute().body();
	}
	
	/**
	 * get请求
	 */
	public static String fastGet(String url, Map<String, Object> paramMap) {
		return fastGet(url, null, paramMap);
	}

	/**
	 * get请求(登录权限验证)
	 */
	public static String fastGet(String url, String token, Map<String, Object> paramMap) {
		HttpRequest request = FastHttpUtils.createGet(url).form(paramMap);
		if(token!=null) {
			request.header("token", token);
		}
		return request.execute().body();
	}
}