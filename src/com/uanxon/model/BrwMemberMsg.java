package com.uanxon.model;

import java.util.Date;

public class BrwMemberMsg {

	//发送人ID，0默认为系统发送
	private Integer puid;
	//发送时间
	private Date addtime;
	//是否阅读0未读，1已读
	private Integer isread;
	//Null
	private Integer id;
	//消息类别
	private Integer type;
	//消息标题
	private String title;
	//接收用户ID
	private Integer rbid;
	//消息内容
	private String content;
	//状态，0正常，1删除
	private Integer status;


	public Integer getpuid(){
		return puid;
	}
	public Date getaddtime(){
		return addtime;
	}
	public Integer getisread(){
		return isread;
	}
	public Integer getid(){
		return id;
	}
	public Integer gettype(){
		return type;
	}
	public String gettitle(){
		return title;
	}
	public Integer getrbid(){
		return rbid;
	}
	public String getcontent(){
		return content;
	}
	public Integer getstatus(){
		return status;
	}
	public void setpuid(Integer puid){
		this.puid=puid;
	}
	public void setaddtime(Date addtime){
		this.addtime=addtime;
	}
	public void setisread(Integer isread){
		this.isread=isread;
	}
	public void setid(Integer id){
		this.id=id;
	}
	public void settype(Integer type){
		this.type=type;
	}
	public void settitle(String title){
		this.title=title;
	}
	public void setrbid(Integer rbid){
		this.rbid=rbid;
	}
	public void setcontent(String content){
		this.content=content;
	}
	public void setstatus(Integer status){
		this.status=status;
	}
}
