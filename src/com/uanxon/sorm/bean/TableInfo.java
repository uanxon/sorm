package com.uanxon.sorm.bean;

import java.util.List;
import java.util.Map;

import com.uanxon.sorm.core.TypeConvertor;


/**
 * 存储表结构的信息
 * @author  
 *
 */
public class TableInfo {
	//表名
	private String tname;  
	
	//所有字段的信息
	private Map<String,ColumnInfo> columns;
	// 所有字段的排序
	private List<String> sorts;
	
	//唯一主键(目前我们只能处理表中有且只有一个主键的情况)
	private ColumnInfo  onlyPriKey;	
	
	// 如果联合主键，则在这里存储
	private List<ColumnInfo> priKeys;   
	
	//转换器
	private TypeConvertor convertor;
	
	//生成的类	
	private StringBuilder beanFile;
	
	//生成的类	
	private StringBuilder daoFile;
	
	//import 
	private Map<String,String> imports;
	
	//dao包的地址
	private String daoSrc;
	//bean包的地址
	private String beanSrc;
	//字段的list string
	private String colStrs;
	
	private JavaDao dao;
	
	
	public List<ColumnInfo> getPriKeys() {
		return priKeys;
	}

	public void setPriKeys(List<ColumnInfo> priKeys) {
		this.priKeys = priKeys;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}

	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}

	public ColumnInfo getOnlyPriKey() {
		return onlyPriKey;
	}

	public void setOnlyPriKey(ColumnInfo onlyPriKey) {
		this.onlyPriKey = onlyPriKey;
	}


	public List<String> getSorts() {
		return sorts;
	}

	public void setSorts(List<String> sorts) {
		this.sorts = sorts;
	}
	public TableInfo() {
	}
	public TableInfo(String tname, Map<String, ColumnInfo> columns,
			ColumnInfo onlyPriKey) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.onlyPriKey = onlyPriKey;
	}
	public TableInfo(String tname,List<ColumnInfo> priKeys, Map<String, ColumnInfo> columns,List<String> sorts
			) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.priKeys = priKeys;
		this.sorts = sorts;
	}

	public TableInfo(String tname, Map<String, ColumnInfo> columns, List<String> sorts, ColumnInfo onlyPriKey,
			List<ColumnInfo> priKeys) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.sorts = sorts;
		this.onlyPriKey = onlyPriKey;
		this.priKeys = priKeys;
	}

	public TypeConvertor getConvertor() {
		return convertor;
	}

	public void setConvertor(TypeConvertor convertor) {
		this.convertor = convertor;
	}

	public StringBuilder getBeanFile() {
		return beanFile;
	}

	public void setBeanFile(StringBuilder beanFile) {
		this.beanFile = beanFile;
	}

	public Map<String, String> getImports() {
		return imports;
	}

	public void setImports(Map<String, String> imports) {
		this.imports = imports;
	}

	public StringBuilder getDaoFile() {
		return daoFile;
	}

	public void setDaoFile(StringBuilder daoFile) {
		this.daoFile = daoFile;
	}

	public String getDaoSrc() {
		return daoSrc;
	}

	public void setDaoSrc(String daoSrc) {
		this.daoSrc = daoSrc;
	}

	public String getBeanSrc() {
		return beanSrc;
	}

	public void setBeanSrc(String beanSrc) {
		this.beanSrc = beanSrc;
	}

	public String getColStrs() {
		if (colStrs ==null) {
			this.colStrs = org.apache.commons.lang.StringUtils.join(this.sorts.toArray(), ",");
		}
		return colStrs;
	}

	public void setColStrs(String colStrs) {
		this.colStrs = colStrs;
	}

	public JavaDao getDao() {
		return dao;
	}

	public void setDao(JavaDao dao) {
		this.dao = dao;
	}
	
}
