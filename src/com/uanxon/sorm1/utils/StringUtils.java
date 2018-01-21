package com.uanxon.sorm1.utils;

/**
 * 封装了字符串常用的操作
 * @author 
 *
 */
public class StringUtils {
	
	/**
	 * 驼峰写法
	 * @param str 目标字符串
	 * @return 首字母变为大写的字符串
	 */
	public static String firstChar2UpperCase(String str){
		//abcd-->Abcd
		//abcd-->ABCD-->Abcd
		
		String [] strs = str.split("_");
		str = "";
		for (int i=0;i<strs.length;i++) {
			if (strs[i] !=null && !"".equals(strs[i])) {
				if (i==0) {
					str += strs[i];
				}else {
					str +=  strs[i].toUpperCase().substring(0, 1)+strs[i].substring(1);
				}
			}
		}
		
		return str;
	}
	/**
	 * 将驼峰写法的首字母大写
	 * @param str
	 * @return
	 */
	public static String firstCharUpperCase(String str) {
		if (str != null && !"".equals(str)) {
			str = str.substring(0, 1).toUpperCase()+str.substring(1);
		}
		return str;
	}
	
	private static String removePrefix (String str , String removePrefix, String incrPrefix) {
		
		if (removePrefix !=null && removePrefix != "" ) {
			if (removePrefix.lastIndexOf("_") != removePrefix.length()-1) {
				removePrefix+="_";
			}
			if (str.indexOf(removePrefix)==0) {
				str = incrPrefix(str.substring(removePrefix.length()), incrPrefix);
			}
		}
		return str;
	}
	private static String incrPrefix (String str , String incrPrefix) {
		
		if (incrPrefix !=null && incrPrefix != "" ) {
			if (incrPrefix.lastIndexOf("_") != incrPrefix.length()-1) {
				incrPrefix+="_";
			}
			if (str.indexOf(incrPrefix)!=0) {
				str = incrPrefix+str;
			}
		}
		return str;
	}
	public static String convTname (String tName , String removePrefix,String incrPrefix) {
		return removePrefix(tName,removePrefix, incrPrefix);
	}
	public static void main(String[] args) {
		String str="\ns";
		System.out.println(str);
	}
}
