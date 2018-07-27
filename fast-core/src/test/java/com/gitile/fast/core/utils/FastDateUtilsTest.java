package com.gitile.fast.core.utils;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.gitile.fast.core.entity.FastDatePattern;

import cn.hutool.core.date.DateField;

/**
 * 日期工具类单元测试
 */
public class FastDateUtilsTest {

	@Test
	public void friendDateTest(){
		Date startDate = FastDateUtils.offset(FastDateUtils.date(), DateField.SECOND, -50);
		String friendDate = FastDateUtils.friendDate(startDate);
		Assert.assertTrue("50秒前".equals(friendDate));
		startDate = FastDateUtils.offset(FastDateUtils.date(), DateField.MINUTE, -40);
		friendDate = FastDateUtils.friendDate(startDate);
		Assert.assertTrue("40分钟前".equals(friendDate));
		startDate = FastDateUtils.offset(FastDateUtils.date(), DateField.HOUR, -10);
		friendDate = FastDateUtils.friendDate(startDate);
		Assert.assertTrue("10小时前".equals(friendDate));
		startDate = FastDateUtils.offset(FastDateUtils.date(), DateField.HOUR, -24);
		friendDate = FastDateUtils.friendDate(startDate);
		Assert.assertTrue("1天前".equals(friendDate));
		startDate = FastDateUtils.offset(FastDateUtils.date(), DateField.DAY_OF_MONTH, -5);
		friendDate = FastDateUtils.friendDate(startDate);
		Assert.assertTrue(FastDateUtils.format(startDate, FastDatePattern.NORM_DATE_PATTERN_CN).equals(friendDate));
	}

	
}
