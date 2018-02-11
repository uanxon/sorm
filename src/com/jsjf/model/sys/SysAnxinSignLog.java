package com.jsjf.model.sys;

import java.util.Date;

public class SysAnxinSignLog {

	//
	private Integer id;
	//用户ID
	private Integer uid;
	//投资ID
	private Integer investId;
	//请求参数
	private String req_param;
	//返回参数
	private String res_param;
	//创建时间
	private Date addtime;
	//执行接口ID
	private String type;
	//执行状态 0-成功 1-失败 
	private Integer status;


	public Integer getId(){
		return id;
	}
	public Integer getUid(){
		return uid;
	}
	public Integer getInvestId(){
		return investId;
	}
	public String getReqParam(){
		return req_param;
	}
	public String getResParam(){
		return res_param;
	}
	public Date getAddtime(){
		return addtime;
	}
	public String getType(){
		return type;
	}
	public Integer getStatus(){
		return status;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public void setUid(Integer uid){
		this.uid=uid;
	}
	public void setInvestId(Integer investId){
		this.investId=investId;
	}
	public void setReqParam(String req_param){
		this.req_param=req_param;
	}
	public void setResParam(String res_param){
		this.res_param=res_param;
	}
	public void setAddtime(Date addtime){
		this.addtime=addtime;
	}
	public void setType(String type){
		this.type=type;
	}
	public void setStatus(Integer status){
		this.status=status;
	}
}
