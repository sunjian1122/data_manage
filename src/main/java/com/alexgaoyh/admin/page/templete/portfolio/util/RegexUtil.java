package com.alexgaoyh.admin.page.templete.portfolio.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
	/**
	 * 上传的图片中，获取到src部分数据
	 * @param content
	 * @return
	 */
	public static String getHrefStrFromContent (String content) {
		
		//String input = "<a style=\" \" href = \"http://www.zjsyc.com\" target=\"_blank\" >www.zjsyc.com</a>" + "<a href = 'http://www.163.com' target='_blank' >www.163.com</a> " + "<a href=http://www.yahoo.com target=_blank >www.yahoo.com</a>";
		String input = content;
		
		String patternString = "\\s*(?i)src\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))"; // href
		Pattern pattern = Pattern.compile(patternString,
		Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);

		if (matcher.find()) {
			String link = matcher.group(1);
			//System.out.println(link);
			link = link.replaceAll("src\\s*=\\s*(['|\"]*)", "");
			//System.out.println("--" + link);
			link = link.replaceAll("['|\"]", "");
			//System.out.println("---" + link);
			return link;
		}else {
			return "";
		}
	}
}
