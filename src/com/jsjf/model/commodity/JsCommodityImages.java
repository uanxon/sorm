package com.jsjf.model.commodity;


public class JsCommodityImages {

	//
	private Integer id;
	//商品ID
	private Integer commodityid;
	//图片路径
	private String url;
	//状态 （1-有效 2-无效）
	private Integer status;


	public Integer getId(){
		return id;
	}
	public Integer getCommodityid(){
		return commodityid;
	}
	public String getUrl(){
		return url;
	}
	public Integer getStatus(){
		return status;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public void setCommodityid(Integer commodityid){
		this.commodityid=commodityid;
	}
	public void setUrl(String url){
		this.url=url;
	}
	public void setStatus(Integer status){
		this.status=status;
	}
}
