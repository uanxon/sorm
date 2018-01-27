package com.jsjf.model.borrow;

import java.math.BigDecimal;

public class TBSysRole {

	//角色主键
	private Integer role_ky;
	//角色编码
	private String code;
	//角色名称
	private String name;
	//保留状态
	private BigDecimal status;
	//角色备注
	private String remark;


	public Integer getRoleKy(){
		return role_ky;
	}
	public String getCode(){
		return code;
	}
	public String getName(){
		return name;
	}
	public BigDecimal getStatus(){
		return status;
	}
	public String getRemark(){
		return remark;
	}
	public void setRoleKy(Integer role_ky){
		this.role_ky=role_ky;
	}
	public void setCode(String code){
		this.code=code;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setStatus(BigDecimal status){
		this.status=status;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
}
