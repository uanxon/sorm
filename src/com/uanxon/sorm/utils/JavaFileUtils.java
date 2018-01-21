package com.uanxon.sorm.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlValue;

import com.uanxon.sorm.bean.ColumnInfo;
import com.uanxon.sorm.bean.JavaFieldGetSet;
import com.uanxon.sorm.bean.TableInfo;
import com.uanxon.sorm.core.DBManager;
import com.uanxon.sorm.core.MySqlTypeConvertor;
import com.uanxon.sorm.core.TableContext;
import com.uanxon.sorm.core.TypeConvertor;

/**
 * 封装了生成Java文件(源代码)常用的操作
 * @author 
 *
 */
public class JavaFileUtils {
	
	/**
	 * 生成javabean 和 xml
	 * @param column 字段信息
	 * @param convertor 类型转化器
	 * @return java属性和set/get方法源码
	 */
	public static JavaFieldGetSet createFields(String fieldName,String fieldType,String fieldRemarks){
		JavaFieldGetSet jfgs  = new JavaFieldGetSet();
		//生成 属性 和注释
		jfgs.setFieldInfo("\t//"+fieldRemarks+"\n\tprivate "+fieldType+" "+fieldName+";\n");
		
		//public String getUsername(){return username;}
		//生成get方法的源代码
		StringBuilder getSrc = new StringBuilder();
		getSrc.append("\tpublic "+fieldType+" get"+fieldName+"(){\n");
		getSrc.append("\t\treturn "+fieldName+";\n");
		getSrc.append("\t}\n");
		jfgs.setGetInfo(getSrc.toString());
		
		//public void setUsername(String username){this.username=username;}
		//生成set方法的源代码
		StringBuilder setSrc = new StringBuilder();
		setSrc.append("\tpublic void set"+fieldName+"(");
		setSrc.append(fieldType+" "+fieldName+"){\n");
		setSrc.append("\t\tthis."+fieldName+"="+fieldName+";\n");
		setSrc.append("\t}\n");
		jfgs.setSetInfo(setSrc.toString());
		return jfgs;
	}
	
	/**
	 * 根据字段信息生成java属性信息。如：varchar username-->private String username;以及相应的set和get方法源码
	 * @param column 字段信息
	 * @param convertor 类型转化器
	 * @return java属性和set/get方法源码
	 */
	public static JavaFieldGetSet createFieldGetSetSRC(ColumnInfo column,TypeConvertor convertor,StringBuilder src){
		JavaFieldGetSet jfgs  = new JavaFieldGetSet();
		
		String javaFieldType = convertor.databaseType2JavaType(column.getDataType());
		
		if (javaFieldType != null &&  javaFieldType.indexOf(".")>0) {
			// 生成 import ...;
			src.append("import "+javaFieldType+";\n");
			javaFieldType = javaFieldType.substring(javaFieldType.lastIndexOf(".")+1,javaFieldType.length());
		}
		
		//生成 属性 和注释
		jfgs.setFieldInfo("\t//"+column.getRemarks()+"\n\tprivate "+javaFieldType+" "+column.getName()+";\n");
		
		//public String getUsername(){return username;}
		//生成get方法的源代码
		StringBuilder getSrc = new StringBuilder();
		getSrc.append("\tpublic "+javaFieldType+" get"+StringUtils.firstChar2UpperCase(column.getName())+"(){\n");
		getSrc.append("\t\treturn "+column.getName()+";\n");
		getSrc.append("\t}\n");
		jfgs.setGetInfo(getSrc.toString());
		
		//public void setUsername(String username){this.username=username;}
		//生成set方法的源代码
		StringBuilder setSrc = new StringBuilder();
		setSrc.append("\tpublic void set"+StringUtils.firstChar2UpperCase(column.getName())+"(");
		setSrc.append(javaFieldType+" "+column.getName()+"){\n");
		setSrc.append("\t\tthis."+column.getName()+"="+column.getName()+";\n");
		setSrc.append("\t}\n");
		jfgs.setSetInfo(setSrc.toString());
		return jfgs;
	}
	
