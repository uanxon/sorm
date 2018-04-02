package com.jsjf.model.member;

import java.util.Date;

public class JsMemberIntegralRecord {

	//
	private Integer id;
	//
	private Integer uid;
	//0-收入 1-支出
	private Integer payType;
	//积分
	private Integer integral;
	//开始时间(所获得的时间)
	private Date startDate;
	//结束时间（预留字段）
	private Date endDate;
	//0-任务 1-投资
	private String type;


	public Integer getId(){
		return id;
	}
	public Integer getUid(){
		return uid;
	}
	public Integer getPayType(){
		return payType;
	}
	public Integer getIntegral(){
		return integral;
	}
	public Date getStartDate(){
		return startDate;
	}
	public Date getEndDate(){
		return endDate;
	}
	public String getType(){
		return type;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public void setUid(Integer uid){
		this.uid=uid;
	}
	public void setPayType(Integer payType){
		this.payType=payType;
	}
	public void setIntegral(Integer integral){
		this.integral=integral;
	}
	public void setStartDate(Date startDate){
		this.startDate=startDate;
	}
	public void setEndDate(Date endDate){
		this.endDate=endDate;
	}
	public void setType(String type){
		this.type=type;
	}
}
