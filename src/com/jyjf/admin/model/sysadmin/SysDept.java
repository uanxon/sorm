package com.jyjf.admin.model.sysadmin;


public class SysDept {

	//
	private Integer deptId;
	//上级部门ID，一级部门为0
	private Integer parentId;
	//部门名称
	private String name;
	//排序
	private Integer orderNum;
	//是否删除  -1：已删除  0：正常
	private Integer delFlag;


	public Integer getDeptId(){
		return deptId;
	}
	public Integer getParentId(){
		return parentId;
	}
	public String getName(){
		return name;
	}
	public Integer getOrderNum(){
		return orderNum;
	}
	public Integer getDelFlag(){
		return delFlag;
	}
	public void setDeptId(Integer deptId){
		this.deptId=deptId;
	}
	public void setParentId(Integer parentId){
		this.parentId=parentId;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setOrderNum(Integer orderNum){
		this.orderNum=orderNum;
	}
	public void setDelFlag(Integer delFlag){
		this.delFlag=delFlag;
	}
}
