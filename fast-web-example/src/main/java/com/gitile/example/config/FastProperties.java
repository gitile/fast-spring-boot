package com.gitile.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = FastProperties.PREFIX)
public class FastProperties {
	
	public static final String PREFIX = "fast";

	private Boolean swaggerOpen = false;// 是否开启文档服务
	
	private String jwtSecret;// jwt加密秘钥
	
	private Long jwtExpire;//jwt过期时间

	public Boolean getSwaggerOpen() {
		return swaggerOpen;
	}

	public void setSwaggerOpen(Boolean swaggerOpen) {
		this.swaggerOpen = swaggerOpen;
	}

	public String getJwtSecret() {
		return jwtSecret;
	}

	public void setJwtSecret(String jwtSecret) {
		this.jwtSecret = jwtSecret;
	}

	public Long getJwtExpire() {
		return jwtExpire;
	}

	public void setJwtExpire(Long jwtExpire) {
		this.jwtExpire = jwtExpire;
	}

}
