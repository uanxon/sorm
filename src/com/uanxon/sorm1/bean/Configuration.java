package com.uanxon.sorm1.bean;

/**
 * 管理配置信息
 * @author 
 *
 */
public class Configuration {
	/**
	 * 驱动类
	 */
	private String driver; 
	/**
	 * jdbc的url
	 */
	private String url;
	/**
	 * 数据库的用户名
	 */
	private String user;
	/**
	 * 数据库的密码
	 */
	private String pwd;
	/**
	 * 正在使用哪个数据库
	 */
	private String usingDB;
	/**
	 * 项目的源码路径
	 */
	private String srcPath;
	/**
	 * 表
	 */
	private String tables[];
	/**
	 * 扫描生成java类的包(po的意思是：Persistence object持久化对象)
	 */
	private String poPackage;
	/**
	 * 扫描生成dao的包
	 */
	private String daoPackage;
	/**
	 * 扫描生成mapperXml的包
	 */
	private String mapperPackage;
	/**
	 * 扫描生成mapperXml的包
	 */
	private String removePrefix;
	/**
	 * 扫描生成mapperXml的包
	 */
	private String incrPrefix;
	
	
	public Configuration() {
	}
	



	public Configuration(String driver, String url, String user, String pwd, String usingDB, String srcPath,
			String poPackage, String daoPackage, String mapperPackage, String removePrefix, String incrPrefix) {
		super();
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pwd = pwd;
		this.usingDB = usingDB;
		this.srcPath = srcPath;
		this.poPackage = poPackage;
		this.daoPackage = daoPackage;
		this.mapperPackage = mapperPackage;
		this.removePrefix = removePrefix;
		this.incrPrefix = incrPrefix;
	}




	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUsingDB() {
		return usingDB;
	}
	public void setUsingDB(String usingDB) {
		this.usingDB = usingDB;
	}
	public String getSrcPath() {
		return srcPath;
	}
	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}
	public String getPoPackage() {
		return poPackage;
	}
	public void setPoPackage(String poPackage) {
		this.poPackage = poPackage;
	}

	public String getDaoPackage() {
		return daoPackage;
	}

	public void setDaoPackage(String daoPackage) {
		this.daoPackage = daoPackage;
	}

	public String getMapperPackage() {
		return mapperPackage;
	}

	public void setMapperPackage(String mapperPackage) {
		this.mapperPackage = mapperPackage;
	}




	public String getRemovePrefix() {
		return removePrefix;
	}




	public void setRemovePrefix(String removePrefix) {
		this.removePrefix = removePrefix;
	}




	public String getIncrPrefix() {
		return incrPrefix;
	}




	public void setIncrPrefix(String incrPrefix) {
		this.incrPrefix = incrPrefix;
	}




	public String[] getTables() {
		return tables;
	}

	public void setTables(String[] tables) {
		this.tables = tables;
	}




	@Override
	public  String toString() {
		return "Configuration [driver=" + driver + ", url=" + url + ", user=" + user + ", pwd=" + pwd + ", usingDB="
				+ usingDB + ", srcPath=" + srcPath + ", poPackage=" + poPackage + ", daoPackage=" + daoPackage
				+ ", mapperPackage=" + mapperPackage + ", removePrefix=" + removePrefix + ", incrPrefix=" + incrPrefix
				+ "]";
	} 
	
	
	

}