	/**
	 * 根据表信息生成java类的源代码
	 * @param tableInfo 表信息
	 * @param convertor 数据类型转化器 
	 * @return java类的源代码
	 */
	public static String createJavaSrc(TableInfo tableInfo,TypeConvertor convertor){
		
		Map<String,ColumnInfo> columns = tableInfo.getColumns();
		List<JavaFieldGetSet> javaFields = new ArrayList<JavaFieldGetSet>();

		StringBuilder src = new StringBuilder();
		//生成package语句
		src.append("package "+DBManager.getConf().getPoPackage()+";\n\n");
		
		
		//生成import语句 和 类信息		
		for(ColumnInfo c:columns.values()){
			javaFields.add(createFieldGetSetSRC(c,convertor,src));
		}
		src.append("\n");
		
		//生成类声明语句
		src.append("public class "+StringUtils.firstChar2UpperCase(tableInfo.getTname())+" {\n\n");
		
		//生成属性列表
		for(JavaFieldGetSet f:javaFields){
			src.append(f.getFieldInfo());
		}
		src.append("\n\n");
		//生成get方法列表
		for(JavaFieldGetSet f:javaFields){
			src.append(f.getGetInfo());
		}
		//生成set方法列表
		for(JavaFieldGetSet f:javaFields){
			src.append(f.getSetInfo());
		}
		
		//生成类结束
		src.append("}\n");
		return src.toString();
	}
	/**
	 * 生成dao 结束
	 * @param masterKey
	 * @param masterType
	 * @param className
	 * @param dao
	 */
	private static void createDao( String masterKey,String masterType,String className,StringBuilder dao) {
		dao.append("/**\n* 添加\n* @param \n* @return\n*/\npublic void insert"+className+"("+className+" record);\n/**\n* 添加\n* @param \n* @return\n*/\npublic int updateByPrimaryKey("+className+" record);\n/**\n* 查询\n* @param \n* @return\n*/\npublic "+className+" selectByPrimaryKey("+masterType+" "+masterKey+");\n}");
	}
	private static void createMapper () {
		
	}
	
