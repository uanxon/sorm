package com.uanxon.sorm.core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.uanxon.sorm.bean.ColumnInfo;
import com.uanxon.sorm.bean.JavaDao;
import com.uanxon.sorm.bean.TableInfo;
import com.uanxon.sorm.utils.JavaFileUtils;
import com.uanxon.sorm.utils.StringUtils;

/**
 * 负责获取管理数据库所有表结构和类结构的关系，并可以根据表结构生成类结构。
 * @author uanxon 
 *
 */
public class TableContext {

	/**
	 * 表名为key，表信息对象为value
	 */
	public static  Map<String,TableInfo>  tables = new HashMap<String,TableInfo>();
	
	/**
	 * 将po的class对象和表信息对象关联起来，便于重用！
	 */
	public static  Map<Class,TableInfo>  poClassTableMap = new HashMap<Class,TableInfo>();
	
	private TableContext(){}
	
//	static {
//		initModel();
//		
//		//加载po包下面所有的类，便于重用，提高效率！
////		loadPOTables();
//	}

	public static void createBean() {
		initModel();
	}
	
	private static void initModel() {
		try {
			String[] tableNames = DBManager.getConf().getTables();
			
			if (tableNames.length>0) {
				
				//初始化获得表的信息
				Connection con = DBManager.getConn();
				DatabaseMetaData dbmd = con.getMetaData(); 
				
				ResultSet tableRet = dbmd.getTables(null, "%","%",new String[]{"TABLE"}); 
				
				while(tableRet.next()){
					String tableName ;
					for (String tnames : tableNames) {
						tableName = (String) tableRet.getObject("TABLE_NAME");
						if (tnames != null && tnames.equals(tableName)) {
							TableInfo ti = new TableInfo(tableName, new ArrayList<ColumnInfo>()
									,new HashMap<String, ColumnInfo>(),new ArrayList<String>());
							tables.put(tableName, ti);
							
							ResultSet set = dbmd.getColumns(null, "%", tableName, "%");  //查询表中的所有字段
							String colname = "";
							while(set.next()){
								colname = set.getString("COLUMN_NAME");
								ColumnInfo ci = new ColumnInfo(colname, 
										set.getString("TYPE_NAME"),set.getString("REMARKS") ,0);
								ti.getColumns().put(colname, ci);
								ti.getSorts().add(colname);
							}
							
							ResultSet set2 = dbmd.getPrimaryKeys(null, "%", tableName);  //查询t_user表中的主键
							while(set2.next()){
								ColumnInfo ci2 = (ColumnInfo) ti.getColumns().get(set2.getObject("COLUMN_NAME"));
								ci2.setKeyType(1);  //设置为主键类型
								ti.getPriKeys().add(ci2);
							}
							
							if(ti.getPriKeys().size()>0){  //取唯一主键。。方便使用。如果是联合主键。则为空！
								ti.setOnlyPriKey(ti.getPriKeys().get(0));
							}
						}
					}
					
					
				}
				//更新类结构
				updateJavaPOFile();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 根据表结构，更新配置的po包下面的java类
	 * 实现了从表结构转化到类结构
	 */
	public static void updateJavaPOFile(){
		Map<String,TableInfo> map = TableContext.tables;
		TypeConvertor convertor = new MySqlTypeConvertor();
		for(TableInfo t:map.values()){
			t.setConvertor(convertor);
			t.setDao(new JavaDao());
			t.getDao().setBeanName(StringUtils.firstCharUpperCase(StringUtils.firstChar2UpperCase(t.getTname())));
			t.getDao().setDaoPage(DBManager.getConf().getDaoPackage());
			t.getDao().setBeanSrc(DBManager.getConf().getPoPackage()+"."+t.getDao().getBeanName());
			JavaFileUtils.createJavaPOFile(t);
		}	
	}
	
	/**
	 * 加载po包下面的类
	 */
	public static void loadPOTables(){
		
		for(TableInfo tableInfo:tables.values()){
			try {
				Class c = Class.forName(DBManager.getConf().getPoPackage()
						+"."+StringUtils.firstChar2UpperCase(tableInfo.getTname()));
				poClassTableMap.put(c, tableInfo);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		TableContext.initModel();
		Map<String,TableInfo>  tables = TableContext.tables;
		System.out.println(tables);
	}

}
