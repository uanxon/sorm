package com.bjsxt.po;

import java.util.Date;

public class UanEmp {

	//
	private Date birthday;
	//部门名字
	private String deptName;
	//
	private Double bonus;
	//名字
	private String empName;
	//
	private String toFrom;
	//
	private Integer deptId;
	//主键
	private Integer id;
	//薪水
	private Double salary;
	//
	private String deptAddr;
	//年龄
	private Integer age;


	public Date getbirthday(){
		return birthday;
	}
	public String getdeptName(){
		return deptName;
	}
	public Double getbonus(){
		return bonus;
	}
	public String getempName(){
		return empName;
	}
	public String gettoFrom(){
		return toFrom;
	}
	public Integer getdeptId(){
		return deptId;
	}
	public Integer getid(){
		return id;
	}
	public Double getsalary(){
		return salary;
	}
	public String getdeptAddr(){
		return deptAddr;
	}
	public Integer getage(){
		return age;
	}
	public void setbirthday(Date birthday){
		this.birthday=birthday;
	}
	public void setdeptName(String deptName){
		this.deptName=deptName;
	}
	public void setbonus(Double bonus){
		this.bonus=bonus;
	}
	public void setempName(String empName){
		this.empName=empName;
	}
	public void settoFrom(String toFrom){
		this.toFrom=toFrom;
	}
	public void setdeptId(Integer deptId){
		this.deptId=deptId;
	}
	public void setid(Integer id){
		this.id=id;
	}
	public void setsalary(Double salary){
		this.salary=salary;
	}
	public void setdeptAddr(String deptAddr){
		this.deptAddr=deptAddr;
	}
	public void setage(Integer age){
		this.age=age;
	}
}
