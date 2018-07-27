package com.gitile.fast.core.utils;

import java.util.ArrayList;
import java.util.List;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 字符串工具类
 * 在hutool中的StrUtil基础上扩展
 *
 */
public class FastStringUtils extends StrUtil {
	
	/**
	 * 构造方法
	 */
	private FastStringUtils() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * 把字符串按分隔符转换为数组
	 * 
	 * @param str 字符串
	 * @param expr 分隔符
	 * @return
	 */
	public static String[] stringToArray(String str, String expr) {
		return str.split(expr);
	}
	
	/**
	 * 把字符串按分隔符转换为List
	 * 
	 * @param str 字符串
	 * @param expr 分隔符
	 * @return
	 */
	public static List<Long> stringToLongList(String str, String expr) {
		String[] idsArray = FastStringUtils.stringToArray(str, expr);
		List<Long> ids = new ArrayList<>();
		for(String idStr:idsArray) {
			Long id = Long.valueOf(idStr);
			if(id!=null) {
				ids.add(id);
			}
		}
		return ids;
	}
	
	/**
	 * 把字符串按分隔符转换为List
	 * 
	 * @param str 字符串
	 * @param expr 分隔符
	 * @return
	 */
	public static List<String> stringToStringList(String str, String expr) {
		String[] idsArray = FastStringUtils.stringToArray(str, expr);
		List<String> ids = new ArrayList<>();
		for(String idStr:idsArray) {
			if(isNotEmpty(idStr)) {
				ids.add(idStr);
			}
		}
		return ids;
	}

	/**
	 * 将数组按照给定的分隔转化成字符串
	 * 
	 * @param arr
	 * @param expr
	 * @return
	 */
	public static String arrayToString(String[] arr, String expr) {
		String strInfo = "";
		if (ArrayUtil.isNotEmpty(arr)) {
			StringBuilder sb = new StringBuilder();
			for (String str : arr) {
				sb.append(str);
				sb.append(expr);
			}
			strInfo = sb.substring(0, sb.length() - 1);
		}
		return strInfo;
	}
	
	/**
	 * 将集合按照给定的分隔转化成字符串
	 * 
	 * @param list
	 * @param expr
	 * @return
	 */
	public static String longListToString(List<Long> list, String expr) {
		String strInfo = "";
		if (CollUtil.isNotEmpty(list)) {
			StringBuilder sb = new StringBuilder();
			for (Long str : list) {
				sb.append(str);
				sb.append(expr);
			}
			strInfo = sb.substring(0, sb.length() - 1);
		}
		return strInfo;
	}

	/**
	 * 将集合按照给定的分隔转化成字符串
	 * 
	 * @param arr
	 * @param expr
	 * @return
	 */
	public static String stringListToString(List<String> list, String expr) {
		String strInfo = "";
		if (CollUtil.isNotEmpty(list)) {
			StringBuilder sb = new StringBuilder();
			for (String str : list) {
				sb.append(str);
				sb.append(expr);
			}
			strInfo = sb.substring(0, sb.length() - 1);
		}
		return strInfo;
	}
	
}
