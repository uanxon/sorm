package com.jsjf.model.commodity;

import java.util.Date;

public class JsCommodityOrder {

	//
	private Integer id;
	//订单号
	private String no;
	//商品ID
	private Integer commodityid;
	//
	private Integer uid;
	//付款人手机号（账号）
	private String mobile;
	//收货人手机号
	private String receivingPhone;
	//收货人地址
	private String address;
	//使用积分
	private Integer integral;
	//兑换数量
	private Integer number;
	//下单时间
	private Date addDate;
	//1-已完成(默认已完成)
	private Integer status;


	public Integer getId(){
		return id;
	}
	public String getNo(){
		return no;
	}
	public Integer getCommodityid(){
		return commodityid;
	}
	public Integer getUid(){
		return uid;
	}
	public String getMobile(){
		return mobile;
	}
	public String getReceivingPhone(){
		return receivingPhone;
	}
	public String getAddress(){
		return address;
	}
	public Integer getIntegral(){
		return integral;
	}
	public Integer getNumber(){
		return number;
	}
	public Date getAddDate(){
		return addDate;
	}
	public Integer getStatus(){
		return status;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public void setNo(String no){
		this.no=no;
	}
	public void setCommodityid(Integer commodityid){
		this.commodityid=commodityid;
	}
	public void setUid(Integer uid){
		this.uid=uid;
	}
	public void setMobile(String mobile){
		this.mobile=mobile;
	}
	public void setReceivingPhone(String receivingPhone){
		this.receivingPhone=receivingPhone;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public void setIntegral(Integer integral){
		this.integral=integral;
	}
	public void setNumber(Integer number){
		this.number=number;
	}
	public void setAddDate(Date addDate){
		this.addDate=addDate;
	}
	public void setStatus(Integer status){
		this.status=status;
	}
}
