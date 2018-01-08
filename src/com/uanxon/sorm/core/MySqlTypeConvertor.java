package com.uanxon.sorm.core;

import java.util.HashMap;
import java.util.Map;

/**
 * mysql数据类型和java数据类型的转换
 * @author 
 *
 */
public class MySqlTypeConvertor implements TypeConvertor {
	
	private static Map<String,String> mapType = new HashMap<>();
	
	static {
		mapType.put("varchar", "String");
		mapType.put("char", "String");
		mapType.put("int", "Integer");
		mapType.put("tinyint", "Integer");
		mapType.put("smallint", "Integer");
		mapType.put("integer", "Integer");
		mapType.put("bigint", "Integer");
		mapType.put("double", "Double");
		mapType.put("float", "Double");
		mapType.put("clob", "java.sql.CLob");
		mapType.put("blob", "java.sql.BLob");
		mapType.put("date", "java.sql.Date");
		mapType.put("time", "java.sql.Time");
		mapType.put("decimal", "java.math.BigDecimal");
		mapType.put("timestamp", "java.util.Date");
		mapType.put("datetime", "java.util.Date");
	}

	@Override
	public String databaseType2JavaType(String columnType) {
		String type = null;
		if(columnType.contains(" ")) {
			columnType = columnType.substring(columnType.indexOf(" "))+columnType.substring(columnType.lastIndexOf(" ")+1,columnType.length());
		}
		type =  mapType.get(columnType.toLowerCase());
		if(type == null) {
			System.out.println(columnType);
		}
		return type;
	}

	@Override
	public String javaType2DatabaseType(String javaDataType) {
		return null;
	}

}
