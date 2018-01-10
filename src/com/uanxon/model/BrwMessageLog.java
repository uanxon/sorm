package com.uanxon.model;

import java.util.Date;

public class BrwMessageLog {

	//手机号码
	private String phone;
	//主键id 自增
	private Integer msgid;
	//会员ID
	private Integer bid;
	//短信验证码
	private String message;
	//
	private Integer type;
	//短信发送时间
	private Date sendtime;
	//发送结果  对应短信接口文档（大于零发送成功）
	private Integer results;


	public String getphone(){
		return phone;
	}
	public Integer getmsgid(){
		return msgid;
	}
	public Integer getbid(){
		return bid;
	}
	public String getmessage(){
		return message;
	}
	public Integer gettype(){
		return type;
	}
	public Date getsendtime(){
		return sendtime;
	}
	public Integer getresults(){
		return results;
	}
	public void setphone(String phone){
		this.phone=phone;
	}
	public void setmsgid(Integer msgid){
		this.msgid=msgid;
	}
	public void setbid(Integer bid){
		this.bid=bid;
	}
	public void setmessage(String message){
		this.message=message;
	}
	public void settype(Integer type){
		this.type=type;
	}
	public void setsendtime(Date sendtime){
		this.sendtime=sendtime;
	}
	public void setresults(Integer results){
		this.results=results;
	}
}