	/**
	 * 根据表信息生成java类的源代码
	 * @param tableInfo 表信息
	 * @param convertor 数据类型转化器 
	 * @return java类的源代码
	 */
	public static String[] createFiles(TableInfo tableInfo,TypeConvertor convertor,String className){
		String[] files = new String[3];
		Map<String,ColumnInfo> columns = tableInfo.getColumns();
		List<JavaFieldGetSet> javaFields = new ArrayList<JavaFieldGetSet>();
		
		StringBuilder src = new StringBuilder();
		StringBuilder dao = new StringBuilder();
		StringBuilder mapper = new StringBuilder();
		StringBuilder importStr =  new StringBuilder(); 
		String masterKey = "";
		String masterType = "";
		//================
		String poPackage = DBManager.getConf().getPoPackage();
		String daoPackage = DBManager.getConf().getDaoPackage();
		String daoName = className+"DAO";
		mapper.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://www.mybatis.org/dtd/mybatis-3-mapper.dtd\" >\n<mapper namespace=\""+daoPackage.replaceAll("/", ".")+"."+daoName+"\">\n");
		//===========
		
		//生成package语句
		src.append("package "+poPackage+";\n\n");
		dao.append("package "+daoPackage+";\n\n");
		
		//生成import语句 和 类信息		
		String fieldName=null,fieldType=null,fieldRemarks=null;
		String classNamesrc = poPackage.replaceAll("/", ".")+"."+className;
		StringBuilder xmlBr = new StringBuilder().append("\t<resultMap id=\"baseResult\" type=\""+classNamesrc+"\">\n");
		StringBuilder xmlselect = new StringBuilder(" <select id=\"selectByPrimaryKey\" resultMap=\"baseResult\" parameterType=\""+classNamesrc+"\">\n\t select ");
		StringBuffer xmlInsert = new StringBuffer(" <insert id=\"insert"+className+"\" useGeneratedKeys=\"true\" keyProperty=\"${1}\" parameterType=\""+classNamesrc+"\">\n\t insert into "+tableInfo.getTname()+" (");
		StringBuffer xmlInsertValue = new StringBuffer(")\n\t values ( ");
		StringBuilder xmlUpdate = new StringBuilder(" <update id=\"updateByPrimaryKey\" parameterType=\""+classNamesrc+"\" >\n\t update "+tableInfo.getTname()+"\n\t <set>\n");
		StringBuffer xmlWhere = new StringBuffer("\t\twhere ");
		
		for(ColumnInfo c:columns.values()){
			fieldName=StringUtils.firstChar2UpperCase(c.getName());
			fieldType=convertor.databaseType2JavaType(c.getDataType());
			fieldRemarks=c.getRemarks();
			if ( masterKey == "" && c.getKeyType()==1) {
				masterKey = c.getName();
				masterType = c.getDataType();
				xmlWhere.append(fieldName+"  = #{"+fieldName+":"+c.getDataType()+"}\n");
			}
			xmlBr.append("\t\t<result column=\""+c.getName()+"\" property=\""+fieldName+"\" jdbcType=\""+c.getDataType()+"\" />\n");
			xmlselect.append(fieldName+",");
			xmlInsert.append(fieldName+",");
			xmlInsertValue.append("#{"+fieldName+":"+c.getDataType()+"},");
			xmlUpdate.append("\t\t<if test=\" "+fieldName+" != null\"> "+fieldName+"  = #{"+fieldName+":"+c.getDataType()+"},</if>\n");
			if (fieldType != null &&  fieldType.indexOf(".")>0) {
				// 生成 import ...;
				importStr.append("import "+fieldType+";\n");
				fieldType = fieldType.substring(fieldType.lastIndexOf(".")+1,fieldType.length());
			}
			
			javaFields.add(createFields(fieldName,fieldType,fieldRemarks));
		}
		src.append(importStr).append("\n");
//		dao.append(importStr).append("\n");
		dao.append("import "+poPackage.replaceAll("/", ".")+"."+className+";\n");
		
		//生成类声明语句
		src.append("public class "+className+" {\n\n");
		createDao(masterKey, convertor.databaseType2JavaType(masterType), className, dao.append("\npublic interface "+daoName+" {\n\n"));
		xmlBr.append("\t</resultMap>\n");
		xmlselect.deleteCharAt(xmlselect.length()-1);
		xmlselect.append("\n\t from "+tableInfo.getTname()+"\n").append(xmlWhere).append(" </select>\n");
		xmlUpdate.append("\t </set>\n").append(xmlWhere).append(" </update>\n");
		xmlInsert.deleteCharAt(xmlInsert.length()-1);
		xmlInsertValue.deleteCharAt(xmlInsertValue.length()-1);
		xmlInsert.append(xmlInsertValue).append(")\n </insert>\n");
		mapper.append(xmlBr).append(xmlselect).append(xmlInsert).append(xmlUpdate).append("</mapper>");
		
		
		//生成属性列表
		for(JavaFieldGetSet f:javaFields){
			src.append(f.getFieldInfo());
		}
		src.append("\n\n");
		//生成get方法列表
		for(JavaFieldGetSet f:javaFields){
			src.append(f.getGetInfo());
		}
		//生成set方法列表
		for(JavaFieldGetSet f:javaFields){
			src.append(f.getSetInfo());
		}
		
		//生成类结束
		src.append("}\n");
		files[0]=src.toString();
		files[1]=dao.toString();
		files[2]=mapper.toString();
		return files;
	}
	
