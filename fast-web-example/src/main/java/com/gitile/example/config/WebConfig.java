package com.gitile.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gitile.fast.core.web.auth.AuthInterceptor;
import com.gitile.fast.core.web.auth.AuthService;

/**
 * WebMvc配置
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	private FastProperties fastProperties;
	
	@Autowired
	private AuthService authService;
	
    /**
     * 增加swagger的支持
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	if(fastProperties.getSwaggerOpen()) {
    		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
            registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    	}
    }

	/**
	 * 跨域配置
	 */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowCredentials(true)
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .maxAge(3600);
    }
    
    /**
     * 权限管理
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	AuthInterceptor authInterceptor = new AuthInterceptor();
    	authInterceptor.setAuthService(authService);
    	registry.addInterceptor(authInterceptor).addPathPatterns("/common/**", "/system/**");
    }

}
