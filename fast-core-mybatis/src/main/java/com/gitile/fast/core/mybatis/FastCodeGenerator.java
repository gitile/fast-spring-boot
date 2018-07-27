package com.gitile.fast.core.mybatis;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.gitile.fast.core.utils.FilenameUtils;

/**
 * 代码生成工具类
 */
public class FastCodeGenerator {
	
	/**
	 * 构造方法
	 */
	private FastCodeGenerator() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * 使用mybatisplus的AutoGenerator进行model、dao、mapper的生成
	 */
	public static void autoPersistenceMysql(String basePakcage, String author, DataSourceConfig dsc) {
		AutoGenerator mpg = new AutoGenerator();
		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir(getMavenJavaPath());// 这里写你自己的java目录
		gc.setFileOverride(false);// 是否覆盖
		gc.setActiveRecord(true);
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(false);// XML columList
		gc.setAuthor(author);
		mpg.setGlobalConfig(gc);
		// 数据源配置
		dsc.setDbType(DbType.MYSQL);
		dsc.setTypeConvert(new MySqlTypeConvert() {
			// 自定义数据库表字段类型转换【可选】
			@Override
			public DbColumnType processTypeConvert(String fieldType) {
				if (fieldType.contains("tinyint")) {
		            return DbColumnType.SHORT;
		        }
				return super.processTypeConvert(fieldType);
			}
		});
		mpg.setDataSource(dsc);
		 // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        mpg.setStrategy(strategy);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(basePakcage);
        mpg.setPackageInfo(pc);
        // 执行生成
        mpg.execute();
	}
	
	public static String getMavenJavaPath() {
		return System.getProperty("user.dir") + FilenameUtils.separatorsToSystem("\\src\\main\\java\\");
	}

}
