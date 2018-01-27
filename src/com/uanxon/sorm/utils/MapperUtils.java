package com.uanxon.sorm.utils;

import com.uanxon.sorm.bean.TableInfo;

public class MapperUtils {
	
	/**
	 * 创建 mapper 主体
	 * @param daoSrc
	 */
	public static StringBuffer createMapper(TableInfo ti) {
		StringBuffer s = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"\r\n\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\r\n<mapper namespace=\""+ti.getDaoSrc()+"\">\r\n")
				.append(createResultMap(ti))
				.append(createDelete(ti))
				.append(createInsert(ti))
				.append(createnInsertSelective(ti))
				.append(createSelect(ti))
				.append(createUpdate(ti))
				.append(createUpdateSelective(ti))
				.append("</mapper>");
		return s;
	}
	/**
	 * 创建reuslt
	 * @param mapper
	 * @param ti
	 * @return
	 */
	public static StringBuffer createResultMap(TableInfo ti) {
		StringBuffer s = new StringBuffer("  <resultMap id=\"BaseResultMap\" type=\""+ti.getBeanSrc()+"\">\r\n"); 
				for (String culname : ti.getSorts()) {
					s.append("\t<result column=\"").append(culname).append("\" property=\"")
					.append(ti.getColumns().get(culname).getFieldName()).append("\" />\r\n");
				}
				s.append("  </resultMap>\r\n <sql id=\"base_Sql\">\r\n    ");
				s.append( org.apache.commons.lang.StringUtils.join(ti.getSorts().toArray(), ",")).append( "\r\n </sql>\r\n"); 
		return s;
	}
	
	/**
	 * 生成删除
	 * @return
	 */
	public static StringBuffer createDelete(TableInfo ti) {
		StringBuffer s = new StringBuffer(" <delete id=\"deleteByPrimaryKey\" parameterType=\"java.lang.Integer\">\r\n    delete from ")
				.append(ti.getTname()).append("\r\n    where ").append(ti.getOnlyPriKey().getName())
				.append(" = #{").append(ti.getOnlyPriKey().getFieldName()).append("}\r\n </delete>\r\n"); 
		return s;
	}
	/**
	 * 生成查询
	 * @param ti
	 * @return
	 */
	public static StringBuffer createSelect(TableInfo ti) {
		StringBuffer s = new StringBuffer(" <select id=\"selectByPrimaryKey\" parameterType=\"java.lang.Integer\" resultMap=\"BaseResultMap\">\r\n    select \r\n    <include refid=\"base_Sql\" />\r\n    from ")
				.append(ti.getTname()).append("\r\n    where id = #{")
				.append(ti.getOnlyPriKey().getFieldName()).append("}\r\n </select>\r\n"); 
		return s;
	}

	/**
	 * 生成所有属性添加
	 * @param ti
	 * @return
	 */
	public static StringBuffer createInsert(TableInfo ti) {
		StringBuffer s = new StringBuffer(" <insert id=\"insert\" parameterType=\"")
				.append(ti.getBeanSrc())
				.append("\">\r\n    insert into ").append(ti.getTname())
				.append(" (").append(ti.getColStrs().substring(ti.getColStrs().indexOf(",")+1))
				.append(")\r\n" )
				.append("    values (");
				for(int i=1;i<ti.getSorts().size();i++) {
					if (i==ti.getSorts().size()-1) {
						s.append("#{").append(ti.getColumns().get(ti.getSorts().get(i)).getFieldName()).append("}");
					}else {
						s.append("#{").append(ti.getColumns().get(ti.getSorts().get(i)).getFieldName()).append("},");
					}
				}
				s.append(")\r\n </insert>\r\n"); 
		return s;
	}
	/**
	 * 生成不为空的属性添加
	 * @param ti
	 * @return
	 */
	public static StringBuffer createnInsertSelective(TableInfo ti) {
		StringBuffer s = new StringBuffer(" <insert id=\"insertSelective\" parameterType=\"")
				.append(ti.getBeanSrc())
				.append("\">\r\n    insert into ").append(ti.getTname())
				.append("\r\n    <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\r\n" );
		StringBuffer x = new StringBuffer();
		StringBuffer y = new StringBuffer();
		for(int i=1;i<ti.getSorts().size();i++) {
			
			if ("String".equals(ti.getConvertor().databaseType2JavaType(ti.getColumns().get(ti.getSorts().get(i)).getDataType()))) {
				x.append("      <if test=\"")
				.append(ti.getColumns().get(ti.getSorts().get(i)).getFieldName())
				.append(" != null && ")
				.append(ti.getColumns().get(ti.getSorts().get(i)).getFieldName())
				.append(" != ''\">\r\n" );
				y.append("      <if test=\"")
				.append(ti.getColumns().get(ti.getSorts().get(i)).getFieldName())
				.append(" != null && ")
				.append(ti.getColumns().get(ti.getSorts().get(i)).getFieldName())
				.append(" != ''\">\r\n" );
			}else {
				x.append("      <if test=\"").append(ti.getColumns().get(ti.getSorts().get(i)).getFieldName())
				.append(" != null\">\r\n" );
				y.append("      <if test=\"").append(ti.getColumns().get(ti.getSorts().get(i)).getFieldName())
				.append(" != null\">\r\n" );
			}					
			x.append( "        ").append(ti.getSorts().get(i)).append(",\r\n      </if>    \r\n" );
			y.append( "          #{").append(ti.getSorts().get(i)).append("},\r\n      </if>    \r\n" );
		}
		s.append(x)
		.append( "    </trim>\r\n    <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">     \r\n" )
		.append(y).append("    </trim>\r\n  </insert>\r\n"); 
		return s;
	}
	
	
	/**
	 * 生成不为空的属性修改
	 * @param ti
	 * @return
	 */
	public static StringBuffer createUpdateSelective(TableInfo ti) {
		StringBuffer s = new StringBuffer("  <update id=\"updateByPrimaryKeySelective\" parameterType=\"")
				.append(ti.getBeanSrc()).append("\">\r\n    update ").append(ti.getTname())
				.append("\r\n    <set>    \r\n");
				for(int i=1;i<ti.getSorts().size();i++) {
					s.append("      <if test=\"").append(ti.getColumns().get(ti.getSorts().get(i)).getFieldName());
					if ("String".equals(ti.getConvertor().databaseType2JavaType(ti.getColumns().get(ti.getSorts().get(i)).getDataType()))) {
						s.append(" != null && ").append(ti.getColumns().get(ti.getSorts().get(i)).getFieldName()).append(" !=''\">\r\n");										
					}else {
						s.append(" != null\">\r\n");
					}
					s.append("        ")
					.append(ti.getSorts().get(i))
					.append(" = #{")
					.append(ti.getColumns().get(ti.getSorts().get(i)).getFieldName())
					.append("},\r\n      </if>\r\n");
				}
				s.append("    </set>\r\n     where ").append(ti.getOnlyPriKey().getName())
				.append(" = #{")
				.append(ti.getOnlyPriKey().getFieldName())
				.append("}\r\n  </update>\r\n"); 
		return s;
	}
	
	/**
	 * 生成所有属性修改
	 * @param ti
	 * @return
	 */
	public static StringBuffer createUpdate(TableInfo ti) {
		StringBuffer s = new StringBuffer("  <update id=\"updateByPrimaryKeySelective\" parameterType=\"")
				.append(ti.getBeanSrc()).append("\">\r\n    update ").append(ti.getTname())
				.append("\r\n    <set>    \r\n");
				for(int i=1;i<ti.getSorts().size();i++) {					
					s.append("        ")
					.append(ti.getSorts().get(i))
					.append(" = #{")
					.append(ti.getColumns().get(ti.getSorts().get(i)).getFieldName())
					.append("},\r\n");
				}
				s.append("    </set>\r\n     where ").append(ti.getOnlyPriKey().getName())
				.append(" = #{")
				.append(ti.getOnlyPriKey().getFieldName())
				.append("}\r\n  </update>\r\n"); 
		return s;
	}
	
}
