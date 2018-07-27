package com.gitile.example;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.gitile.fast.core.mybatis.FastCodeGenerator;

/**
 * 自动生成代码
 */
public class AutoCodeGenerator {
	
	public static void main(String[] args) {
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDriverName("com.mysql.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("123456");
		dsc.setUrl("jdbc:mysql://127.0.0.1:3306/fast_web_example?characterEncoding=utf8");
		FastCodeGenerator.autoPersistenceMysql("com.gitile.example.modules.system", "涂灵峰", dsc);
	}

}
