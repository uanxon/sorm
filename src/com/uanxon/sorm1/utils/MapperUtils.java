package com.uanxon.sorm1.utils;

import com.uanxon.sorm1.bean.JavaMapper;
import com.uanxon.sorm1.bean.TableInfo;

public class MapperUtils {
	
	/**
	 * 创建 mapper 主体
	 * @param daoSrc
	 */
	public static void createMapper(JavaMapper mapper) {
		String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"\r\n" + 
				"\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\r\n" + 
				"<mapper namespace=\""+mapper.getDaoSrc()+"\">\r\n" + 
				"	${resultMap}\r\n" + 
				"	${delete}\r\n" + 
				"	${insert}\r\n" + 
				"	${insertSelective}\r\n" + 
				"	${select}\r\n" + 
				"	${update}\r\n" + 
				"	${updateByKey}\r\n" + 
				"</mapper>";
	}
	/**
	 * 创建reuslt
	 * @param mapper
	 * @param ti
	 * @return
	 */
	public static StringBuffer createResultMap(JavaMapper mapper,TableInfo ti) {
		StringBuffer s = new StringBuffer("  <resultMap id=\"BaseResultMap\" type=\""+mapper.getBeanSrc()+"\">\r\n"); 
				for (String culname : ti.getSorts()) {
					s.append("    <result column=\""+culname+"\" property=\""+ti.getColumns().get(culname).getFieldName()+"\" />");
				}
				s.append("  \r\n  </resultMap>\r\n  <sql id=\"baseSql\">\r\n    ");
				s.append( org.apache.commons.lang.StringUtils.join(ti.getSorts().toArray(), ",")+ "\r\n  </sql>");
		return s;
	}
	
	/**
	 * 
	 * @return
	 */
	public static StringBuffer createDelete(TableInfo ti) {
		StringBuffer s = new StringBuffer("<delete id=\"deleteByPrimaryKey\" parameterType=\"java.lang.Integer\">\r\n" + 
				"    delete from "+ti.getTname()+"\r\n" + 
				"    where "+ti.getOnlyPriKey().getName()+" = #{"+ti.getOnlyPriKey().getFieldName()+"}\r\n" + 
				"  </delete>");
		return s;
	}

}
