package com.gitile.fast.core.utils;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;

/**
 * 字符串工具类单元测试
 */
public class FastStringUtilsTest {
	
	@Test
	public void stringToArrayTest(){
		String splitString = "1,2,3,4,5";
		String[] array = FastStringUtils.stringToArray(splitString, ",");
		Assert.assertTrue(ArrayUtil.isNotEmpty(array));
		Assert.assertTrue(array.length==5);
	}

	@Test
	public void stringToLongListTest(){
		String splitString = "1,2,3,4,5";
		List<Long> list = FastStringUtils.stringToLongList(splitString, ",");
		Assert.assertTrue(CollUtil.isNotEmpty(list));
		Assert.assertTrue(list.size()==5);
	}

	@Test
	public void stringToStringListTest(){
		String splitString = "1,2,3,4,5";
		List<String> list = FastStringUtils.stringToStringList(splitString, ",");
		Assert.assertTrue(CollUtil.isNotEmpty(list));
		Assert.assertTrue(list.size()==5);
	}
	@Test
	public void arrayToStringTest(){
		String[] array = {"1", "2", "3", "4", "5"};
		String arrayString = FastStringUtils.arrayToString(array, ",");
		Assert.assertTrue(FastStringUtils.isNotEmpty(arrayString));
		Assert.assertTrue("1,2,3,4,5".equals(arrayString));
	}
	
	@Test
	public void longListToStringTest(){
		List<Long> list = new ArrayList<>();
		list.add(1L);
		list.add(2L);
		list.add(3L);
		list.add(4L);
		list.add(5L);
		String listString = FastStringUtils.longListToString(list, ",");
		Assert.assertTrue(FastStringUtils.isNotEmpty(listString));
		Assert.assertTrue("1,2,3,4,5".equals(listString));
	}
	
	@Test
	public void stringListToStringTest(){
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		String listString = FastStringUtils.stringListToString(list, ",");
		Assert.assertTrue(FastStringUtils.isNotEmpty(listString));
		Assert.assertTrue("1,2,3,4,5".equals(listString));
	}
	
}
