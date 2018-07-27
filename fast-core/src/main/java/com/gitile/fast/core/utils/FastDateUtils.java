package com.gitile.fast.core.utils;

import java.util.Date;

import com.gitile.fast.core.entity.FastDatePattern;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

/**
 * 日期工具类
 * 在hutool中的DateUtil基础上扩展
 */
public class FastDateUtils extends DateUtil {
	
	private static final long ONE_MINUTE_UNIT = 60;
	private static final long ONE_HOUR_UNIT = ONE_MINUTE_UNIT*60;
	private static final long ONE_DAY_UNIT = ONE_HOUR_UNIT*24;
	private static final long THRRE_DAY_UNIT = ONE_DAY_UNIT*3;
	
	/**
	 * 构造方法
	 */
	private FastDateUtils() {
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * 友好日期显示
	 */
	public static String friendDate(Date startDate) {
		// 获取时间间隔，以秒表示
		long time = between(startDate, date(), DateUnit.SECOND);
		if(time < ONE_MINUTE_UNIT) {
			return time + "秒前";
		} else if (time < ONE_HOUR_UNIT) {
			return time/ONE_MINUTE_UNIT + "分钟前";
		} else if (time < ONE_DAY_UNIT) {
			return time/ONE_HOUR_UNIT + "小时前";
		} else if (time < THRRE_DAY_UNIT) {
			return time/ONE_DAY_UNIT + "天前";
		} else {
			return DateUtil.format(startDate, FastDatePattern.NORM_DATE_PATTERN_CN);
		}
	}
	
}
