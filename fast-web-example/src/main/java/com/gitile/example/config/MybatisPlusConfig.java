package com.gitile.example.config;

import java.util.Properties;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;

/**
 * MybatisPlus配置
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.gitile.example.modules.*.mapper"})
public class MybatisPlusConfig {

	/**
	 * 分页插件配置
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}

	/**
	 * 性能分析插件 <br/>
	 * 性能分析拦截器，用于输出每条 SQL 语句及其执行时间<br/>
	 * maxTime SQL 执行最大时长，超过自动停止运行，有助于发现问题。
	 */
	@Bean
	@Profile({ "dev", "test" }) // 设置 dev test 环境开启
	public PerformanceInterceptor performanceInterceptor() {
		PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
		Properties properties = new Properties();
		properties.setProperty("maxTime", "100");
		performanceInterceptor.setProperties(properties);
		return new PerformanceInterceptor();
	}

}
