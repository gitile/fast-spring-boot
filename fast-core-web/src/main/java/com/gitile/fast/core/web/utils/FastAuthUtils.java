package com.gitile.fast.core.web.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.gitile.fast.core.utils.FastStringUtils;
import com.gitile.fast.core.web.entity.LoginUser;
import com.gitile.fast.core.web.exception.FastUnLoginException;

import cn.hutool.crypto.SecureUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 用户权限工具类
 *
 */
public class FastAuthUtils {

	public static final String TOKEN = "token";// 登录令牌保存参数关键字
	
	/**
	 * 构造方法
	 */
	private FastAuthUtils() {
		throw new IllegalStateException("Utility class");
	}

	  /**
     * 获取请求的token
     */
	public static String getHeaderToken(HttpServletRequest httpRequest){
        //从header中获取token
        String token = httpRequest.getHeader(TOKEN);
        //如果header中不存在token，则从参数中获取token
        if(FastStringUtils.isBlank(token)){
            token = httpRequest.getParameter(TOKEN);
        }
        return token;
    }

    /**
     * 生成token
     */
	public static String generateToken(LoginUser loginUser, String secret, long expire) {
        Date nowDate = new Date();
        //过期时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", loginUser.getId());
        claims.put("name", loginUser.getName());
        claims.put("username", loginUser.getUsername());
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(loginUser.getId()+"")
                .setClaims(claims)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
	
	/**
	 * 解析token
	 * @param secret
	 * @param token
	 * @return
	 */
	public static LoginUser parserToken(String token, String secret) {
		
		try {
			if(FastStringUtils.isNotEmpty(token)) {
				Claims claims = Jwts.parser()
		                .setSigningKey(secret)
		                .parseClaimsJws(token)
		                .getBody();
				if(claims!=null) {
					// 判断是否过期
					Date expiration = claims.getExpiration();
					if(expiration.after(new Date())) {
						LoginUser loginUser = new LoginUser();
						loginUser.setId(Long.parseLong(String.valueOf(claims.get("id"))));
						loginUser.setName(String.valueOf(claims.get("name")));
						loginUser.setUsername(String.valueOf(claims.get("username")));
						return loginUser;
					} else {
						throw new FastUnLoginException("TokenExpire");
					}
				}
			} else {
				throw new FastUnLoginException("TokenEmpty");
			}
		} catch (FastUnLoginException e) {
			throw new FastUnLoginException(e.getMessage());
		} catch (Exception e) {
			throw new FastUnLoginException("TokenError");
		}
		throw new FastUnLoginException("TokenFail");
	}

	/**
	 * 验证密码是否正确
	 * @param loginUser
	 * @return
	 */
	public static boolean validatePassword(String md5Password, String plainPassword) {
		return FastStringUtils.isNotEmpty(md5Password)&&md5Password.equals(md5Password(plainPassword));
	}
	
	/**
	 * md5加密密码
	 * @param loginUser
	 * @return
	 */
	public static String md5Password(String plainPassword) {
		return SecureUtil.md5(plainPassword);
	}

}