	/**
	 * 根据表信息生成java类的源代码
	 * @param tableInfo 表信息
	 * @param convertor 数据类型转化器 
	 * @return java类的源代码
	 */
	public static String[] createBeanFiles(TableInfo tableInfo,TypeConvertor convertor,String className){
		String[] files = new String[3];
		Map<String,ColumnInfo> columns = tableInfo.getColumns();
		List<JavaFieldGetSet> javaFields = new ArrayList<JavaFieldGetSet>();
		
		StringBuilder src = new StringBuilder();
	
	
		StringBuilder importStr =  new StringBuilder(); 
	
		//================
		String poPackage = DBManager.getConf().getPoPackage();
		//===========
		
		//生成package语句
		src.append("package "+poPackage+";\n\n");
		
		//生成import语句 和 类信息		
		String fieldName=null,fieldType=null,fieldRemarks=null;
		
		for(ColumnInfo c:columns.values()){
			fieldName=StringUtils.firstChar2UpperCase(c.getName());
			fieldType=convertor.databaseType2JavaType(c.getDataType());
			fieldRemarks=c.getRemarks();
			if (fieldType != null &&  fieldType.indexOf(".")>0) {
				// 生成 import ...;
				importStr.append("import "+fieldType+";\n");
				fieldType = fieldType.substring(fieldType.lastIndexOf(".")+1,fieldType.length());
			}
			javaFields.add(createFields(fieldName,fieldType,fieldRemarks));
		}
		src.append(importStr).append("\n");
		
		//生成类声明语句
		src.append("public class "+className+" {\n\n");
		
		//生成属性列表
		for(JavaFieldGetSet f:javaFields){
			src.append(f.getFieldInfo());
		}
		src.append("\n\n");
		//生成get方法列表
		for(JavaFieldGetSet f:javaFields){
			src.append(f.getGetInfo());
		}
		//生成set方法列表
		for(JavaFieldGetSet f:javaFields){
			src.append(f.getSetInfo());
		}
		
		//生成类结束
		src.append("}\n");
		files[0]=src.toString();
		return files;
	}
	
	
	
	public static void createJavaPOFile(TableInfo tableInfo,TypeConvertor convertor){
		String src = createJavaSrc(tableInfo,convertor);
		
		String srcPath = DBManager.getConf().getSrcPath()+"\\";
		String packagePath = DBManager.getConf().getPoPackage().replaceAll("\\.", "/");
		
		File f = new File(srcPath+packagePath);
		
		if(!f.exists()){  //如果指定目录不存在，则帮助用户建立
			f.mkdirs();
		}
		
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(f.getAbsoluteFile()+"/"+StringUtils.firstChar2UpperCase(tableInfo.getTname())+".java"));
			bw.write(src);
			System.out.println("建立表"+tableInfo.getTname()+
					"对应的java类："+StringUtils.firstChar2UpperCase(tableInfo.getTname())+".java");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(bw!=null){
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void createJavaFiles(TableInfo tableInfo,TypeConvertor convertor){
		String className = StringUtils.firstChar2UpperCase(StringUtils.convTname( tableInfo.getTname(), DBManager.getConf().getRemovePrefix(),  DBManager.getConf().getIncrPrefix()));
		className = className.substring(0,1).toUpperCase()+className.substring(1);
		String[] fileName = new String[] {className+".java", className+"DAO.java",tableInfo.getTname()+"_SqlMap.xml"};
		
		String[] src = createFiles(tableInfo, convertor,className);
		
		String srcPath = DBManager.getConf().getSrcPath()+"\\";
		String [] path = new String[] {DBManager.getConf().getPoPackage().replaceAll("\\.", "/"),
					DBManager.getConf().getDaoPackage().replaceAll("\\.", "/"),
					DBManager.getConf().getMapperPackage().replaceAll("\\.", "/")};
		BufferedWriter bw = null;
		File f ;
		for (int i = 0; i < src.length; i++) {
			try {
				f = new File(srcPath+path[i]);
				
				if(!f.exists()){  //如果指定目录不存在，则帮助用户建立
					f.mkdirs();
				}
				bw = new BufferedWriter(new FileWriter(f.getAbsoluteFile()+"/"+fileName[i]));
				bw.write(src[i]);
				System.out.println("建立表"+tableInfo.getTname()+
						"对应的 ："+fileName[i]);
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(bw!=null){
						bw.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
//		ColumnInfo ci = new ColumnInfo("id", "int", 0);
//		JavaFieldGetSet f = createFieldGetSetSRC(ci,new MySqlTypeConvertor());
//		System.out.println(f);
		
		Map<String,TableInfo> map = TableContext.tables;
		for(TableInfo t:map.values()){
			createJavaPOFile(t,new MySqlTypeConvertor());
		}
	}
	
}
