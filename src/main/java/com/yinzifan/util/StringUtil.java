package com.yinzifan.util;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description 字符串工具类 
 * @author Cin
 * @date 2018/01/27 11:41:52
 */
public class StringUtil {

	/**
	 * 判断是否是空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || "".equals(str.trim());
	}

	/**
	 * 判断是否不是空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	/**
	 * 格式化模糊查询
	 * @param str
	 * @return
	 */
	public static String formatLike(String str) {
		return isNotEmpty(str) ? "%" + str + "%" : null;
	}

	/**
	 * 过滤掉集合里的空格
	 * @param list
	 * @return
	 */
	public static List<String> filterWhite(List<String> list) {
		return list.stream().filter(StringUtil::isNotEmpty).collect(Collectors.toList());
	}
}
