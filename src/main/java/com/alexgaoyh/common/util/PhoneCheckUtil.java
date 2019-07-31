package com.alexgaoyh.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneCheckUtil {
	
	/**
	 * 中国电信号码格式验证 手机段： 133,153,180,181,189,177,1700
	 * **/
	private static final String CHINA_TELECOM_PATTERN = "(^1(33|53|77|8[019])\\d{8}$)|(^1700\\d{7}$)";

	/**
	 * 中国联通号码格式验证 手机段：130,131,132,155,156,185,186,145,176,1709
	 * **/
	private static final String CHINA_UNICOM_PATTERN = "(^1(3[0-2]|4[5]|5[56]|7[6]|8[56])\\d{8}$)|(^1709\\d{7}$)";

	/**
	 * 中国移动号码格式验证
	 * 手机段：134,135,136,137,138,139,150,151,152,157,158,159,182,183,184
	 * ,187,188,147,178,1705
	 * **/
	private static final String CHINA_MOBILE_PATTERN = "(^1(3[4-9]|4[7]|5[0-27-9]|7[8]|8[2-478])\\d{8}$)|(^1705\\d{7}$)";
    
	/**
	 * 手机号验证
	 * 
	 * @author ：shijing 2016年12月5日下午4:34:46
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isMobile(final String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		// 验证手机号
		p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
		m = p.matcher(str);
		b = m.matches();
		return b;
	}
	
	/**
	 * 是否为中国移动号码
	 * 
	 * @author sj
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isChinaMobile(final String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile(CHINA_MOBILE_PATTERN);
		m = p.matcher(str);
		b = m.matches();
		return b;
	}
	
	/**
	 * 是否为中国联通号码
	 * 
	 * @author sj
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isChinaUnicom(final String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile(CHINA_UNICOM_PATTERN);
		m = p.matcher(str);
		b = m.matches();
		return b;
	}
	
	/**
	 * 是否为中国电信号码
	 * 
	 * @author sj
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isChinaTelecom(final String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile(CHINA_TELECOM_PATTERN);
		m = p.matcher(str);
		b = m.matches();
		return b;
	}

	/**
	 * 电话号码验证
	 * 
	 * @author ：shijing 2016年12月5日下午4:34:21
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isPhone(final String str) {
		Pattern p1 = null, p2 = null;
		Matcher m = null;
		boolean b = false;
		p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$"); // 验证带区号的
		p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$"); // 验证没有区号的
		if (str.length() > 9) {
			m = p1.matcher(str);
			b = m.matches();
		} else {
			m = p2.matcher(str);
			b = m.matches();
		}
		return b;
	}

	public static void main(String[] args) {
		String phone = "13900442200";
		String phone2 = "021-88889999";
		String phone3 = "88889999";
		String phone4 = "1111111111";
		// 测试1
		if (isPhone(phone) || isMobile(phone)) {
			System.out.println("1这是符合的");
		}
		// 测试2
		if (isPhone(phone2) || isMobile(phone2)) {
			System.out.println("2这是符合的");
		}
		// 测试3
		if (isPhone(phone3) || isMobile(phone3)) {
			System.out.println("3这是符合的");
		}
		// 测试4
		if (isPhone(phone4) || isMobile(phone4)) {
			System.out.println("4这是符合的");
		} else {
			System.out.println("不符合");
		}
	}

}
