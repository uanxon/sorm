package com.bjsxt.dao;

import com.bjsxt.po.Emp;

public interface EmpDAO {

/**
* 添加
* @param 
* @return
*/
public void insertEmp(Emp record);
/**
* 添加
* @param 
* @return
*/
public int updateByPrimaryKey(Emp record);
/**
* 查询
* @param 
* @return
*/
public Emp selectByPrimaryKey(Integer id);
}