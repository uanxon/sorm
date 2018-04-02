package com.jsjf.model.member;


public class JsMemberIntegral {

	//ID
	private Integer id;
	//用户ID
	private Integer uid;
	//可使用的积分
	private Integer integralBalance;
	//已使用的积分
	private Integer integralUse;
	//过期积分
	private Integer integralOverdue;
	//总积分
	private Integer integralCount;
	//即将过期的积分
	private Integer integralSoon;


	public Integer getId(){
		return id;
	}
	public Integer getUid(){
		return uid;
	}
	public Integer getIntegralBalance(){
		return integralBalance;
	}
	public Integer getIntegralUse(){
		return integralUse;
	}
	public Integer getIntegralOverdue(){
		return integralOverdue;
	}
	public Integer getIntegralCount(){
		return integralCount;
	}
	public Integer getIntegralSoon(){
		return integralSoon;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public void setUid(Integer uid){
		this.uid=uid;
	}
	public void setIntegralBalance(Integer integralBalance){
		this.integralBalance=integralBalance;
	}
	public void setIntegralUse(Integer integralUse){
		this.integralUse=integralUse;
	}
	public void setIntegralOverdue(Integer integralOverdue){
		this.integralOverdue=integralOverdue;
	}
	public void setIntegralCount(Integer integralCount){
		this.integralCount=integralCount;
	}
	public void setIntegralSoon(Integer integralSoon){
		this.integralSoon=integralSoon;
	}
}
