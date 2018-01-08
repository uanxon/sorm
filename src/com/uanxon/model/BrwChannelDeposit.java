package com.uanxon.model;

import java.math.BigDecimal;
import java.util.Date;

public class BrwChannelDeposit {

	//保证金
	private BigDecimal amount;
	//清账时间
	private Date settleTime;
	//操作人
	private Integer optUser;
	//添加时间
	private Date addTime;
	//债权id
	private Integer lid;
	//保证金收取备注
	private String receiveRemark;
	//
	private Integer id;
	//清账备注
	private String settleRemark;
	//渠道id
	private Integer cid;


	public BigDecimal getamount(){
		return amount;
	}
	public Date getsettleTime(){
		return settleTime;
	}
	public Integer getoptUser(){
		return optUser;
	}
	public Date getaddTime(){
		return addTime;
	}
	public Integer getlid(){
		return lid;
	}
	public String getreceiveRemark(){
		return receiveRemark;
	}
	public Integer getid(){
		return id;
	}
	public String getsettleRemark(){
		return settleRemark;
	}
	public Integer getcid(){
		return cid;
	}
	public void setamount(BigDecimal amount){
		this.amount=amount;
	}
	public void setsettleTime(Date settleTime){
		this.settleTime=settleTime;
	}
	public void setoptUser(Integer optUser){
		this.optUser=optUser;
	}
	public void setaddTime(Date addTime){
		this.addTime=addTime;
	}
	public void setlid(Integer lid){
		this.lid=lid;
	}
	public void setreceiveRemark(String receiveRemark){
		this.receiveRemark=receiveRemark;
	}
	public void setid(Integer id){
		this.id=id;
	}
	public void setsettleRemark(String settleRemark){
		this.settleRemark=settleRemark;
	}
	public void setcid(Integer cid){
		this.cid=cid;
	}
}
