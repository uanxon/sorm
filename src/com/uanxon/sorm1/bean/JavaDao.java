package com.uanxon.sorm1.bean;

public class JavaDao {
	
	
	private String daoPage;
	private String beanSrc;
	private String daoName;
	private String keyRely;
	private String beanName;
	
	private StringBuffer daoSrc;
	
	public String getDaoPage() {
		return daoPage;
	}
	public void setDaoPage(String daoPage) {
		this.daoPage = daoPage;
	}
	public String getBeanSrc() {
		return beanSrc;
	}
	public void setBeanSrc(String beanSrc) {
		this.beanSrc = beanSrc;
	}
	public String getDaoName() {
		return daoName;
	}
	public void setDaoName(String daoName) {
		this.daoName = daoName;
	}
	public String getKeyRely() {
		return keyRely;
	}
	public void setKeyRely(String keyRely) {
		this.keyRely = keyRely;
	}
	public String getBeanName() {
		return beanName;
	}
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	public StringBuffer getDaoSrc() {
		return daoSrc;
	}
	public void setDaoSrc(StringBuffer daoSrc) {
		this.daoSrc = daoSrc;
	}

}
