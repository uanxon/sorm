package com.uanxon.sorm.core;

import java.util.HashMap;
import java.util.Map;

/**
 * mysql数据类型和java数据类型的转换
 * @author uanxon 
 *
 */
public class MySqlTypeConvertor implements TypeConvertor {
	
	private static Map<String,String> mapType = new HashMap<>();
	
	static {
		mapType.put("varchar", "String");
		mapType.put("char", "String");
		mapType.put("text", "String");
		mapType.put("int", "Integer");
		mapType.put("tinyint", "Integer");
		mapType.put("bit", "Integer");
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
			columnType = columnType.substring(0,columnType.indexOf(" "));
		}
		type =  mapType.get(columnType.toLowerCase());
		if(type == null) {
			System.out.println(">>>>>>>>>>>>>>>>\n发现jdbc类型不存在:"+columnType);
			type = mapType.get("int");
		}
		return type;
	}

	@Override
	public String javaType2DatabaseType(String javaDataType) {
		return null;
	}

	public static void main(String[] args) {
		MySqlTypeConvertor c = new MySqlTypeConvertor();
		System.out.println(	c.databaseType2JavaType("BIGINT UNSIGNED"));
	}
}
