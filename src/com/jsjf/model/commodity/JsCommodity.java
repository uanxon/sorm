package com.jsjf.model.commodity;

import java.util.Date;

public class JsCommodity {

	//
	private Integer id;
	//商品分组(字典表)
	private Integer commoditGroup;
	//商品分类(字典表)
	private Integer commodityType;
	//优惠券类型
	private Integer couponType;
	//商品名称
	private String commodityName;
	//优惠券ID
	private Integer activityid;
	//兑换积分
	private Integer exchangeIntegral;
	//是否促销(1-是  2-否）
	private Integer promotion;
	//促销积分
	private Integer promotionIntegral;
	//库存(剩余)
	private Integer inventory;
	//兑换量（已兑换）
	private Integer sales;
	//商品排序
	private Integer sort;
	//平台类型
	private Integer channel;
	//是否限购（1-是 2-否）
	private Integer purchasing;
	//限购开始时间(年月日)
	private Date purchasingStartDate;
	//限购结束时间(年月日)
	private Date purchasingEndDate;
	//限购数量
	private Integer purchasingNumber;
	//限购类型(字典表)
	private Integer purchasingType;
	//限购时段（时分秒）
	private String purchasingStartTime;
	//限购时段(时分秒)
	private String purchasingEndTime;
	//会员等级
	private Integer mgid;
	//支付方式(1-积分)
	private Integer paymentMethod;
	//推荐商品（字典表）
	private Integer recommendedCommodity;
	//首页推荐权重
	private Integer pageSort;
	//兑换成功页推荐权重
	private Integer exchangeSort;
	//分享描述
	private String shareDescription;
	//券类说明
	private String instructions;
	//PC商品详情大图
	private String pcUrl;
	//H5商品详情大图
	private String h5Url;
	//状态 （1-未上架 2-已上架 3-已下架 4-已删除）
	private Integer status;
	//添加时间
	private Date addDate;
	//添加人
	private Integer addUser;
	//修改时间
	private Date updateDate;
	//修改人
	private Integer updateUser;


	public Integer getId(){
		return id;
	}
	public Integer getCommoditGroup(){
		return commoditGroup;
	}
	public Integer getCommodityType(){
		return commodityType;
	}
	public Integer getCouponType(){
		return couponType;
	}
	public String getCommodityName(){
		return commodityName;
	}
	public Integer getActivityid(){
		return activityid;
	}
	public Integer getExchangeIntegral(){
		return exchangeIntegral;
	}
	public Integer getPromotion(){
		return promotion;
	}
	public Integer getPromotionIntegral(){
		return promotionIntegral;
	}
	public Integer getInventory(){
		return inventory;
	}
	public Integer getSales(){
		return sales;
	}
	public Integer getSort(){
		return sort;
	}
	public Integer getChannel(){
		return channel;
	}
	public Integer getPurchasing(){
		return purchasing;
	}
	public Date getPurchasingStartDate(){
		return purchasingStartDate;
	}
	public Date getPurchasingEndDate(){
		return purchasingEndDate;
	}
	public Integer getPurchasingNumber(){
		return purchasingNumber;
	}
	public Integer getPurchasingType(){
		return purchasingType;
	}
	public String getPurchasingStartTime(){
		return purchasingStartTime;
	}
	public String getPurchasingEndTime(){
		return purchasingEndTime;
	}
	public Integer getMgid(){
		return mgid;
	}
	public Integer getPaymentMethod(){
		return paymentMethod;
	}
	public Integer getRecommendedCommodity(){
		return recommendedCommodity;
	}
	public Integer getPageSort(){
		return pageSort;
	}
	public Integer getExchangeSort(){
		return exchangeSort;
	}
	public String getShareDescription(){
		return shareDescription;
	}
	public String getInstructions(){
		return instructions;
	}
	public String getPcUrl(){
		return pcUrl;
	}
	public String getH5Url(){
		return h5Url;
	}
	public Integer getStatus(){
		return status;
	}
	public Date getAddDate(){
		return addDate;
	}
	public Integer getAddUser(){
		return addUser;
	}
	public Date getUpdateDate(){
		return updateDate;
	}
	public Integer getUpdateUser(){
		return updateUser;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public void setCommoditGroup(Integer commoditGroup){
		this.commoditGroup=commoditGroup;
	}
	public void setCommodityType(Integer commodityType){
		this.commodityType=commodityType;
	}
	public void setCouponType(Integer couponType){
		this.couponType=couponType;
	}
	public void setCommodityName(String commodityName){
		this.commodityName=commodityName;
	}
	public void setActivityid(Integer activityid){
		this.activityid=activityid;
	}
	public void setExchangeIntegral(Integer exchangeIntegral){
		this.exchangeIntegral=exchangeIntegral;
	}
	public void setPromotion(Integer promotion){
		this.promotion=promotion;
	}
	public void setPromotionIntegral(Integer promotionIntegral){
		this.promotionIntegral=promotionIntegral;
	}
	public void setInventory(Integer inventory){
		this.inventory=inventory;
	}
	public void setSales(Integer sales){
		this.sales=sales;
	}
	public void setSort(Integer sort){
		this.sort=sort;
	}
	public void setChannel(Integer channel){
		this.channel=channel;
	}
	public void setPurchasing(Integer purchasing){
		this.purchasing=purchasing;
	}
	public void setPurchasingStartDate(Date purchasingStartDate){
		this.purchasingStartDate=purchasingStartDate;
	}
	public void setPurchasingEndDate(Date purchasingEndDate){
		this.purchasingEndDate=purchasingEndDate;
	}
	public void setPurchasingNumber(Integer purchasingNumber){
		this.purchasingNumber=purchasingNumber;
	}
	public void setPurchasingType(Integer purchasingType){
		this.purchasingType=purchasingType;
	}
	public void setPurchasingStartTime(String purchasingStartTime){
		this.purchasingStartTime=purchasingStartTime;
	}
	public void setPurchasingEndTime(String purchasingEndTime){
		this.purchasingEndTime=purchasingEndTime;
	}
	public void setMgid(Integer mgid){
		this.mgid=mgid;
	}
	public void setPaymentMethod(Integer paymentMethod){
		this.paymentMethod=paymentMethod;
	}
	public void setRecommendedCommodity(Integer recommendedCommodity){
		this.recommendedCommodity=recommendedCommodity;
	}
	public void setPageSort(Integer pageSort){
		this.pageSort=pageSort;
	}
	public void setExchangeSort(Integer exchangeSort){
		this.exchangeSort=exchangeSort;
	}
	public void setShareDescription(String shareDescription){
		this.shareDescription=shareDescription;
	}
	public void setInstructions(String instructions){
		this.instructions=instructions;
	}
	public void setPcUrl(String pcUrl){
		this.pcUrl=pcUrl;
	}
	public void setH5Url(String h5Url){
		this.h5Url=h5Url;
	}
	public void setStatus(Integer status){
		this.status=status;
	}
	public void setAddDate(Date addDate){
		this.addDate=addDate;
	}
	public void setAddUser(Integer addUser){
		this.addUser=addUser;
	}
	public void setUpdateDate(Date updateDate){
		this.updateDate=updateDate;
	}
	public void setUpdateUser(Integer updateUser){
		this.updateUser=updateUser;
	}
}
