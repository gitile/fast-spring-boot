package com.gitile.example.config;

import java.util.ArrayList;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "fast", name = "swagger-open", havingValue = "true")
public class SwaggerConfig {
	
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("admin")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))//这里采用包含注解的方式来确定要显示的接口
                .paths(PathSelectors.any())
                .build();
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("涂灵峰", "https://github.com/gitile", "xtotly@aliyun.com");
		return new ApiInfo("后台接口文档", "后台接口文档说明", "1.0.0", "http://www.gitile.com", contact, "Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());
	}

}