package com.uanxon.sorm.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.uanxon.sorm.bean.ColumnInfo;
import com.uanxon.sorm.bean.JavaDao;
import com.uanxon.sorm.bean.JavaFieldGetSet;
import com.uanxon.sorm.bean.TableInfo;
import com.uanxon.sorm.core.DBManager;
import com.uanxon.sorm.core.TableContext;
import com.uanxon.sorm.core.TypeConvertor;

/**
 * 封装了生成Java文件(源代码)常用的操作
 * @author 
 *
 */
public class JavaFileUtils {
	
	
	/**
	 * 新	
	 */
	public static void createFieldGetSetSRC(TableInfo tableInfo,List<JavaFieldGetSet> javaFields){
		JavaFieldGetSet jfgs;
		ColumnInfo column ;
		tableInfo.setImports(new HashMap<>());
		String imports = "";
		for(String colname:tableInfo.getSorts()){
			column = tableInfo.getColumns().get(colname);
			jfgs  = new JavaFieldGetSet();	
			
			String javaFieldType = tableInfo.getConvertor().databaseType2JavaType(column.getDataType());
			
			if (javaFieldType != null &&  javaFieldType.indexOf(".")>0) {
				// 生成 import ...;
				imports = "import "+javaFieldType+";\n";
				javaFieldType = javaFieldType.substring(javaFieldType.lastIndexOf(".")+1,javaFieldType.length());
				if (!tableInfo.getImports().containsKey(javaFieldType)) {
					tableInfo.getImports().put(javaFieldType, imports);
					tableInfo.getBeanFile().append(imports);
				}
			}
			column.setFieldName(StringUtils.firstChar2UpperCase(colname));
			//生成 属性 和注释
			jfgs.setFieldInfo("\t//"+column.getRemarks()+"\n\tprivate "+javaFieldType+" "+colname+";\n");
			
			//public String getUsername(){return username;}
			//生成get方法的源代码
			StringBuilder getSrc = new StringBuilder();
			getSrc.append("\tpublic "+javaFieldType+" get"+StringUtils.firstCharUpperCase(column.getFieldName())+"(){\n");
			getSrc.append("\t\treturn "+column.getName()+";\n");
			getSrc.append("\t}\n");
			jfgs.setGetInfo(getSrc.toString());
			
			//public void setUsername(String username){this.username=username;}
			//生成set方法的源代码
			StringBuilder setSrc = new StringBuilder();
			setSrc.append("\tpublic void set"+StringUtils.firstCharUpperCase(column.getFieldName())+"(");
			setSrc.append(javaFieldType+" "+column.getName()+"){\n");
			setSrc.append("\t\tthis."+column.getName()+"="+column.getName()+";\n");
			setSrc.append("\t}\n");
			jfgs.setSetInfo(setSrc.toString());
			
			javaFields.add(jfgs);
		}
	}
	
	/**
	 * 新 根据表信息生成java类的源代码
	 * @param tableInfo 表信息
	 * @param convertor 数据类型转化器 
	 * @return java类的源代码
	 */
	public static String createJavaSrc(TableInfo tableInfo){
		
		List<JavaFieldGetSet> javaFields = new ArrayList<JavaFieldGetSet>();

		StringBuilder src = new StringBuilder();
		
		tableInfo.setBeanFile(src);
		
		//生成package语句
		src.append("package "+DBManager.getConf().getPoPackage()+";\n\n");
		
		
		//生成import语句 和 类信息	
		createFieldGetSetSRC(tableInfo,javaFields);
		
		src.append("\n");
		
	
		//生成类声明语句
		src.append("public class "+tableInfo.getDao().getBeanName()+" {\n\n");
		
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
	private static void createDaoFiles(JavaDao dao ) {
		dao.setDaoSrc(new StringBuffer(
				"package "+dao.getDaoPage()+";\r\n" + 
						"\r\n" + 
						"import "+dao.getBeanSrc()+";\r\n" + 
						"\r\n" + 
						"public interface "+dao.getDaoName()+" {\r\n" + 
						"	/**\r\n" + 
						"	 * delete\r\n" + 
						"	 * @param id\r\n" + 
						"	 * @return\r\n" + 
						"	 */\r\n" + 
						"	public int deleteByPrimaryKey("+dao.getKeyRely()+");\r\n" + 
						"	/**\r\n" + 
						"	 * insert 所有属性\r\n" + 
						"	 * @param record\r\n" + 
						"	 * @return\r\n" + 
						"	 */\r\n" + 
						"	public int insert("+dao.getBeanName()+" obj);\r\n" + 
						"	/**\r\n" + 
						"	 * insert 不为空的属性\r\n" + 
						"	 * @param record\r\n" + 
						"	 * @return\r\n" + 
						"	 */\r\n" + 
						"	public int insertSelective("+dao.getBeanName()+" obj);\r\n" + 
						"	/**\r\n" + 
						"	 * 查询\r\n" + 
						"	 * @param id\r\n" + 
						"	 * @return\r\n" + 
						"	 */\r\n" + 
						"	public "+dao.getBeanName()+" selectByPrimaryKey("+dao.getKeyRely()+");\r\n" + 
						"	/**\r\n" + 
						"	 * 修改不为空的属性\r\n" + 
						"	 * @param record\r\n" + 
						"	 * @return\r\n" + 
						"	 */\r\n" + 
						"	public int updateByPrimaryKeySelective("+dao.getBeanName()+" obj);\r\n" + 
						"	/**\r\n" + 
						"	 * 修改所有属性\r\n" + 
						"	 * @param record\r\n" + 
						"	 * @return\r\n" + 
						"	 */\r\n" + 
						"	public int updateByPrimaryKey("+dao.getBeanName()+" record);\r\n" + 
						"	  \r\n" + 
						"}"
				));
		
	}
	
	/**
	 * 根据表信息生成java dao
	 */
	public static void createJavaDao(TableInfo ti){
		if (ti.getOnlyPriKey() != null) {
			ti.getOnlyPriKey().setFieldName(StringUtils.firstChar2UpperCase(ti.getOnlyPriKey().getName()));
			ti.getDao().setKeyRely(ti.getConvertor().databaseType2JavaType(ti.getOnlyPriKey().getDataType())+" "+ti.getOnlyPriKey().getName());
		}else {
			ti.getDao().setKeyRely(ti.getConvertor().databaseType2JavaType(ti.getColumns().get(ti.getSorts().get(0)).getDataType())+" "+ti.getSorts().get(0));
		}
		createDaoFiles(ti.getDao());
	}
	
	
	
	/**
	 * 新
	 * @param tableInfo
	 */
	public static void createJavaPOFile(TableInfo tableInfo){
		
		String srcPath = DBManager.getConf().getSrcPath()+"\\";
		
		String javaSrc = createJavaSrc(tableInfo);
		createJavaDao(tableInfo);
		MapperUtils.createMapper(tableInfo);
		String[] src = new String[] {javaSrc,tableInfo.getDao().getDaoSrc().toString(),
				MapperUtils.createMapper(tableInfo).toString()};
		
		String [] path = new String[] {DBManager.getConf().getPoPackage().replaceAll("\\.", "/"),
					DBManager.getConf().getDaoPackage().replaceAll("\\.", "/"),
					DBManager.getConf().getMapperPackage().replaceAll("\\.", "/")};
		
		String[] fileName = new String[] {tableInfo.getDao().getBeanName()+".java", tableInfo.getDao().getDaoName()+".java",tableInfo.getTname()+"_SqlMap.xml"};
		
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
			createJavaPOFile(t);
		}
	}
	
}
